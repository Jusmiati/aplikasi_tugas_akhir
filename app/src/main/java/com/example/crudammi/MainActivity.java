package com.example.crudammi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.crudammi.ui.aktivitasfisik.AktivitasfisikActivity;
import com.example.crudammi.ui.imt.ImtActivity;
import com.example.crudammi.ui.riwayatpenyakit.Riwayatpenyakit;
import com.example.crudammi.ui.skalastress.SkalastressActivity;
import com.example.crudammi.ui.user.UserActivity;


public class MainActivity extends AppCompatActivity {
    CardView userButton;
    CardView imtButton;
    CardView riwayatpenyakitButton;
    CardView aktivitasfisikButton;
    CardView skalastressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pasang button user ke yang dilayout, baru diset untuk buka aktivity user dari main activity
        userButton = findViewById(R.id.menuUser);
        userButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
        });

        imtButton = findViewById(R.id.menuIndexMassaTubuh);
        imtButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ImtActivity.class);
            startActivity(intent);
        });

        riwayatpenyakitButton = findViewById(R.id.menuRiwayatSakit);
        riwayatpenyakitButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Riwayatpenyakit.class);
            startActivity(intent);
        });

        aktivitasfisikButton = findViewById(R.id.menuKeteranganAktifitas);
        aktivitasfisikButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AktivitasfisikActivity.class);
            startActivity(intent);
        });

        skalastressButton = findViewById(R.id.menuJiwa);
        skalastressButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SkalastressActivity.class);
            startActivity(intent);
        });
    }

}
