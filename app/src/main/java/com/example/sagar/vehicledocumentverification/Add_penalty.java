package com.example.sagar.vehicledocumentverification; // 1. Corrected package name

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity; // 2. Changed to AndroidX import
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner; // This import is present, but Spinner variables are commented out/unused in provided code.
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Assuming you have 'Api.java' and 'IsExist.java' and 'SharedPrefHandler.java'
// in the same package or correctly imported.

public class Add_penalty extends AppCompatActivity {
    EditText et_pdetails, et_amount, et_mno, et_uname, et_address;
    // Spinner spinner_city, spinner_occupation; // These are declared but not initialized or used in the provided code.
    Button button_submit;
    String stringet_pdetails, stringet_amount, stringet_mno, stringet_uname, stringet_address;
    SharedPrefHandler sharedPrefHandler;

    // String string_input; // This variable is declared but not used.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_penalty);

        sharedPrefHandler = new SharedPrefHandler(this);

        et_pdetails = (EditText) findViewById(R.id.et_pdetails);
        et_amount = (EditText) findViewById(R.id.et_amount);
        et_mno = (EditText) findViewById(R.id.et_mno);
        et_uname = (EditText) findViewById(R.id.et_uname);
        et_address = (EditText) findViewById(R.id.et_address);

        button_submit = (Button) findViewById(R.id.btn_sub);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringet_pdetails = et_pdetails.getText().toString().trim(); // Added .trim()
                stringet_amount = et_amount.getText().toString().trim();  // Added .trim()
                stringet_mno = et_mno.getText().toString().trim();      // Added .trim()
                stringet_uname = et_uname.getText().toString().trim();    // Added .trim()
                stringet_address = et_address.getText().toString().trim();  // Added .trim()

                sharedPrefHandler.setSharedPreferences("mno", stringet_mno);
                sharedPrefHandler.setSharedPreferences("name", stringet_uname);
                sharedPrefHandler.setSharedPreferences("address", stringet_address);
                sharedPrefHandler.setSharedPreferences("pd", stringet_pdetails);
                sharedPrefHandler.setSharedPreferences("amt", stringet_amount);

                // Improved empty check: Check each field individually for better feedback or check if any is empty
                if (stringet_pdetails.isEmpty() || stringet_amount.isEmpty() || stringet_mno.isEmpty() || stringet_uname.isEmpty() || stringet_address.isEmpty()) {
                    Toast.makeText(Add_penalty.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    CreateUserAccount();
                    // Consider if you want to navigate away *before* knowing if CreateUserAccount was successful.
                    // Often, navigation happens inside the onResponse of the API call if it's successful.
                    Intent intent = new Intent(getApplicationContext(), PrintfinalBillActivity.class); // Used getApplicationContext()
                    startActivity(intent);
                }
            }
        });
    }

    private void CreateUserAccount() {
        // It's generally better to create the Retrofit instance once (e.g., in a singleton or Application class)
        // rather than on every call, but for this example, it's kept as is.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL) // Make sure Api.BASE_URL is correctly defined
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.CreatePenalty(
                stringet_pdetails,
                stringet_amount,
                stringet_mno,
                stringet_uname,
                stringet_address
        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                if (response.isSuccessful() && response.body() != null) {
                    IsExist responseResult = response.body();
                    Boolean isSuccess = responseResult.getSuccess(); // Assuming IsExist has a getSuccess() method

                    if (isSuccess != null && isSuccess) {
                        showCreateSuccessToast();
                        // If navigation should happen on success, move it here:
                        // Intent intent = new Intent(Add_penalty.this, PrintfinalBillActivity.class);
                        // startActivity(intent);
                        // finish(); // Optionally finish this activity
                    } else {
                        showCreateFailedToast("Creation failed or unsuccessful response.");
                    }
                } else {
                    // Handle unsuccessful responses (e.g., 404, 500)
                    showCreateFailedToast("Server error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                // Log the error for debugging: Log.e("API_CALL_FAILURE", "Error: ", t);
            }
        });
    }

    private void showCreateFailedToast(String message) { // Added message parameter
        Toast.makeText(this, "OOPS, Create action failed! " + message, Toast.LENGTH_LONG).show();
    }

    private void showCreateSuccessToast() {
        Toast.makeText(this, "Penalty created successfully.", Toast.LENGTH_LONG).show();
    }

    // showEditFailedToast and showEditSuccessToast are not used in this particular flow.
    // private void showEditFailedToast() {
    //     Toast.makeText(this, "OOPS, Edit action failed!", Toast.LENGTH_LONG).show();
    // }
    //
    // private void showEditSuccessToast() {
    //     Toast.makeText(this, "updated successfully.", Toast.LENGTH_LONG).show();
    // }
}