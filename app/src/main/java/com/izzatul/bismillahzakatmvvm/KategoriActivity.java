package com.izzatul.bismillahzakatmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatEmasActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatFitrahActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatHewanTernakActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatPerakActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatPerdaganganActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatPertanianActivity;
import com.izzatul.bismillahzakatmvvm.kalkulator.HitungZakatRikazActivity;
import com.izzatul.bismillahzakatmvvm.materi.DeskripsiMateriActivity;
import com.izzatul.bismillahzakatmvvm.model.Zakat;
import com.izzatul.bismillahzakatmvvm.model.ZakatAdapter;

import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity implements ZakatAdapter.OnRecyclerViewListener{

    private RecyclerView rv;
    private List<Zakat> zakatList;
    private int bundle;

    Bundle fitrah, emas, perak, dagang, tani, ternak, rikaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tes_recyclerview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bundle = getIntent().getExtras().getInt("menu");
        if (bundle == 1) {
            getSupportActionBar().setTitle(R.string.materi);
        } else {
            getSupportActionBar().setTitle(R.string.kalkulator);
        }

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
        zakatList.add(new Zakat("Zakat Rikaz"));
    }

    private void inisialisasiAdapter(){
        ZakatAdapter adapter = new ZakatAdapter(this, zakatList);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClickCardView(int position) {
        Intent intent;
        /* Jika value yang dipassing adalah 3, maka akan menuju ke activity kalkulator */
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
                    intent = new Intent(this, HitungZakatHewanTernakActivity.class);
                    startActivity(intent);
                    break;
                case 6 :
                    intent = new Intent(this, HitungZakatRikazActivity.class);
                    startActivity(intent);
                    break;
            }
        }
        /* Jika value yang dipassing adalah 1, maka akan menuju ke activity materi */
        else {
            switch (position) {
                case 0 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    fitrah = new Bundle();
                    fitrah.putInt("kategori", 1);
                    intent.putExtras(fitrah);
                    startActivity(intent);
                    break;
                case 1 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    emas = new Bundle();
                    emas.putInt("kategori", 2);
                    intent.putExtras(emas);
                    startActivity(intent);
                    break;
                case 2 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    perak = new Bundle();
                    perak.putInt("kategori", 3);
                    intent.putExtras(perak);
                    startActivity(intent);
                    break;
                case 3 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    dagang = new Bundle();
                    dagang.putInt("kategori", 4);
                    intent.putExtras(dagang);
                    startActivity(intent);
                    break;
                case 4 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    tani = new Bundle();
                    tani.putInt("kategori", 5);
                    intent.putExtras(tani);
                    startActivity(intent);
                    break;
                case 5 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    ternak = new Bundle();
                    ternak.putInt("kategori", 6);
                    intent.putExtras(ternak);
                    startActivity(intent);
                    break;
                case 6 :
                    intent = new Intent(this, DeskripsiMateriActivity.class);
                    rikaz = new Bundle();
                    rikaz.putInt("kategori", 7);
                    intent.putExtras(rikaz);
                    startActivity(intent);
                    break;
            }
        }
    }

    // tombol click back ke home atau activity sebelumnya
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idItem = item.getItemId();
        switch (idItem) {
            case android.R.id.home :
                finish();
                break;
            default:
                Toast.makeText(this, "what are you pushing?", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
