package com.izzatul.bismillahzakatmvvm.kalkulator;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.izzatul.bismillahzakatmvvm.R;

public class HitungZakatHewanTernakActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton rbUnta, rbSapiKerbau, rbKambing;
    private TextInputEditText jumlahHewan;
    ImageButton resetJumlah;
    private TextView tvHitung, tvUlang, tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_hewan_ternak);

        rbUnta = findViewById(R.id.rb_unta);
        rbSapiKerbau = findViewById(R.id.rb_sapi_kerbau);
        rbKambing = findViewById(R.id.rb_kambing);

        jumlahHewan = findViewById(R.id.jumlah_hewan);
        tvHitung = findViewById(R.id.btn_hitung);
        tvUlang = findViewById(R.id.btn_ulang);
        tvHasil = findViewById(R.id.hasil_hitung);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_hitung :
                if (rbUnta.isChecked()){
                    // TODO (1) perhitungan zakat unta
                } else if (rbSapiKerbau.isChecked()){
                    // TODO (2) perhitungan zakat sapi atau kerbau
                } else {
                    // TODO (3) perhitungan zakat kambing. cek ppt
                }
                break;
            case R.id.reset_jumlah_hewan :
                jumlahHewan.setText("");
                break;
            case R.id.btn_ulang :
                jumlahHewan.setText("");
                tvHasil.setText("");
                break;
        }
    }
}
