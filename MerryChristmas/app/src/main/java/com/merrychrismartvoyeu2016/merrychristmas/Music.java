package com.merrychrismartvoyeu2016.merrychristmas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {
    RelativeLayout background2;
    TextView tvMessage;
    ListView lvMusic;

    MediaPlayer song;

    ArrayList<String> music_name, message;
    ArrayList<Integer> music_mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        getReferences();

        setupUI();

        addListeners();

        backtoMain();
    }

    private void setupUI() {
        background2.setBackgroundResource(R.drawable.background);
        song = MediaPlayer.create( getApplicationContext(), R.raw.beautifulinwhite);
        song.start();

        tvMessage.setText("Love U Forever");
        animation();

        addArray();

        addAdapter();

    }

    private void getReferences() {
        background2 = (RelativeLayout) findViewById(R.id.background2);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        lvMusic = (ListView) findViewById(R.id.lvMusic);
    }

    private void addAdapter(){
        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                music_name
        );
        lvMusic.setAdapter(adapter);
    }

    public void addArray(){
        music_mp3 = new ArrayList<Integer>();
        music_name = new ArrayList<String>();
        message = new ArrayList<String>();

        music_mp3.add(R.raw.votuyetvoinhat);
        music_name.add("Vợ Tuyệt Vời Nhất");
        message.add("Nhìn em cạnh bên anh ngủ ngoan lòng anh quá nỗi nhẹ nhàng thoáng chốc anh quên đi bao phiền ưu\n" +
                "Nhắm mắt lại và mong sao em có thể hiểu, từ lúc em bên cạnh anh thấy cuộc sống ổn hơn nhiều\n" +
                "Nhiều lần giận hờn nhau đôi chúng ta từng phải nói chia tay mà, và cớ sao em vẫn luôn là người thứ tha\n" +
                "Anh cảm ơn trời đã trao anh người con gái tuyệt vời, chỉ muốn bên em và yêu em đến hết cuộc đời\n" +
                "\n" +
                "Người tuyệt vời nhất là em chẳng ai khác ngoài em\n" +
                "Và lý do anh cho là em luôn luôn tuệt vời nhất\n" +
                "Vì em từng biết lắng nghe biết chịu đựng biết sẻ chia\n" +
                "Anh biết cả đời này anh ko gặp ai tốt hơn em\n" +
                "Cảm ơn em đã vì anh suốt quãng đường vừa qua\n" +
                "Và thứ tha cho anh nhiều lần anh dối trá\n" +
                "Anh hiểu rằng anh rất may mắn khi được em ở bên cạnh\n" +
                "Muốn thấy nụ cười nở trên môi hạnh phúc chỉ thế thôi là em !");

        music_mp3.add(R.raw.motnha);
        music_name.add("Một Nhà");
        message.add("Cảm ơn em vì những tháng ngày qua em đã đến bên anh \n" +
                "Cảm ơn em đã là hậu phương cho ước mơ trong anh \n" +
                "Xin lỗi em vì những tối em thức muộn nhịn đói chờ cơm \n" +
                "Anh rất yêu em và con bài này anh viết xin tặng 2 mẹ con.");

        music_mp3.add(R.raw.bantinhcadautien);
        music_name.add("Bản Tình Ca Đầu Tiên");
        message.add("Vì nếu em cần một bờ vai êm.\n" +
                "Nếu em cần những phút bình yên.\n" +
                "Anh sẽ đến ngồi kề bên em.\n" +
                "Khi em khóc giọt nước mắt chứa chan.\n" +
                "Dẫu phong ba anh sẽ đến với em.\n" +
                "Cho dù không làm em cười.\n" +
                "Anh sẽ đến để được khóc cùng em.\n" +
                "Vì nếu em cười nụ cười long lanh.\n" +
                "Con tim anh hạnh phúc rạng ngời.\n" +
                "Anh sẽ đến như bao lần.\n" +
                "Để mình cùng tựa vào vai nhau");

        music_mp3.add(R.raw.duanhauditron);
        music_name.add("Đưa Nhau Đi Trốn");
        message.add("Em ơi đi trốn với anh\n" +
                "Mình đi đến nơi có biển bạc núi xanh\n" +
                "Chạy con xe anh chở em tròng trành \n" +
                "Mình phóng tầm mắt ngắm chân trời mới toanh\n" +
                "Sẽ là những bình mình không có tiếng chuông báo thức\n" +
                "Và tất cả điều làm anh thấy háo hức");
    }

    private void addListeners() {
        lvMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                song.stop();
                song = MediaPlayer.create(getApplicationContext(), music_mp3.get(position));
                song.start();

                tvMessage.setText(message.get(position));
                animation();

            }
        });
    }

    public void animation(){
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        zoom.reset();
        tvMessage.clearAnimation();
        tvMessage.startAnimation(zoom);

    }

    public void backtoMain(){
        tvMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMain);
            }
        });
    }

    @Override
    public void onBackPressed() {
        song.stop();
        super.onBackPressed();

    }
}
