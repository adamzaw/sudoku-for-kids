package com.gmail.adam.kidssudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int table[][] = {{1, 0, 3}, {2, 3, 0}, {3, 1, 2}};
    private int result[][] = new int[3][3];
    private boolean answerNo[] = {false, false, false};

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

        final ImageView image1A = findViewById(R.id.image1A);
        final ImageView image2A = findViewById(R.id.image2A);
        final ImageView image3A = findViewById(R.id.image3A);
        final ImageView image1B = findViewById(R.id.image1B);
        final ImageView image2B = findViewById(R.id.image2B);
        final ImageView image3B = findViewById(R.id.image3B);
        final ImageView image1C = findViewById(R.id.image1C);
        final ImageView image2C = findViewById(R.id.image2C);
        final ImageView image3C = findViewById(R.id.image3C);
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

        image1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[0][0] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[0][0] = i;
                            image1A.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[0][1] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[0][1] = i;
                            image2A.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[0][2] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[0][2] = i;
                            image3A.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[1][0] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[1][0] = i;
                            image1B.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[1][1] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[1][1] = i;
                            image2B.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[1][2] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[1][2] = i;
                            image3B.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[2][0] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[2][0] = i;
                            image1C.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[2][1] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[2][1] = i;
                            image2C.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });
        image3C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[2][2] == 0) {
                    for (int i = 0; i < answerNo.length; i++) {
                        if (answerNo[i]) {
                            result[2][2] = i;
                            image3C.setImageResource(getResources().getIdentifier("@drawable/a0" + (i + 1)
                                    , null, MainActivity.this.getPackageName()));
                        }
                    }
                }
            }
        });

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                switch (i) {
                    case 0:
                        switch (j) {
                            case 0:
                                image1A.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                            case 1:
                                image2A.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                            case 2:
                                image3A.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                        }
                    case 1:
                        switch (j) {
                            case 0:
                                image1B.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                            case 1:
                                image2B.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                            case 2:
                                image3B.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                        }
                    case 2:
                        switch (j) {
                            case 0:
                                image1C.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                            case 1:
                                image2C.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                            case 2:
                                image3C.setImageResource(getResources().getIdentifier("@drawable/a0" + table[i][j]
                                        , null, this.getPackageName()));
                                break;
                        }
                }
            }
        }


    }

}
