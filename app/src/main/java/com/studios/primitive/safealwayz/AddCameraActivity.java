package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.material.tabs.TabLayout;
import com.studios.primitive.safealwayz.ui.main.CCTV.CCTVModel;
import com.studios.primitive.safealwayz.ui.main.CCTV.DBCCTV;
import com.studios.primitive.safealwayz.ui.main.Fragments.AppliancesFragment;
import com.studios.primitive.safealwayz.ui.main.Fragments.SectionsPagerAdapter;
import com.studios.primitive.safealwayz.ui.main.Fragments.SettingsFragment;

public class AddCameraActivity extends AppCompatActivity {

    String name;
    EditText nameInput;

    Button addCameraButton;
    Button cancelAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camera);

        nameInput = (EditText) findViewById(R.id.camera_name);

        addCameraButton = (Button) findViewById(R.id.add_camera);
        addCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameInput.getText().toString();
                CCTVModel newCamera = new CCTVModel(name);
                DBCCTV dbcctv = new DBCCTV(AddCameraActivity.this);
                dbcctv.addCamera(newCamera);

            }
        });

        cancelAddButton = (Button) findViewById(R.id.cancel_add_camera);
        cancelAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddCameraActivity.this, LoggedInActivity.class));
            }
        });

    }
}