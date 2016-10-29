package vn.techkids.hwdatabase.models;

/**
 * Created by Dell latitude E6520 on 10/29/2016.
 */

public class NoteModel {
    private int id;
    private String title;
    private String content;
    private String time_created;

    public NoteModel(int id, String title, String content, String time_created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time_created = time_created;
    }

    public NoteModel(String title, String content, String time_created){
        this(-1, title, content, time_created);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime_created() {
        return time_created;
    }


}
