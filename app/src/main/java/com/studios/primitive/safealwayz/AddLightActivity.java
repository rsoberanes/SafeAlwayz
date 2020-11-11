package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studios.primitive.safealwayz.ui.main.Account.AccountModel;
import com.studios.primitive.safealwayz.ui.main.Light.LightDatabaseHelper;
import com.studios.primitive.safealwayz.ui.main.Light.LightModel;

import java.io.Serializable;

public class AddLightActivity extends AppCompatActivity {
    EditText location;
    Button connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_light);

        final AccountModel model = (AccountModel) getIntent().getSerializableExtra("obj");

        location = (EditText) findViewById(R.id.get_location);
        connect = (Button) findViewById(R.id.connect_light);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationIn = location.getText().toString();
                if(locationIn.isEmpty()){
                    Toast.makeText(AddLightActivity.this, "Please Fill in location", Toast.LENGTH_SHORT).show();
                }else{
                    LightModel light = new LightModel(locationIn,model);
                    LightDatabaseHelper ldb = new LightDatabaseHelper(AddLightActivity.this);
                    ldb.addLight(light, model);



                }

            }
        });


    }
}