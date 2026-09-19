package com.royal.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;

public class CallActivity extends AppCompatActivity {

    ListView listCall;
    ImageButton imgBtnMail,imgBtnUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listCall = findViewById(R.id.listViewCallCallList);
        imgBtnMail = findViewById(R.id.imgBtnCallMail);
        imgBtnUser = findViewById(R.id.imgBtnCallUser);


        String contactNum[] =  {"9632587412","1478523698","8523698741","1478963255","7412589630","9632587410"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contactNum);
        listCall.setAdapter(adapter);

        imgBtnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MailActivity.class);
                startActivity(intent);
            }
        });

        imgBtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent);
            }
        });

    }
}