package com.thanhlh.cinema.ui.screens.MoviesList;

import com.thanhlh.cinema.mvpbase.MvpView;
import com.thanhlh.cinema.repository.model.Movie;

import java.util.List;

/**
 * Created by thanhle on 4/25/17.
 */

public interface MoviesList {
    interface View extends MvpView {
        void gotoMovieDetail(String movieId);
        void loadSuccess(List<Movie> movieList);
        void loadError(String message);
        void noDataFound();
    }
    interface Presenter {
        void getListMovies();
    }
}
