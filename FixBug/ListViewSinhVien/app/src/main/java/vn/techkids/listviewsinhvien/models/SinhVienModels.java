package vn.techkids.listviewsinhvien.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/28/2016.
 */

public class SinhVienModels {
    private int id;
    private String hoten;
    private String mssv;
    private String lop;

    public SinhVienModels(int id, String hoten, String mssv, String lop) {
        this.id = id;
        this.hoten = hoten;
        this.mssv = mssv;
        this.lop = lop;
    }

    public SinhVienModels(String hoten, String mssv, String lop){
        this(-1, hoten, mssv, lop);
    }

    public int getId() {
        return id;
    }

    public String getHoten() {
        return hoten;
    }

    public String getMssv() {
        return mssv;
    }

    public String getLop() {
        return lop;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<SinhVienModels> list = new ArrayList<>();

}
