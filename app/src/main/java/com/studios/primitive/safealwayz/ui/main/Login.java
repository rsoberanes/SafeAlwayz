package com.studios.primitive.safealwayz.ui.main;

import android.database.sqlite.SQLiteDatabase;

import com.studios.primitive.safealwayz.RegisterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Login {
    private List<AccountModel> accounts;
    private HashMap <String,String> logins;

    public Login(List<AccountModel> acc){
        this.accounts = acc;


    }

}
