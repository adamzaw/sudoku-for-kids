package com.gmail.adam.kidssudoku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Game extends AppCompatActivity {

    private Sudoku s = new Sudoku();

    private static final String TAG = "Game";
    private int level = 4;
    private int[][] table;
    private int[][] result;
    private int answerNo = 0;
    private HashMap<String, ImageView> threeImageViewHashMap = new HashMap<String, ImageView>();
    private HashMap<String, ImageView> fourImageViewHashMap = new HashMap<>();
    private HashMap<String, ImageView> fiveImageViewHashMap = new HashMap<>();
    private HashMap<String, ImageView> tempImageViewHashMap = new HashMap<>();

    private Random random = new Random();
    private String path = "@drawable/A";
    private HashSet<Integer> images = new HashSet<>();
    private int[] imagesPath;
    private Button threeCheckButton;
    private Button fourCheckButton;
    private Button fiveCheckButton;
    private Button[] checkButtons = new Button[3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d(TAG, "onCreate: started.");


        level = getIntent().getIntExtra("LEVEL", 4);
        result = new int[level][level];
        table = s.generate(level);
        s.setSudoku(table);
        tableToResult();

        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.myViewFlipper);
        ConstraintLayout threeLayout = (ConstraintLayout) findViewById(R.id.three_layout);
        ConstraintLayout fourLayout = (ConstraintLayout) findViewById(R.id.four_layout);
        ConstraintLayout fiveLayout = (ConstraintLayout) findViewById(R.id.five_layout);


        fourCheckButton = findViewById(R.id.fourCheckButton);
        checkButtons[1] = fourCheckButton;

        final ImageView four00 = findViewById(R.id.four00);
        final ImageView four01 = findViewById(R.id.four01);
        final ImageView four02 = findViewById(R.id.four02);
        final ImageView four03 = findViewById(R.id.four03);
        final ImageView four12 = findViewById(R.id.four12);
        final ImageView four10 = findViewById(R.id.four10);
        final ImageView four11 = findViewById(R.id.four11);
        final ImageView four13 = findViewById(R.id.four13);
        final ImageView four20 = findViewById(R.id.four20);
        final ImageView four21 = findViewById(R.id.four21);
        final ImageView four22 = findViewById(R.id.four22);
        final ImageView four23 = findViewById(R.id.four23);
        final ImageView four30 = findViewById(R.id.four30);
        final ImageView four31 = findViewById(R.id.four31);
        final ImageView four32 = findViewById(R.id.four32);
        final ImageView four33 = findViewById(R.id.four33);
        final ImageView fourA0 = findViewById(R.id.fourA0);
        final ImageView fourA1 = findViewById(R.id.fourA1);
        final ImageView fourA2 = findViewById(R.id.fourA2);
        final ImageView fourA3 = findViewById(R.id.fourA3);
        fourImageViewHashMap.put("00", four00);
        fourImageViewHashMap.put("01", four01);
        fourImageViewHashMap.put("02", four02);
        fourImageViewHashMap.put("03", four03);
        fourImageViewHashMap.put("10", four10);
        fourImageViewHashMap.put("11", four11);
        fourImageViewHashMap.put("12", four12);
        fourImageViewHashMap.put("13", four13);
        fourImageViewHashMap.put("20", four20);
        fourImageViewHashMap.put("21", four21);
        fourImageViewHashMap.put("22", four22);
        fourImageViewHashMap.put("23", four23);
        fourImageViewHashMap.put("30", four30);
        fourImageViewHashMap.put("31", four31);
        fourImageViewHashMap.put("32", four32);
        fourImageViewHashMap.put("33", four33);
        fourImageViewHashMap.put("A0", fourA0);
        fourImageViewHashMap.put("A1", fourA1);
        fourImageViewHashMap.put("A2", fourA2);
        fourImageViewHashMap.put("A3", fourA3);

        threeCheckButton = findViewById(R.id.threeCheckButton);
        checkButtons[0] = threeCheckButton;

        final ImageView three00 = findViewById(R.id.three00);
        final ImageView three01 = findViewById(R.id.three01);
        final ImageView three02 = findViewById(R.id.three02);
        final ImageView three10 = findViewById(R.id.three10);
        final ImageView three11 = findViewById(R.id.three11);
        final ImageView three12 = findViewById(R.id.three12);
        final ImageView three20 = findViewById(R.id.three20);
        final ImageView three21 = findViewById(R.id.three21);
        final ImageView three22 = findViewById(R.id.three22);
        final ImageView threeA0 = findViewById(R.id.threeA0);
        final ImageView threeA1 = findViewById(R.id.threeA1);
        final ImageView threeA2 = findViewById(R.id.threeA2);
        threeImageViewHashMap.put("00", three00);
        threeImageViewHashMap.put("01", three01);
        threeImageViewHashMap.put("02", three02);
        threeImageViewHashMap.put("10", three10);
        threeImageViewHashMap.put("11", three11);
        threeImageViewHashMap.put("12", three12);
        threeImageViewHashMap.put("20", three20);
        threeImageViewHashMap.put("21", three21);
        threeImageViewHashMap.put("22", three22);
        threeImageViewHashMap.put("A0", threeA0);
        threeImageViewHashMap.put("A1", threeA1);
        threeImageViewHashMap.put("A2", threeA2);

        fiveCheckButton = findViewById(R.id.fiveCheckButton);
        checkButtons[2] = fiveCheckButton;

        final ImageView five00 = findViewById(R.id.five00);
        final ImageView five01 = findViewById(R.id.five01);
        final ImageView five02 = findViewById(R.id.five02);
        final ImageView five03 = findViewById(R.id.five03);
        final ImageView five04 = findViewById(R.id.five04);
        final ImageView five10 = findViewById(R.id.five10);
        final ImageView five11 = findViewById(R.id.five11);
        final ImageView five12 = findViewById(R.id.five12);
        final ImageView five13 = findViewById(R.id.five13);
        final ImageView five14 = findViewById(R.id.five14);
        final ImageView five20 = findViewById(R.id.five20);
        final ImageView five21 = findViewById(R.id.five21);
        final ImageView five22 = findViewById(R.id.five22);
        final ImageView five23 = findViewById(R.id.five23);
        final ImageView five24 = findViewById(R.id.five24);
        final ImageView five30 = findViewById(R.id.five30);
        final ImageView five31 = findViewById(R.id.five31);
        final ImageView five32 = findViewById(R.id.five32);
        final ImageView five33 = findViewById(R.id.five33);
        final ImageView five34 = findViewById(R.id.five34);
        final ImageView five40 = findViewById(R.id.five40);
        final ImageView five41 = findViewById(R.id.five41);
        final ImageView five42 = findViewById(R.id.five42);
        final ImageView five43 = findViewById(R.id.five43);
        final ImageView five44 = findViewById(R.id.five44);
        final ImageView fiveA0 = findViewById(R.id.fiveA0);
        final ImageView fiveA1 = findViewById(R.id.fiveA1);
        final ImageView fiveA2 = findViewById(R.id.fiveA2);
        final ImageView fiveA3 = findViewById(R.id.fiveA3);
        final ImageView fiveA4 = findViewById(R.id.fiveA4);
        fiveImageViewHashMap.put("00", five00);
        fiveImageViewHashMap.put("01", five01);
        fiveImageViewHashMap.put("02", five02);
        fiveImageViewHashMap.put("03", five03);
        fiveImageViewHashMap.put("04", five04);
        fiveImageViewHashMap.put("10", five10);
        fiveImageViewHashMap.put("11", five11);
        fiveImageViewHashMap.put("12", five12);
        fiveImageViewHashMap.put("13", five13);
        fiveImageViewHashMap.put("14", five14);
        fiveImageViewHashMap.put("20", five20);
        fiveImageViewHashMap.put("21", five21);
        fiveImageViewHashMap.put("22", five22);
        fiveImageViewHashMap.put("23", five23);
        fiveImageViewHashMap.put("24", five24);
        fiveImageViewHashMap.put("30", five30);
        fiveImageViewHashMap.put("31", five31);
        fiveImageViewHashMap.put("32", five32);
        fiveImageViewHashMap.put("33", five33);
        fiveImageViewHashMap.put("34", five34);
        fiveImageViewHashMap.put("40", five40);
        fiveImageViewHashMap.put("41", five41);
        fiveImageViewHashMap.put("42", five42);
        fiveImageViewHashMap.put("43", five43);
        fiveImageViewHashMap.put("44", five44);
        fiveImageViewHashMap.put("A0", fiveA0);
        fiveImageViewHashMap.put("A1", fiveA1);
        fiveImageViewHashMap.put("A2", fiveA2);
        fiveImageViewHashMap.put("A3", fiveA3);
        fiveImageViewHashMap.put("A4", fiveA4);


        switch (level){
            case(3):{
                viewFlipper.setDisplayedChild(0);
                tempImageViewHashMap = threeImageViewHashMap;
                break;
            }
            case(4):{
                viewFlipper.setDisplayedChild(1);
                tempImageViewHashMap = fourImageViewHashMap;
                break;
            }
            case(5):{
                viewFlipper.setDisplayedChild(2);
                tempImageViewHashMap = fiveImageViewHashMap;
                break;
            }
            default:
                viewFlipper.setDisplayedChild(1);
                tempImageViewHashMap = fourImageViewHashMap;
                break;
        }


        randomizeImages();
        draw();
        setValueOnClick();

    }

    void tableToResult() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

                result[i][j] = table[i][j];
            }
        }
    }

    void setValueOnClick() {

        final Context context = this;
        checkButtons[level - 3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fault = false;

                int[][] solving = s.getSolving(table);
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[i].length; j++) {
                        if (table[i][j] == 0) {
                            if (result[i][j] == solving[i][j]) {
                                tempImageViewHashMap.get("" + i + j).setBackgroundColor(Color.parseColor("#13EF1C"));
                            } else {
                                tempImageViewHashMap.get("" + i + j).setBackgroundColor(Color.parseColor("#CA2C2C"));
                                fault = true;
                            }
                        } else {
                            if (result[i][j] == 0)
                                fault = true;
                        }
                    }
                }

                if (!fault) {
                    winMassage(context);

                } else {
                    v.startAnimation(AnimationUtils.loadAnimation(context,
                            R.anim.shake));
                    for (ImageView value : tempImageViewHashMap.values()) {
                        value.findViewById(value.getId()).startAnimation(AnimationUtils.loadAnimation(context,
                                R.anim.shake));
                    }
                }

            }
        });

        for (final Map.Entry<String, ImageView> stringImageViewEntry : tempImageViewHashMap.entrySet()) {
            final int first = ((int) stringImageViewEntry.getKey().charAt(0) - 48);
            final int second = ((int) stringImageViewEntry.getKey().charAt(1) - 48);

            if (stringImageViewEntry.getKey().contains("A")) {
                stringImageViewEntry.getValue().setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (answerNo != 0) {
                            tempImageViewHashMap.get("A" + (answerNo - 1)).setBackgroundColor(Color.parseColor("#FAF6F6"));
                        }
                        stringImageViewEntry.getValue().setBackgroundColor(Color.parseColor("#efe013"));
                        answerNo = second + 1;

                    }
                });
            } else {
                stringImageViewEntry.getValue().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (table[first][second] == 0 && answerNo != 0) {
                            int answerValue;
                            if (result[first][second] != answerNo) {
                                answerValue = answerNo;

                            } else {
                                answerValue = 0;
                            }
                            result[first][second] = answerValue;
                            if (answerValue == 0) {
                                stringImageViewEntry.getValue().setImageResource(
                                        getResources().getIdentifier((path + "00")
                                                , null, Game.this.getPackageName()));
                            } else {
                                String temp;
                                if (imagesPath[(answerValue - 1)] < 10) {
                                    temp = "0" + imagesPath[(answerValue - 1)];
                                } else {
                                    temp = "" + imagesPath[(answerValue - 1)];
                                }
                                stringImageViewEntry.getValue().setImageResource(
                                        getResources().getIdentifier((path + temp)
                                                , null, Game.this.getPackageName()));
                            }
                        }
                    }
                });
            }
        }
    }


    void draw() {

        for (final Map.Entry<String, ImageView> stringImageViewEntry : tempImageViewHashMap.entrySet()) {
            final int first = ((int) stringImageViewEntry.getKey().charAt(0) - 48);
            final int second = ((int) stringImageViewEntry.getKey().charAt(1) - 48);


            if (stringImageViewEntry.getKey().contains("A")) {
                String temp;
                if (imagesPath[second] < 10) {
                    temp = "0" + imagesPath[second];
                } else {
                    temp = "" + imagesPath[second];
                }
                stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier(
                        (path + temp),
                        null, this.getPackageName()));


            } else {
                if (table[first][second] == 0)
                    stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier(path + "00"
                            , null, Game.this.getPackageName()));
                else {
                    String temp;
                    if (imagesPath[(table[first][second] - 1)] < 10) {
                        temp = "0" + imagesPath[(table[first][second] - 1)];
                    } else {
                        temp = "" + imagesPath[(table[first][second] - 1)];
                    }
                    stringImageViewEntry.getValue().setImageResource(getResources().getIdentifier(path +
                                    temp
                            , null, Game.this.getPackageName()));
                }

            }
        }
    }

    void randomizeImages() {
        path = "@drawable/" + (char) random.ints(97, 99).findFirst().getAsInt();
        images.clear();
        while (images.size() <= table.length) {
            images.add((Integer) random.ints(1, 13).findFirst().getAsInt());
        }
        imagesPath = images.stream().mapToInt(Number::intValue).toArray();
    }

    void winMassage(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle("You WON");
        alertDialogBuilder.setMessage("You solve the puzzle\nNew game?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                answerNo = 0;
                table = s.generate(level);
                tableToResult();
                for (ImageView imageView : tempImageViewHashMap.values()) {
                    imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                randomizeImages();
                draw();

            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
