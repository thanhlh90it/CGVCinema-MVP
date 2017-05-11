package com.thanhlh.cinema.repository;

import com.thanhlh.cinema.repository.model.ListMoviesResponse;
import com.thanhlh.cinema.repository.model.MovieDetailResponse;

import rx.Observable;

/**
 * Created by thanhle on 4/24/17.
 */

public interface IDataSource {

    Observable<ListMoviesResponse> listMovies();
    Observable<MovieDetailResponse> getMovieDetail(String movieId);
}
