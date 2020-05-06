package com.gmail.adam.kidssudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Sudoku s = new Sudoku();

    private static final String TAG = "MainActivity";
    //private int[][] table = {{1, 0, 3}, {2, 3, 0}, {3, 1, 2}};
    private int[][] table = s.generate(3);
    private int[][] result = new int[3][3];
    private int answerNo = -1;
    private HashMap<String, ImageView> imageViewHashMap = new HashMap<String, ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        s.setSudoku(table);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

                result[i][j] = table[i][j];
            }
        }
        Button checkButton = findViewById(R.id.CheckButton);

        final ImageView image00 = findViewById(R.id.image00);
        final ImageView image01 = findViewById(R.id.image01);
        final ImageView image02 = findViewById(R.id.image02);
        final ImageView image10 = findViewById(R.id.image10);
        final ImageView image11 = findViewById(R.id.image11);
        final ImageView image12 = findViewById(R.id.image12);
        final ImageView image20 = findViewById(R.id.image20);
        final ImageView image21 = findViewById(R.id.image21);
        final ImageView image22 = findViewById(R.id.image22);
        final ImageView imageA0 = findViewById(R.id.imageA0);
        final ImageView imageA1 = findViewById(R.id.imageA1);
        final ImageView imageA2 = findViewById(R.id.imageA2);
        imageViewHashMap.put("00", image00);
        imageViewHashMap.put("01", image01);
        imageViewHashMap.put("02", image02);
        imageViewHashMap.put("10", image10);
        imageViewHashMap.put("11", image11);
        imageViewHashMap.put("12", image12);
        imageViewHashMap.put("20", image20);
        imageViewHashMap.put("21", image21);
        imageViewHashMap.put("22", image22);
        imageViewHashMap.put("A0", imageA0);
        imageViewHashMap.put("A1", imageA1);
        imageViewHashMap.put("A2", imageA2);


        for (final Map.Entry<String, ImageView> stringImageViewEntry : imageViewHashMap.entrySet()) {
            final int first = ((int) stringImageViewEntry.getKey().charAt(0) - 48);
            final int second = ((int) stringImageViewEntry.getKey().charAt(1) - 48);


            if (stringImageViewEntry.getKey().contains("A")) {
                stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier(
                        ("@drawable/a0" + (second + 1)),
                        null, this.getPackageName()));

                stringImageViewEntry.getValue().setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (answerNo != -1) {
                            imageViewHashMap.get("A" + (answerNo - 1)).setBackgroundColor(Color.parseColor("#FAF6F6"));
                        }
                        stringImageViewEntry.getValue().setBackgroundColor(Color.parseColor("#13EF1C"));
                        answerNo = second + 1;

                    }
                });

            } else {
                stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier("@drawable/a0" +
                                table[first][second]
                        , null, MainActivity.this.getPackageName()));

                stringImageViewEntry.getValue().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (table[first][second] == 0 && answerNo != -1) {
                            result[first][second] = answerNo;
                            stringImageViewEntry.getValue().setImageResource(
                                    getResources().getIdentifier(("@drawable/a0" + answerNo)
                                            , null, MainActivity.this.getPackageName()));
                        }
                    }
                });
            }
        }


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[i].length; j++) {
                        if (table[i][j] == 0) {
                            if (s.check(i, j, result[i][j], result)) {
                                imageViewHashMap.get("" + i + j).setBackgroundColor(Color.parseColor("#13EF1C"));
                            } else {
                                imageViewHashMap.get("" + i + j).setBackgroundColor(Color.parseColor("#CA2C2C"));
                            }
                        }
                    }
                }
            }
        });
    }


}
