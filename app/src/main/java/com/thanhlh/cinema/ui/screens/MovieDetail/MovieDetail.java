package com.thanhlh.cinema.ui.screens.MovieDetail;

import com.thanhlh.cinema.mvpbase.MvpView;

/**
 * Created by thanhle on 4/25/17.
 */

public interface MovieDetail {
    interface View extends MvpView {
        void loadSuccess(com.thanhlh.cinema.repository.model.MoviesDetail movieDetail);
        void loadError(String message);
        void noDataFound();
    }
    interface Presenter {
        void getMovieDetail(String movieId);
    }
}
