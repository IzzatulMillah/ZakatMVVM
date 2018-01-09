package com.izzatul.bismillahzakatmvvm.materi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.izzatul.bismillahzakatmvvm.R;

import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity {

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

        // TODO lanjutkan lihat di github tutplus
    }

    private void inisialisasi(){
        zakatList = new ArrayList<>();
        zakatList.add(new Zakat("Zakat Fitrah", "see"));
        zakatList.add(new Zakat("Zakat Emas", "see"));
        zakatList.add(new Zakat("Zakat Perak", "see"));
        zakatList.add(new Zakat("Zakat Perdagangan", "see"));
        zakatList.add(new Zakat("Zakat Pertanian", "see"));
        zakatList.add(new Zakat("Zakat ...", "see"));
    }

    private void inisialisasiAdapter(){
        ZakatAdapter adapter = new ZakatAdapter(zakatList);
        rv.setAdapter(adapter);
    }

}
