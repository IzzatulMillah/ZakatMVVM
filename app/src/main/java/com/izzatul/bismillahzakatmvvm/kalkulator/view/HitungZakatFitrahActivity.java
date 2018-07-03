package com.izzatul.bismillahzakatmvvm.kalkulator.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;
import com.izzatul.bismillahzakatmvvm.kalkulator.KalkulatorView;
import com.izzatul.bismillahzakatmvvm.kalkulator.KalkulatorViewModel;
import com.izzatul.bismillahzakatmvvm.materi.DeskripsiMateriView;
import com.izzatul.bismillahzakatmvvm.model.ZakatFitrah;

public class HitungZakatFitrahActivity extends AppCompatActivity implements View.OnClickListener, KalkulatorView{

    KalkulatorViewModel kalkulatorViewModel;
    EditText editHargaBeras, editJumlahOrang;
    ImageButton btResetHrgBeras, btResetJumlahOrang;
    TextView bHitung, bUlang, textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_fitrah);

        setToolbar();
        getView();
    }

    public void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    public void getView(){
        editHargaBeras = findViewById(R.id.etHargaBeras);
        editJumlahOrang = findViewById(R.id.etJumlahOrang);
        btResetHrgBeras = findViewById(R.id.btnResetBeras);
        btResetJumlahOrang = findViewById(R.id.btnResetJumlahOrang);
        bHitung = findViewById(R.id.btnHitung);
        bUlang = findViewById(R.id.btnUlangi);
        textHasil = findViewById(R.id.tvHasil);

        btResetHrgBeras.setOnClickListener(this);
        btResetJumlahOrang.setOnClickListener(this);
        bHitung.setOnClickListener(this);
        bUlang.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnResetBeras :
                editHargaBeras.setText("");
                break;
            case R.id.btnResetJumlahOrang :
                editJumlahOrang.setText("");
                break;
            case R.id.btnHitung :
                hitung();
                break;
            case R.id.btnUlangi :
                setNull();
                break;
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

    public void setNull(){
        editHargaBeras.setText("");
        editJumlahOrang.setText("");
        textHasil.setText("");
    }
    public void hitung(){
        Log.d("Fungsi hitung ", "Activity");
        kalkulatorViewModel = new KalkulatorViewModel();
        kalkulatorViewModel.hitungZakatFitrah();
    }
    @Override
    public void onAttachView() {

    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showHasilFitrah(ZakatFitrah zakatFitrah) {
        textHasil.setText(kalkulatorViewModel.getZakatFitrah().getHasilZakat());
    }
}
