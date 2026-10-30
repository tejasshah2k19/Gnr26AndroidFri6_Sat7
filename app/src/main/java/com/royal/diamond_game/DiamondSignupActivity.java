package com.royal.diamond_game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class DiamondSignupActivity extends AppCompatActivity {


    Button btnSignup;
    EditText txtFirstName,txtLastName,txtEmail,txtPassword;

    //declare
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diamond_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        btnSignup = findViewById(R.id.btnDiamondSignupSubmit);
        txtEmail = findViewById(R.id.edtDiamondSignupEmail);
        txtFirstName  = findViewById(R.id.edtDiamondSignupFirstName);
        txtLastName = findViewById(R.id.edtDiamondSignupLastName);
    txtPassword = findViewById(R.id.edtDiamondSignupPassword);

        //click
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //read
                String firstName = txtFirstName.getText().toString();
                String lastName = txtLastName.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                int credits = 5000;

                UserModel userModel = new UserModel();
                userModel.setFirstName(firstName);
                userModel.setLastName(lastName);
                userModel.setEmail(email);
                userModel.setPassword(password);
                userModel.setCredit(credits);

                //api -- rest --- rest api -- json
                UserApiService userApi =  RetrofitClient.getUserApi();
                userApi.signupApi(userModel).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Log.i("DiamondSignupActivity",response.toString());
                        Log.i("DiamondSignupActivity",response.message());
                        Toast.makeText(getApplicationContext(),"Signup done",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), DiamondLoginActivity.class);
                        intent.putExtra("email",email);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable throwable) {
                        Log.i("DiamondSingupActivity",throwable.toString());
                        Log.i("DiamondSingupActivity",throwable.getMessage().toString());
                    }
                });
            }
        });
    }
}