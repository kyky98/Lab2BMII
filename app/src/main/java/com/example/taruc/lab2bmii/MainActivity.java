package com.example.taruc.lab2bmii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = " com.example.taruc.lab2bmii.MESSAGE";
    EditText editTxtWeight, editTxtHeight, editTxtABC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtHeight = findViewById(R.id.txtHeight);
        editTxtWeight = findViewById(R.id.txtWeight);

    }

    public void calculateBMI(View view) {
        double weight, height, result;
        int abc = 0;
        if (TextUtils.isEmpty(editTxtHeight.getText())) {
            editTxtHeight.setError("Please enter body height");
        } else if (TextUtils.isEmpty(editTxtWeight.getText())) {
            editTxtWeight.setError("Please enter body weight");
        } else {
            weight = Double.parseDouble(editTxtWeight.getText().toString());
            height = Double.parseDouble(editTxtHeight.getText().toString());


            result = weight / (height * height);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, result);
            Log.d("MainActivity", result + ""); //to test intermediate result (check passing data)
            startActivity(intent);
        }
    }
}
