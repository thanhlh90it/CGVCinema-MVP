package com.thanhlh.cinema.repository.remote;

import com.thanhlh.cinema.repository.model.ListMoviesResponse;
import com.thanhlh.cinema.repository.model.MovieDetailResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by thanhle on 4/24/17.
 */

public interface ApiService {
    @GET("api/movie/list/")
    Observable<ListMoviesResponse> listMovies();

    @GET("api/movie/movie/id/{id}")
    Observable<MovieDetailResponse> getMovieDetail(@Path("id") String movieId);
}
