package com.cookandroid.androidapp_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity {

    Button btnGoPage2;
    Button btnGoPage3;
    Button btnGoPage4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        btnGoPage2 = (Button)findViewById(R.id.btnGoPage2);
        btnGoPage4 = (Button)findViewById(R.id.btnGoPage4);
        btnGoPage3 = (Button)findViewById(R.id.btnGoPage3);

        btnGoPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page2.class);
                startActivity(intent);
            }
        });

        btnGoPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page3.class);
                startActivity(intent);
            }
        });

        btnGoPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page4.class);
                startActivity(intent);
            }
        });



    }
}
