package com.thanhlh.cinema.ui.screens.MoviesList;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.thanhlh.cinema.R;
import com.thanhlh.cinema.commom.Constants;
import com.thanhlh.cinema.mvpbase.MvpPresenter;
import com.thanhlh.cinema.repository.model.Movie;
import com.thanhlh.cinema.ui.BaseMvpActivity;
import com.thanhlh.cinema.ui.adapter.MoviesAdapter;
import com.thanhlh.cinema.ui.screens.MovieDetail.MovieDetailActivity;
import com.thanhlh.cinema.utils.DateUtils;
import com.thanhlh.cinema.utils.StringUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MoviesListActivity extends BaseMvpActivity implements MoviesList.View, MoviesAdapter.ICallBack, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.swRefresh) SwipeRefreshLayout swRefresh;
    @BindView(R.id.rcList) RecyclerView rcList;

    private MoviesListPresenter presenter = new MoviesListPresenter();
    private List<Movie> movieList = new ArrayList<Movie>();
    private MoviesAdapter adapter;

    @Override
    public MvpPresenter getPresenter() {
        return presenter;
    }

    @Override
    public int getMainLayout() {
        return R.layout.activity_movies_list;
    }

    @Override
    public void setRootView() {
        mRootView = findViewById(R.id.rootView);
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.lb_movies_list_title));
    }

    @Override
    public void bindEventHandlers() {
        swRefresh.setOnRefreshListener(this);
    }

    @Override
    public void initComponents() {
        adapter = new MoviesAdapter(this, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rcList.setLayoutManager(manager);
        rcList.setAdapter(adapter);
        swRefresh.setRefreshing(true);
        loadData();
    }

    private void loadData() {
        presenter.getListMovies();
    }

    @Override
    public void gotoMovieDetail(String movieId) {
        Intent i = new Intent(this, MovieDetailActivity.class);
        i.putExtra(Constants.AG_MOVIE_ID,movieId);
        startActivity(i);
    }

    @Override
    public void loadSuccess(List<Movie> movieList) {
        swRefresh.setRefreshing(false);
        this.movieList.clear();
        this.movieList.addAll(movieList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadError(String message) {
        swRefresh.setRefreshing(false);
        showMessage(message);
    }

    @Override
    public void noDataFound() {
        swRefresh.setRefreshing(false);
        this.movieList.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public void updateViewHolder(MoviesAdapter.ViewHolder holder, int position) {
        Movie item = movieList.get(position);
        holder.tvDate.setText(DateUtils.parseDateToString(item.getRelease_date(), DateUtils.OUT_DATE_FORMAT));
        holder.tvTitle.setText(item.getName());
        holder.tvCodes.setText(item.getCodes() + " - ");
        if(!StringUtils.isEmptyString(item.getRating_icon()))
            Picasso.with(this)
                    .load(item.getRating_icon())
                    .placeholder(R.drawable.no_image)
                    .error(R.drawable.no_image)
                    .into(holder.imvRatingIcon);
        Picasso.with(this)
                .load(item.getThumbnail())
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(holder.imvThumbnail);
    }

    @Override
    public void onClickItemView(int position) {
        Movie item = movieList.get(position);
        gotoMovieDetail(item.getId());
    }

    @Override
    public void onRefresh() {
        loadData();
    }
}
