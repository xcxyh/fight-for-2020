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

    @Override
    public String toString() {
        return "VDToNodeModel{" +
                "FID=" + FID +
                ", vd='" + vd + '\'' +
                ", node='" + node + '\'' +
                ", xqbh='" + xqbh + '\'' +
                '}';
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
