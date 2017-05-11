package com.thanhlh.cinema.mvpbase;

/**
 * Created by thanhle on 4/24/17.
 */

public interface MvpViewActivity extends MvpView {

    int getMainLayout();

    void setRootView();

    void initToolbar();

    void bindEventHandlers();

    void initComponents();
}
