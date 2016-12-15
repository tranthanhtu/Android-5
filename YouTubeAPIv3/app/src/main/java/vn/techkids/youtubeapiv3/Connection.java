package vn.techkids.youtubeapiv3;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class Connection {

    private static final String url = "https://www.youtube.com/watch?v=wspaiNlauBs&list=PLPYoHdBDRq5XehaJvHw_Ha0S6pmyWlqMH";
    private Document document;
    private ArrayList<String> arrayList = new ArrayList<>();

    public Connection() {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }



    public ArrayList<String> getListId() {
        ArrayList<String> idList = new ArrayList<>();

        String id = "playlist-autoscroll-list";
        Element list = document.getElementById(id);

        Elements listTagA = list.getElementsByTag("a");
        String href = "";
        for(Element e : listTagA){
            href = e.attr("href");
            idList.add(href.substring(
                    href.indexOf("=") + 1,
                    href.indexOf("&")
            ));
        }

        for(int i = 0; i < idList.size(); i++)
            System.out.println(idList.get(i));
        return idList;
    }

    private static Connection instance;

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

}
