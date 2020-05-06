package com.gmail.adam.kidssudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        Button threeButton = findViewById(R.id.three);
        Button fourButton = findViewById(R.id.four);

        threeButton.setText("3x3");
        fourButton.setText("4x4");

        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),ThreeActivity.class));
            }


        });


    }
}
