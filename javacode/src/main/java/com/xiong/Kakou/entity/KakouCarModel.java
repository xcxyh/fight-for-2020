package com.xiong.Kakou.entity;

import java.io.Serializable;

public class KakouCarModel implements Serializable {
    private String sbbh;

    private String CDBH;

    private String gcsj;

    private String hphm;

    private String hpzl;

    private String latitude;

    private String longitude;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "KakouCarModel{" +
                "sbbh='" + sbbh + '\'' +
                ", CDBH='" + CDBH + '\'' +
                ", gcsj='" + gcsj + '\'' +
                ", hphm='" + hphm + '\'' +
                ", hpzl='" + hpzl + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh == null ? null : sbbh.trim();
    }

    public String getCDBH() {
        return CDBH;
    }

    public void setCDBH(String CDBH) {
        this.CDBH = CDBH == null ? null : CDBH.trim();
    }

    public String getGcsj() {
        return gcsj;
    }

    public void setGcsj(String gcsj) {
        this.gcsj = gcsj == null ? null : gcsj.trim();
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl == null ? null : hpzl.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }
}