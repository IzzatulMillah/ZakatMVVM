package com.izzatul.bismillahzakatmvvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.izzatul.bismillahzakatmvvm.materi.KategoriActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bMateri, bLatihan, bKalkulator, bTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      COMPLETED cari method OnClickListener yang lebih efisien

        bMateri = findViewById(R.id.btnMateri);
        bLatihan = findViewById(R.id.btnSoalLatihan);
        bKalkulator = findViewById(R.id.btnKalkulator);
        bTentang = findViewById(R.id.btnTentangAplikasi);

        bMateri.setOnClickListener(this);
        bLatihan.setOnClickListener(this);
        bKalkulator.setOnClickListener(this);
        bTentang.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMateri:
                Intent materi = new Intent(MainActivity.this, KategoriActivity.class);
                startActivity(materi);
                break;
            case R.id.btnSoalLatihan:
                Intent latihan = new Intent(MainActivity.this, KategoriActivity.class);
                startActivity(latihan);
                break;
            case R.id.btnKalkulator:
                Intent kalkulator = new Intent(MainActivity.this, KategoriActivity.class);
                startActivity(kalkulator);
                break;
            case R.id.btnTentangAplikasi:
                break;
        }
    }
}
