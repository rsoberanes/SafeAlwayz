package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                startActivity(new Intent(AddDeviceActivity.this, AddCameraActivity.class));
            }
        });

    }
}