package com.royal.diamond_game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;

public class GamePlayScreen extends AppCompatActivity {

    TextView tvCredit;
    Button btnCheckout;

    ImageButton btn[] = new ImageButton[9]; //array

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
        btn[0] = findViewById(R.id.imgBtnGamePlay1);
        btn[1] = findViewById(R.id.imgBtnGamePlay2);
        btn[2] = findViewById(R.id.imgBtnGamePlay3);
        btn[3] = findViewById(R.id.imgBtnGamePlay4);
        btn[4] = findViewById(R.id.imgBtnGamePlay5);
        btn[5] = findViewById(R.id.imgBtnGamePlay6);
        btn[6] = findViewById(R.id.imgBtnGamePlay7);
        btn[7] = findViewById(R.id.imgBtnGamePlay8);
        btn[8] = findViewById(R.id.imgBtnGamePlay9);
        btnCheckout.setClickable(false);



        for(ImageButton b : btn) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(b.getBackground().toString().contains("RippleDrawable")) {

                        int randomNum = (int) (Math.random() * 100);//036.987452148 * 100
                        if (randomNum % 2 == 0) {
                            b.setBackgroundResource(R.drawable.diamond_hmt_512);
                            btnCheckout.setClickable(true);

                            //diamond
                        } else {
                            //bomb
                            btnCheckout.setClickable(false);
                            b.setBackgroundResource(R.drawable.blast_hmt);
                            for(ImageButton t:btn){
                                t.setClickable(false);
                            }

//                            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//                            builder.setMessage("game over")
//                                    .setTitle("GAME OVER");
//                            AlertDialog dialog = builder.create();
//                            dialog.show();
                            Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_LONG).show();

                            b.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                    startActivity(intent);

                                }
                            },1000);

                        }
                    }

                 }
            });
        }


    }
}