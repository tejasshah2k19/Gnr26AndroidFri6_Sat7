package com.royal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class InputDataActivity extends AppCompatActivity {


    EditText edtFirstname;
    Button btnSave;
    TextView tvListLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtFirstname = findViewById(R.id.edtInputDataFirstName);
        btnSave = findViewById(R.id.btnInputDataSave);
        tvListLink = findViewById(R.id.tvInputDataLinkForListStudent);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //read
                String firstName = edtFirstname.getText().toString();
                //validation

                //store
                SharedPreferences sharedPreferences = getSharedPreferences("studentData",MODE_PRIVATE);

                //editor
                SharedPreferences.Editor editor =  sharedPreferences.edit();

                //write data
                editor.putString("firstName",firstName);

                editor.apply();

                //message alert
                Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_LONG).show();

                edtFirstname.setText("");

            }
        });

        tvListLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(intent);
            }
        });
    }
}