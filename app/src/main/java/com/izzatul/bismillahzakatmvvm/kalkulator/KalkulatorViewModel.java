package com.izzatul.bismillahzakatmvvm.kalkulator;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.izzatul.bismillahzakatmvvm.model.ZakatFitrah;
import com.izzatul.bismillahzakatmvvm.source.ViewModel;

/**
 * Created by Izzatul on 7/3/2018.
 */

public class KalkulatorViewModel implements ViewModel<KalkulatorView>{
    private KalkulatorView kView;
    public ZakatFitrah zakatFitrah;

    public KalkulatorViewModel() {
        hitungZakatFitrah();
    }

    @Override
    public void onAttach(KalkulatorView view) {
        kView = view;
    }

    @Override
    public void onDetach() {
        kView = null;
    }

    public void hitungZakatFitrah(){
        Log.d("Fungsi Z. Fitrah ", "Jalan");
        ZakatFitrah zakatFitrah = new ZakatFitrah();
        float kadar = zakatFitrah.getKADAR_ZAKAT_FITRAH();
        Float hargaBeras = zakatFitrah.getHargaBeras();
        int jumlahOrang = zakatFitrah.getJumlahOrang();
        float hasilLiter = kadar * jumlahOrang;
        float hasilRupiah = hasilLiter * hargaBeras;

        zakatFitrah.setHasilZakat("Zakat yang dibayarkan dapat berupa " + hasilLiter + " liter makanan pokok setempat, atau dapat berupa uang sejumlah Rp. " + hasilRupiah);
        kView.showHasilFitrah(zakatFitrah);
    }

    public ZakatFitrah getZakatFitrah(){
        return this.zakatFitrah;
    }

}
