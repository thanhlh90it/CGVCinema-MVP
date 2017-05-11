package com.thanhlh.cinema.repository.model;

import java.util.List;

/**
 * Created by thanhle on 4/24/17.
 */

public class ListMoviesResponse {

    private List<Movie> data;

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }
}
