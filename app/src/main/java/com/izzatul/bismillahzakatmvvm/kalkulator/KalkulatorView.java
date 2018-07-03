package com.izzatul.bismillahzakatmvvm.kalkulator;

import com.izzatul.bismillahzakatmvvm.model.ZakatFitrah;
import com.izzatul.bismillahzakatmvvm.source.BaseView;

/**
 * Created by Izzatul on 7/3/2018.
 */

public interface KalkulatorView extends BaseView {
    void showToast(String message);
    void showHasilFitrah(ZakatFitrah zakatFitrah);
}
