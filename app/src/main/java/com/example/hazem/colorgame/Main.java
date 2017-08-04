package com.example.hazem.colorgame;

import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main extends AppCompatActivity {
    HashMap<String,Integer>ColorCodes;
    ArrayList<String>ColorNames;
    ArrayList<Integer>ColorRes;
    TextView ColorGame,Counter;
    ImageButton Right,Wrong;
    Random random;
    int counter=0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SettingIDs();
        SettingEvents();
    }
    private void SettingIDs()
    {
        ColorCodes=SettingColors();
        ColorNames=SettingColorNames();
        ColorRes=SettingColorRes();
        ColorGame= (TextView) findViewById(R.id.color_code);
        Counter= (TextView) findViewById(R.id.counter);
        Right= (ImageButton) findViewById(R.id.right);
        Wrong= (ImageButton) findViewById(R.id.wrong);
        random=new Random();
        RandomColors();

    }
    private HashMap<String,Integer> SettingColors()
    {
        HashMap<String,Integer> newMap=new HashMap<>();
        newMap.put("Red",R.color.Red);
        newMap.put("Pink",R.color.Pink);
        newMap.put("Purple",R.color.Purple);
        newMap.put("Blue",R.color.Blue);
        newMap.put("Indigo",R.color.Indigo);
        newMap.put("Cyan",R.color.Cyan);
        newMap.put("Deep Purple",R.color.Deep_Purple);
        newMap.put("Light Blue",R.color.Light_Blue);
        newMap.put("Teal",R.color.Teal);
        newMap.put("Green",R.color.Green);
        newMap.put("Light Green",R.color.Light_Green);
        newMap.put("Lime",R.color.Lime);
        newMap.put("Yellow",R.color.Yellow);
        newMap.put("Amber",R.color.Amber);
        newMap.put("Orange",R.color.Orange);
        newMap.put("Black",R.color.Black);
        newMap.put("Blue Grey",R.color.Blue_Grey);
        newMap.put("Grey",R.color.Grey);
        newMap.put("Brown",R.color.Brown);

        return newMap;
    }
    private ArrayList<String>SettingColorNames()
    {
        ArrayList<String> newArray=new ArrayList<>();
        newArray.add("Red");
        newArray.add("Pink");
        newArray.add("Purple");
        newArray.add("Blue");
        newArray.add("Indigo");
        newArray.add("Cyan");
        newArray.add("Deep Purple");
        newArray.add("Light Blue");
        newArray.add("Teal");
        newArray.add("Green");
        newArray.add("Light Green");
        newArray.add("Lime");
        newArray.add("Yellow");
        newArray.add("Amber");
        newArray.add("Orange");
        newArray.add("Black");
        newArray.add("Blue Grey");
        newArray.add("Grey");
        newArray.add("Brown");
        return newArray;
    }
    private ArrayList<Integer>SettingColorRes()
    {
        ArrayList<Integer> newArray=new ArrayList<>();
        newArray.add(R.color.Red);
        newArray.add(R.color.Pink);
        newArray.add(R.color.Purple);
        newArray.add(R.color.Blue);
        newArray.add(R.color.Indigo);
        newArray.add(R.color.Cyan);
        newArray.add(R.color.Deep_Purple);
        newArray.add(R.color.Light_Blue);
        newArray.add(R.color.Teal);
        newArray.add(R.color.Green);
        newArray.add(R.color.Light_Green);
        newArray.add(R.color.Lime);
        newArray.add(R.color.Yellow);
        newArray.add(R.color.Amber);
        newArray.add(R.color.Orange);
        newArray.add(R.color.Black);
        newArray.add(R.color.Blue_Grey);
        newArray.add(R.color.Grey);
        newArray.add(R.color.Brown);
        return newArray;
    }
    private void RandomColors()
    {
        int poll=random.nextInt(1);
        if(poll==0)
        {
            int index=random.nextInt(ColorNames.size()-1);
            ColorGame.setText(ColorNames.get(index));
            ColorGame.setBackgroundColor(getResources().getColor(ColorRes.get(index)));
        }
        else
        {
            int index=random.nextInt(ColorNames.size()-1);
            int index2=random.nextInt(ColorRes.size()-1);
            ColorGame.setText(ColorNames.get(index));
            ColorGame.setBackgroundColor(getResources().getColor(ColorRes.get(index2)));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void SettingEvents()
    {

        Right.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                final String colorName=ColorGame.getText().toString();
                final int color=((ColorDrawable) ColorGame.getBackground()).getColor();
                if(getResources().getColor(ColorCodes.get(colorName))==color)
                {
                    Toast.makeText(Main.this, "Right", Toast.LENGTH_SHORT).show();
                    counter++;

                }
                else
                {
                    Toast.makeText(Main.this, "NO", Toast.LENGTH_SHORT).show();
                    counter--;
                }
                Counter.setText(counter+"");
                RandomColors();
            }
        });
        Wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String colorName=ColorGame.getText().toString();
                final int color=((ColorDrawable) ColorGame.getBackground()).getColor();
                if(getResources().getColor(ColorCodes.get(colorName))!=color)
                {
                    Toast.makeText(Main.this, "Right", Toast.LENGTH_SHORT).show();
                    counter++;
                }
                else
                {
                    Toast.makeText(Main.this, "NO", Toast.LENGTH_SHORT).show();
                    counter--;
                }
                Counter.setText(counter+"");
                RandomColors();
            }
        });
    }
}
