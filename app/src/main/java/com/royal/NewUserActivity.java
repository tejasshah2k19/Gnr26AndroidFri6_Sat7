package com.royal;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewUserActivity extends AppCompatActivity {


    RadioButton rbtMale,rbtFemale;

    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rbtMale = findViewById(R.id.rbNewUserGenderMale);
        rbtFemale = findViewById(R.id.rbNewUserGenderFemale);
        rgGender = findViewById(R.id.rgNewUserGender);

        String gender ;

        if(rbtMale.isChecked()){
            gender = rbtMale.getText().toString();
        }

        if(rbtFemale.isChecked()){
            gender = rbtFemale.getText().toString();
        }

        RadioButton rb  =  findViewById(rgGender.getCheckedRadioButtonId());
        String gender2 = rb.getText().toString();



    }
}