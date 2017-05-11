package com.thanhlh.cinema.mvpbase;

/**
 * Created by thanhle on 4/24/17.
 */

public interface MvpView {

    MvpPresenter getPresenter();

    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
