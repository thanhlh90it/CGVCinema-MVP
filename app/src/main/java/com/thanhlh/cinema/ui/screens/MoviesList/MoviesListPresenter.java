package com.thanhlh.cinema.ui.screens.MoviesList;

import com.thanhlh.cinema.mvpbase.MvpRxPresenter;
import com.thanhlh.cinema.repository.DataRepository;
import com.thanhlh.cinema.repository.model.ListMoviesResponse;

import rx.functions.Action1;

/**
 * Created by thanhle on 4/25/17.
 */

public class MoviesListPresenter extends MvpRxPresenter<MoviesList.View> implements MoviesList.Presenter{
    @Override
    public void getListMovies() {
        subscribe(DataRepository.getInstance().listMovies(), new Action1<ListMoviesResponse>() {
            @Override
            public void call(ListMoviesResponse response) {
                if(!response.getData().isEmpty())
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
