package com.example.useretrofitex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.useretrofitex.activities.addr.AddressActivity;
import com.example.useretrofitex.activities.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginBtn = findViewById(R.id.main_btn_login);
        Button addrBtn = findViewById(R.id.main_btn_addr);
        Button sensorBtn = findViewById(R.id.main_btn_int_sensor);
        Button searchBtn = findViewById(R.id.main_btn_search);


        loginBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
        addrBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
            startActivity(intent);
        });
        sensorBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
            startActivity(intent);
        });
        searchBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
            startActivity(intent);
        });

    }
}