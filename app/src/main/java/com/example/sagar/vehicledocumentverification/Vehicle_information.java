package com.example.sagar.vehicledocumentverification;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Vehicle_information extends AppCompatActivity
{

    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;
    TextView textView1d,textView2d,textView3d,textView4d,textView5d,textView6d,textView7d,textView8d,textView9d,textView10d;
    TextView textView1e,textView2e,textView3e,textView4e,textView5e,textView6e,textView7e,textView8e;

    TextView textView1i,textView2i,textView3i,textView4i,textView5i,textView6i,textView7i,textView8i;

    SharedPrefHandler sharedPrefHandler;
    String string_qe;
    String todayString;

    String string_driving_valid,string_documnet_valid,string_emission_valid,string_insurence_valid;

    Button button_msg;

    int dr_a,dr_b,do_a,do_b,em_a,em_b,in_a,in_b;
    List<Vehicle_Driving> productList1;
    List<Vehicle_Document> productList2;
    List<Vehicle_Insurence> productList3;
    List<Vehicle_Emission> productList4;
Date date_todays;
    Date date_dr,date_do,date_em,date_in;
    Date todayDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_information);
        sharedPrefHandler = new SharedPrefHandler(this);

        string_qe = sharedPrefHandler.getSharedPreferences("qrcode");
        Toast.makeText(this, "" + string_qe, Toast.LENGTH_SHORT).show();


        textView1 = (TextView) findViewById(R.id.TextViewCard1);
        textView2 = (TextView) findViewById(R.id.TextViewCard2);
        textView3 = (TextView) findViewById(R.id.TextViewCard3);
        textView4 = (TextView) findViewById(R.id.TextViewCard4);
        textView5 = (TextView) findViewById(R.id.TextViewCard5);
        textView6 = (TextView) findViewById(R.id.TextViewCard6);
        textView7 = (TextView) findViewById(R.id.TextViewCard7);
        textView8 = (TextView) findViewById(R.id.TextViewCard8);
        textView9 = (TextView) findViewById(R.id.TextViewCard9);
        textView10 = (TextView) findViewById(R.id.TextViewCard10);


        textView1d = (TextView) findViewById(R.id.TextViewCard1d);
        textView2d = (TextView) findViewById(R.id.TextViewCard2d);
        textView3d = (TextView) findViewById(R.id.TextViewCard3d);
        textView4d = (TextView) findViewById(R.id.TextViewCard4d);
        textView5d = (TextView) findViewById(R.id.TextViewCard5d);
        textView6d = (TextView) findViewById(R.id.TextViewCard6d);
        textView7d = (TextView) findViewById(R.id.TextViewCard7d);
        textView8d = (TextView) findViewById(R.id.TextViewCard8d);
        textView9d = (TextView) findViewById(R.id.TextViewCard9d);
        textView10d = (TextView) findViewById(R.id.TextViewCard10d);


        textView1e = (TextView) findViewById(R.id.TextViewCard1e);
        textView2e = (TextView) findViewById(R.id.TextViewCard2e);
        textView3e = (TextView) findViewById(R.id.TextViewCard3e);
        textView4e = (TextView) findViewById(R.id.TextViewCard4e);
        textView5e = (TextView) findViewById(R.id.TextViewCard5e);
        textView6e = (TextView) findViewById(R.id.TextViewCard6e);
        textView7e = (TextView) findViewById(R.id.TextViewCard7e);
        textView8e = (TextView) findViewById(R.id.TextViewCard8e);


        textView1i = (TextView) findViewById(R.id.TextViewCard1i);
        textView2i = (TextView) findViewById(R.id.TextViewCard2i);
        textView3i = (TextView) findViewById(R.id.TextViewCard3i);
        textView4i = (TextView) findViewById(R.id.TextViewCard4i);
        textView5i = (TextView) findViewById(R.id.TextViewCard5i);
        textView6i = (TextView) findViewById(R.id.TextViewCard6i);
        textView7i = (TextView) findViewById(R.id.TextViewCard7i);
        textView8i = (TextView) findViewById(R.id.TextViewCard8i);

        button_msg = (Button) findViewById(R.id.fine);


        button_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                AlertDialog.Builder builder = new AlertDialog.Builder(Vehicle_information.this);
//                builder.setMessage("This Notice from RTO.Your Vehicle Penalty Amount Rs.1000 Kindly Pay amount within 8 working days of date of notice issued.Thank You.");
//                builder.setTitle("VEHICLE NOTICE");
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();


                Intent intent=new Intent(getApplication(),Add_penalty.class);
                startActivity(intent);




            }
        });


        getDriving(string_qe);
        getDocument(string_qe);
        getInsurence(string_qe);
        getEmission(string_qe);







//
//
//
//        string_documnet_valid=sharedPrefHandler.getSharedPreferences("document");
//
//
//
//
//        SimpleDateFormat formatter_do = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            date_do=formatter_do.parse(string_documnet_valid);
//
//
//        }catch (Exception e)
//        {
//
//        }
//
//
//
//
//
//
//        if(date_do.compareTo(date_todays) < 0)
//        {
//
//            textView9d.setTextColor(getResources().getColor(R.color.some_color));
//        }
//        else
//        {
//
//        }
//
//
//
//
//
//                string_emission_valid=sharedPrefHandler.getSharedPreferences("emission");
//
//
//
//
//
//
//        SimpleDateFormat formatter_em = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            date_em=formatter_em.parse(string_emission_valid);
//
//
//        }catch (Exception e)
//        {
//
//        }
//
//
//
//
//
//
//
//
//        if (date_em.compareTo(date_todays) < 0)
//        {
//
//            textView5e.setTextColor(getResources().getColor(R.color.some_color));
//        }
//else {
//
//        }
//
//
//                string_insurence_valid=sharedPrefHandler.getSharedPreferences("insurence");
//
//
//
//
//
//
//        SimpleDateFormat formatter_in = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            date_in=formatter_in.parse(string_insurence_valid);
//
//
//        }catch (Exception e)
//        {
//
//        }
//
//
//        if (date_in.compareTo(date_todays) < 0)
//        {
//
//            textView6i.setTextColor(getResources().getColor(R.color.some_color));
//        }
//        else {
//
//        }
//


    }





    public void Driving()
    {

        todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        todayString = formatter.format(todayDate);
        try {

            date_todays=formatter.parse(todayString);

        }catch (Exception e)
        {

        }
        Toast.makeText(this, ""+todayString, Toast.LENGTH_SHORT).show();
        string_driving_valid=sharedPrefHandler.getSharedPreferences("driving");

        SimpleDateFormat formatter_dr = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date_dr=formatter_dr.parse(string_driving_valid);


        }catch (Exception e)
        {

        }

        if (date_dr.compareTo(date_todays) < 0)
        {

            textView7.setTextColor(getResources().getColor(R.color.some_color));
        }
        else
        {


        }



    }








    // Drivining


    private void getDriving(final String string_qe)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Vehicle_Driving>> call = api.getVehicle_Driving(string_qe);

        call.enqueue(new Callback<List<Vehicle_Driving>>() {
            @Override
            public void onResponse(Call<List<Vehicle_Driving>> call, Response<List<Vehicle_Driving>> response) {
                productList1 = response.body();

                Boolean isSuccess = false;
                if(response.body() != null) {
                    isSuccess = true;
                }

                if(isSuccess) {
                    textView1.setText("Vehicle No : "+productList1.get(0).getv_no());
                    textView2.setText("Owner Name : "+productList1.get(0).geto_name());
                    textView3.setText("Vehicle Name : "+productList1.get(0).getv_name());
                    textView4.setText("Mobile No : "+productList1.get(0).getmno());
                    textView5.setText("Address  : "+productList1.get(0).getaddress());
                    textView6.setText("Date of Birth : "+productList1.get(0).getdob());
                    textView7.setText("Validate UpTo : "+productList1.get(0).getvalidate_till());
                    textView8.setText("Blood Group : "+productList1.get(0).getblood_group());
                    textView9.setText("Date of Issued : "+productList1.get(0).getdoi());
                    textView10.setText("Vehicle Type : "+productList1.get(0).getd_type());


                    sharedPrefHandler.setSharedPreferences("driving",textView7.getText().toString());

                   // Driving();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Vehicle_Driving>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Document

    private void getDocument(final String string_qe)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Vehicle_Document>> call = api.getVehicle_Document(string_qe);

        call.enqueue(new Callback<List<Vehicle_Document>>() {
            @Override
            public void onResponse(Call<List<Vehicle_Document>> call, Response<List<Vehicle_Document>> response) {
                productList2 = response.body();

                Boolean isSuccess = false;
                if(response.body() != null) {
                    isSuccess = true;
                }

                if(isSuccess) {
                    textView1d.setText("Vehicle No : "+productList2.get(0).getv_no());
                    textView2d.setText("Registration Date : "+productList2.get(0).getregister_date());
                    textView3d.setText("Vehicle Name : "+productList2.get(0).getv_name());
                    textView4d.setText("Vehicle Type : "+productList2.get(0).getv_type());
                    textView5d.setText("Owner Name  : "+productList2.get(0).geto_name());
                    textView6d.setText("Address : "+productList2.get(0).getaddress());
                    textView7d.setText("Flue : "+productList2.get(0).getfuel());
                    textView8d.setText("Manufacture Date : "+productList2.get(0).getmanu_facture());
                    textView9d.setText("Validate Upto : "+productList2.get(0).getvalidate_upto());
                    textView10d.setText("Seating No : "+productList2.get(0).getseating_no());

                    sharedPrefHandler.setSharedPreferences("document",textView9d.getText().toString());
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Vehicle_Document>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Insurence


    private void getInsurence(final String string_qe)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Vehicle_Insurence>> call = api.getVehicle_Insurence(string_qe);

        call.enqueue(new Callback<List<Vehicle_Insurence>>() {
            @Override
            public void onResponse(Call<List<Vehicle_Insurence>> call, Response<List<Vehicle_Insurence>> response) {
                productList3 = response.body();

                Boolean isSuccess = false;
                if(response.body() != null) {
                    isSuccess = true;
                }

                if(isSuccess) {
                    textView1i.setText("Vehicle No : "+productList3.get(0).getv_no());
                    textView2i.setText("Owner Name : "+productList3.get(0).geto_name());
                    textView3i.setText("vehicle Type : "+productList3.get(0).getv_type());
                    textView4i.setText("Vehicle Price : "+productList3.get(0).getv_price());
                    textView5i.setText("Insurence Date : "+productList3.get(0).getinsurence_date());
                    textView6i.setText("Validate Upto : "+productList3.get(0).getvalid_upto());
                    textView7i.setText("Insurence Amount : "+productList3.get(0).getinsurence_amount());
                    textView8i.setText("Address : "+productList3.get(0).getaddress());

                    sharedPrefHandler.setSharedPreferences("insurence",textView6i.getText().toString());


                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Vehicle_Insurence>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Emission


    private void getEmission(final String string_qe)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Vehicle_Emission>> call = api.getVehicle_Emission(string_qe);

        call.enqueue(new Callback<List<Vehicle_Emission>>() {
            @Override
            public void onResponse(Call<List<Vehicle_Emission>> call, Response<List<Vehicle_Emission>> response) {
                productList4 = response.body();

                Boolean isSuccess = false;
                if(response.body() != null) {
                    isSuccess = true;
                }

                if(isSuccess) {
                    textView1e.setText("Vehicle No : "+productList4.get(0).getv_no());
                    textView2e.setText("Owner Name : "+productList4.get(0).geto_name());
                    textView3e.setText("vehicle Name : "+productList4.get(0).getv_name());
                    textView4e.setText("Date : "+productList4.get(0).getemission_test_date());
                    textView5e.setText("Valid Upto : "+productList4.get(0).getemission_valid_upto());
                    textView6e.setText("Vehicle Type : "+productList4.get(0).getv_type());
                    textView7e.setText("Vehicle Condition : "+productList4.get(0).getv_condition());
                    textView8e.setText("Carbon Value : "+productList4.get(0).getcarbon_value());

                    sharedPrefHandler.setSharedPreferences("emission",textView5e.getText().toString());
                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Vehicle_Emission>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





//
//
//    private class MyAsyncTaskDriving extends AsyncTask<String, Void, String> {
//        private ProgressDialog progressDialog = new ProgressDialog(Vehicle_information.this);
//
//        protected void onPreExecute()
//        {
//            progressDialog.setMessage("Fetching data...");
//            progressDialog.show();
//            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface arg0)
//                {
//                    MyAsyncTaskDriving.this.cancel(true);
//
//                }
//            });
//        }
//
//        public void postData( String string_qe) {
//
//
//            // Create a new HttpClient and Post Header
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("https://broken-winded-slash.000webhostapp.com/QR_CODE/get_driving.php");
//
//            try {
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//
//                nameValuePairs.add(new BasicNameValuePair("f1", string_qe));
//                // nameValuePairs.add(new BasicNameValuePair("f2",rcv_sem));
//
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                Log.d("nameValuePairs", "" + nameValuePairs);
//                HttpResponse response = httpclient.execute(httppost);
//                HttpEntity entity = response.getEntity();
//
//
//                // If the response does not enclose an entity, there is no need
//                if (entity != null) {
//                    InputStream instream = entity.getContent();
//
//                    String result;
//                    result = convertStreamToString(instream);
//                    Log.d("aaa", "" + result);
//
//
//                    JSONArray arr = new JSONArray(result);
//                    for (int i = 0; i < arr.length(); i++) {
//                        JSONObject jsonObject = arr.getJSONObject(i);
//                        String  v_no = jsonObject.getString("v_no");
//                        String o_name = jsonObject.getString("o_name");
//                        String  v_name = jsonObject.getString("v_name");
//                        String  mno = jsonObject.getString("mno");
//                        String  address = jsonObject.getString("address");
//                        String  dob = jsonObject.getString("dob");
//                        String  validate_till = jsonObject.getString("validate_till");
//                        String  blood_group = jsonObject.getString("blood_group");
//                        String  doi = jsonObject.getString("doi");
//                        String  d_type = jsonObject.getString("d_type");
//
//                        sharedPrefHandler.setSharedPreferences("driving",validate_till);
//
//
//                        setdata(v_no, o_name,v_name,mno, address,dob,validate_till,blood_group,doi,d_type);
//
//                    }
//                }
//
//
//            } catch (Exception e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "Something went wrong.Please try again.", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        }
//
//
//
//
//        public void setdata( final  String v_no,final  String o_name,final  String v_name,final  String mno,final  String address,final  String dob,final  String validate_till,final  String blood_group,final  String doi,final  String d_type)
//        {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    textView1.setText("VEHICHLE NUMBER  :  "+v_no);
//                    textView2.setText("OWNER NAME : "+o_name);
//                    textView3.setText("VEHICHLE NAME : "+v_name);
//                    textView4.setText("MOBILE NUMBER  : "+mno);
//                    textView5.setText("ADDRESS  : "+address);
//                    textView6.setText("DATE OF BIRTH : "+dob);
//                    textView7.setText("VALIDATE TILL  : "+validate_till);
//                    textView8.setText("BLOOD GROUP  : "+blood_group);
//                    textView9.setText("DATE OF ISSUED  : "+doi);
//                    textView10.setText("VEHICHLE TYPE  : "+d_type);
//
//
//                }
//            });
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            postData(string_qe);
//            //start loading proggress dialog
//            //pd= ProgressDialog.show(Chg_Password.this, "Loading...","");
//            this.progressDialog.dismiss();
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            //dissmiss
//            //pd.dismiss();
//            //  adp.notifyDataSetChanged();
//        }
//
//        private String convertStreamToString(InputStream is) {
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String result;
//            String line = null;
//            try {
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//            } catch (Exception ex) {
//                Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_LONG).show();
//            }
//
//            result = sb.toString().trim();
//
//
//            result = result.substring(1, result.length() - 1);
//
//            if (!result.trim().equals("Error")) {
//                String[] r = result.split("-");
//
//
//            } else
//
//                Toast.makeText(getApplication(), "", Toast.LENGTH_LONG).show();
//            return sb.toString();
//
//        }
//
//        private void showToast(final String res) {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    //stuff that updates ui
//                    if (res.equals("1")) {
//                        Toast.makeText(getApplicationContext(), " Successfull", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        Toast.makeText(getApplicationContext(), " Failed ", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//
//
//    }
//
//
//
//    //Documents
//
//
//
//
//
//    private class MyAsyncTaskDocument extends AsyncTask<String, Void, String> {
//        private ProgressDialog progressDialog = new ProgressDialog(Vehicle_information.this);
//
//        protected void onPreExecute()
//        {
//            progressDialog.setMessage("Fetching data...");
//            progressDialog.show();
//            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface arg0)
//                {
//                    MyAsyncTaskDocument.this.cancel(true);
//
//                }
//            });
//        }
//
//        public void postData( String string_qe) {
//
//
//            // Create a new HttpClient and Post Header
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("https://broken-winded-slash.000webhostapp.com/QR_CODE/get_vehicle_document.php");
//
//            try {
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//
//                nameValuePairs.add(new BasicNameValuePair("f1", string_qe));
//                // nameValuePairs.add(new BasicNameValuePair("f2",rcv_sem));
//
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                Log.d("nameValuePairs", "" + nameValuePairs);
//                HttpResponse response = httpclient.execute(httppost);
//                HttpEntity entity = response.getEntity();
//
//
//                // If the response does not enclose an entity, there is no need
//                if (entity != null) {
//                    InputStream instream = entity.getContent();
//
//                    String result;
//                    result = convertStreamToString(instream);
//                    Log.d("aaa", "" + result);
//
//
//                    JSONArray arr = new JSONArray(result);
//                    for (int i = 0; i < arr.length(); i++) {
//                        JSONObject jsonObject = arr.getJSONObject(i);
//                        String  v_no = jsonObject.getString("v_no");
//                        String o_name = jsonObject.getString("register_date");
//                        String  v_name = jsonObject.getString("v_name");
//                        String  mno = jsonObject.getString("v_type");
//                        String  address = jsonObject.getString("o_name");
//                        String  dob = jsonObject.getString("address");
//                        String  validate_till = jsonObject.getString("fuel");
//                        String  blood_group = jsonObject.getString("manu_facture");
//                        String  doi = jsonObject.getString("validate_upto");
//                        String  d_type = jsonObject.getString("seating_no");
//
//                        sharedPrefHandler.setSharedPreferences("document",validate_upto);
//
//                        setdata(v_no, o_name,v_name,mno, address,dob,validate_till,blood_group,doi,d_type);
//
//                    }
//                }
//
//
//            } catch (Exception e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "Something went wrong.Please try again.", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        }
//
//
//
//
//        public void setdata( final  String v_no,final  String o_name,final  String v_name,final  String mno,final  String address,final  String dob,final  String validate_till,final  String blood_group,final  String doi,final  String d_type)
//        {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    textView1d.setText("VEHICHLE NUMBER  :  "+v_no);
//                    textView2d.setText("REGISTER NUMBER : "+o_name);
//                    textView3d.setText("VEHICHLE NAME : "+v_name);
//                    textView4d.setText("VEHICLE TYPE  : "+mno);
//                    textView5d.setText("OWNER NAME : "+address);
//                    textView6d.setText("ADDRESS : "+dob);
//                    textView7d.setText("FUEL TYPE  : "+validate_till);
//                    textView8d.setText("MANUFACTURE DATE  : "+blood_group);
//                    textView9d.setText("VALID UPTO  : "+doi);
//                    textView10d.setText("SEATING NUMBER  : "+d_type);
//
//
//                }
//            });
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            postData(string_qe);
//            //start loading proggress dialog
//            //pd= ProgressDialog.show(Chg_Password.this, "Loading...","");
//            this.progressDialog.dismiss();
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            //dissmiss
//            //pd.dismiss();
//            //  adp.notifyDataSetChanged();
//        }
//
//        private String convertStreamToString(InputStream is) {
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String result;
//            String line = null;
//            try {
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//            } catch (Exception ex) {
//                Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_LONG).show();
//            }
//
//            result = sb.toString().trim();
//
//
//            result = result.substring(1, result.length() - 1);
//
//            if (!result.trim().equals("Error")) {
//                String[] r = result.split("-");
//
//
//            } else
//
//                Toast.makeText(getApplication(), "", Toast.LENGTH_LONG).show();
//            return sb.toString();
//
//        }
//
//
//
//    }
//
//
//
//
//
//
//    //Emission
//
//
//
//    private class MyAsyncTaskEmission extends AsyncTask<String, Void, String> {
//        private ProgressDialog progressDialog = new ProgressDialog(Vehicle_information.this);
//
//        protected void onPreExecute()
//        {
//            progressDialog.setMessage("Fetching data...");
//            progressDialog.show();
//            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface arg0)
//                {
//                    MyAsyncTaskEmission.this.cancel(true);
//
//                }
//            });
//        }
//
//        public void postData( String string_qe) {
//
//
//            // Create a new HttpClient and Post Header
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("https://broken-winded-slash.000webhostapp.com/QR_CODE/get_emission.php");
//
//            try {
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//
//                nameValuePairs.add(new BasicNameValuePair("f1", string_qe));
//                // nameValuePairs.add(new BasicNameValuePair("f2",rcv_sem));
//
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                Log.d("nameValuePairs", "" + nameValuePairs);
//                HttpResponse response = httpclient.execute(httppost);
//                HttpEntity entity = response.getEntity();
//
//
//                // If the response does not enclose an entity, there is no need
//                if (entity != null) {
//                    InputStream instream = entity.getContent();
//
//                    String result;
//                    result = convertStreamToString(instream);
//                    Log.d("aaa", "" + result);
//
//
//                    JSONArray arr = new JSONArray(result);
//                    for (int i = 0; i < arr.length(); i++) {
//                        JSONObject jsonObject = arr.getJSONObject(i);
//                        String  v_no = jsonObject.getString("v_no");
//                        String o_name = jsonObject.getString("o_name");
//                        String  v_name = jsonObject.getString("v_name");
//                        String  mno = jsonObject.getString("emission_test_date");
//                        String  address = jsonObject.getString("emission_valid_upto");
//                        String  dob = jsonObject.getString("v_type");
//                        String  validate_till = jsonObject.getString("v_condition");
//                        String  blood_group = jsonObject.getString("carbon_value");
//
//                        sharedPrefHandler.setSharedPreferences("emission",address);
//
//                        setdata(v_no, o_name,v_name,mno, address,dob,validate_till,blood_group);
//
//                    }
//                }
//
//
//            } catch (Exception e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "Something went wrong.Please try again.", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        }
//
//
//
//
//        public void setdata( final  String v_no,final  String o_name,final  String v_name,final  String mno,final  String address,final  String dob,final  String validate_till,final  String blood_group)
//        {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    textView1e.setText("VEHICHLE NUMBER  :  "+v_no);
//                    textView2e.setText("OWNER NAME : "+o_name);
//                    textView3e.setText("VEHICHLE NAME : "+v_name);
//                    textView4e.setText("EMISSION TEST DATE  : "+mno);
//                    textView5e.setText("VALID UPTO  : "+address);
//                    textView6e.setText("VEHICHKE TYPE : "+dob);
//                    textView7e.setText("CONDITION  : "+validate_till);
//                    textView8e.setText("CARBON VALUE  : "+blood_group);
//
//
//                }
//            });
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            postData(string_qe);
//            //start loading proggress dialog
//            //pd= ProgressDialog.show(Chg_Password.this, "Loading...","");
//            this.progressDialog.dismiss();
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            //dissmiss
//            //pd.dismiss();
//            //  adp.notifyDataSetChanged();
//        }
//
//        private String convertStreamToString(InputStream is) {
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String result;
//            String line = null;
//            try {
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//            } catch (Exception ex) {
//                Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_LONG).show();
//            }
//
//            result = sb.toString().trim();
//
//
//            result = result.substring(1, result.length() - 1);
//
//            if (!result.trim().equals("Error")) {
//                String[] r = result.split("-");
//
//
//            } else
//
//                Toast.makeText(getApplication(), "", Toast.LENGTH_LONG).show();
//            return sb.toString();
//
//        }
//
//
//
//    }
//
//
//
//
//
//    //Insurence
//
//
//
//    private class MyAsyncTaskInsurence extends AsyncTask<String, Void, String> {
//        private ProgressDialog progressDialog = new ProgressDialog(Vehicle_information.this);
//
//        protected void onPreExecute()
//        {
//            progressDialog.setMessage("Fetching data...");
//            progressDialog.show();
//            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface arg0)
//                {
//                    MyAsyncTaskInsurence.this.cancel(true);
//
//                }
//            });
//        }
//
//        public void postData( String string_qe) {
//
//
//            // Create a new HttpClient and Post Header
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("https://broken-winded-slash.000webhostapp.com/QR_CODE/get_insurence.php");
//
//            try {
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//
//                nameValuePairs.add(new BasicNameValuePair("f1", string_qe));
//                // nameValuePairs.add(new BasicNameValuePair("f2",rcv_sem));
//
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                Log.d("nameValuePairs", "" + nameValuePairs);
//                HttpResponse response = httpclient.execute(httppost);
//                HttpEntity entity = response.getEntity();
//
//
//                // If the response does not enclose an entity, there is no need
//                if (entity != null) {
//                    InputStream instream = entity.getContent();
//
//                    String result;
//                    result = convertStreamToString(instream);
//                    Log.d("aaa", "" + result);
//
//
//                    JSONArray arr = new JSONArray(result);
//                    for (int i = 0; i < arr.length(); i++) {
//                        JSONObject jsonObject = arr.getJSONObject(i);
//                        String  v_no = jsonObject.getString("v_no");
//                        String o_name = jsonObject.getString("o_name");
//                        String  v_name = jsonObject.getString("v_type");
//                        String  mno = jsonObject.getString("v_price");
//                        String  address = jsonObject.getString("insurence_date");
//                        String  dob = jsonObject.getString("valid_upto");
//                        String  validate_till = jsonObject.getString("insurence_amount");
//                        String  blood_group = jsonObject.getString("address");
//
//                        sharedPrefHandler.setSharedPreferences("insurence",dob);
//
//                        setdata(v_no, o_name,v_name,mno, address,dob,validate_till,blood_group);
//
//                    }
//                }
//
//
//            } catch (Exception e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "Something went wrong.Please try again.", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        }
//
//
//
//
//        public void setdata( final  String v_no,final  String o_name,final  String v_name,final  String mno,final  String address,final  String dob,final  String validate_till,final  String blood_group)
//        {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    textView1i.setText("VEHICHLE NUMBER  :  "+v_no);
//                    textView2i.setText("OWNER NAME : "+o_name);
//                    textView3i.setText("VEHICHLE TYPE : "+v_name);
//                    textView4i.setText("VEHICLE PRICE  : "+mno);
//                    textView5i.setText("INSURENCE DATE  : "+address);
//                    textView6i.setText("VALID UPTO: "+dob);
//                    textView7i.setText("INSURENCE AMOUNT : "+validate_till);
//                    textView8i.setText("ADDRESS : "+blood_group);
//
//
//                }
//            });
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            postData(string_qe);
//            //start loading proggress dialog
//            //pd= ProgressDialog.show(Chg_Password.this, "Loading...","");
//            this.progressDialog.dismiss();
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            //dissmiss
//            //pd.dismiss();
//            //  adp.notifyDataSetChanged();
//        }
//
//        private String convertStreamToString(InputStream is) {
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String result;
//            String line = null;
//            try {
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//            } catch (Exception ex) {
//                Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_LONG).show();
//            }
//
//            result = sb.toString().trim();
//
//
//            result = result.substring(1, result.length() - 1);
//
//            if (!result.trim().equals("Error")) {
//                String[] r = result.split("-");
//
//
//            } else
//
//                Toast.makeText(getApplication(), "", Toast.LENGTH_LONG).show();
//            return sb.toString();
//
//        }
//
//
//
//    }











}
