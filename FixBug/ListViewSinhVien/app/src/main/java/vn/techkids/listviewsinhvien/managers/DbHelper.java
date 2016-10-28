package vn.techkids.listviewsinhvien.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import vn.techkids.listviewsinhvien.models.SinhVienModels;

/**
 * Created by Dell latitude E6520 on 10/28/2016.
 */

public class DbHelper extends SQLiteAssetHelper {

    public static final String DB_NAME = "test.db";
    public static final int DB_Version = 1;
    private static final String DB_TABLE = "sinhvien";
    private static final String SINHVIEN_COLUMN_ID = "id";
    private static final String SINHVIEN_COLUMN_HOTEN = "hoten";
    private static final String SINHVIEN_COLUMN_MSSV = "mssv";
    private static final String SINHVIEN_COLUMN_LOP = "lop";
    private static final String[] SINHVIEN_COLUMN = new String[]{
            SINHVIEN_COLUMN_ID,
            SINHVIEN_COLUMN_HOTEN,
            SINHVIEN_COLUMN_MSSV,
            SINHVIEN_COLUMN_LOP
    };

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    public List<SinhVienModels> selectAllSinhVien(){
        SQLiteDatabase database =   getReadableDatabase();

        Cursor cursor = database.query(DB_TABLE, SINHVIEN_COLUMN, null, null, null, null, null);
        while (cursor.moveToNext()){
            SinhVienModels.list.add(creatSinhVienModel(cursor));
        }
        cursor.close();
        database.close();
        return SinhVienModels.list;
    }

    public void insert(SinhVienModels sinhVienModels){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SINHVIEN_COLUMN_HOTEN, sinhVienModels.getHoten());
        contentValues.put(SINHVIEN_COLUMN_MSSV, sinhVienModels.getMssv());
        contentValues.put(SINHVIEN_COLUMN_LOP, sinhVienModels.getLop());
        long id  = database.insert(DB_TABLE, null, contentValues);
        sinhVienModels.setId((int) id);

        database.close();
    }


    private SinhVienModels creatSinhVienModel(Cursor cursor){
        int id = cursor.getInt(cursor.getColumnIndex(SINHVIEN_COLUMN_ID));
        String hoten = cursor.getString(cursor.getColumnIndex(SINHVIEN_COLUMN_HOTEN));
        String mssv = cursor.getString(cursor.getColumnIndex(SINHVIEN_COLUMN_MSSV));
        String lop = cursor.getString(cursor.getColumnIndex(SINHVIEN_COLUMN_LOP));
        SinhVienModels sinhVienModels = new SinhVienModels(id, hoten, mssv, lop);
        return sinhVienModels;
    }

    private static DbHelper instance;
    public static DbHelper getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new DbHelper(context);
    }
}
