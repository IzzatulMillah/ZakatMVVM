package com.izzatul.bismillahzakatmvvm.materi;

/**
 * Created by Izzatul on 12/19/2017.
 */

class Materi {
    int id;
    String judul_materi;
    String deskripsi_materi;
    String nishab;
    String waktu;
    String zakat;

    public Materi(int id, String judul_materi, String deskripsi_materi, String nishab, String waktu, String zakat) {
        this.id = id;
        this.judul_materi = judul_materi;
        this.deskripsi_materi = deskripsi_materi;
        this.nishab = nishab;
        this.waktu = waktu;
        this.zakat = zakat;
    }
}
