package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {


    Button btnSubmit;
    EditText edtFirstName,edtEmail,edtPassword;

    RadioButton rbMale,rbFemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtFirstName= findViewById(R.id.edtRegistrationFirstName);
        edtEmail  = findViewById(R.id.edtRegistrationEmail);
        edtPassword = findViewById(R.id.edtRegistrationPassword);

        rbMale = findViewById(R.id.rbRegistrationMale);
        rbFemale = findViewById(R.id.rbRegistrationFemale);


        btnSubmit = findViewById(R.id.btnRegistrationSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isError = false;
                //read
                String email = edtEmail.getText().toString(); //read email as string
                //validation
                if(email.isBlank()){
                    edtEmail.setError("Please Enter Email");
                    isError = true;
                }

                if(!isError) {
                    //db insertion


                    Toast.makeText(getApplicationContext(),"Signup Success",Toast.LENGTH_LONG).show();
                    //navigate to login
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }else{

                }
            }
        });
    }
}