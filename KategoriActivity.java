package com.izzatul.bismillahzakatmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatEmasActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatFitrahActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatPerakActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatPerdaganganActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatPertanianActivity;
import com.izzatul.bismillahzakatmvvm.materi.view.DeskripsiMateriActivity;

import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity implements ZakatAdapter.OnRecyclerViewListener{

    private RecyclerView rv;
    private List<Zakat> zakatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tes_recyclerview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        rv = findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        inisialisasi();
        inisialisasiAdapter();
    }

    private void inisialisasi(){
        zakatList = new ArrayList<>();
        zakatList.add(new Zakat("Zakat Fitrah"));
        zakatList.add(new Zakat("Zakat Emas"));
        zakatList.add(new Zakat("Zakat Perak"));
        zakatList.add(new Zakat("Zakat Perdagangan"));
        zakatList.add(new Zakat("Zakat Pertanian"));
        zakatList.add(new Zakat("Zakat Hewan Ternak"));
    }

    private void inisialisasiAdapter(){
        ZakatAdapter adapter = new ZakatAdapter(this, zakatList);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClickCardView(int position) {
        Intent intent;
        int bundle = getIntent().getExtras().getInt("menu");
        if (bundle == 3){
            switch (position) {
                case 0 :
                    intent = new Intent(this, HitungZakatFitrahActivity.class);
                    startActivity(intent);
                    break;
                case 1 :
                    intent = new Intent(this, HitungZakatEmasActivity.class);
                    startActivity(intent);
                    break;
                case 2 :
                    intent = new Intent(this, HitungZakatPerakActivity.class);
                    startActivity(intent);
                    break;
                case 3 :
                    intent = new Intent(this, HitungZakatPerdaganganActivity.class);
                    startActivity(intent);
                    break;
                case 4 :
                    intent = new Intent(this, HitungZakatPertanianActivity.class);
                    startActivity(intent);
                    break;
                case 5 :
                    Toast.makeText(this, "Masih On Going", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else {
            switch (position) {
                case 0 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    startActivity(intent);
                    break;
                case 1 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    startActivity(intent);
                    break;
                case 2 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    startActivity(intent);
                    break;
                case 3 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    startActivity(intent);
                    break;
                case 4 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    startActivity(intent);
                    break;
                case 5 :
                    Toast.makeText(this, "Masih On Going", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
