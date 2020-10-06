package com.studios.primitive.safealwayz.ui.main;

import java.util.HashMap;
import java.util.List;

public class Login {
    private List<AccountModel> accounts;
    private HashMap <String,String> login;

    public Login(List<AccountModel> acc){
        this.accounts = acc;
        login = new HashMap<>();
        for (AccountModel account : acc){
            login.put(account.getEmail(),account.getPassword());
        }


    }
    public Boolean isValidated(String email, String password){
        boolean valid = false;
        if(login.containsKey(email)){
            if(login.get(email) == password){
                valid = true;
            }
        }else{
            valid = false;
        }

        return valid;
    }

}
