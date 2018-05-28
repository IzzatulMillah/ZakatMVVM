package com.izzatul.bismillahzakatmvvm.materi;

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
import com.izzatul.bismillahzakatmvvm.model.Materi;
import com.izzatul.bismillahzakatmvvm.source.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

/**
 * Created by Izzatul on 5/23/2018.
 */

public class DeskripsiMateriViewModel implements ViewModel<DeskripsiMateriView>{
    private DeskripsiMateriView mView;

    public Materi materi;

    private int bundleMateri;

    private String url = "http://192.168.43.20/basic/web/services/get-data/";

//    KategoriActivity kategoriActivity;

    Context mContext;

    public DeskripsiMateriViewModel(int extraBundle, Context context) {
        this.mContext = context;
        this.bundleMateri = extraBundle;
        materi = new Materi();
        getData();
        Log.d("MATERI ViewModel Cons",materi.toString());
    }

    @Override
    public void onAttach(DeskripsiMateriView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

//    private int getIdMateri(){
//        bundleMateri = getIntent().getExtras().getInt("kategori");
//        return bundleMateri;
//    }

    private void getData(){
//        mView.showProgressDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url+this.bundleMateri , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {
                    // Parsing json object response
                    // response will be a json object
                    JSONObject data = response.getJSONObject("data");
                    String judul = data.getString("jenis_zakat");
                    String definisi = data.getString("definisi");
                    String nishab = data.getString("nishab_zakat");
                    String waktu = data.getString("waktu_pelaksanaan");
                    String besar = data.getString("besar_zakat");
                    String contoh = data.getString("contoh_perhitungan");
                    materi.setJenisZakat(judul);
                    materi.setDeskripsiZakat(definisi);
                    materi.setNishabZakat(nishab);
                    materi.setWaktuZakat(waktu);
                    materi.setBesarZakat(besar);
                    materi.setContohHitungan(contoh);
                    mView.showMateri(materi);

                } catch (JSONException e) {
                    e.printStackTrace();
                    mView.showToast(e.getMessage());
                }
//                mView.hideProgressDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                mView.showToast(error.getMessage());
//                mView.hideProgressDialog();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(jsonObjReq);

    }

    public Materi getMateri(){
        return this.materi;
    }

}
