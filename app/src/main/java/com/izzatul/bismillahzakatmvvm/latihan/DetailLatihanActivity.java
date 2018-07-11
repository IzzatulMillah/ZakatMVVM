package com.izzatul.bismillahzakatmvvm.latihan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.izzatul.bismillahzakatmvvm.R;
import com.izzatul.bismillahzakatmvvm.model.Pertanyaan;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class DetailLatihanActivity extends AppCompatActivity implements View.OnClickListener, DetailLatihanView{
    private int i = 1;
    private int skor;
    private String jawabanBenar, pembahasanSoal;

    DetailLatihanViewModel viewModel;
    private static final String TAG = DetailLatihanActivity.class.getName();

    private TextView noUrutSoal, textSoal, btnNext, textSkor, btnCekJwbn, textPembahasan;
    private RadioButton jawaban1, jawaban2, jawaban3, jawaban4;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_latihan);

        setUpToolbar();
        getElements();
        initViewModel();
        onAttachView();

        btnCekJwbn.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    private void initViewModel(){
        viewModel = new DetailLatihanViewModel(this.getApplicationContext());
    }

    void setUpToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.latihan);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    void getElements(){
        noUrutSoal = findViewById(R.id.tv_urutan_soal);
        textSoal = findViewById(R.id.tv_soal);
        jawaban1 = findViewById(R.id.jawaban1);
        jawaban2 = findViewById(R.id.jawaban2);
        jawaban3 = findViewById(R.id.jawaban3);
        jawaban4 = findViewById(R.id.jawaban4);
        btnNext = findViewById(R.id.btn_next);
        btnCekJwbn = findViewById(R.id.btn_cek_jawaban);
        textPembahasan = findViewById(R.id.tv_pembahasan);
        textSkor = findViewById(R.id.tv_skor);
        btnNext.setVisibility(View.GONE);
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
        switch (view.getId()){
            case R.id.btn_cek_jawaban :
                cekJawaban();
                fungsiCek();
                break;
            case R.id.btn_next :
                viewModel.getKuis();
                fungsiNext();
                break;
        }
    }

    @Override
    public void onAttachView() {
        progressDialog = new ProgressDialog(this);
        viewModel.onAttach(this);
    }

    @Override
    public void onDetachView() {
    viewModel.onDetach();
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
    public void showLatihan(Pertanyaan pertanyaan) {
        textSoal.setText(viewModel.pertanyaan.getSoal());
        jawaban1.setText(viewModel.pertanyaan.getJawaban1());
        jawaban2.setText(viewModel.pertanyaan.getJawaban2());
        jawaban3.setText(viewModel.pertanyaan.getJawaban3());
        jawaban4.setText(viewModel.pertanyaan.getJawaban4());
    }

    public void showLatihan(){
        noUrutSoal.setText(String.valueOf(i));
    }

    public void cekJawaban(){
        jawabanBenar = viewModel.getJawabanBenar();
        if (jawaban1.isChecked()){
            if (jawaban1.getText().toString().equals(jawabanBenar)){
                skor = skor + 10;
                textSkor.setText(""+skor);
                jawaban1.setTextColor(getResources().getColor(R.color.trueColor));
//                showToast("Jawaban Benar");
            }
            else {
                textSkor.setText(""+skor);
                jawaban1.setTextColor(getResources().getColor(R.color.wrongColor));
//                showToast("Jawaban Salah");
            }
        }
        else if (jawaban2.isChecked()){
            if (jawaban2.getText().toString().equals(jawabanBenar)){
                skor = skor + 10;
                textSkor.setText(""+skor);
                jawaban2.setTextColor(getResources().getColor(R.color.trueColor));
//                showToast("Jawaban Benar");c
            }
            else {
                textSkor.setText(""+skor);
                jawaban2.setTextColor(getResources().getColor(R.color.wrongColor));
//                showToast("Jawaban Salah");
            }
        }
        else if (jawaban3.isChecked()){
            if (jawaban3.getText().toString().equals(jawabanBenar)){
                skor = skor + 10;
                textSkor.setText(""+skor);
                jawaban3.setTextColor(getResources().getColor(R.color.trueColor));
//                showToast("Jawaban Benar");
            }
            else {
                textSkor.setText(""+skor);
                jawaban3.setTextColor(getResources().getColor(R.color.wrongColor));
//                showToast("Jawaban Salah");
            }
        }
        else if (jawaban4.isChecked()){
            if (jawaban4.getText().toString().equals(jawabanBenar)){
                skor = skor + 10;
                textSkor.setText(""+skor);
                jawaban4.setTextColor(getResources().getColor(R.color.trueColor));
//                showToast("Jawaban Benar");
            }
            else {
                textSkor.setText(""+skor);
                jawaban4.setTextColor(getResources().getColor(R.color.wrongColor));
//                showToast("Jawaban Salah");
            }
        }
    }

    public void fungsiCek(){
        btnNext.setVisibility(View.VISIBLE);
        btnCekJwbn.setVisibility(View.GONE);
        pembahasanSoal = viewModel.getPembahasan();
        textPembahasan.setText(pembahasanSoal);
    }

    public void fungsiNext(){
        i++;
        showLatihan();
        if (i > 10){
            Intent intent = new Intent(DetailLatihanActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("skorAkhir", skor);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        btnCekJwbn.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.GONE);

        textPembahasan.setText("");
        jawaban1.setTextColor(getResources().getColor(R.color.colorBlack));
        jawaban2.setTextColor(getResources().getColor(R.color.colorBlack));
        jawaban3.setTextColor(getResources().getColor(R.color.colorBlack));
        jawaban4.setTextColor(getResources().getColor(R.color.colorBlack));
    }
}
