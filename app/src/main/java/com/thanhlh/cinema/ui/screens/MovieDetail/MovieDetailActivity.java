package com.thanhlh.cinema.ui.screens.MovieDetail;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.thanhlh.cinema.R;
import com.thanhlh.cinema.commom.Constants;
import com.thanhlh.cinema.mvpbase.MvpPresenter;
import com.thanhlh.cinema.repository.model.MoviesDetail;
import com.thanhlh.cinema.ui.BaseMvpActivity;
import com.thanhlh.cinema.utils.DateUtils;
import com.thanhlh.cinema.utils.StringUtils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class MovieDetailActivity  extends BaseMvpActivity implements MovieDetail.View, View.OnClickListener{

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.imvThumbnail) ImageView imvThumbnail;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvDate) TextView tvDate;
    @BindView(R.id.tvCodes) TextView tvCodes;
    @BindView(R.id.tvEndtime) TextView tvEndtime;
    @BindView(R.id.tvDescription) TextView tvDescription;
    @BindView(R.id.btnBookNow) Button btnBookNow;
    @BindView(R.id.imvRatingIcon) ImageView imvRatingIcon;
    @BindView(R.id.tvActress) TextView tvActress;


    private ProgressDialog mProgress;
    private MoviesDetail moviesDetail;


    private MovieDetailPresenter presenter = new MovieDetailPresenter();
    private String mMovieId = "";

    @Override
    public MvpPresenter getPresenter() {
        return presenter;
    }

    @Override
    public int getMainLayout() {
        return R.layout.activity_movie_detail;
    }

    @Override
    public void setRootView() {
        mRootView = findViewById(R.id.rootView);
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.movie_detail));
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void bindEventHandlers() {
        btnBookNow.setOnClickListener(this);
    }

    @Override
    public void initComponents() {
        mMovieId = getIntent().getStringExtra(Constants.AG_MOVIE_ID);
        loadData(mMovieId);
    }

    private void loadData(String id) {
        showProgress();
        presenter.getMovieDetail(id);
    }

    @Override
    public void loadSuccess(com.thanhlh.cinema.repository.model.MoviesDetail movieDetail) {
        hideProgress();
        moviesDetail = movieDetail;
        tvCodes.setText(movieDetail.getCodes());
        tvDate.setText(DateUtils.parseDateToString(movieDetail.getRelease_date(), DateUtils.OUT_DATE_FORMAT));
        tvTitle.setText(movieDetail.getName());
        tvDescription.setText(movieDetail.getFull_description());
        tvEndtime.setText(movieDetail.getMovie_endtime() +" " + getString(R.string.minutes));
        tvActress.setText(movieDetail.getMovie_actress());
        if(!StringUtils.isEmptyString(movieDetail.getRating_icon()))
            Picasso.with(this)
                    .load(movieDetail.getRating_icon())
                    .placeholder(R.drawable.no_image)
                    .error(R.drawable.no_image)
                    .into(imvRatingIcon);
        Picasso.with(this)
                .load(movieDetail.getThumbnail())
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(imvThumbnail);
    }

    @Override
    public void loadError(String message) {
        hideProgress();
        showMessage(message);
    }

    @Override
    public void noDataFound() {
        hideProgress();
        showMessage(getString(R.string.not_found));
    }

    @Override
    public void showProgress() {
        super.showProgress();
        if(mProgress == null){
            mProgress = new ProgressDialog(this);
            mProgress.setTitle(null);
            mProgress.setMessage(getString(R.string.loading));
        }
        mProgress.show();
    }

    @Override
    public void hideProgress() {
        super.hideProgress();
        if(mProgress != null)
            mProgress.cancel();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBookNow:
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(moviesDetail.getUrl()));
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
