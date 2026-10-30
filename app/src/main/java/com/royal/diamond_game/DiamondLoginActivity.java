package com.royal.diamond_game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;
import com.royal.config.RetrofitClient;
import com.royal.model.UserModel;
import com.royal.service.UserApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DiamondLoginActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;

    TextView tvSignupLink;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diamond_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        tvSignupLink = findViewById(R.id.tvDiamondLoginSignupLink);
        btnSubmit = findViewById(R.id.btnDiamondLoginSubmit);

        edtEmail  = findViewById(R.id.edtDiamondLoginEmail);
        edtPassword  = findViewById(R.id.edtDiamondLoginPassword);


        Intent intent = getIntent();
        String email = intent.getStringExtra("email");


        edtEmail.setText(email);

        tvSignupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DiamondSignupActivity.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                UserModel userModel = new UserModel();
                userModel.setEmail(email);
                userModel.setPassword(password);

                UserApiService userApiService = RetrofitClient.getUserApi();
                
                userApiService.loginApi(userModel).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {

                        Log.i("DimaondLoginActivity", response.toString());

                        Log.i("DimaondLoginActivity", response.message());

                        //400 ->
                        //200 ->
                        if (response.code() == 400) {
                            Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                        } else {


                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        }
                    }
                    @Override
                    public void onFailure(Call<Object> call, Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}