package com.example.sagar.vehicledocumentverification;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Missing_bike extends AppCompatActivity
{

    EditText editText_v_no;
    Button button_submit;
    SharedPrefHandler sharedPrefHandler;
    String string_v_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_bike);

        sharedPrefHandler=new SharedPrefHandler(this);

        editText_v_no=(EditText)findViewById(R.id.et_missing_vehicle);
        button_submit=(Button)findViewById(R.id.btn_missing_vehicle_submit);


        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                string_v_no=editText_v_no.getText().toString();


                if (string_v_no.isEmpty())
                {
                    Toast.makeText(Missing_bike.this, "Enter Vehicle number", Toast.LENGTH_SHORT).show();
                }
                else {
                    sharedPrefHandler.setSharedPreferences("vno", string_v_no);


                    Intent intent = new Intent(getApplication(), Missing_bike_details.class);
                    startActivity(intent);
                }



            }
        });







    }
}
