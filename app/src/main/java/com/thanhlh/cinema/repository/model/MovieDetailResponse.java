package com.thanhlh.cinema.repository.model;

/**
 * Created by thanhle on 4/25/17.
 */

public class MovieDetailResponse {

    /**
     * data : {"id":"1856","sku":"1352","category":"Phim đang chiếu","name":"Vệ Binh Dải Ngân Hà 2","thumbnail":"https://www.cgv.vn/media/catalog/product/cache/1/movie_poster/9df78eab33525d08d6e5fb8d27136e95/v/b/vbdnh_scdb_406x600.jpg","url":"https://www.cgv.vn/vn/ve-binh-dai-ngan-ha-2.html","full_description":"Vệ Binh Dải Ngân Hà phần 2 được dẫn dắt dưới bàn tay đạo diễn James Gunn cùng sự tham gia của các diễn viên: Chris Pratt trong vai Star-Lord, Zoe Saldana trong vai Gamora, và Dave Bautista trong vai Drax. Phim dự kiến khởi chiếu ngày 28/04/2017 với định dạng 2D, 3D và IMAX 3D.","genre":"Hành Động, Phiêu Lưu","rating_code":"c13 phim không dành cho khán giả dưới 13 tuổi.","rating_icon":"https://www.cgv.vn/skin/frontend/cgv/default/images/icon-mobile-rating-c13.png","review_percent":null,"codes":"4DX,IMAX,3D,2D,Starium","release_date":"2017-04-28 00:00:00","movie_trailer":"//www.youtube.com/embed/kRcRVsAiE7U","movie_director":"James Gunn","movie_language":"Tiếng Anh với phụ đề tiếng Việt","movie_endtime":136,"movie_actress":"Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel, Bradley Cooper, Michael Rooker, Karen Gillan, Pom Klementieff, Elizabeth Debicki, Kurt Russell","is_booking":true}
     */

    private MoviesDetail data;

    public MoviesDetail getData() {
        return data;
    }

    public void setData(MoviesDetail data) {
        this.data = data;
    }

}
