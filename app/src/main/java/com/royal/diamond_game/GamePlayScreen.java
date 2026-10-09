package com.royal.diamond_game;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;

public class GamePlayScreen extends AppCompatActivity {

    TextView tvCredit;
    Button btnCheckout;

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9; //array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_play_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCredit = findViewById(R.id.tvGamePlayCredit);
        btnCheckout = findViewById(R.id.btnGamePlayCheckout);
        btn1 = findViewById(R.id.imgBtnGamePlay1);
        btn2 = findViewById(R.id.imgBtnGamePlay2);
        btn3 = findViewById(R.id.imgBtnGamePlay3);
        btn4 = findViewById(R.id.imgBtnGamePlay4);
        btn5 = findViewById(R.id.imgBtnGamePlay5);
        btn6 = findViewById(R.id.imgBtnGamePlay6);
        btn7 = findViewById(R.id.imgBtnGamePlay7);
        btn8 = findViewById(R.id.imgBtnGamePlay8);
        btn9 = findViewById(R.id.imgBtnGamePlay9);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNum  = (int)(Math.random()* 100) ;//036.987452148 * 100
                if(randomNum%2 ==0){
                    btn1.setBackgroundResource(R.drawable.diamond_hmt_512);
                }else{
                    btn1.setBackgroundResource(R.drawable.blast_hmt);
                }

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNum  = (int)(Math.random()* 100) ;//036.987452148 * 100
                if(randomNum%2 ==0){
                    btn2.setBackgroundResource(R.drawable.diamond_hmt_512);
                }else{
                    btn2.setBackgroundResource(R.drawable.blast_hmt);
                }

            }
        });


    }
}