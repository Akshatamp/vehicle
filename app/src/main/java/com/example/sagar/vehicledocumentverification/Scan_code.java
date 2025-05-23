package com.example.sagar.vehicledocumentverification;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class Scan_code extends AppCompatActivity {


    SurfaceView surfaceView;
    TextView txtBarcodeValue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    Button btnAction;
    String intentData = "";
    boolean isEmail = false;
    SharedPrefHandler sharedPrefHandler;





    String txt_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        sharedPrefHandler=new SharedPrefHandler(this);



        initViews();



    }

    private void initViews() {
        txtBarcodeValue = findViewById(R.id.txtBarcodeValue);
        surfaceView = findViewById(R.id.surfaceView);
        btnAction = findViewById(R.id.btnAction);


        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






//
//                if (intentData.length() > 0) {
//                    if (isEmail)
//                        //startActivity(new Intent(ScannedBarcodeActivity.this, EmailActivity.class).putExtra("email_address", intentData));
//                    else {
//                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(intentData)));
//                    }
//                }


            }
        });
    }

    private void initialiseDetectorsAndSources() {

        Toast.makeText(getApplicationContext(), "Barcode scanner started", Toast.LENGTH_SHORT).show();

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(Scan_code.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(Scan_code.this, new
                                String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                Toast.makeText(getApplicationContext(), "To prevent memory leaks barcode scanner has been stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {


                    txtBarcodeValue.post(new Runnable() {

                        @Override
                        public void run() {

                            if (barcodes.valueAt(0).email != null) {
                                txtBarcodeValue.removeCallbacks(null);
                                intentData = barcodes.valueAt(0).email.address;
                                txtBarcodeValue.setText(intentData);
                                isEmail = true;
                                btnAction.setText("VIEW DETAILS");
                            } else {
                                isEmail = false;
                                btnAction.setText("VIEW DETAILS");
                                intentData = barcodes.valueAt(0).displayValue;
                                txtBarcodeValue.setText(intentData);

                                txt_val=txtBarcodeValue.getText().toString();

                                sharedPrefHandler.setSharedPreferences("qrcode",txt_val);

                                Intent intent=new Intent(getApplication(),Vehicle_information.class);
                                startActivity(intent);
                                // Toast.makeText(ScannedBarcodeActivity.this, ""+txt_val, Toast.LENGTH_SHORT).show();




                            }
                        }
                    });

                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialiseDetectorsAndSources();


    }
}
