package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    //declare
    TextView tvSignupLink;
    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        tvSignupLink = findViewById(R.id.tvLoginSignupLink);
        edtEmail = findViewById(R.id.edtLoginEmail);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        if(email == null){
            email ="";
        }
        edtEmail.setText(email);

        tvSignupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent

                Intent intent = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);//
            }
        });
    }
}