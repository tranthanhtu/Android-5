package com.example.tu.homeworkss15_daily_quote.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tu.homeworkss15_daily_quote.models.Quote;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 30/10/2016.
 */
public class DbHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "quote.db";
    private static final int DATABASE_VERSION = 1;

    /*=========================== Quote ===========================*/
    private static final String QUOTE_TABLE_NAME = "tbl_quote";
    private static final String QUOTE_COLUMN_TITLE = "title";
    private static final String QUOTE_COLUMN_ID = "id";
    private static final String QUOTE_COLUMN_CONTENT = "content";
    private static final String[] QUOTE_COLUMS = new String[] {
            QUOTE_COLUMN_TITLE,
            QUOTE_COLUMN_CONTENT,
            QUOTE_COLUMN_ID
    };

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insert(Quote quote) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE, quote.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT, quote.getContent());
        long id = db.insert(QUOTE_TABLE_NAME, null, contentValues);
        quote.setId((int) id);
        db.close();
    }

    public Quote selectRandomQuote() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(QUOTE_TABLE_NAME,QUOTE_COLUMS,
                null,
                null,
                null,
                null,
                "RANDOM()",
                "1");
        if (cursor.moveToNext()) {
            // Row exists
            return createQuote(cursor);
        }
        return null;
    }


    public List<Quote> selectALlQuotes() {
        ArrayList<Quote> quoteList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(QUOTE_TABLE_NAME,QUOTE_COLUMS,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            // Get data by filed
            Quote quote = createQuote(cursor);
            quoteList.add(quote);
        }
        cursor.close();
        db.close();
        return quoteList;
    }

    private Quote createQuote(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(QUOTE_COLUMN_ID)); //id
        String title = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_CONTENT));
        Quote quote = new Quote(id, title, content);
        return quote;
    }

    /*=========================== Singleton ===========================*/

    private static DbHelper instance = null;

    public static DbHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbHelper(context);
    }
}
