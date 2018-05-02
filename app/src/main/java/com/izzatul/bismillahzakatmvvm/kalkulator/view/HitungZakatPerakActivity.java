package com.izzatul.bismillahzakatmvvm.kalkulator.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;

import java.text.NumberFormat;
import java.util.Locale;

public class HitungZakatPerakActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editLamaKepemilikan, editJumlahTotal, editJumlahDipakai, editHargaPerak;
    ImageButton btResetKepemilikan, btResetJumlahTotal, btResetJumlahDipakai, btResetHarga;
    TextView bHitung, bUlang, textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_perak);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        editLamaKepemilikan = findViewById(R.id.etLamaKepemilikan);
        editJumlahTotal = findViewById(R.id.etTotalPerak);
        editJumlahDipakai = findViewById(R.id.etTotalDipakai);
        editHargaPerak = findViewById(R.id.etHargaPerak);

        btResetKepemilikan = findViewById(R.id.btnResetLamaKepemilikan);
        btResetJumlahTotal = findViewById(R.id.btnResetTotalPerak);
        btResetJumlahDipakai = findViewById(R.id.btnResetTotalDipakai);
        btResetHarga = findViewById(R.id.btnHargaPerak);

        bHitung = findViewById(R.id.btnHitung);
        bUlang = findViewById(R.id.btnUlangi);
        textHasil = findViewById(R.id.tvHasil);

        btResetKepemilikan.setOnClickListener(this);
        btResetJumlahTotal.setOnClickListener(this);
        btResetJumlahDipakai.setOnClickListener(this);
        btResetHarga.setOnClickListener(this);
        bHitung.setOnClickListener(this);
        bUlang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float NISAB_Perak = 595; // nisab Perak
        int HAUL_Perak = 1; // haul Perak
        double PERSEN_ZAKAT = 0.025;

        int lama = Integer.parseInt(editLamaKepemilikan.getText().toString());
        float jumlahPerak = Float.parseFloat(editJumlahTotal.getText().toString());
        float jumlahDipakai = Float.parseFloat(editJumlahDipakai.getText().toString());
        float hargaPerak = Float.parseFloat(editHargaPerak.getText().toString());

        // membuat format untuk menampilkan harga dalam rupiah
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        switch (view.getId()){
            case R.id.btnResetLamaKepemilikan :
                editLamaKepemilikan.setText("");
                break;
            case R.id.btnResetTotalPerak :
                editJumlahTotal.setText("");
                break;
            case R.id.btnResetTotalDipakai :
                editJumlahDipakai.setText("");
                break;
            case R.id.btnHargaPerak :
                editHargaPerak.setText("");
                break;
            case R.id.btnHitung :
                if (jumlahPerak >= NISAB_Perak && lama >= HAUL_Perak){
                    double hitung = PERSEN_ZAKAT * (jumlahPerak - jumlahDipakai);
                    double rupiah = hitung * hargaPerak;
                    textHasil.setText("Harta yang dizakatkan sejumlah " + formatRupiah.format(rupiah));
                }
                else
                    textHasil.setText("Anda tidak wajib membayar zakat karena harta yang dimiliki belum mencapai nisab dan haul");
                break;
            case R.id.btnUlangi :
                editLamaKepemilikan.setText("");
                editJumlahTotal.setText("");
                editJumlahDipakai.setText("");
                editHargaPerak.setText("");
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
}
