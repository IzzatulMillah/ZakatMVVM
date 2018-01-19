package com.izzatul.bismillahzakatmvvm.materi.model;

/**
 * Created by Izzatul on 12/19/2017.
 */

public class Materi {
    int id;
    String judul_materi;
    String deskripsi_materi;
    String nishab;
    String haul;
    String zakat;

    public Materi(int id, String judul_materi, String deskripsi_materi, String nishab, String haul, String zakat) {
        this.id = id;
        this.judul_materi = judul_materi;
        this.deskripsi_materi = deskripsi_materi;
        this.nishab = nishab;
        this.haul = haul;
        this.zakat = zakat;
    }
}
