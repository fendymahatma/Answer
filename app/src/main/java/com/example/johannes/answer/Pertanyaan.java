package com.example.johannes.answer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pertanyaan extends AppCompatActivity {

    Button jawaban1;
    Button jawaban2;
    Button jawaban3;
    Button jawaban4;
    Button balik;
    EditText caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);

        jawaban1 = (Button) findViewById(R.id.jawaban1);
        jawaban2 = (Button) findViewById(R.id.jawaban2);
        jawaban3 = (Button) findViewById(R.id.jawaban3);
        jawaban4 = (Button) findViewById(R.id.jawaban4);
        balik = (Button) findViewById(R.id.balik);


    }

    public void onClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public  void tambahJawaban(View view){
        Intent in = new Intent(this, Jawaban.class);
        caption = (EditText) findViewById(R.id.caption);
        String ambil = caption.getText().toString();
        in.putExtra("data", ambil);

        startActivity(in);
    }
}
