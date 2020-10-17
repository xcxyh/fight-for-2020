package com.xiong.Kakou.entity;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/3 15:08
 * @description：
 * @modified By：
 * @version: $
 */
public class BeijingTaxiModel {
    private Integer taxiID;

    private String gettime;

    private String longitude;

    private String latitude;

    BeijingTaxiModel(){

    }

    public BeijingTaxiModel(Integer taxiID, String gettime, String longitude, String latitude) {
        this.taxiID = taxiID;
        this.gettime = gettime;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "BeijingTaxiModel{" +
                "taxiID=" + taxiID +
                ", gettime='" + gettime + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public Integer getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(Integer taxiID) {
        this.taxiID = taxiID;
    }

    public String getGettime() {
        return gettime;
    }

    public void setGettime(String gettime) {
        this.gettime = gettime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
