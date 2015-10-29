package com.example.johannes.answer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button jawaban1;
    Button jawaban2;
    Button jawaban3;
    Button jawaban4;
    Button tabah_data;
    TextView pertanyaan;
    LinearLayout pertanyaan_depan;
    LinearLayout jawaban_depan;
    TextView caption_terpilih;
    TextView jawaban_terpilih;
    ArrayList<String> dataJawaban;
    ArrayList<String> dataCaption;
    ArrayList<Integer> dataBenarSalah;
    String pertanyaan_awal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabah_data = (Button) findViewById(R.id.tabah_data);
        jawaban1 = (Button) findViewById(R.id.jawaban1);
        jawaban2 = (Button) findViewById(R.id.jawaban2);
        jawaban3 = (Button) findViewById(R.id.jawaban3);
        jawaban4 = (Button) findViewById(R.id.jawaban4);
        pertanyaan = (TextView) findViewById(R.id.pertanyaan);
        caption_terpilih = (TextView) findViewById(R.id.caption_terpilih);
        jawaban_terpilih = (TextView) findViewById(R.id.jawaban_terpilih);


        pertanyaan_depan = (LinearLayout) findViewById(R.id.pertanyaan_depan);
        jawaban_depan = (LinearLayout) findViewById(R.id.jawaban_depan);

        Bundle data = getIntent().getExtras();
        if (data == null) {
            return;
        }

        pertanyaan_awal = data.getString("pertanyaan_awal");
        dataJawaban = data.getStringArrayList("dataJawaban");
        if (dataJawaban == null) {
            dataJawaban = new ArrayList<>();
        }
        dataCaption = data.getStringArrayList("dataCaption");
        if (dataCaption == null) {
            dataCaption = new ArrayList<>();
        }
        dataBenarSalah = data.getIntegerArrayList("dataBenarSalah");
        if (dataBenarSalah == null) {
            dataBenarSalah = new ArrayList<>();
        }


        if (dataJawaban.size() >= 1 && dataCaption.size() >=1) {
            jawaban1.setText(dataJawaban.get(0) + " " + dataBenarSalah.get(0));
            pertanyaan_depan.setVisibility(View.VISIBLE);
            pertanyaan.setText(pertanyaan_awal);
            if (dataJawaban.size() >= 2 && dataCaption.size() >=2) {
                jawaban2.setText(dataJawaban.get(1) + " " + dataBenarSalah.get(1));
                if (dataJawaban.size() >= 3  && dataCaption.size() >=3) {
                    jawaban3.setText(dataJawaban.get(2) + " " + dataBenarSalah.get(2));
                    if (dataJawaban.size() >= 4  && dataCaption.size() >=4){
                        jawaban4.setText(dataJawaban.get(3) + " " + dataBenarSalah.get(3));
                    }
                }
            }
        }
    }

    public void onClickTambah(View view) {
        Intent i = new Intent(this, Pertanyaan.class);
        startActivity(i);
    }

    public void onClickKembaliDepan(View view){
        jawaban_depan.setVisibility(View.GONE);
        pertanyaan_depan.setVisibility(View.VISIBLE);
    }

    public void iniBenar(){
        pertanyaan_depan.setVisibility(View.GONE);
        jawaban_depan.setVisibility(View.VISIBLE);
        jawaban_depan.setBackgroundColor(Color.parseColor("#028dce"));
    }

    public void iniSalah(){
        pertanyaan_depan.setVisibility(View.GONE);
        jawaban_depan.setVisibility(View.VISIBLE);
        jawaban_depan.setBackgroundColor(Color.parseColor("#fb0f0f"));
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.jawaban1:
                if(dataBenarSalah.get(0) == 1){
                    iniBenar();
                }else{
                    iniSalah();
                }
                caption_terpilih.setText(dataCaption.get(0));
                jawaban_terpilih.setText(dataJawaban.get(0));
                break;
            case R.id.jawaban2:
                if(dataBenarSalah.get(1) == 1){
                    iniBenar();
                }else{
                    iniSalah();
                }
                caption_terpilih.setText(dataCaption.get(1));
                jawaban_terpilih.setText(dataJawaban.get(1));
                break;
            case R.id.jawaban3:
                if(dataBenarSalah.get(2) == 1){
                    iniBenar();
                }else{
                    iniSalah();
                }
                caption_terpilih.setText(dataCaption.get(2));
                jawaban_terpilih.setText(dataJawaban.get(2));
                break;
            case R.id.jawaban4:
                if(dataBenarSalah.get(3) == 1){
                    iniBenar();
                }else{
                    iniSalah();
                }
                caption_terpilih.setText(dataCaption.get(3));
                jawaban_terpilih.setText(dataJawaban.get(3));
                break;
            default:
                break;
        }
    }



}
