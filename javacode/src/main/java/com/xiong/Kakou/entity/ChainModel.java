package com.xiong.Kakou.entity;

import java.io.Serializable;

public class ChainModel implements Serializable {
    private String hphm;

    private String gcsj;

    private String sbbh;

    private String CDBH;

    private String longitude;

    private String latitude;

    private String status;

    @Override
    public String toString() {
        return "ChainModel{" +
                "hphm='" + hphm + '\'' +
                ", gcsj='" + gcsj + '\'' +
                ", sbbh='" + sbbh + '\'' +
                ", CDBH='" + CDBH + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public String getGcsj() {
        return gcsj;
    }

    public void setGcsj(String gcsj) {
        this.gcsj = gcsj;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public String getCDBH() {
        return CDBH;
    }

    public void setCDBH(String CDBH) {
        this.CDBH = CDBH;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}