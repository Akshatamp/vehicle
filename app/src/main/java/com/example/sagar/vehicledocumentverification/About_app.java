package com.example.sagar.vehicledocumentverification; // 1. Corrected package name to 'sager'

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity; // 2. Changed to AndroidX import

public class About_app extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
    }
}