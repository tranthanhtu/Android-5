package vn.techkids.homework14_2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class CountryModels {
    String country;
    int imageContry;

    public CountryModels(String country, int imageContry) {
        this.country = country;
        this.imageContry = imageContry;
    }

    public String getCountry() {
        return country;
    }

    public int getImageContry() {
        return imageContry;
    }

    public static final List<CountryModels> list = new ArrayList<>();
}
