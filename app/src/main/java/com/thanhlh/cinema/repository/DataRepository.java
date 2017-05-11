package com.thanhlh.cinema.repository;

import android.support.annotation.NonNull;

import com.thanhlh.cinema.commom.Constants;
import com.thanhlh.cinema.repository.model.ListMoviesResponse;
import com.thanhlh.cinema.repository.model.MovieDetailResponse;
import com.thanhlh.cinema.repository.remote.ApiService;
import com.thanhlh.cinema.repository.remote.IRemoteDataSource;
import com.thanhlh.cinema.repository.remote.RemoteDataSource;
import com.thanhlh.cinema.repository.remote.ServiceFactory;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by thanhle on 4/24/17.
 */

public class DataRepository implements IDataSource {
    private static final String TAG = DataRepository.class.getSimpleName();
    private final IRemoteDataSource mRemoteDataSource;
    static public IDataSource instance;

    public DataRepository(@NonNull IRemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    static public IDataSource getInstance() {
        if (instance == null) {
            instance = new DataRepository(new RemoteDataSource(ServiceFactory.createServiceFrom(ApiService.class, Constants.REMOTE_SERVICE_URL)));
        }
        return instance;
    }

    @Override
    public Observable<ListMoviesResponse> listMovies() {
        Observable<ListMoviesResponse> remote = mRemoteDataSource.listMovies()
                .doOnNext(new Action1<ListMoviesResponse>() {
                    @Override
                    public void call(ListMoviesResponse response) {
                        //save local cache if we need.
                    }
                });
        return remote;
    }

    @Override
    public Observable<MovieDetailResponse> getMovieDetail(String movieId) {
        Observable<MovieDetailResponse> remote = mRemoteDataSource.getMovieDetail(movieId)
                .doOnNext(new Action1<MovieDetailResponse>() {
                    @Override
                    public void call(MovieDetailResponse response) {
                        //save local cache if we need.
                    }
                });
        return remote;
    }
}
