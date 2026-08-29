package com.royal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    //declare
    EditText edtN1 ;
    EditText edtN2 ;
    Button btnAdd;
    Button btnSub;
    Button btnMultiply;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //binding
        edtN1 = findViewById(R.id.edtCalculatorInput1);
        edtN2 = findViewById(R.id.edtCalculatorInput2);
        btnAdd = findViewById(R.id.btnCalculatorAdd);
        btnSub = findViewById(R.id.btnCalculatorSub);
        btnMultiply = findViewById(R.id.btnCalculatorMultiply);
        tvResult = findViewById(R.id.tvCalculatorResult);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = edtN1.getText().toString();
                String input2 = edtN2.getText().toString();
                boolean isError = false;


                if(input1.isBlank()){
                    edtN1.setError("Please enter number 1");
                    isError = true;
                }
                if(input2.isBlank()){
                    edtN2.setError("Please enter number 2 ");
                    isError=true;
                }

                if(!isError) {

                    Integer n1 = Integer.parseInt(input1);
                    Integer n2 = Integer.parseInt(input2);

                    int result = n1 + n2;
                    String add = Integer.toString(result);

                    tvResult.setText(add);
                }

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = edtN1.getText().toString();
                Integer n1 = Integer.parseInt(input1);

                String input2 = edtN2.getText().toString();
                Integer n2 = Integer.parseInt(input2);

                int result = n1 - n2 ;
                String sub = Integer.toString(result);

                tvResult.setText(sub);


            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = edtN1.getText().toString();
                Integer n1 = Integer.parseInt(input1);

                String input2 = edtN2.getText().toString();
                Integer n2 = Integer.parseInt(input2);

                int result = n1 * n2 ;
                String multiply = Integer.toString(result);

                tvResult.setText(multiply);


            }
        });

    }
}