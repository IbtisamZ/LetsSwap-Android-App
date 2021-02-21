package com.example.letsswap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;



    public static final String DBNAME = "App.db";
    public DBHelper(Context context) {
        super(context, "App.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT)");
        MyDB.execSQL("CREATE TABLE book(bookId INTEGER PRIMARY KEY AUTOINCREMENT, bookName TEXT, bookCategory TEXT, price TEXT, bookStatus TEXT, contact TEXT , image BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        MyDB.execSQL("DROP TABLE IF EXISTS book");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }



    public boolean addBook(String title, String bookcat, String priice, String state, String cont , byte[] image ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("bookName", title);
        cv.put("bookCategory", bookcat);
        cv.put("price", priice);
        cv.put("bookStatus", state);
        cv.put("contact", cont);
        cv.put("image ", image);

        long result = db.insert("book",null, cv);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }


    Cursor hisyoryData(){
        String H = "History";
        String query = "SELECT * FROM book WHERE bookCategory ='"+H+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor scienceData(){
        String S = "Science";
        String query = "SELECT * FROM book WHERE bookCategory ='"+S+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor religionData(){
        String R = "Religion";
        String query = "SELECT * FROM book WHERE bookCategory ='"+R+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor philosophyData(){
        String P = "Philosophy";
        String query = "SELECT * FROM book WHERE bookCategory ='"+P+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor sciData(){
        String SF = "Science Fiction";
        String query = "SELECT * FROM book WHERE bookCategory ='"+SF+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor politicsData(){
        String Pol = "Politics";
        String query = "SELECT * FROM book WHERE bookCategory ='"+Pol+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor mysteryData(){
        String M = "Mystery";
        String query = "SELECT * FROM book WHERE bookCategory ='"+M+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor poetryData(){
        String Poe = "Poetry";
        String query = "SELECT * FROM book WHERE bookCategory ='"+Poe+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor romanceData(){
        String Rom = "Romance";
        String query = "SELECT * FROM book WHERE bookCategory ='"+Rom+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
