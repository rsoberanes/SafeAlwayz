package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.studios.primitive.safealwayz.ui.main.Account.AccountModel;

import java.io.Serializable;

public class AddDeviceActivity extends AppCompatActivity {

    Button addCCTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        addCCTV = (Button) findViewById(R.id.add_cctv);
        addCCTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AccountModel model = (AccountModel) getIntent().getSerializableExtra("obj");
                Intent intent = new Intent(AddDeviceActivity.this, AddCameraActivity.class);
                intent.putExtra("obj", (Serializable) model);
                startActivity(intent);
            }
        });

    }
}