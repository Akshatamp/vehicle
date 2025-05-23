package com.example.sagar.vehicledocumentverification;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Flash_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_page);


        Thread thread=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent=new Intent(getApplication(),Login_page.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e)
                {

                }
            }
        };

        thread.start();


    }
}
