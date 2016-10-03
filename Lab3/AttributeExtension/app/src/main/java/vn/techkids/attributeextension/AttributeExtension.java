package vn.techkids.attributeextension;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class AttributeExtension extends LinearLayout {

    @BindView(R.id.tv_changenumber)
    TextView tvNumber;

    @BindView(R.id.tv_value)
    TextView tvValue;

    private String value;
    private int number;

    public void updateUI(){
        tvNumber.setText(number+"");
        tvValue.setText(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        updateUI();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        updateUI();
    }

    public AttributeExtension(Context context) {
        super(context);
        initContext(context, null);
    }

    public AttributeExtension(Context context, AttributeSet attrs) {
        super(context, attrs);
        initContext(context, attrs);
    }

    public AttributeExtension(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContext(context, attrs);
    }

    public void initContext(Context context, AttributeSet attrs){
        View view = inflate(context, R.layout.attribute_extension, this);
        ButterKnife.bind(this, view);
        if(attrs != null) {
            TypedArray typedAray = context.obtainStyledAttributes(attrs, R.styleable.AttributeExtension);
            this.number = typedAray.getInteger(R.styleable.AttributeExtension_number, -1);
            typedAray.recycle();
            this.value = typedAray.getString(R.styleable.AttributeExtension_value);
            typedAray.recycle();

        }
        updateUI();
    }
}
