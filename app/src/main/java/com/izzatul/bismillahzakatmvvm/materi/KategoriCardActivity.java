package com.izzatul.bismillahzakatmvvm.materi;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.izzatul.bismillahzakatmvvm.R;

public class KategoriCardActivity extends Activity {

    TextView namaZakat;
    TextView detailZakat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_card);

        namaZakat = findViewById(R.id.nama_zakat);
        detailZakat = findViewById(R.id.detail);

        namaZakat.setText("Zakat Fitrah");
        detailZakat.setText("read more..");
    }
}
