package com.gmail.adam.kidssudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int[][] table = {{1, 0, 3}, {2, 3, 0}, {3, 1, 2}};
    private int[][] result = new int[3][3];
    private boolean[] answerNo = {false, false, false};
    private HashMap<String, ImageView> imageViewHashMap = new HashMap<String, ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {
                result[i][j] = table[i][i];
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
        imageViewHashMap.put("00",image00);
        imageViewHashMap.put("01",image01);
        imageViewHashMap.put("02",image02);
        imageViewHashMap.put("10",image10);
        imageViewHashMap.put("11",image11);
        imageViewHashMap.put("12",image12);
        imageViewHashMap.put("20",image20);
        imageViewHashMap.put("21",image21);
        imageViewHashMap.put("22",image22);

        final ImageView image1S = findViewById(R.id.image1S);
        final ImageView image2S = findViewById(R.id.image2S);
        final ImageView image3S = findViewById(R.id.image3S);

        int source1 = getResources().getIdentifier("@drawable/a01", null, this.getPackageName());
        int source2 = getResources().getIdentifier("@drawable/a02", null, this.getPackageName());
        int source3 = getResources().getIdentifier("@drawable/a03", null, this.getPackageName());
        image1S.setImageResource(source1);
        image2S.setImageResource(source2);
        image3S.setImageResource(source3);



        image1S.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image1S.setBackgroundColor(Color.parseColor("#13EF1C"));
                image2S.setBackgroundColor(Color.parseColor("#FAF6F6"));
                image3S.setBackgroundColor(Color.parseColor("#FAF6F6"));
                answerNo[0] = true;
                answerNo[1] = false;
                answerNo[2] = false;

            }
        });
        image2S.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image1S.setBackgroundColor(Color.parseColor("#FAF6F6"));
                image2S.setBackgroundColor(Color.parseColor("#13EF1C"));
                image3S.setBackgroundColor(Color.parseColor("#FAF6F6"));
                answerNo[0] = false;
                answerNo[1] = true;
                answerNo[2] = false;
            }
        });
        image3S.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image1S.setBackgroundColor(Color.parseColor("#FAF6F6"));
                image2S.setBackgroundColor(Color.parseColor("#FAF6F6"));
                image3S.setBackgroundColor(Color.parseColor("#13EF1C"));
                answerNo[0] = false;
                answerNo[1] = false;
                answerNo[2] = true;
            }
        });

        for (final Map.Entry<String, ImageView> stringImageViewEntry : imageViewHashMap.entrySet()) {

            stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier("@drawable/a0" +
                            table[((int) stringImageViewEntry.getKey().charAt(0) - 48)][((int)stringImageViewEntry.getKey().charAt(1) - 48)]
                    , null, MainActivity.this.getPackageName()));

            stringImageViewEntry.getValue().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (table[( (int) stringImageViewEntry.getKey().charAt(0) - 48)][((int)stringImageViewEntry.getKey().charAt(1) - 48)] == 0) {
                        for (int i = 0; i < answerNo.length; i++) {
                            if (answerNo[i]) {
                                result[0][0] = i;
                                stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                        , null, MainActivity.this.getPackageName()));
                            }
                        }
                    }

                }
            });
        }
//
//        image00.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[0][0] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[0][0] = i;
//                            image00.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//
//        image01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[0][1] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[0][1] = i;
//                            image01.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[0][2] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[0][2] = i;
//                            image02.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[1][0] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[1][0] = i;
//                            image10.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[1][1] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[1][1] = i;
//                            image11.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[1][2] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[1][2] = i;
//                            image12.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image20.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[2][0] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[2][0] = i;
//                            image20.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image21.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[2][1] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[2][1] = i;
//                            image21.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        image22.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (table[2][2] == 0) {
//                    for (int i = 0; i < answerNo.length; i++) {
//                        if (answerNo[i]) {
//                            result[2][2] = i;
//                            image22.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
//                                    , null, MainActivity.this.getPackageName()));
//                        }
//                    }
//                }
//            }
//        });
//        checkButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for (int i = 0; i < result.length; i++) {
//                    for (int j = 0; j < result[i].length; j++) {
//                        if (table[i][j] == 0){
//                            if (i == 0){
//                                int sum = result[0][j] + result[1][j] +result[2][j];
//                                if ()
//                            }
//                        }
//                    }
//                }
//                image1S.setBackgroundColor(Color.parseColor("#13EF1C"));
//            }
//        });

//        for (int i = 0; i < table.length; i++) {
//            for (int j = 0; j < table[i].length; j++) {
//                switch (i) {
//                    case 0:
//                        switch (j) {
//                            case 0:
//                                image00.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                            case 1:
//                                image01.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                            case 2:
//                                image02.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                        }
//                    case 1:
//                        switch (j) {
//                            case 0:
//                                image10.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                            case 1:
//                                image11.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                            case 2:
//                                image12.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                        }
//                    case 2:
//                        switch (j) {
//                            case 0:
//                                image20.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                            case 1:
//                                image21.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                            case 2:
//                                image22.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
//                                        , null, this.getPackageName()));
//                                break;
//                        }
//                }
//            }
//        }


    }

  public boolean check(int row, int col, int value){
      for (int i = 0; i < result.length; i++) {
          if (result[row][i] == value || result[i][col] == value){
              return false;
          }

      }
      return true;
  }
}
