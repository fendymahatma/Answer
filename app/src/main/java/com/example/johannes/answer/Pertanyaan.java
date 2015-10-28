package com.example.johannes.answer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Pertanyaan extends AppCompatActivity {

    Button jawaban1;
    Button jawaban2;
    Button jawaban3;
    Button jawaban4;
    Button balik;
    EditText caption;
    ArrayList<String> jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);

        jawaban1 = (Button) findViewById(R.id.jawaban1);
        jawaban2 = (Button) findViewById(R.id.jawaban2);
        jawaban3 = (Button) findViewById(R.id.jawaban3);
        jawaban4 = (Button) findViewById(R.id.jawaban4);
        balik = (Button) findViewById(R.id.balik);

        Bundle data = getIntent().getExtras();
        if(data == null){
            return;
        }

        String dataText = data.getString("jawaban");
        jawaban = new ArrayList<>();
        jawaban.add(dataText);
        jawaban1.setText(jawaban.get(0));
        jawaban2.setText(jawaban.get(0));
        jawaban3.setText(jawaban.get(0));
        jawaban4.setText(jawaban.get(0));
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
