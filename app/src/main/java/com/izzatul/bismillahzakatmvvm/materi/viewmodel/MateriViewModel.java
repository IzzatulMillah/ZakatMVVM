package com.izzatul.bismillahzakatmvvm.materi.viewmodel;

import android.databinding.ObservableField;

import java.util.Observable;

/**
 * Created by Izzatul on 1/15/2018.
 */

// TODO (4) cek referensi
public class MateriViewModel extends Observable {
    public ObservableField<String> judulZakat = new ObservableField<>();
    public ObservableField<String> deskripsiZakat = new ObservableField<>();
    public ObservableField<String> nishabZakat = new ObservableField<>();
    public ObservableField<String> waktuZakat = new ObservableField<>();
    public ObservableField<String> besarZakat = new ObservableField<>();
    public ObservableField<String> contohZakat = new ObservableField<>();

    public void getData(){

    }
}
