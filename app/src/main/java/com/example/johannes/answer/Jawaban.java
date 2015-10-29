package com.example.johannes.answer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Jawaban extends AppCompatActivity {

    TextView pertanyaanke;
    EditText caption;
    EditText jawaban;
    Button tambah;
    ArrayList<String> dataJawaban;
    ArrayList<String> dataCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jawaban);

        pertanyaanke = (TextView) findViewById(R.id.pertanyaanke);
        caption = (EditText) findViewById(R.id.caption);
        jawaban = (EditText) findViewById(R.id.jawaban);
        tambah = (Button) findViewById(R.id.tambah);

        Bundle data = getIntent().getExtras();
        if(data == null){
            return;
        }

        dataJawaban = data.getStringArrayList("dataJawaban");
        if(dataJawaban == null) {
            dataJawaban = new ArrayList<>();
        }
        dataCaption = data.getStringArrayList("dataCaption");
        if(dataCaption == null) {
            dataCaption = new ArrayList<>();
        }

    }

    public void onClick(View view){
        Intent i = new Intent(this, Pertanyaan.class);

        dataCaption.add(caption.getText().toString());
        i.putExtra("dataCaption", dataCaption);
        dataJawaban.add(jawaban.getText().toString());
        i.putExtra("dataJawaban", dataJawaban);

        startActivity(i);
    }
}