package com.izzatul.bismillahzakatmvvm.latihan;

import android.app.ProgressDialog;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class DetailLatihanActivity extends AppCompatActivity implements View.OnClickListener{
    private int idLatihan;
    private int urutanSoal = 0;
    private int i = 1;

    private static final String TAG = DetailLatihanActivity.class.getName();
    private String url = "http://192.168.43.20/basic/web/services/get-latihan/";
//    192.168.43.20

    private TextView noUrutSoal, jumlahSoal, textSoal, btnNext, btnPrev;
    private RadioButton jawaban1, jawaban2, jawaban3, jawaban4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_latihan);

        setUpToolbar();

        getElements();

        ambilData();
    }

    void ambilData(){
        idLatihan = getRandomNumber();
        urutanSoal = idLatihan;
        getSoal(idLatihan);
//        getJawaban(idLatihan);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);
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
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
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

    private int getRandomNumber(){
        int num;
        int min = 1;
        int max = 10;

        num = new Random().nextInt((max - min) + 1) + min;
        return num;
    }

    private void getSoal(int idSoal){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url + idSoal, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    JSONObject data = response.getJSONObject("data");
                    String soal = data.getString("soal");
                    String jawab1 = data.getString("jawaban_1");
                    String jawab2 = data.getString("jawaban_2");
                    String jawab3 = data.getString("jawaban_3");
                    String jawab4 = data.getString("jawaban_4");
                    String jawaban_benar = data.getString("jawaban_benar");

                    textSoal.setText(soal);
                    jawaban1.setText(jawab1);
                    jawaban2.setText(jawab2);
                    jawaban3.setText(jawab3);
                    jawaban4.setText(jawab4);

                    Toast.makeText(DetailLatihanActivity.this, jawaban_benar, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_prev :
                Toast.makeText(this, "TOMBOL PREV CLICKED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_next :
                while(i >= 10){
                    idLatihan = getRandomNumber();
                    urutanSoal = idLatihan;
                    getSoal(idLatihan);

                    i++;
                }
                Toast.makeText(this, "TOMBOL NEXT CLICKED", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
