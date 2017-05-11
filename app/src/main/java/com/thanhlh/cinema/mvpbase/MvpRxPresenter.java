package com.thanhlh.cinema.mvpbase;

import com.thanhlh.cinema.utils.LogUtils;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by thanhle on 4/24/17.
 */

public class MvpRxPresenter<V extends MvpView> extends MvpPresenter<V> {
    private final CompositeSubscription mSubscriptions = new CompositeSubscription();

    /**
     * don't handle result
     * @param observable
     * @param subscriber
     * @param <T>
     * @return
     */
    protected  <T> Subscription subscribe(final Observable<T> observable, final Subscriber<T> subscriber) {
        if (observable == null) return null;
        Subscription subscription = observable.subscribe(subscriber);
        mSubscriptions.add(subscription);
        return subscription;
    }

    /**
     * handle result: success or error
     * @param observable
     * @param onNext
     * @param onError
     * @param <T>
     * @return
     */
    protected <T> Subscription subscribe(final Observable<T> observable, final Action1<T> onNext, final Action1<Throwable> onError) {
        if (observable == null) return null;
        Subscription subscription = subscribe(observable, new Subscriber<T>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (onError != null) {
                    e.printStackTrace();
                    onError.call(e);
                }
            }

            @Override
            public void onNext(T t) {
                if (onNext != null) {
                    onNext.call(t);
                }
            }
        });

        mSubscriptions.add(subscription);
        return subscription;
    }

    /**
     * handle only result: success
     * @param observable
     * @param onNext
     * @param <T>
     * @return
     */
    public <T> Subscription subscribe(final Observable<T> observable, final Action1<T> onNext) {
        if (observable == null) return null;
        Subscription subscription = subscribe(observable, onNext, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                LogUtils.RX_ANDROID.e(throwable.getMessage());
                if (getView() != null) getView().showMessage(throwable.getMessage());
            }
        });

        mSubscriptions.add(subscription);
        return subscription;
    }

    @Override
    public void detachView() {
        super.detachView();
        //unsubscribe
        if(mSubscriptions.isUnsubscribed()){
            mSubscriptions.unsubscribe();
        }
    }
}