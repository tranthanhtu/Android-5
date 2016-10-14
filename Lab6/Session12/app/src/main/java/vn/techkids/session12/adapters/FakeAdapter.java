package vn.techkids.session12.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vn.techkids.session12.R;
import vn.techkids.session12.jsonmodels.FakeItems;

/**
 * Created by Dell latitude E6520 on 10/14/2016.
 */

public class FakeAdapter extends ArrayAdapter<FakeItems> {
    public FakeAdapter(Context context, int resource, List<FakeItems> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.layout_fake_item, parent, false);

        FakeItems items = getItem(position);

        TextView tvtitle = (TextView) convertView.findViewById(R.id.tv_title_flickr);
        TextView tvuserId = (TextView) convertView.findViewById(R.id.tv_link_flickr);
        TextView tvbody = (TextView) convertView.findViewById(R.id.tv_date_taken_flickr);

        tvbody.setText(items.getBody());
        tvuserId.setText(items.getUserId());
        tvtitle.setText(items.getTitle());
        return convertView;
    }
}
