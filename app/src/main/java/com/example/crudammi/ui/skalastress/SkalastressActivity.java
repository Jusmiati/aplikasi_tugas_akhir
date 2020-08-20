package com.example.crudammi.ui.skalastress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudammi.R;

import java.util.ArrayList;

public class SkalastressActivity extends AppCompatActivity {

    ArrayList<Integer> nilaiTotal;
    int totalNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skalastress);

        nilaiTotal = new ArrayList<>();

        Button hasilBT = findViewById(R.id.hasilBT);
        TextView hasilTV = findViewById(R.id.hasiltv);

        hasilBT.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                nilaiTotal.clear();
                totalNilai = 0;
                //no 1
                RadioGroup no1 = findViewById(R.id.list_jawaban);
                getNilaiDariNomor(no1);
                //no 2
                RadioGroup no2 = findViewById(R.id.list_jawaban1);
                getNilaiDariNomor(no2);
                //no 3
                RadioGroup no3 = findViewById(R.id.list_jawaban2);
                getNilaiDariNomor(no3);
                //no 4
                RadioGroup no4 = findViewById(R.id.list_jawaban3);
                getNilaiDariNomor(no4);
                //no 5
                RadioGroup no5 = findViewById(R.id.list_jawaban4);
                getNilaiDariNomor(no5);
                //no 6
                RadioGroup no6 = findViewById(R.id.list_jawaban5);
                getNilaiDariNomor(no6);
                //no 7
                RadioGroup no7 = findViewById(R.id.list_jawaban6);
                getNilaiDariNomor(no7);
                //no 8
                RadioGroup no8 = findViewById(R.id.list_jawaban7);
                getNilaiDariNomor(no8);
                //no 9
                RadioGroup no9 = findViewById(R.id.list_jawaban8);
                getNilaiDariNomor(no9);
                //no 10
                RadioGroup no10 = findViewById(R.id.list_jawaban9);
                getNilaiDariNomor(no10);

                //get total nilai
                int totalNilai = getTotalNilai(nilaiTotal);
                //hapus ini toast klo nda mau dimunculkan
                Toast.makeText(getBaseContext(), "Total Nilai: " + totalNilai, Toast.LENGTH_SHORT).show();
                if (totalNilai<14) {
                    hasilTV.setText("Stress rendah");
                } else if (totalNilai<27) {
                    hasilTV.setText("Stress sedang");
                } else {
                    hasilTV.setText("Stress berat");
                }
            }
        });
    }

    private int getTotalNilai(ArrayList<Integer> data) {
        int sum = 0;
        for(int d : data)
            sum += d;
        return sum;
    }

    private int getNilaiJawaban (String inputData) {
        switch (inputData) {
            case "Tidak pernah":
                return 0;
            case "Hampir tidak pernah":
                return 1;
            case "Kadang-kadang":
                return 2;
            case "Sering":
                return 3;
            case "Sangat Sering":
                return 4;
            default:
                return 0;
        }
    }

    public void getNilaiDariNomor(RadioGroup soal) {
        RadioButton a = findViewById(soal.getCheckedRadioButtonId());
        if (a!=null) {
            int nilai = getNilaiJawaban(a.getText().toString());
            nilaiTotal.add(nilai);
        } else {
          //  Toast.makeText(SkalastressActivity.this, "Anda harus mengisi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }
    }
}
