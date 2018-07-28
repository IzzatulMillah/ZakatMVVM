package com.izzatul.bismillahzakatmvvm.kalkulator;

import android.content.Context;

import com.izzatul.bismillahzakatmvvm.source.ViewModel;

/**
 * Created by Izzatul on 7/27/2018.
 */

public class ZakatViewModel implements ViewModel<ZakatView>{
    Context mContext;

    public ZakatViewModel(Context context){
        this.mContext = context;
    }

    @Override
    public void onAttach(ZakatView view) {

    }

    @Override
    public void onDetach() {

    }
}
