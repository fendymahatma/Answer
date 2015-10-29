package com.example.johannes.answer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button jawaban1;
    Button jawaban2;
    Button jawaban3;
    Button jawaban4;
    Button tabah_data;
    TextView pertanyaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jawaban1 = (Button) findViewById(R.id.jawaban1);
        jawaban2 = (Button) findViewById(R.id.jawaban2);
        jawaban3 = (Button) findViewById(R.id.jawaban3);
        jawaban4 = (Button) findViewById(R.id.jawaban4);
        tabah_data = (Button) findViewById(R.id.tabah_data);
        pertanyaan = (TextView) findViewById(R.id.pertanyaan);


    }

    public void onClick(View view){
        Intent i = new Intent(this, Pertanyaan.class);
        startActivity(i);
    }



}
