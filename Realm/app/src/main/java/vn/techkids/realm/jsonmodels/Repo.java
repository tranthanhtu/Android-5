package vn.techkids.realm.jsonmodels;

/**
 * Created by Dell latitude E6520 on 11/2/2016.
 */

public class Repo {
    private int id;
    private String name;
    private String full_name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}
