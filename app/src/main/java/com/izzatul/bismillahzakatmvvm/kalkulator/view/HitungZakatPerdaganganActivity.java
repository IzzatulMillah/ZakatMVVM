package com.izzatul.bismillahzakatmvvm.kalkulator.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;
import com.izzatul.bismillahzakatmvvm.source.AppActivity;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.text.NumberFormat;
import java.util.Locale;

public class HitungZakatPerdaganganActivity extends AppActivity{

    @NotEmpty(message = "Mohon diisi dahulu")
    EditText editModal, editHaul, editEmas;
    TextView bHitung, bUlang, textHasil;
    ImageButton btResetModal, btResetHaul, btResetEmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_perdagangan);

        setToolbar();
        getView();
    }
    public void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    }
    public void getView(){
        editHaul = findViewById(R.id.etHaul);
        editEmas = findViewById(R.id.etHargaEmas);
        editModal = findViewById(R.id.etModal);

        bHitung = findViewById(R.id.btnHitung);
        bUlang = findViewById(R.id.btnUlangi);
        textHasil = findViewById(R.id.tvHasil);

        btResetHaul = findViewById(R.id.btnResetHaul);
        btResetEmas = findViewById(R.id.btnResetHargaEmas);
        btResetModal = findViewById(R.id.btnResetModal);

        btResetHaul.setOnClickListener(this);
        btResetEmas.setOnClickListener(this);
        btResetModal.setOnClickListener(this);
        bHitung.setOnClickListener(this);
        bUlang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (validated) {
            switch (view.getId()){
                case R.id.btnResetHaul:
                    editHaul.setText("");
                    break;
                case R.id.btnResetModal :
                    editModal.setText("");
                    break;
                case R.id.btnResetHargaEmas :
                    editModal.setText("");
                    break;
                case R.id.btnHitung :
                    hitungZakat();
                    break;
                case R.id.btnUlangi:
                    validated = false;
                    setNull();
                    break;
            }
        }
    }

    public void setNull(){
        editHaul.setText("");
        editModal.setText("");
        editEmas.setText("");
    }

    public void hitungZakat() {
        // membuat format untuk menampilkan harga dalam rupiah
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        final float NISAB_DAGANG = 85; // nisab perdagangan sama dengan emas, yaitu 85 gram
        final int HAUL = 1; // haul harta dagang juga sama dengan emas
        final double PERSEN_ZAKAT = 0.025;

        float kepemilikan = Float.parseFloat(editHaul.getText().toString());
        int hargaEmas = Integer.parseInt(editEmas.getText().toString());
        int modal = Integer.parseInt(editModal.getText().toString());
        double nisab = modal / hargaEmas;

        if (kepemilikan >= HAUL & nisab >= NISAB_DAGANG) {
            double zakat = modal * PERSEN_ZAKAT;
            textHasil.setText("Harta yang dizakatkan sejumlah " + formatRupiah.format(zakat));
        }
        else
            textHasil.setText(R.string.tidak_wajib_zakat);
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
