package vn.tranthanhtu.weather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import vn.tranthanhtu.weather.data.Channel;
import vn.tranthanhtu.weather.data.Item;
import vn.tranthanhtu.weather.service.WeatherServiceCallback;
import vn.tranthanhtu.weather.service.YahooWeatherService;

public class Weather extends AppCompatActivity implements WeatherServiceCallback {
    private static final String TAG = Weather.class.toString();
    private ImageView iconWeather;
    private TextView temperatureF;
    private TextView condition;
    private TextView cityname;
    private TextView temperatureC;
    private EditText city;
    private Button check;

    private YahooWeatherService service;
    private ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        getReferences();
        service = new YahooWeatherService(Weather.this);

        setupUI();

    }



    private void setupUI() {
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLY);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (city.getText().length() == 0){
                    service.refreshWeather("Ha Noi");
                    cityname.setText("Ha Noi");
                }
                else {
                    service.refreshWeather(city.getText().toString());
                    cityname.setText(city.getText().toString());
                }

                dialog = new ProgressDialog(Weather.this);
                dialog.setMessage("Loading...");
                dialog.show();
                city.setText("");

                Snackbar snackbar = Snackbar.make(coordinatorLayout, "", Snackbar.LENGTH_LONG)
                        .setDuration(Snackbar.LENGTH_INDEFINITE)
                        .setAction("SEND MESSAGE", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(Weather.this, ListContact.class);
                                intent.putExtra("temperatorF", temperatureF.getText().toString());
                                intent.putExtra("temperatorC", temperatureC.getText().toString());
                                intent.putExtra("condition", condition.getText().toString());
                                startActivity(intent);
                            }
                        });


                snackbar.show();
            }
        });
    }



    private void getReferences() {
        iconWeather = (ImageView) findViewById(R.id.imv_weatherIcon);
        temperatureF = (TextView) findViewById(R.id.tv_temperatorF);
        condition = (TextView) findViewById(R.id.tv_condition);
        city = (EditText) findViewById(R.id.edt_city);
        check = (Button) findViewById(R.id.btn_check);
        cityname = (TextView) findViewById(R.id.tv_namecity);
        temperatureC = (TextView) findViewById(R.id.tv_temperatorC);
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();
        Item item = channel.getItem();
        int resources = getResources()
                .getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resources);

        iconWeather.setImageDrawable(weatherIconDrawable);

        temperatureF.setText(item.getCondition().getTemperature() + " "  + channel.getUnits().getTemperator());

        float c ;

        c = (item.getCondition().getTemperature() - 32) / 1.8f;

        temperatureC.setText(c + " C");

        condition.setText(item.getCondition().getDescription());


    }

    @Override
    public void serviceFailure(Exception e) {
        dialog.hide();
        Toast.makeText(this, "Service Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:

                break;
            case R.id.setting:

                break;
        }
        return false;
    }

    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
