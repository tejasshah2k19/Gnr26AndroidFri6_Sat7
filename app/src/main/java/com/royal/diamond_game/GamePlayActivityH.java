package com.royal.diamond_game;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;

public class GamePlayActivityH extends AppCompatActivity {
    //declare
    ImageButton btn[]= new ImageButton[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_play_h);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        btn[0] = findViewById(R.id.imgBtnGamePlayH1);
        btn[1] = findViewById(R.id.imgBtnGamePlayH2);
        btn[2] = findViewById(R.id.imgBtnGamePlayH3);
        btn[3] = findViewById(R.id.imgBtnGamePlayH4);
        btn[4] = findViewById(R.id.imgBtnGamePlayH5);
        btn[5] = findViewById(R.id.imgBtnGamePlayH6);
        btn[6] = findViewById(R.id.imgBtnGamePlayH7);
        btn[7] = findViewById(R.id.imgBtnGamePlayH8);
        btn[8] = findViewById(R.id.imgBtnGamePlayH9);

    for(ImageButton b  : btn ) {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (int) (Math.random() * 100);//069.8563215456 * 100
                if (random % 2 == 0) {
                    b.setBackgroundResource(R.drawable.diamond_hmt_512);
                } else {
                    b.setBackgroundResource(R.drawable.blast_hmt);
                }
            }
        });
    }

    }
}