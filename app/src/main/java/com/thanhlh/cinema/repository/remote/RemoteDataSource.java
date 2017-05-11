package com.thanhlh.cinema.repository.remote;

import com.thanhlh.cinema.repository.model.ListMoviesResponse;
import com.thanhlh.cinema.repository.model.MovieDetailResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by thanhle on 4/24/17.
 */

public class RemoteDataSource implements IRemoteDataSource {

    ApiService mService;

    public RemoteDataSource (ApiService apiService) {
        mService = apiService;
    }

    @Override
    public Observable<ListMoviesResponse> listMovies() {
        return mService.listMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<MovieDetailResponse> getMovieDetail(String movieId) {
        return mService.getMovieDetail(movieId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
