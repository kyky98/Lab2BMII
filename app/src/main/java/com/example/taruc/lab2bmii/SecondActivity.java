package com.example.taruc.lab2bmii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageViewBMI = findViewById(R.id.imageView);
        TextView txtBMIStatus = findViewById(R.id.txtBMIStatus);

        Intent intent = getIntent(); //who called me?

        if (intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            double bmi = intent.getDoubleExtra(MainActivity.EXTRA_MESSAGE, 0);

            //Assign drawable to an image view
            if (bmi < 18.5) {
                imageViewBMI.setImageResource(R.drawable.under);
                txtBMIStatus.setText("Under Weight");
            } else if (bmi > 24.5) {
                imageViewBMI.setImageResource(R.drawable.over);
                txtBMIStatus.setText("Over Weight");
            } else {
                imageViewBMI.setImageResource(R.drawable.normal);
                txtBMIStatus.setText("Perfect");
            }
        }
    }

    public void closeActivity(View view) {
        finish();
    }
}
