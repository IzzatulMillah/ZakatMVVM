package com.izzatul.bismillahzakatmvvm.source;

/**
 * Created by Izzatul on 1/9/2018.
 */

public interface ViewModel<T extends BaseView> {
//    private final BindingView<E> bindingView;
//    private V view;

//    public ViewModel(BindingView<E> bindingView){
//        this.bindingView = bindingView;
//    }
//
//    protected BindingView<E> getBindingView(){
//        return bindingView;
//    }
//
//    protected V getView(){
//        return view;
//    }

    void onAttach(T view);

    void onDetach();
}
