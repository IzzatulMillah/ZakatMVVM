package com.izzatul.bismillahzakatmvvm.materi;

import com.izzatul.bismillahzakatmvvm.model.Materi;
import com.izzatul.bismillahzakatmvvm.source.BaseView;

/**
 * Created by Izzatul on 5/28/2018.
 */

public interface DeskripsiMateriView extends BaseView{
    void showMateri(Materi materi);

    void showProgressDialog();

    void hideProgressDialog();

    void showToast(String message);
}
