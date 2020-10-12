package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studios.primitive.safealwayz.ui.main.AccountModel;
import com.studios.primitive.safealwayz.ui.main.DatabaseHelper;
import com.studios.primitive.safealwayz.ui.main.Login;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String password, email;
    EditText passwordInput;
    EditText emailInput;

    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = (EditText) findViewById(R.id.email);
        passwordInput = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailInput.getText().toString();
                password = passwordInput.getText().toString();
                //handle these before going to next activity
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                List<AccountModel> acc = databaseHelper.getAllAccounts();
                Login loginAttempt = new Login(acc);


                if(loginAttempt.isValidated(email, password)){
                    startActivity(new Intent(MainActivity.this, LoggedInActivity.class));
                }else{
                    //error message
                }


            }
        });

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }
}