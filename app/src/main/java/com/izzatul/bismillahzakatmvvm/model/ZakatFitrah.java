package com.izzatul.bismillahzakatmvvm.model;

/**
 * Created by Izzatul on 7/3/2018.
 */

public class ZakatFitrah {
    private float hargaBeras;
    private int jumlahOrang;
    private String hasilZakat;

    final float KADAR_ZAKAT_FITRAH = (float) 3.5;

    public float getKADAR_ZAKAT_FITRAH() {
        return KADAR_ZAKAT_FITRAH;
    }

    public ZakatFitrah() {
    }

    public float getHargaBeras() {
        return hargaBeras;
    }

    public void setHargaBeras(int hargaBeras) {
        this.hargaBeras = hargaBeras;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public String getHasilZakat() {
        return hasilZakat;
    }

    public void setHasilZakat(String hasilZakat) {
        this.hasilZakat = hasilZakat;
    }
}
