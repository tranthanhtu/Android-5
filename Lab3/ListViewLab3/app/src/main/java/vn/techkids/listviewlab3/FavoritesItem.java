package vn.techkids.listviewlab3;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class FavoritesItem {
    private String title;
    private String minutes;
    private int imageResId;

    public FavoritesItem(String title, String minutes, int imageResId) {
        this.title = title;
        this.minutes = minutes;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }


    @Override
    public String toString() {
        return this.title;
    }

    public static final FavoritesItem[] ARRAY = new FavoritesItem[]{

            new FavoritesItem("He may act like he wants a secretary but most of the time they’re looking for…", "10min", R.drawable.item1),
            new FavoritesItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face", "13min", R.drawable.item2),
            new FavoritesItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head", "16min", R.drawable.item3),
            new FavoritesItem("Get out of here and move forward. This never happened. It will shock you how much", "19min", R.drawable.item4),
            new FavoritesItem("That poor girl. She doesn’t know that loving you is the worst way to get you", "22min", R.drawable.item5)

    };
}
