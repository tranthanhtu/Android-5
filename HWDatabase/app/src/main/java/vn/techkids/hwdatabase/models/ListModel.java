package vn.techkids.hwdatabase.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/29/2016.
 */
public class ListModel {
    private String title;

    public ListModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static final List<ListModel> list = new ArrayList<>();
}
