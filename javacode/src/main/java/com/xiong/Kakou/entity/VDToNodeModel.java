package com.xiong.Kakou.entity;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/15 10:08
 * @description：
 * @modified By：
 * @version: $
 */
public class VDToNodeModel {

    private Integer FID;
    private String vd;
    private String node;
    private String xqbh;
    private String latitude;
    private String longitude;

    @Override
    public String toString() {
        return "VDToNodeModel{" +
                "FID=" + FID +
                ", vd='" + vd + '\'' +
                ", node='" + node + '\'' +
                ", xqbh='" + xqbh + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

    public String getVd() {
        return vd;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getXqbh() {
        return xqbh;
    }

    public void setXqbh(String xqbh) {
        this.xqbh = xqbh;
    }
}
