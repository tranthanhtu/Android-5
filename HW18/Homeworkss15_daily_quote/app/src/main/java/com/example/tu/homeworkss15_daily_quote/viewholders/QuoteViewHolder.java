package com.example.tu.homeworkss15_daily_quote.viewholders;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hau.homeworkss15_daily_quote.R;
import com.example.tu.homeworkss15_daily_quote.constants.Constants;
import com.example.tu.homeworkss15_daily_quote.managers.FileManager;
import com.example.tu.homeworkss15_daily_quote.managers.NetworkManger;
import com.example.tu.homeworkss15_daily_quote.managers.Preferrences;
import com.example.tu.homeworkss15_daily_quote.models.Quote;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 25/10/2016.
 */
public class QuoteViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = QuoteViewHolder.class.toString();
    @BindView(R.id.imv_background)
    ImageView imvBackground;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_username)
    TextView tvUsername;

    public QuoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Quote quote) {

        tvTitle.setText(quote.getTitle());
        tvContent.setText(Html.fromHtml(quote.getContent()));
        tvUsername.setText(String.format("Hi, %s", Preferrences.getInstance().getUsername()));

        if (NetworkManger.getInstance().isConnectedToInternet()) {
            ImageLoader.getInstance().displayImage(Constants.UNPLASH_API, imvBackground);
            Log.d(TAG, "set image");
        } else {
            Random random = new Random();
            int position = random.nextInt(10);
            Log.d(TAG, String.format("position = %s", position));
            File file = FileManager.getInstance().loadImageFile(String.format(FileManager.IMAGE_DIR_FORMAT, position));
            ImageLoader.getInstance().displayImage(
                    Uri.fromFile(file).toString(),
                    imvBackground
            );

//            // load image from realm
//            Image image = DbContextRealm.getInstance().findFirstImageRandom();
//            Bitmap bitmap = BitmapFactory.decodeByteArray(image.getBytes(), 0, image.getBytes().length);
////            if (bitmap != null) {
//
//                Log.d(TAG, bitmap.toString());
//                imvBackground.setImageBitmap(bitmap);
////            }
        }
//        imvBackground.setImageBitmap(quote.getBitmap());
    }
}
