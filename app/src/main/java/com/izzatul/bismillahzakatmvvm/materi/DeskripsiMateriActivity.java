package com.izzatul.bismillahzakatmvvm.materi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;

public class DeskripsiMateriActivity extends AppCompatActivity {

    private TextView tvJudulMateri, tvDeskripsi;
    private int bundleMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.deskripsi_materi_activity);

        setupToolbar();

        tvJudulMateri = findViewById(R.id.tv_judul_materi);
        tvDeskripsi = findViewById(R.id.tv_deskripsi_materi);

        getIdMateri();
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.materi);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    private void getIdMateri(){
        bundleMateri = getIntent().getExtras().getInt("kategori");

        if (bundleMateri == 1){
            Toast.makeText(this, "Zakat Fitrah", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 2){
            Toast.makeText(this, "Zakat Emas", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 3){
            Toast.makeText(this, "Zakat Perak", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 5){
            Toast.makeText(this, "Zakat Perdagangan", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 5){
            Toast.makeText(this, "Zakat Pertanian", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 6){
            Toast.makeText(this, "Zakat Hewan Ternak", Toast.LENGTH_SHORT).show();
        }
    }

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
