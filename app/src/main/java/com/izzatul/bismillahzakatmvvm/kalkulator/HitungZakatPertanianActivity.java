package com.izzatul.bismillahzakatmvvm.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;

public class HitungZakatPertanianActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editJenis, editBerat;
    private TextView textHasil;
    private ImageButton resetJenis, resetBerat;
    private RadioButton rbManual, rbHujan;
    String selectedMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_pertanian);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        editJenis = findViewById(R.id.etJenis);
        editBerat = findViewById(R.id.etBerat);
        textHasil = findViewById(R.id.tvHasil);
        resetBerat = findViewById(R.id.btnResetJenis);
        resetBerat = findViewById(R.id.btnResetBerat);
        rbManual = findViewById(R.id.rbManual);
        rbHujan = findViewById(R.id.rbHujan);

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

    @Override
    public void onClick(View view) {
        // manual, zakatnya 5% ; hujan, zakatnya 10%
        if (rbManual.isChecked()){
            selectedMethod = rbManual.getText().toString();
        } else {
            selectedMethod = rbHujan.getText().toString();
        }
        Toast.makeText(this, selectedMethod, Toast.LENGTH_SHORT).show();
    }
}
