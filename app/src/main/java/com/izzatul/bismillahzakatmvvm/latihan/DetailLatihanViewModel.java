package com.izzatul.bismillahzakatmvvm.latihan;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.izzatul.bismillahzakatmvvm.model.Pertanyaan;
import com.izzatul.bismillahzakatmvvm.source.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by Izzatul on 3/20/2018.
 */

public class DetailLatihanViewModel implements ViewModel<DetailLatihanView> {
    private DetailLatihanView detailLatihanView;
    public Pertanyaan pertanyaan;
    private int IdSoal;
    private String url = "http://millah.cyber1011.com/web/services/get-latihan/";
    Context mContext;
    private String jawabanBenar;

    public DetailLatihanViewModel(Context mContext) {
        this.mContext = mContext;
        this.IdSoal = getRandomNumber();
        pertanyaan = new Pertanyaan();
        getData();
        Log.d("Pengambilan Data Soal", pertanyaan.toString());
    }

    @Override
    public void onAttach(DetailLatihanView view) {
        detailLatihanView = view;
    }

    @Override
    public void onDetach() {
        detailLatihanView = null;
    }

    private int getRandomNumber(){
        int num;
        int min = 1;
        int max = 10;

        num = new Random().nextInt((max - min) + 1) + min;
        return num;
    }

    private void getData(){
//        detailLatihanView.showProgressDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url + this.IdSoal, null, new Response.Listener<JSONObject>() {

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

                    pertanyaan.setSoal(soal);
                    pertanyaan.setJawaban1(jawab1);
                    pertanyaan.setJawaban2(jawab2);
                    pertanyaan.setJawaban3(jawab3);
                    pertanyaan.setJawaban4(jawab4);
                    detailLatihanView.showLatihan(pertanyaan);

                    jawabanBenar = jawaban_benar;
//                    Toast.makeText(LatihanActivity.this, jawaban_benar, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    detailLatihanView.showToast(e.getMessage());
                }
                detailLatihanView.hideProgressDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                detailLatihanView.showToast(error.getMessage());
                detailLatihanView.hideProgressDialog();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(jsonObjReq);
    }

}
