package com.izzatul.bismillahzakatmvvm.materi;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
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
import com.izzatul.bismillahzakatmvvm.databinding.DeskripsiMateriActivityBinding;
import com.izzatul.bismillahzakatmvvm.model.Materi;

import org.json.JSONException;
import org.json.JSONObject;

public class DeskripsiMateriActivity extends AppCompatActivity {

    private TextView tvJudulMateri, tvDeskripsi, tvNishab, tvWaktu, tvBesar, tvContoh;
    private int bundleMateri;

    private static final String TAG = DeskripsiMateriActivity.class.getName();
    private String url = "http://192.168.43.20/basic/web/services/get-data/";

    Materi materi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.deskripsi_materi_activity);

        setupToolbar();

        tvJudulMateri = findViewById(R.id.tv_judul_materi);
        tvDeskripsi = findViewById(R.id.tv_deskripsi_materi);
        tvNishab = findViewById(R.id.tv_nishab_zakat);
        tvWaktu = findViewById(R.id.tv_waktu_zakat);
        tvBesar = findViewById(R.id.tv_besar_zakat);
        tvContoh = findViewById(R.id.tv_contoh_zakat);

//        DeskripsiMateriActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.deskripsi_materi_activity);

        bundleMateri = getIdMateri();
        getData(bundleMateri);

//        binding.setMateri(materi);
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.materi);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    private int getIdMateri(){
        bundleMateri = getIntent().getExtras().getInt("kategori");

        if (bundleMateri == 1){
            Toast.makeText(this, "Zakat Fitrah", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 2){
            Toast.makeText(this, "Zakat Emas", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 3){
            Toast.makeText(this, "Zakat Perak", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 5){
            Toast.makeText(this, "Zakat Perdagangan", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 5){
            Toast.makeText(this, "Zakat Pertanian", Toast.LENGTH_SHORT).show();
        } else if (bundleMateri == 6){
            Toast.makeText(this, "Zakat Hewan Ternak", Toast.LENGTH_SHORT).show();
        }

        return bundleMateri;
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

    private void getData(int idZakat){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url+idZakat , null, new Response.Listener<JSONObject>() {

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

                    tvJudulMateri.setText(judul);
                    tvDeskripsi.setText(definisi);
                    tvNishab.setText(nishab);
                    tvWaktu.setText(waktu);
                    tvBesar.setText(besar);
                    tvContoh .setText(contoh);

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
}
