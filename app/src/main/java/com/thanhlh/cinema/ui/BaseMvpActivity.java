package com.thanhlh.cinema.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.thanhlh.cinema.commom.MyApplication;
import com.thanhlh.cinema.mvpbase.MvpViewActivity;

import butterknife.ButterKnife;

/**
 * Created by thanhle on 4/25/17.
 */

public abstract class BaseMvpActivity extends AppCompatActivity implements MvpViewActivity {
    protected View mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getMainLayout());
        ButterKnife.bind(this);
        initToolbar();
        bindEventHandlers();
        initComponents();
        initComponents();
        if (getPresenter() != null) {
            getPresenter().attachView(this);
        }

    }

    @Override
    protected void onDestroy() {
        if (getPresenter() != null) {
            getPresenter().detachView();
        }

        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    /**
     * Implement MvpView interface
     */


    @Override
    public void hideProgress() {
    }


    @Override
    public void showProgress() {
    }

    @Override
    public void showMessage(String message) {
        showSimpleSnack(message);
    }

    public MyApplication getApp() {
        return (MyApplication) getApplication();
    }

    public void showSimpleSnack(final String message) {
        if (mRootView == null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return;
        }
        Snackbar snackbar = Snackbar.make(mRootView, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void hideKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
