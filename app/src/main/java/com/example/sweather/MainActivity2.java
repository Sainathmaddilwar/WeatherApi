package com.example.sweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //globle g=new globle();

        final TextView resultweather = (TextView) findViewById(R.id.textView2);
        final ImageView image = (ImageView) findViewById(R.id.imageView);
        final TextView resulttemprature = (TextView) findViewById(R.id.textView3);
        String s=getIntent().getStringExtra("weather");
        String i=getIntent().getStringExtra("tt");

        resulttemprature.setText(s);
        resultweather.setText(i+"° C");
        switch (s){

            case "Clouds":
                image.setImageResource(R.drawable.clouds);
                break;
            case "Haze":
                image.setImageResource(R.drawable.clouds);
                break;
            case "Clear":
                image.setImageResource(R.drawable.clear);
                break;
            case "Sunny":
                image.setImageResource(R.drawable.sunny);
                break;
            case "Rain":
                image.setImageResource(R.drawable.rainy);
                break;
        }

    }
}
