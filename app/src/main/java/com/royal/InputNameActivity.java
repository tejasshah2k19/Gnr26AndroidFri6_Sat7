package com.royal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputNameActivity extends AppCompatActivity {

    //1 declare
    EditText edtName;
    Button btnUpper,btnRev;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        //2 Binding
        edtName = findViewById(R.id.edtInputNameName);//R
        btnRev = findViewById(R.id.btnInputNameReverse);
        btnUpper = findViewById(R.id.btnInputNameUpper);
        tvResult = findViewById(R.id.tvInputNameResult);


        //click event
        btnUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Log.i("InputNameActivity","upper button click");
            }
        });

    }

    //
}