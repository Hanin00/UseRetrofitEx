package com.example.useretrofitex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.useretrofitex.addr.AddressActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.main_btn_addr);
        btn.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
            startActivity(intent);
        });
    }
}