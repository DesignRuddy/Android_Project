package com.cookandroid.androidapp_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page4 extends AppCompatActivity {

    Button btnGoMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        btnGoMap = (Button)findViewById(R.id.btnGoMap);

        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page4_Map.class);
                startActivity(intent);
            }
        });
    }
}
