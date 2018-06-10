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

import static android.content.ContentValues.TAG;

/**
 * Created by Izzatul on 3/20/2018.
 */

public class DetailLatihanViewModel implements ViewModel<DetailLatihanView> {
    private DetailLatihanView detailLatihanView;
    public Pertanyaan pertanyaan;
    private int bundleMateri;
    private String url = "http://192.168.43.20/basic/web/services/get-data/";
    Context mContext;
    private String jawabanBenar;

    public DetailLatihanViewModel(int extraBundle, Context mContext) {
        this.mContext = mContext;
        this.bundleMateri = extraBundle;
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

    private void getData(){
        detailLatihanView.showProgressDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url + this.bundleMateri, null, new Response.Listener<JSONObject>() {

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
