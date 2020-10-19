package com.studios.primitive.safealwayz.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.studios.primitive.safealwayz.LoggedInActivity;
import com.studios.primitive.safealwayz.MainActivity;
import com.studios.primitive.safealwayz.R;
import com.studios.primitive.safealwayz.RegisterActivity;

public class ConfirmDeleteActivity extends AppCompatActivity {
    EditText passwordInput;
    EditText emailInput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_delete);

        /*
        Button delete = (Button) findViewById(R.id.confirm_delete);
        Button cancel = (Button) findViewById(R.id.cancel_delete);
        passwordInput = (EditText) findViewById(R.id.password_confrim);
        emailInput = (EditText) findViewById(R.id.email_confirm);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                DatabaseHelper helper = new DatabaseHelper(ConfirmDeleteActivity.this);
                Login validate = new Login(helper.getAllAccounts());
                if(validate.isValidated(email, password)){
                    helper.deleteAccount(email);
                    startActivity(new Intent(ConfirmDeleteActivity.this, MainActivity.class));
                }else{
                    //error message
                }
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmDeleteActivity.this, LoggedInActivity.class));
            }
        });
        */

    }
    
}
