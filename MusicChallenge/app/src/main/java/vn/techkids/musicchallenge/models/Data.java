package vn.techkids.musicchallenge.models;

import java.util.ArrayList;

/**
 * Created by Nhan on 11/9/2016.
 */

public class Data {
    private static ArrayList<Song> songList = new ArrayList<>();

    public static ArrayList<Song> getSongList() {
        songList.clear();
        songList.add(new Song(
                "Hello Hello",
                "FT Island",
                "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVEDLVAGTLDJTDGLG"
        ));
        songList.add(new Song(
                "Faded",
                "Alan Walker",
                "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNQAQJNLVTLDJTDGLG"
        ));
        songList.add(new Song(
                "Heathens",
                "Twenty One Pilots",
                "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNQQVNLNJTLDJTDGLG"
        ));
        songList.add(new Song(
                "Clap Hands",
                "Tom Waits",
                "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVNXQEQJTLDJTDGLG"
        ));
        songList.add(new Song(
                "Everybody Knows",
                "Ride",
                "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNAAQEEGDTLDJTDGLG"
        ));
        return songList;
    }
}
