
package com.studios.primitive.safealwayz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.studios.primitive.safealwayz.ui.main.Account.AccountModel;
import com.studios.primitive.safealwayz.ui.main.Light.LightDatabaseHelper;
import com.studios.primitive.safealwayz.ui.main.Light.LightModel;

import java.util.List;

public class AccountLightActivity extends AppCompatActivity {
    Button turn;
    ListView listV;
    EditText lightID;
    ArrayAdapter<LightModel> lightArrayAdapter;
    LightDatabaseHelper lightDatabaseHelper;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_light);
        final AccountModel model = (AccountModel) getIntent().getSerializableExtra("obj");
        turn = (Button) findViewById(R.id.turn_light);
        listV = (ListView) findViewById(R.id.list_view);
        lightID = (EditText) findViewById(R.id.light_id_input);

        /*
        lightArrayAdapter = new ArrayAdapter<LightModel>(AccountLightActivity.this, android.R.layout.simple_list_item_1,lightDatabaseHelper.getAllLights(model));
        listV.setAdapter(lightArrayAdapter);

         */

        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lightInput = lightID.getText().toString();
                Toast.makeText(AccountLightActivity.this, model.getUserName(), Toast.LENGTH_SHORT).show();

                //LightModel li = lightDatabaseHelper.getLight(lightInput, model.getUserName());
                //Toast.makeText(AccountLightActivity.this, li.toString(), Toast.LENGTH_SHORT).show();

                /*

                if (lightInput.isEmpty()) {
                    Toast.makeText(AccountLightActivity.this, "Please Choose a LightID", Toast.LENGTH_SHORT).show();
                }else{
                    LightModel li = lightDatabaseHelper.getLight(lightInput, model.getUserName());
                    if(li.isActive()){
                        li.setActive(false);
                    }else{
                        li.setActive(true);
                    }
                    lightDatabaseHelper.changeLightStatus(li);
                    Toast.makeText(AccountLightActivity.this, li.toString() , Toast.LENGTH_SHORT).show();
                    lightArrayAdapter = new ArrayAdapter<LightModel>(AccountLightActivity.this, android.R.layout.simple_list_item_1,lightDatabaseHelper.getAllLights(model));
                    listV.setAdapter(lightArrayAdapter);
                }

                 */
            }
        });



    }
}