package com.thanhlh.cinema.mvpbase;

/**
 * Created by thanhle on 4/24/17.
 */

public class MvpPresenter<V extends MvpView> {

    protected V mView;

    public void attachView(V view) {
        mView = view;
        onCreate();
    }

    public void detachView() {
        onViewDetached();
        mView = null;
    }

    public V getView() {
        return mView;
    }

    /**
     * Call when view call onCreate()
     */
    public void onCreate() {

    }
    /**
     * Call when view is pause
     */
    public void onPause() {

    }

    /**
     * Call when view resume
     */
    public void onResume() {

    }

    /**
     * Call when view stop
     */
    public void onStop() {

    }

    /**
     * Calll when view detach
     */
    public void onViewDetached() {}
}
