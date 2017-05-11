package com.thanhlh.cinema.repository.model;

import java.util.Date;

/**
 * Created by thanhle on 4/24/17.
 */

public class Movie {

    /**
     * id : 1856
     * sku : 1352
     * category_id : 0
     * category : Phim đang chiếu
     * name : Vệ Binh Dải Ngân Hà 2
     * thumbnail : https://www.cgv.vn/media/catalog/product/cache/1/movie_poster/9df78eab33525d08d6e5fb8d27136e95/v/b/vbdnh_scdb_406x600.jpg
     * movie_trailer :
     * release_date : 2017-04-28 00:00:00
     * movie_endtime : 136
     * rating_icon : https://www.cgv.vn/skin/frontend/cgv/default/images/icon-mobile-rating-c13.png
     * codes : 4DX,IMAX,3D,2D,Starium
     * is_booking : true
     * is_new : true
     * position : 0
     */

    private String id;
    private String sku;
    private int category_id;
    private String category;
    private String name;
    private String thumbnail;
    private String movie_trailer;
    private Date release_date;
    private int movie_endtime;
    private String rating_icon;
    private String codes;
    private boolean is_booking;
    private boolean is_new;
    private int position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getMovie_endtime() {
        return movie_endtime;
    }

    public void setMovie_endtime(int movie_endtime) {
        this.movie_endtime = movie_endtime;
    }

    public String getRating_icon() {
        return rating_icon;
    }

    public void setRating_icon(String rating_icon) {
        this.rating_icon = rating_icon;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public boolean isIs_booking() {
        return is_booking;
    }

    public void setIs_booking(boolean is_booking) {
        this.is_booking = is_booking;
    }

    public boolean isIs_new() {
        return is_new;
    }

    public void setIs_new(boolean is_new) {
        this.is_new = is_new;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
