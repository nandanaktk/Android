package com.example.android_08img;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    boolean imageOne = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            if (imageOne) {
                imageView.setImageResource(R.drawable.moon_mot);
                imageOne = false;
            } else {
                imageView.setImageResource(R.drawable.sun_mot);
                imageOne = true;
            }
        });
    }
}
