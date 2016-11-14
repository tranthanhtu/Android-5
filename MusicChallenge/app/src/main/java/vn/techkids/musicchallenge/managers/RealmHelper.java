package vn.techkids.musicchallenge.managers;

import android.content.Context;

import java.util.List;

import io.realm.Realm;
import vn.techkids.musicchallenge.models.Song;

/**
 * Created by Dell latitude E6520 on 11/13/2016.
 */

public class RealmHelper  {
    private Realm realm;
    private static RealmHelper instance;
    public static RealmHelper getInstance() {
        return instance;
    }
    public static void init(Context context) {
        instance = new RealmHelper(context);
    }

    public RealmHelper(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void add(Song song){
        realm.beginTransaction();
        realm.copyToRealm(song);
        realm.commitTransaction();
    }

    public void addList(List<Song> songList){
        for (Song song : songList){
            add(song);
        }
    }

    public List<Song> getListSong() {
        return realm.where(Song.class).findAll();
    }
}
