package com.thanhlh.cinema.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thanhlh.cinema.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by thanhle on 4/25/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>
        implements View.OnClickListener {
    protected ICallBack mCallback;

    public MoviesAdapter(Context context, ICallBack callBack) {
        mCallback = callBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mCallback.updateViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mCallback.getCount();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rootView:
                IGetPosition interf = (IGetPosition) v.getTag();
                mCallback.onClickItemView(interf.getPosition());
                break;
            default:
                break;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle) public TextView tvTitle;
        @BindView(R.id.tvDate) public TextView tvDate;
        @BindView(R.id.imvThumbnail) public ImageView imvThumbnail;
        @BindView(R.id.tvCodes) public TextView tvCodes;
        @BindView(R.id.imvRatingIcon) public ImageView imvRatingIcon;
        @BindView(R.id.rootView) public RelativeLayout rootView;

        public ViewHolder(View itemView, View.OnClickListener onClick) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            IGetPosition getPosition = new IGetPosition() {
                @Override
                public int getPosition() {
                    return getAdapterPosition();
                }
            };
            rootView.setTag(getPosition);
            rootView.setOnClickListener(onClick);
        }


    }

    public interface ICallBack {

        int getCount();

        void updateViewHolder(ViewHolder holder, int position);

        void onClickItemView(int position);
    }
}