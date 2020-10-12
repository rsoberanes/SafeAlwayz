package com.studios.primitive.safealwayz.ui.main;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String ACCOUNTS = "ACCOUNTS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_EMAIL = "EMAIL";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ACCOUNTS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USERNAME + " TEXT UNIQUE, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_EMAIL + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addAccount(AccountModel accountModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERNAME, accountModel.getUserName());
        cv.put(COLUMN_PASSWORD, accountModel.getPassword());
        cv.put(COLUMN_EMAIL, accountModel.getEmail());
        long insert = db.insert(ACCOUNTS, null, cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }
    public List<AccountModel> getAllAccounts(){
        List<AccountModel> rtnList = new ArrayList<>();
        String queryCommand = "SELECT * FROM " + ACCOUNTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryCommand,null);
        if(cursor.moveToFirst()){
            do{
                int accID = cursor.getInt(0);
                String accUsername = cursor.getString(1);
                String accPassword = cursor.getString(2);
                String accEmail = cursor.getString(3);

                AccountModel newAcc = new AccountModel(accUsername,accPassword,accEmail);
                newAcc.setId(accID);
                rtnList.add(newAcc);

            }while(cursor.moveToNext());
        }else{
            //returns an empty list
        }
        cursor.close();
        db.close();
        return rtnList;
    }
    public boolean deleteAccount(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryCommand = "DELETE FROM "+ ACCOUNTS + " WHERE " + COLUMN_EMAIL + " = " + email;
        Cursor cursor = db.rawQuery(queryCommand, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }


}
