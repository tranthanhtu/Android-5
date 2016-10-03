package vn.techkids.attributeextension;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class AttributeExtension extends TextView {
    public AttributeExtension(Context context) {
        super(context);
    }

    public AttributeExtension(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AttributeExtension(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initContext(Context context, AttributeSet attrs){

    }
}
