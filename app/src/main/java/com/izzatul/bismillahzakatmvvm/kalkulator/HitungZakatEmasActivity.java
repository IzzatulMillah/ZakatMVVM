package com.izzatul.bismillahzakatmvvm.kalkulator;

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

public class HitungZakatEmasActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editLamaKepemilikan, editJumlahTotal, editJumlahDipakai, editHargaEmas;
    ImageButton btResetKepemilikan, btResetJumlahTotal, btResetJumlahDipakai, btResetHarga;
    TextView bHitung, bUlang, textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_emas);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        editLamaKepemilikan = findViewById(R.id.etLamaKepemilikan);
        editJumlahTotal = findViewById(R.id.etTotalEmas);
        editJumlahDipakai = findViewById(R.id.etTotalDipakai);
        editHargaEmas = findViewById(R.id.etHargaEmas);

        btResetKepemilikan = findViewById(R.id.btnResetLamaKepemilikan);
        btResetJumlahTotal = findViewById(R.id.btnResetTotalEmas);
        btResetJumlahDipakai = findViewById(R.id.btnResetTotalDipakai);
        btResetHarga = findViewById(R.id.btnHargaEmas);

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

    // Perhitungan Zakat emas https://www.rumahzakat.org/zakat/zakat-emas-dan-perak/ atau http://www.sami-an.com/islam-dan-dakwah/perhitungan-zakat-emas.html
    @Override
    public void onClick(View view) {
        float NISAB_EMAS = 85; // nisab emas
        int HAUL_EMAS = 1; // haul emas
        double PERSEN_ZAKAT = 0.025;

        int lama = Integer.parseInt(editLamaKepemilikan.getText().toString());
        float jumlahEmas = Float.parseFloat(editJumlahTotal.getText().toString());
        float jumlahDipakai = Float.parseFloat(editJumlahDipakai.getText().toString());
        float hargaEmas = Float.parseFloat(editHargaEmas.getText().toString());

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        switch (view.getId()){
            case R.id.btnResetLamaKepemilikan :
                editLamaKepemilikan.setText("");
                break;
            case R.id.btnResetTotalEmas :
                editJumlahTotal.setText("");
                break;
            case R.id.btnResetTotalDipakai :
                editJumlahDipakai.setText("");
                break;
            case R.id.btnHargaEmas :
                editHargaEmas.setText("");
                break;
            case R.id.btnHitung :
                if (jumlahEmas >= NISAB_EMAS && lama >= HAUL_EMAS){
                    double hitung = PERSEN_ZAKAT * (jumlahEmas - jumlahDipakai);
                    double rupiah = hitung * hargaEmas;
                    textHasil.setText("Harta yang dizakatkan sejumlah " + formatRupiah.format(rupiah));
                }
                else
                    textHasil.setText("Anda tidak wajib membayar zakat karena harta yang dimiliki belum mencapai nisab dan haul");
                break;
            case R.id.btnUlangi :
                editLamaKepemilikan.setText("");
                editJumlahTotal.setText("");
                editJumlahDipakai.setText("");
                editHargaEmas.setText("");
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
