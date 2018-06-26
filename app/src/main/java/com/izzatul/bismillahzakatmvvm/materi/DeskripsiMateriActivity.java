package com.izzatul.bismillahzakatmvvm.materi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.R;
import com.izzatul.bismillahzakatmvvm.model.Materi;
import com.izzatul.bismillahzakatmvvm.KategoriActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class DeskripsiMateriActivity extends AppCompatActivity implements DeskripsiMateriView{
    DeskripsiMateriViewModel viewModel;

    private TextView tvJudulMateri, tvDeskripsi, tvNishab, tvWaktu, tvBesar, tvContoh;
    private int bundleMateri;

    private static final String TAG = DeskripsiMateriActivity.class.getName();

    Materi materi;

    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_materi_activity);

        setupToolbar();

        getElement();
        bundleMateri = getIntent().getExtras().getInt("kategori");
//        DeskripsiMateriActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.deskripsi_materi_activity);

//        binding.setMateri(materi);

//        bundleMateri = viewModel.getIdMateri();
//        getData(bundleMateri);
        initViewModel();

        onAttachView();
    }

    private void getElement(){
        tvJudulMateri = findViewById(R.id.tv_judul_materi);
        tvDeskripsi = findViewById(R.id.tv_deskripsi_materi);
        tvNishab = findViewById(R.id.tv_nishab_zakat);
        tvWaktu = findViewById(R.id.tv_waktu_zakat);
        tvBesar = findViewById(R.id.tv_besar_zakat);
        tvContoh = findViewById(R.id.tv_contoh_zakat);
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.materi);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    @Override
    public void onAttachView() {
        progressDialog = new ProgressDialog(this);
        viewModel.onAttach(this);
    }

    private void initViewModel(){
        viewModel = new DeskripsiMateriViewModel(this.bundleMateri, this.getApplicationContext());
    }

    @Override
    public void onDetachView() {
        viewModel.onDetach();
    }

    @Override
    public void showMateri(Materi materi) {
//        untuk mengunci materi ke view
//        showToast(viewModel.materi.toString());
        tvJudulMateri.setText(viewModel.materi.getJenisZakat());
        tvDeskripsi.setText(viewModel.materi.getDeskripsiZakat());
        tvNishab.setText(viewModel.materi.getNishabZakat());
        tvWaktu.setText(viewModel.materi.getWaktuZakat());
        tvBesar.setText(viewModel.getMateri().getBesarZakat());
        tvContoh.setText(viewModel.getMateri().getContohHitungan());

//        hideProgressDialog();
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.hide();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

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
