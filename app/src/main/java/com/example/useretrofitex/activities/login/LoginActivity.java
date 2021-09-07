package com.example.useretrofitex.activities.login;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useretrofitex.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public EditText loginId;
    public EditText loginPw;
    public ImageView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginId = (EditText) findViewById(R.id.login_ed_id);
        loginPw = (EditText) findViewById(R.id.login_ed_password);
        loginBtn = (ImageView) findViewById(R.id.login_ed_login);
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        loginBtn.setOnClickListener((v) -> {

            if (loginId.getText().toString().length() == 0) {
                //공백일 때 처리할 내용
                imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);
            } else if (loginPw.getText().toString().length() == 0) {
                imm.hideSoftInputFromWindow(loginPw.getWindowToken(), 0);
            } else {
                imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(loginPw.getWindowToken(), 0);
                addrLoginRetrofit();
            }

        });

        loginId.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                switch (keyCode) {
                    case KeyEvent.ACTION_DOWN:
                        imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);

                    case KeyEvent.KEYCODE_ENTER:
                        imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);
                }
                return true;
            }
        });

        loginPw.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                switch (keyCode) {
                    case KeyEvent.ACTION_DOWN:
                        imm.hideSoftInputFromWindow(loginPw.getWindowToken(), 0);

                    case KeyEvent.KEYCODE_ENTER:
                        imm.hideSoftInputFromWindow(loginPw.getWindowToken(), 0);
                }
                return true;
            }
        });
    }

    public void addrLoginRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://210.119.145.22/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginRetrofitInterface loginRetrofitInterface = retrofit.create(LoginRetrofitInterface.class);

        String mLogId = loginId.getText().toString();
        String mLogPw = loginPw.getText().toString();

        Call<LoginResponse> call = loginRetrofitInterface.getLogins(mLogId, mLogPw);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("Test", "Login Activity !isSuccess code : " + response.code());
                } else {
                    LoginResponse posts = response.body();
                    Toast.makeText(getApplicationContext(), posts.getMsg(), Toast.LENGTH_SHORT).show();
                    Log.d("Test", "Login Activity myId : " + loginId.getText());
                    Log.d("Test", "Login Activity myId : " + loginPw.getText());
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("Test", "Login Activity onFailure msg : " + t.toString());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        loginId.setText("");
        loginPw.setText("");
    }
}
