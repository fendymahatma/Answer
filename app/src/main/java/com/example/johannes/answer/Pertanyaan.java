package com.example.johannes.answer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Pertanyaan extends AppCompatActivity {

    Button jawaban1;
    TextView caption1;
    Button jawaban2;
    TextView caption2;
    Button jawaban3;
    TextView caption3;
    Button jawaban4;
    TextView caption4;
    Button balik;
    EditText caption;
    ArrayList<String> dataJawaban;
    ArrayList<String> dataCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);

        caption = (EditText) findViewById(R.id.caption);
        jawaban1 = (Button) findViewById(R.id.jawaban1);
        caption1 = (TextView) findViewById(R.id.caption1);
        jawaban2 = (Button) findViewById(R.id.jawaban2);
        caption2 = (TextView) findViewById(R.id.caption2);
        jawaban3 = (Button) findViewById(R.id.jawaban3);
        caption3 = (TextView) findViewById(R.id.caption3);
        jawaban4 = (Button) findViewById(R.id.jawaban4);
        caption4 = (TextView) findViewById(R.id.caption4);
        balik = (Button) findViewById(R.id.balik);

        Bundle data = getIntent().getExtras();
        if (data == null) {
            return;
        }

        dataJawaban = data.getStringArrayList("dataJawaban");
        if (dataJawaban == null) {
            dataJawaban = new ArrayList<>();
        }
        dataCaption = data.getStringArrayList("dataCaption");
        if (dataCaption == null) {
            dataCaption = new ArrayList<>();
        }


        if (dataJawaban.size() >= 1 && dataCaption.size() >=1) {
            caption1.setText(dataCaption.get(0));
            jawaban1.setText(dataJawaban.get(0));
            jawaban1.setEnabled(false);
            if (dataJawaban.size() >= 2 && dataCaption.size() >=2) {
                caption2.setText(dataCaption.get(1));
                jawaban2.setText(dataJawaban.get(1));
                jawaban2.setEnabled(false);
                if (dataJawaban.size() >= 3  && dataCaption.size() >=3) {
                    caption3.setText(dataCaption.get(2));
                    jawaban3.setText(dataJawaban.get(2));
                    jawaban3.setEnabled(false);
                    if (dataJawaban.size() >= 4  && dataCaption.size() >=4){
                        caption4.setText(dataCaption.get(3));
                        jawaban4.setText(dataJawaban.get(3));
                        jawaban4.setEnabled(false);
                    }
                }
            }
        }


    }

    public void onClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void tambahJawaban(View view) {
        Intent in = new Intent(this, Jawaban.class);

        in.putExtra("dataCaption", dataCaption);
        in.putExtra("dataJawaban", dataJawaban);

        startActivity(in);
    }

}

        /*if (jawaban1.getText().equals("tambah data")) {
            jawaban1.setText(dataText);
        } else if (jawaban2.getText().equals("tambah data")) {
            jawaban2.setText(dataText);
        } else if (jawaban3.getText().equals("tambah data")) {
            jawaban3.setText(dataText);
        } else if (jawaban4.getText().equals("tambah data")) {
            jawaban4.setText(dataText);
        }*/
