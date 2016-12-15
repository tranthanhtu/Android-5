package vn.techkids.youtubeapiv3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class Adapter extends ArrayAdapter<String> {

    public Adapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_video, parent, false);
        }
        TextView tvIDvideo;
        tvIDvideo = (TextView) convertView.findViewById(R.id.tv_idPlayvideo);
        tvIDvideo.setText(getItem(position));
        return convertView;
    }
}
