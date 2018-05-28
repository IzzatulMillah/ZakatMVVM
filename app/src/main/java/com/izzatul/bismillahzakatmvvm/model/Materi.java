package com.izzatul.bismillahzakatmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Izzatul on 12/19/2017.
 */

public class Materi extends BaseObservable{
    private int id;
    private String jenisZakat;
    private String deskripsiZakat;
    private String nishabZakat;
    private String waktuZakat;
    private String besarZakat;
    private String contohHitungan;

    public Materi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getJenisZakat() {
        return jenisZakat;
    }

    public void setJenisZakat(String jenisZakat) {
        this.jenisZakat = jenisZakat;
    }

    @Bindable
    public String getDeskripsiZakat() {
        return deskripsiZakat;
    }

    public void setDeskripsiZakat(String deskripsiZakat) {
        this.deskripsiZakat = deskripsiZakat;
    }

    @Bindable
    public String getNishabZakat() {
        return nishabZakat;
    }

    public void setNishabZakat(String nishabZakat) {
        this.nishabZakat = nishabZakat;
    }

    @Bindable
    public String getWaktuZakat() {
        return waktuZakat;
    }

    public void setWaktuZakat(String waktuZakat) {
        this.waktuZakat = waktuZakat;
    }

    @Bindable
    public String getContohHitungan() {
        return contohHitungan;
    }

    public void setContohHitungan(String contohHitungan) {
        this.contohHitungan = contohHitungan;
    }

    @Bindable
    public String getBesarZakat() {
        return besarZakat;
    }

    public void setBesarZakat(String besarZakat) {
        this.besarZakat = besarZakat;
    }

    @Override
    public String toString() {
        return "Materi{" +
                "id=" + id +
                ", jenisZakat='" + jenisZakat + '\'' +
                ", deskripsiZakat='" + deskripsiZakat + '\'' +
                ", nishabZakat='" + nishabZakat + '\'' +
                ", waktuZakat='" + waktuZakat + '\'' +
                ", besarZakat='" + besarZakat + '\'' +
                ", contohHitungan='" + contohHitungan + '\'' +
                '}';
    }
}
