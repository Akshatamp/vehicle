package com.example.sagar.vehicledocumentverification;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    CardView cardView_one,cardView_two,cardView_three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        cardView_one=(CardView)findViewById(R.id.r1);
        cardView_two=(CardView)findViewById(R.id.r2);
        cardView_three=(CardView)findViewById(R.id.r3);



        cardView_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplication(),Scan_code.class);
                startActivity(intent);

            }
        });



        cardView_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),Feedback.class);
                startActivity(intent);
            }
        });


        cardView_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),Missing_bike.class);
                startActivity(intent);
            }
        });





    }
}
