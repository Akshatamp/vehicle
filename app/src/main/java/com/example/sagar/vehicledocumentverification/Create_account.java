package com.example.sagar.vehicledocumentverification;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Create_account extends AppCompatActivity
{

    EditText editText_name,editText_mno,editText_email,editText_password;
    Spinner spinner_city,spinner_occupation;
    Button button_submit;
    String stringname,stringmno,stringemail,stringpassword;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    SharedPrefHandler sharedPrefHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
sharedPrefHandler=new SharedPrefHandler(this);


        editText_name=(EditText)findViewById(R.id.et_create_name);
        editText_mno=(EditText)findViewById(R.id.et_create_mno);
        editText_email=(EditText)findViewById(R.id.et_create_email);
        editText_password=(EditText)findViewById(R.id.et_create_password);


        button_submit=(Button)findViewById(R.id.btn_create_submit);




        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                stringname=editText_name.getText().toString();
                stringmno=editText_mno.getText().toString();
                stringemail=editText_email.getText().toString();
                stringpassword=editText_password.getText().toString();


                CreateUserAccount();
                //SetValidation();
                Toast.makeText(Create_account.this, "  Account Create successfully.", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplication(),Login_page.class);
                startActivity(intent);
                finish();


            }
        });


    }


    public void SetValidation() {
        // Check for a valid name.
        if (editText_name.getText().toString().isEmpty()) {
            editText_name.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else {
            isNameValid = true;
        }

        // Check for a valid email address.
        if (editText_email.getText().toString().isEmpty()) {
            editText_email.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editText_email.getText().toString()).matches()) {
            editText_email.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else {
            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (editText_mno.getText().toString().isEmpty()) {
            editText_mno.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else if (!Patterns.PHONE.matcher(editText_mno.getText().toString()).matches() || editText_mno.getText().toString().length() < 10) {
            editText_mno.setError(getResources().getString(R.string.phone_error));
            isEmailValid = false;
        } else {
            isPhoneValid = true;
        }

        // Check for a valid password.
        if (editText_password.getText().toString().isEmpty()) {
            editText_password.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
        }

        if (isNameValid && isEmailValid && isPhoneValid && isPasswordValid) {



            // Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }

    }


    private void CreateUserAccount()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.CreateAccount
                (
                stringname,
                stringmno,
                stringemail,
                stringpassword
        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if(responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if(isSuccess) {

                    showCreateSuccessToast();
                } else {
                    // Show Creation Failed Message
                    showCreateFailedToast();
                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
               // Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showCreateFailedToast() {
        Toast.makeText(this, "OOPS,   Create action failed!", Toast.LENGTH_LONG).show();
    }

    private void showCreateSuccessToast() {
        Toast.makeText(this, "  created successfully.", Toast.LENGTH_LONG).show();
    }

    private void showEditFailedToast() {
        Toast.makeText(this, "OOPS,   Edit action failed!", Toast.LENGTH_LONG).show();
    }

    private void showEditSuccessToast() {
        Toast.makeText(this, "  updated successfully.", Toast.LENGTH_LONG).show();
    }




//
//    private class MyAsyncTaskreg extends AsyncTask<String, Void, String>
//    {
//        private ProgressDialog progressDialog = new ProgressDialog(Create_account.this);
//
//        protected void onPreExecute()
//        {
//            progressDialog.setMessage("Please Wait");
//            progressDialog.show();
//
//        }
//        public void postData( String stringname,String stringmno,String stringemail,String stringpassword)
//        {
//            // Create a new HttpClient and Post Header
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("https://broken-winded-slash.000webhostapp.com/QR_CODE/register.php");
//
//            try {
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                //nameValuePairs.add(new BasicNameValuePair("f1", usn));
//                nameValuePairs.add(new BasicNameValuePair("f1", stringname));
//                nameValuePairs.add(new BasicNameValuePair("f2", stringmno));
//                nameValuePairs.add(new BasicNameValuePair("f3", stringemail));
//                nameValuePairs.add(new BasicNameValuePair("f4", stringpassword));
//
//
//
//
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                Log.d("nameValuePairs",""+nameValuePairs);
//                HttpResponse response = httpclient.execute(httppost);
//
//                HttpEntity entity = response.getEntity();
//
//
//                // If the response does not enclose an entity, there is no need
//                if (entity != null) {
//                    InputStream instream = entity.getContent();
//
//                    String result;
//                    result = convertStreamToString(instream);
//                    Log.d("respo", "" + result);
//                    JSONObject jsonObject = new JSONObject(result);
//                    String status = jsonObject.getString("success");
//                    Log.d("status", "" + status);
//
//                    if (status.equals("1"))
//                    {
//                        Intent intent=new Intent(getApplication(),Login_page.class);
//                        startActivity(intent);
//                        Toast.makeText(Create_account.this, "User Register Successfull", Toast.LENGTH_SHORT).show();
//
//                    }
//                    else
//                    {
//
//                        Toast.makeText(Create_account.this, "User Register Fail", Toast.LENGTH_SHORT).show();
//
//                    }
//
//
//
//                }
//
//
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        protected String doInBackground (String...params)
//        {
//            postData(stringname,stringmno,stringemail,stringpassword);
//            progressDialog.dismiss();
//            return null;
//        }
//        private  String convertStreamToString(InputStream is)
//        {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//
//            String line = null;
//            try {
//                while ((line = reader.readLine()) != null)
//                {
//                    sb.append(line + "\n");
//                }
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//            finally
//            {
//                try
//                {
//                    is.close();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            return sb.toString();
//        }
//    }
//    private void showToast(final String res)
//    {
//        runOnUiThread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                //stuff that updates ui
//                if (res.equals("1"))
//                {
//                    Toast.makeText(getApplicationContext(), "  Register Successful ", Toast.LENGTH_SHORT).show();
//
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(), "Register Failed ", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

}













