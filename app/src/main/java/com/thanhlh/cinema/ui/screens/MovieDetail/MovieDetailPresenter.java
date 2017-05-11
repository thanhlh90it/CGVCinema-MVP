package com.thanhlh.cinema.ui.screens.MovieDetail;

import com.thanhlh.cinema.mvpbase.MvpRxPresenter;
import com.thanhlh.cinema.repository.DataRepository;
import com.thanhlh.cinema.repository.model.MovieDetailResponse;

import rx.functions.Action1;

/**
 * Created by thanhle on 4/25/17.
 */

public class MovieDetailPresenter  extends MvpRxPresenter<MovieDetail.View> implements MovieDetail.Presenter{
    @Override
    public void getMovieDetail(String movieId) {
        subscribe(DataRepository.getInstance().getMovieDetail(movieId), new Action1<MovieDetailResponse>() {
            @Override
            public void call(MovieDetailResponse response) {
                if(null != response.getData())
                    getView().loadSuccess(response.getData());
                else
                    getView().noDataFound();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().loadError(throwable.getMessage());
            }
        });
    }
}
