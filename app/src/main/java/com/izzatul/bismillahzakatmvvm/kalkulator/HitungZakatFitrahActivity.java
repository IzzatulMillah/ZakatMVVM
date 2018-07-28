package com.izzatul.bismillahzakatmvvm.kalkulator;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;
import com.izzatul.bismillahzakatmvvm.model.ZakatFitrah;
import com.izzatul.bismillahzakatmvvm.source.AppActivity;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.text.NumberFormat;
import java.util.Locale;

public class HitungZakatFitrahActivity extends AppActivity{

    @NotEmpty(message = "Mohon diisi dahulu")
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
        super.onClick(view);
        if (validated) {
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
                    validated = false;
                    setNull();
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

    public void setNull(){
        editHargaBeras.setText("");
        editJumlahOrang.setText("");
        textHasil.setText("");
    }
    public void hitung(){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        ZakatFitrah zakatFitrah = new ZakatFitrah();
        float kadar = zakatFitrah.getKADAR_ZAKAT_FITRAH();
        Float hargaBeras = Float.parseFloat(editHargaBeras.getText().toString());
        int jumlahOrang = Integer.parseInt(editJumlahOrang.getText().toString());
        float hasilLiter = kadar * jumlahOrang;
        float hasilRupiah = hasilLiter * hargaBeras;

        zakatFitrah.setHasilZakat("Zakat yang dibayarkan dapat berupa "
                + hasilLiter
                + " liter makanan pokok setempat, atau dapat berupa uang sejumlah "
                + formatRupiah.format(hasilRupiah));
        textHasil.setText(zakatFitrah.getHasilZakat());
    }
}
