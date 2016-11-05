package com.example.tu.homeworkss15_daily_quote.managers;

import android.content.Context;

import com.example.tu.homeworkss15_daily_quote.models.Image;
import com.example.tu.homeworkss15_daily_quote.models.Quote;

import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Hau on 04/11/2016.
 */
public class DbContextRealm {
    private Realm realm;

    public DbContextRealm(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    private static DbContextRealm instance;

    public static DbContextRealm getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbContextRealm(context);
    }

    /*====================== Quote =============================*/
    public void add(Quote quote) {
        realm.beginTransaction();
        realm.copyToRealm(quote);
        realm.commitTransaction();
    }

    public List<Quote> findAllQuote() {
        RealmResults<Quote> quotes = realm
                .where(Quote.class)
                .findAll();
        return quotes;
    }

    public Quote findFirstQuoteRandom() {
        RealmResults<Quote> quotes = realm
                .where(Quote.class)
                .findAll();
        Random random = new Random();
        int firtRandomNumber = random.nextInt(quotes.size());
        return quotes.get(firtRandomNumber);
    }

    public long getSizeQuote() {
        return realm.where(Quote.class).count();
    }

    /*====================== Quote =============================*/
    public void add(Image image) {
        realm.beginTransaction();
        realm.copyToRealm(image);
        realm.commitTransaction();
    }

    public List<Image> findAllImage() {
        RealmResults<Image> images = realm
                .where(Image.class)
                .findAll();
        return images;
    }

    public Image findFirstImageRandom() {
        RealmResults<Image> images = realm
                .where(Image.class)
                .findAll();
        Random random = new Random();
        int firtRandomNumber = random.nextInt(images.size());
        return images.get(firtRandomNumber);
    }

    public long getSizeImage() {
        return realm.where(Image.class).count();
    }
}
