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

public class HitungZakatFitrahActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editHargaBeras, editJumlahOrang;
    ImageButton btResetHrgBeras, btResetJumlahOrang;
    TextView bHitung, bUlang, textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_fitrah);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

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
                // TODO cari tahu format titik untuk inputan edittext. cek textwatcher. but yet still confusing
                if (editHargaBeras.getText().toString().equals("") || editJumlahOrang.getText().toString().equals("")){
                    Toast.makeText(this, "Isi kolom terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
                else{
                    final float KADAR_ZAKAT_FITRAH = (float) 3.5;
                    Float hargaBeras = Float.parseFloat(editHargaBeras.getText().toString());
                    int jumlahOrang = Integer.parseInt(editJumlahOrang.getText().toString());
                    float hasilLiter = KADAR_ZAKAT_FITRAH * jumlahOrang;
                    float hasilRupiah = hasilLiter * hargaBeras;
                    textHasil.setText("Zakat yang dibayarkan dapat berupa " + hasilLiter + " liter makanan pokok setempat, atau dapat berupa uang sejumlah Rp. " + hasilRupiah);
                }
                break;
            case R.id.btnUlangi :
                editHargaBeras.setText("");
                editJumlahOrang.setText("");
                textHasil.setText("");
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
