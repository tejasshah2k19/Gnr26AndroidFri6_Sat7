package com.royal.diamond_game;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;
import com.royal.model.UserModel;

public class DiamondSignupActivity extends AppCompatActivity {


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

        //read
        //click
        String firstName = "ram";
        String email = "ram@111.com";
        String password = "secret123";
        int credits = 5000;

        UserModel userModel = new UserModel();
        userModel.setFirstName(firstName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setCredits(credits);


        //api -- rest --- rest api -- json

    }
}