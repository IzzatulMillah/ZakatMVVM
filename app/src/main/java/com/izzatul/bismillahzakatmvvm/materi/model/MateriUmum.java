package com.izzatul.bismillahzakatmvvm.materi.model;

/**
 * Created by Izzatul on 3/13/2018.
 */

public class MateriUmum {
    int id_materi;
    String judul;
    String subjudul;
    String deskripsi;

    public MateriUmum() {
    }

    public MateriUmum(int id_materi, String judul, String subjudul, String deskripsi) {
        this.id_materi = id_materi;
        this.judul = judul;
        this.subjudul = subjudul;
        this.deskripsi = deskripsi;
    }

    public int getId_materi() {
        return id_materi;
    }

    public String getJudul() {
        return judul;
    }

    public String getSubjudul() {
        return subjudul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
