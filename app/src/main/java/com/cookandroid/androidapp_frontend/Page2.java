package com.cookandroid.androidapp_frontend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity {

    Button btn4;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);


        btnDial = findViewById(R.id.btnDial);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });




        btn4 = findViewById(R.id.button4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kua.go.kr/uaptm010/selectMain.do"));
                startActivity(urlintent);
            }
        });

        btn6 = findViewById(R.id.button6);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.work.go.kr/jobyoung/smallGiants/smallGiantsMain.do"));
                startActivity(urlintent);
            }
        });

        btn7 = findViewById(R.id.button7);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hrd.go.kr/hrdp/ma/pmmao/newIndexRenewal.do"));
                startActivity(urlintent);
            }
        });

        btn8 = findViewById(R.id.button8);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.work.go.kr/youngtomorrow/index.do"));
                startActivity(urlintent);
            }
        });




    }
}

