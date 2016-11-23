package com.example.waviq.reacycleimplement.models;

/**
 * Created by waviq on 21/11/2016.
 */

public class Station {

    final  String DRAWABLE = "drawable/";

    private String stationTitle;
    private String imgUrl;

    /*constructor disini digunakan sebagai parameter yang akan dipakai di DataService*/
    public Station(String stationTitle, String imgUrl) {
        this.stationTitle = stationTitle;
        this.imgUrl = imgUrl;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImgUrl() {
        return DRAWABLE + imgUrl;
    }

}
