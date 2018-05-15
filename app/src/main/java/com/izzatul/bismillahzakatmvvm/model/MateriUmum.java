package com.izzatul.bismillahzakatmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Izzatul on 3/13/2018.
 */

public class MateriUmum extends BaseObservable{
    int idMateri;
    String judul;
    String subjudul;
    String deskripsi;

    public MateriUmum() {
    }

    public MateriUmum(int idMateri, String judul, String subjudul, String deskripsi) {
        this.idMateri = idMateri;
        this.judul = judul;
        this.subjudul = subjudul;
        this.deskripsi = deskripsi;
    }

    @Bindable
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSubjudul() {
        return subjudul;
    }

    public void setSubjudul(String subjudul) {
        this.subjudul = subjudul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
