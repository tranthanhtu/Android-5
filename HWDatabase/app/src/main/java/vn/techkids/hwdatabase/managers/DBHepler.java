package vn.techkids.hwdatabase.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import vn.techkids.hwdatabase.models.NoteModel;

/**
 * Created by Dell latitude E6520 on 10/29/2016.
 */

public class DBHepler extends SQLiteAssetHelper {

    private final static String DB_NAME = "Note.db";
    private final static int DB_VERSION = 1;
    private static final String QUOTE_TABLE_NAME = "Note";
    private static final String QUOTE_COLUMN_ID = "id";
    private static final String QUOTE_COLUMN_TITLE = "title";
    private static final String QUOTE_COLUMN_CONTENT = "content";
    private static final String QUOTE_COLUMN_TIME_CREATED = "time_created";
    private static final String[] QUOTE_COLUMNS = new String[]{
            QUOTE_COLUMN_ID,
            QUOTE_COLUMN_TITLE,
            QUOTE_COLUMN_CONTENT,
            QUOTE_COLUMN_TIME_CREATED
    };

    public DBHepler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insert(NoteModel tempNote) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE, tempNote.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT, tempNote.getContent());
        contentValues.put(QUOTE_COLUMN_TIME_CREATED, tempNote.getTime_created());
        long id = writableDatabase.insert(QUOTE_TABLE_NAME, null, contentValues);
        tempNote.setId((int) id);
        writableDatabase.close();
    }


    public List<NoteModel> selectAllNote() {
        ArrayList<NoteModel> quotesList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

//    public Cursor query(String table, String[] columns, String selection,
//                        String[] selectionArgs, String groupBy, String having,
//                        String orderBy) {

        Cursor cursor = db.query(QUOTE_TABLE_NAME,
                QUOTE_COLUMNS,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            quotesList.add(createNote(cursor));
        }
        cursor.close();

        db.close();
        return quotesList;
    }

    public void deleteAllNote() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(
                QUOTE_TABLE_NAME,
                null,
                null
        );
    }

    public void update(NoteModel noteModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE, noteModel.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT, noteModel.getContent());
        contentValues.put(QUOTE_COLUMN_TIME_CREATED, noteModel.getTime_created());

        db.update(
                QUOTE_TABLE_NAME,
                contentValues,
                QUOTE_COLUMN_ID + "=" + noteModel.getId(),
                null
        );
        db.close();
    }


    private NoteModel createNote(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(QUOTE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_CONTENT));
        String time_created = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_TIME_CREATED));
        return new NoteModel(id, title, content, time_created);
    }

    public NoteModel getRandomQuote() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(QUOTE_TABLE_NAME,//table
                QUOTE_COLUMNS,//column
                null,//selection
                null,//selectionArgs
                null,//groupBy
                null,//having
                "RANDOM()",//orderBy
                "1");//limit

        if (cursor.moveToNext()) {
            return createNote(cursor);
        }
        return null;
    }

    private static DBHepler instance;
    public static DBHepler getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DBHepler(context);
    }

    public void delete(NoteModel tmpNote) {
        //delete by ID
        SQLiteDatabase db = getWritableDatabase();
        db.delete(
                QUOTE_TABLE_NAME,
                QUOTE_COLUMN_ID + "=" + tmpNote.getId(),
                null
        );
    }
}

