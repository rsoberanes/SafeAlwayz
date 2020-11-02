package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.studios.primitive.safealwayz.ui.main.Account.AccountModel;
import com.studios.primitive.safealwayz.ui.main.Account.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    String username, email, password;
    EditText usernameInput;
    EditText passwordInput;
    EditText emailInput;

    Button createAccount;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameInput = (EditText) findViewById(R.id.register_username);
        emailInput = (EditText) findViewById(R.id.register_email);
        passwordInput = (EditText) findViewById(R.id.register_password);

        createAccount = (Button) findViewById(R.id.create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameInput.getText().toString();
                email = emailInput.getText().toString();
                password = passwordInput.getText().toString();
                AccountModel newAccount = new AccountModel(username, password, email);
                DatabaseHelper databaseHelper = new DatabaseHelper(RegisterActivity.this);
                databaseHelper.addAccount(newAccount);
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();
            }
        });

        cancel = (Button) findViewById(R.id.cancel_register);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}