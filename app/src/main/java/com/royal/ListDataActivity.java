package com.royal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class ListDataActivity extends AppCompatActivity {

//    TextView tvName;
    Spinner listSpinerNames;
    ListView listViewNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    listSpinerNames = findViewById(R.id.spinnerListDataNames);
    listViewNames = findViewById(R.id.listViewListDataNames);



    //ListView

        //tvName = findViewById(R.id.tvListDataName);

        //read
        SharedPreferences sp = getSharedPreferences("studentData",MODE_PRIVATE);
//        String firstName = sp.getString("firstName","");
        Set<String> listOfNames = sp.getStringSet("list",null);
//        if(list!=null){
//            tvName.setText(list.toString());
//        }
//        tvName.setText(firstName);


        String list[]  = new String[listOfNames.size()];
        int i=0;
        for(String x:listOfNames){
            list[i] = x;
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);

        listSpinerNames.setAdapter(adapter);
        listViewNames.setAdapter(adapter);

    }
}