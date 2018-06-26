package com.izzatul.bismillahzakatmvvm.latihan;

import com.izzatul.bismillahzakatmvvm.model.Pertanyaan;
import com.izzatul.bismillahzakatmvvm.source.BaseView;

/**
 * Created by Izzatul on 6/10/2018.
 */

public interface DetailLatihanView extends BaseView{
    void showProgressDialog();

    void hideProgressDialog();

    void showToast(String message);

    void showLatihan(Pertanyaan pertanyaan);
}
