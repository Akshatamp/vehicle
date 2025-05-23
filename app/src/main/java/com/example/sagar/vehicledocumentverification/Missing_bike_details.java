package com.example.sagar.vehicledocumentverification;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
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
import java.util.List;

public class Missing_bike_details extends AppCompatActivity
{

    TextView textView1i,textView2i,textView3i,textView4i,textView5i,textView6i,textView7i,textView8i;
    String string_vno;
    SharedPrefHandler sharedPrefHandler;

    List<Vehicle_Missing> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_bike_details);

        sharedPrefHandler=new SharedPrefHandler(this);

    string_vno=sharedPrefHandler.getSharedPreferences("vno");




        textView1i=(TextView)findViewById(R.id.TextViewCard1m);
        textView2i=(TextView)findViewById(R.id.TextViewCard2m);
        textView3i=(TextView)findViewById(R.id.TextViewCard3m);
        textView4i=(TextView)findViewById(R.id.TextViewCard4m);
        textView5i=(TextView)findViewById(R.id.TextViewCard5m);
        textView6i=(TextView)findViewById(R.id.TextViewCard6m);
        textView7i=(TextView)findViewById(R.id.TextViewCard7m);
        textView8i=(TextView)findViewById(R.id.TextViewCard8m);




        getProductByCode(string_vno);




    }



    private void getProductByCode(final String string_vno)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Vehicle_Missing>> call = api.getVehicle_Missing(string_vno);

        call.enqueue(new Callback<List<Vehicle_Missing>>() {
            @Override
            public void onResponse(Call<List<Vehicle_Missing>> call, Response<List<Vehicle_Missing>> response) {
                productList = response.body();

                Boolean isSuccess = false;
                if(response.body() != null) {
                    isSuccess = true;
                }

                if(isSuccess) {
                    textView1i.setText("Vehicle No : "+productList.get(0).getv_no());
                    textView2i.setText("Owner Name : "+productList.get(0).geto_name());
                    textView3i.setText("Address : "+productList.get(0).getaddress());
                    textView4i.setText("Vehicle Type : "+productList.get(0).getv_type());
                    textView5i.setText("Vehicle Name : "+productList.get(0).getv_name());
                    textView6i.setText("Complaint Date : "+productList.get(0).getcomplete_date());
                    textView7i.setText("Details : "+productList.get(0).getdesc_details());
                    textView8i.setText("Police Station : "+productList.get(0).getcomplete_station());
                    //textView7.setText(productList.get(0).getshop_id());
//
//                    ratingBar.setRating(Float.parseFloat(productList.get(0).getrating()));




                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Vehicle_Missing>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



//    private class MyAsyncTaskInsurence extends AsyncTask<String, Void, String> {
//        private ProgressDialog progressDialog = new ProgressDialog(Missing_bike_details.this);
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
//        public void postData( String string_vno) {
//
//
//            // Create a new HttpClient and Post Header
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("https://broken-winded-slash.000webhostapp.com/QR_CODE/getmissing.php");
//
//            try {
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//
//                nameValuePairs.add(new BasicNameValuePair("f1", string_vno));
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
//                        String  v_name = jsonObject.getString("address");
//                        String  mno = jsonObject.getString("v_type");
//                        String  address = jsonObject.getString("v_name");
//                        String  dob = jsonObject.getString("complete_date");
//                        String  validate_till = jsonObject.getString("desc_details");
//                        String  blood_group = jsonObject.getString("complete_station");
//
//
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
//                public void run()
//                {
//
//
//                    textView1i.setText("VEHICHLE NUMBER  :  "+v_no);
//                    textView2i.setText("OWNER NAME : "+o_name);
//                    textView3i.setText("ADDRESS : "+v_name);
//                    textView4i.setText("VEHICLE TYPE  : "+mno);
//                    textView5i.setText("VEHICLE NAME  : "+address);
//                    textView6i.setText("COMPLAINT DATE: "+dob);
//                    textView7i.setText("DESCRIPTION : "+validate_till);
//                    textView8i.setText("COMPLAINT STATION NAME : "+blood_group);
//
//
//                }
//            });
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            postData(string_vno);
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




}
