package com.example.useretrofitex.activities.addr;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useretrofitex.R;
import com.example.useretrofitex.activities.addr.adapter.AddrRecyAdapter;
import com.example.useretrofitex.activities.addr.model.AddressResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddressActivity extends AppCompatActivity {

    public AddrRecyAdapter mRecyclerViewAdapter;
    public RecyclerView mRecyclerView;
    public EditText inputAddr;
    public ImageView searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        inputAddr = (EditText) findViewById(R.id.addr_ed_addr);
        searchBtn = (ImageView) findViewById(R.id.addr_btn_search);
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        searchBtn.setOnClickListener((v) -> {

            if (inputAddr.getText().toString().length() == 0) {
                //공백일 때 처리할 내용
                imm.hideSoftInputFromWindow(inputAddr.getWindowToken(),0);
            } else {
                imm.hideSoftInputFromWindow(inputAddr.getWindowToken(),0);
                inputAddr.setText("");
                addrRetrofit();
            }

        });

        inputAddr.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                switch(keyCode){
                    case KeyEvent.ACTION_DOWN:
                        imm.hideSoftInputFromWindow(inputAddr.getWindowToken(),0);
                        addrRetrofit();

                    case KeyEvent.KEYCODE_ENTER:
                        addrRetrofit();
                        imm.hideSoftInputFromWindow(inputAddr.getWindowToken(),0);
                        addrRetrofit();
                }return true;
            }
        });


    }

    public void addrRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://210.119.145.22/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AddressRetrofitInterface addressRetrofitInterface = retrofit.create(AddressRetrofitInterface.class);
        Call<List<AddressResponse>> call = addressRetrofitInterface.getPosts(inputAddr.toString());
        call.enqueue(new Callback<List<AddressResponse>>() {
            @Override
            public void onResponse(Call<List<AddressResponse>> call, Response<List<AddressResponse>> response) {
                if (!response.isSuccessful()) {
                    Log.d("Test", "Addr Activity-isSuccess code : " + response.code());
                    return;
                }
                ArrayList<AddressResponse> posts = (ArrayList<AddressResponse>) response.body();
                //initiate adapter

                RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.addr_rv_list_all);
                mRecyclerViewAdapter = new AddrRecyAdapter(posts, getApplicationContext());
                //initiate recyclerview
                mRecyclerView.setAdapter(mRecyclerViewAdapter);

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<AddressResponse>> call, Throwable t) {
                Log.d("Test", "Addr Activity onFailure msg : " + t.toString());
            }
        });
    }

}
