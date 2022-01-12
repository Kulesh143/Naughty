package com.kulesh.naughty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name=getIntent().getStringExtra("kkl");
        TextView tv=findViewById(R.id.test);
        tv.setText(name);
    }
}