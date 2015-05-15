package com.example.game2048;

/**
 * Created by Kubish on 14.05.2015.
 */
 import android.graphics.Color;
 import android.widget.Button;


public class Colors {

    static int lightText = Color.parseColor("#f9f6f2");
    static int darkText = Color.parseColor("#776e65");

    static int V0 = Color.parseColor("#cec3b6");
    static int V2 = Color.parseColor("#eee4da");
    static int V4 = Color.parseColor("#ede0c8");
    static int V8 = Color.parseColor("#f2b179");
    static int V16 = Color.parseColor("#f59563");
    static int V32 = Color.parseColor("#f67c5f");
    static int V64 = Color.parseColor("#f65e3b");
    static int V128 = Color.parseColor("#edcf72");
    static int V256 = Color.parseColor("#edcc61");
    static int V512 = Color.parseColor("#edc850");
    static int V1024 = Color.parseColor("#edc53f");
    static int V2048 = Color.parseColor("#FFDF00");
    static int V4096 = Color.parseColor("#e620ff");

    public static void changeColor(Button b) {
        String value = String.valueOf(b.getText().toString());
        switch (value) {
            case "":
                b.setBackgroundColor(Colors.V0);
                return;
            case "0":
                return;
            case "2":
                b.setBackgroundColor(Colors.V2);
                b.setTextColor(Colors.lightText);
                break;
            case "4":
                b.setBackgroundColor(Colors.V4);
                b.setTextColor(Colors.lightText);
                break;
            case "8":
                b.setBackgroundColor(Colors.V8);
                b.setTextColor(Colors.darkText);
                break;
            case "16":
                b.setBackgroundColor(Colors.V16);
                b.setTextColor(Colors.darkText);
                break;
            case "32":
                b.setBackgroundColor(Colors.V32);
                b.setTextColor(Colors.lightText);
                break;
            case "64":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "128":
                b.setBackgroundColor(Colors.V128);
                b.setTextColor(Colors.darkText);
                break;
            case "256":
                b.setBackgroundColor(Colors.V256);
                b.setTextColor(Colors.darkText);
                break;
            case "512":
                b.setBackgroundColor(Colors.V512);
                b.setTextColor(Colors.darkText);
                break;
            case "1024":
                b.setBackgroundColor(Colors.V1024);
                b.setTextColor(Colors.darkText);
                break;
            case "2048":
                b.setBackgroundColor(Colors.V2048);
                b.setTextColor(Colors.lightText);
                break;
            case "4096":
                b.setBackgroundColor(Colors.V4096);
                b.setTextColor(Colors.lightText);
                break;
            case "G":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "A":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "M":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "E":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "O":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "V":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "R":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;
            case "RES":
                b.setBackgroundColor(Colors.V64);
                b.setTextColor(Colors.lightText);
                break;

        }
    }

}