package vn.techkids.homework14.activities.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class Menu {
    private String title;
    private int imageMenu;

    public Menu(String title, int imageMenu) {
        this.title = title;
        this.imageMenu = imageMenu;
    }

    public String getTitle() {
        return title;
    }

    public int getImageMenu() {
        return imageMenu;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageMenu(int imageMenu) {
        this.imageMenu = imageMenu;
    }

    public static final List<Menu> list = new ArrayList<>();

}
