package com.example.sagar.vehicledocumentverification;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Login_page extends AppCompatActivity {

    EditText editText_mno, editText_password;
    Button button_login, button_create;
    String s1, s2;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    ProgressDialog progressBar;

    SharedPrefHandler sharedPrefHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        sharedPrefHandler = new SharedPrefHandler(this);

        editText_mno = (EditText) findViewById(R.id.et_login_mno);
        editText_password = (EditText) findViewById(R.id.et_login_password);
        button_login = (Button) findViewById(R.id.btn_login_login);
        button_create = (Button) findViewById(R.id.btn_login_create);



        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(getApplication(),Create_account.class);
                startActivity(intent);

            }
        });




        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = editText_mno.getText().toString();
                String password = editText_password.getText().toString();






                sharedPrefHandler.setSharedPreferences("mno",username);


                doLogin(username,password);


//                    sharedPrefHandler.setSharedPreferences("user", username);
//                    sharedPrefHandler.setSharedPreferences("login","true");




            }
        });







    }

    private boolean validateLogin(final String username, final String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_LONG).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }



    private void doLogin(final String username, final String password){
        // creating progress bar dialog
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(false);
        progressBar.setMessage("Please wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // progressBar.setProgress(0);
        // progressBar.setMax(100);
        progressBar.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.doLogin(username, password);

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if(responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if(isSuccess) {
                    progressBar.dismiss();

                    Toast.makeText(Login_page.this, "Login Successfully..", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplication(),MainActivity.class);
                    startActivity(intent);
                    finish();


                } else {
                    // Show Login Failed Message
                    progressBar.dismiss();
                    showLoginFailedToast();
                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showLoginFailedToast() {
        Toast.makeText(this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
    }







}