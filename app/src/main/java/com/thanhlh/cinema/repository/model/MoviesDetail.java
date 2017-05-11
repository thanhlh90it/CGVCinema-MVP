package com.thanhlh.cinema.repository.model;

import java.util.Date;

/**
 * Created by thanhle on 4/25/17.
 */

public class MoviesDetail {

    /**
     * id : 1856
     * sku : 1352
     * category : Phim đang chiếu
     * name : Vệ Binh Dải Ngân Hà 2
     * thumbnail : https://www.cgv.vn/media/catalog/product/cache/1/movie_poster/9df78eab33525d08d6e5fb8d27136e95/v/b/vbdnh_scdb_406x600.jpg
     * url : https://www.cgv.vn/vn/ve-binh-dai-ngan-ha-2.html
     * full_description : Vệ Binh Dải Ngân Hà phần 2 được dẫn dắt dưới bàn tay đạo diễn James Gunn cùng sự tham gia của các diễn viên: Chris Pratt trong vai Star-Lord, Zoe Saldana trong vai Gamora, và Dave Bautista trong vai Drax. Phim dự kiến khởi chiếu ngày 28/04/2017 với định dạng 2D, 3D và IMAX 3D.
     * genre : Hành Động, Phiêu Lưu
     * rating_code : c13 phim không dành cho khán giả dưới 13 tuổi.
     * rating_icon : https://www.cgv.vn/skin/frontend/cgv/default/images/icon-mobile-rating-c13.png
     * review_percent : null
     * codes : 4DX,IMAX,3D,2D,Starium
     * release_date : 2017-04-28 00:00:00
     * movie_trailer : //www.youtube.com/embed/kRcRVsAiE7U
     * movie_director : James Gunn
     * movie_language : Tiếng Anh với phụ đề tiếng Việt
     * movie_endtime : 136
     * movie_actress : Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel, Bradley Cooper, Michael Rooker, Karen Gillan, Pom Klementieff, Elizabeth Debicki, Kurt Russell
     * is_booking : true
     */

    private String id;
    private String sku;
    private String category;
    private String name;
    private String thumbnail;
    private String url;
    private String full_description;
    private String genre;
    private String rating_code;
    private String rating_icon;
    private Object review_percent;
    private String codes;
    private Date release_date;
    private String movie_trailer;
    private String movie_director;
    private String movie_language;
    private int movie_endtime;
    private String movie_actress;
    private boolean is_booking;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating_code() {
        return rating_code;
    }

    public void setRating_code(String rating_code) {
        this.rating_code = rating_code;
    }

    public String getRating_icon() {
        return rating_icon;
    }

    public void setRating_icon(String rating_icon) {
        this.rating_icon = rating_icon;
    }

    public Object getReview_percent() {
        return review_percent;
    }

    public void setReview_percent(Object review_percent) {
        this.review_percent = review_percent;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public int getMovie_endtime() {
        return movie_endtime;
    }

    public void setMovie_endtime(int movie_endtime) {
        this.movie_endtime = movie_endtime;
    }

    public String getMovie_actress() {
        return movie_actress;
    }

    public void setMovie_actress(String movie_actress) {
        this.movie_actress = movie_actress;
    }

    public boolean isIs_booking() {
        return is_booking;
    }

    public void setIs_booking(boolean is_booking) {
        this.is_booking = is_booking;
    }
}
