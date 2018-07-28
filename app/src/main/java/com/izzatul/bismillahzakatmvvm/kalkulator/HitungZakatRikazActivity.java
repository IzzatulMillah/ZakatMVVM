package com.izzatul.bismillahzakatmvvm.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.izzatul.bismillahzakatmvvm.R;

import java.text.NumberFormat;
import java.util.Locale;

public class HitungZakatRikazActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText hargaJual, hargaEmas;
    public TextView textHasil, buttonHitung, buttonUlang;

    public double hargaRupiahEmas, zakatYangDibayar;

    // membuat format untuk menampilkan harga dalam rupiah
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_rikaz);

        getTheView();
    }

    public void getTheView(){
        hargaJual = findViewById(R.id.harga_jual);
        hargaEmas = findViewById(R.id.harga_emas);
        textHasil = findViewById(R.id.hasil_hitung);
        buttonHitung = findViewById(R.id.btn_hitung);
        buttonUlang = findViewById(R.id.btn_ulang);

        buttonHitung.setOnClickListener(this);
        buttonUlang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hitung :
                hitungZakat();
                break;
            case R.id.btn_ulang :
                setNull();
                break;
        }
    }

    private void hitungZakat() {
        int hargaJualBarang = Integer.parseInt(hargaJual.getText().toString());
        int hargaEmasGram = Integer.parseInt(hargaEmas.getText().toString());

//      nishab zakat rikaz
        final float NISAB_RIKAZ = 85;
        final double BESAR_ZAKAT = 0.2;

        hargaRupiahEmas = hargaEmasGram * NISAB_RIKAZ;

        if (hargaJualBarang >= hargaRupiahEmas) {
            zakatYangDibayar = hargaJualBarang * BESAR_ZAKAT;
            textHasil.setText("Zakat yang dibayarkan adalah " + formatRupiah.format(zakatYangDibayar));
        } else {
            textHasil.setText(R.string.tidak_wajib_zakat);
        }
    }

    private void setNull(){
        hargaJual.setText("");
        hargaEmas.setText("");
        textHasil.setText("");
    }


}
