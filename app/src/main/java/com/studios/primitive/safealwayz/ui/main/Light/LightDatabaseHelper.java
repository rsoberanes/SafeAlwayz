package com.studios.primitive.safealwayz.ui.main.Light;
import com.studios.primitive.safealwayz.ui.main.Account.AccountModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LightDatabaseHelper extends SQLiteOpenHelper {

    public static final String LIGHTS = "LIGHTS";
    public static final String COLUMN_LIGHTID = "LIGHTID";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_STATUS = "STATUS";

    public LightDatabaseHelper(@Nullable Context context) {
        super(context, "lights.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + LIGHTS + " (" + COLUMN_LIGHTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USERNAME + " TEXT, " + COLUMN_LOCATION + " TEXT, " + COLUMN_STATUS + " BOOL)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addLight(LightModel light, AccountModel accountModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERNAME, accountModel.getUserName());
        cv.put(COLUMN_LOCATION, light.getLocation());
        cv.put(COLUMN_STATUS, light.isActive());
        long insert = db.insert(LIGHTS, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }
    public void changeLightStatus(LightModel light){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_LIGHTID, light.getLightID());
        cv.put(COLUMN_LOCATION,light.getLocation());
        cv.put(COLUMN_USERNAME, light.getUsername());
        cv.put(COLUMN_STATUS, light.isActive());
        db.update(LIGHTS, cv, COLUMN_LIGHTID + " = ?", new String[] { String.valueOf(light.getLightID())});


    }
    public List<LightModel> getAllLights(AccountModel account){
        List<LightModel> rtnList = new ArrayList<>();
        String queryCommand = "SELECT * FROM " + LIGHTS +" WHERE " + COLUMN_USERNAME + " = " + "'"+account.getUserName()+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryCommand,null);
        if(cursor.moveToFirst()){
            do{
                int LightID = cursor.getInt(0);
                String username = cursor.getString(1);
                String lightLocation = cursor.getString(2);
                boolean lightStatus = cursor.getInt(3) == 1? true: false;
                LightModel newLight = new LightModel(lightLocation, account);
                newLight.setActive(lightStatus);
                newLight.setLightID(LightID);

                rtnList.add(newLight);

            }while(cursor.moveToNext());
        }else{
            //returns an empty list
        }
        cursor.close();
        db.close();
        return rtnList;
    }
    public LightModel getLight(String lightID, String username){
        LightModel light = new LightModel(username);
        SQLiteDatabase db = this.getReadableDatabase();
        String queryCommand = "SELECT * FROM " + LIGHTS + " WHERE "+ COLUMN_LIGHTID + " = "+ "'" + lightID +"'";
        Cursor cursor = db.rawQuery(queryCommand,null);
        if(cursor.moveToFirst()){
            do{
                int lightNum = cursor.getInt(0);
                String user = cursor.getString(1);
                String location = cursor.getString(2);
                boolean status = cursor.getInt(3) == 1 ? true: false;

                light.setActive(status);
                light.setLocation(location);
                light.setLightID(lightNum);


            }while(cursor.moveToNext());
        }else{
            //returns an empty list
        }
        cursor.close();
        db.close();
        return light;

    }
}
