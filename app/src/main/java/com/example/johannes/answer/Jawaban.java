package com.example.johannes.answer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Jawaban extends AppCompatActivity {

    TextView pertanyaanke;
    EditText caption;
    EditText jawaban;
    Button tambah;
    RadioButton radio_benar;
    RadioButton radio_salah;
    ArrayList<String> dataJawaban;
    ArrayList<String> dataCaption;
    ArrayList<Integer> dataBenarSalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jawaban);

        pertanyaanke = (TextView) findViewById(R.id.pertanyaanke);
        caption = (EditText) findViewById(R.id.caption);
        jawaban = (EditText) findViewById(R.id.jawaban);
        tambah = (Button) findViewById(R.id.tambah);
        radio_benar = (RadioButton) findViewById(R.id.radio_benar);
        radio_salah = (RadioButton) findViewById(R.id.radio_salah);

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
        dataBenarSalah = data.getIntegerArrayList("dataBenarSalah");
        if(dataBenarSalah == null) {
            dataBenarSalah = new ArrayList<>();
        }



    }

    public void onClick(View view){
        Intent i = new Intent(this, Pertanyaan.class);

        dataCaption.add(caption.getText().toString());
        i.putExtra("dataCaption", dataCaption);

        dataJawaban.add(jawaban.getText().toString());
        i.putExtra("dataJawaban", dataJawaban);

        if(radio_benar.isChecked()){
            dataBenarSalah.add(1);
        }else if(radio_salah.isChecked()){
            dataBenarSalah.add(0);
        }
        i.putExtra("dataBenarSalah", dataBenarSalah);

        startActivity(i);
    }
}