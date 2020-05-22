package com.gmail.adam.kidssudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class FiveActivity extends AppCompatActivity {
    private Sudoku s = new Sudoku();

    private static final String TAG = "FiveActivity";
    //private int[][] table = {{1, 0, 3}, {2, 3, 0}, {3, 1, 2}};
    private int[][] table = s.generate(5);
    private int[][] result = new int[5][5];
    private int answerNo = -1;
    private HashMap<String, ImageView> imageViewHashMap = new HashMap<String, ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        Log.d(TAG, "onCreate: started.");

        s.setSudoku(table);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

                result[i][j] = table[i][j];
            }
        }
        Button checkButton = findViewById(R.id.checkButton);

        final ImageView image00 = findViewById(R.id.image00);
        final ImageView image01 = findViewById(R.id.image01);
        final ImageView image02 = findViewById(R.id.image02);
        final ImageView image03 = findViewById(R.id.image03);
        final ImageView image04 = findViewById(R.id.image04);
        final ImageView image10 = findViewById(R.id.image10);
        final ImageView image11 = findViewById(R.id.image11);
        final ImageView image12 = findViewById(R.id.image12);
        final ImageView image13 = findViewById(R.id.image13);
        final ImageView image14 = findViewById(R.id.image14);
        final ImageView image20 = findViewById(R.id.image20);
        final ImageView image21 = findViewById(R.id.image21);
        final ImageView image22 = findViewById(R.id.image22);
        final ImageView image23 = findViewById(R.id.image23);
        final ImageView image24 = findViewById(R.id.image24);
        final ImageView image30 = findViewById(R.id.image30);
        final ImageView image31 = findViewById(R.id.image31);
        final ImageView image32 = findViewById(R.id.image32);
        final ImageView image33 = findViewById(R.id.image33);
        final ImageView image34 = findViewById(R.id.image34);
        final ImageView image40 = findViewById(R.id.image40);
        final ImageView image41 = findViewById(R.id.image41);
        final ImageView image42 = findViewById(R.id.image42);
        final ImageView image43 = findViewById(R.id.image43);
        final ImageView image44 = findViewById(R.id.image44);
        final ImageView imageA0 = findViewById(R.id.imageA0);
        final ImageView imageA1 = findViewById(R.id.imageA1);
        final ImageView imageA2 = findViewById(R.id.imageA2);
        final ImageView imageA3 = findViewById(R.id.imageA3);
        final ImageView imageA4 = findViewById(R.id.imageA4);
        imageViewHashMap.put("00", image00);
        imageViewHashMap.put("01", image01);
        imageViewHashMap.put("02", image02);
        imageViewHashMap.put("03", image03);
        imageViewHashMap.put("04", image04);
        imageViewHashMap.put("10", image10);
        imageViewHashMap.put("11", image11);
        imageViewHashMap.put("12", image12);
        imageViewHashMap.put("13", image13);
        imageViewHashMap.put("14", image14);
        imageViewHashMap.put("20", image20);
        imageViewHashMap.put("21", image21);
        imageViewHashMap.put("22", image22);
        imageViewHashMap.put("23", image23);
        imageViewHashMap.put("24", image24);
        imageViewHashMap.put("30", image30);
        imageViewHashMap.put("31", image31);
        imageViewHashMap.put("32", image32);
        imageViewHashMap.put("33", image33);
        imageViewHashMap.put("34", image34);
        imageViewHashMap.put("40", image40);
        imageViewHashMap.put("41", image41);
        imageViewHashMap.put("42", image42);
        imageViewHashMap.put("43", image43);
        imageViewHashMap.put("44", image44);
        imageViewHashMap.put("A0", imageA0);
        imageViewHashMap.put("A1", imageA1);
        imageViewHashMap.put("A2", imageA2);
        imageViewHashMap.put("A3", imageA3);
        imageViewHashMap.put("A4", imageA4);


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
                        , null, FiveActivity.this.getPackageName()));

                stringImageViewEntry.getValue().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (table[first][second] == 0 && answerNo != -1) {
                            int answerValue;
                            if (result[first][second] != answerNo) {
                                answerValue = answerNo;

                            } else {
                                answerValue = 0;
                            }
                            result[first][second] = answerValue;
                            stringImageViewEntry.getValue().setImageResource(
                                    getResources().getIdentifier(("@drawable/a0" + answerValue)
                                            , null, FiveActivity.this.getPackageName()));
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