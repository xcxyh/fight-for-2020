package com.xiong.Kakou.entity;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/15 10:08
 * @description：
 * @modified By：
 * @version: $
 */
public class VDToNodeModel {


    private String vd;
    private String node;

    @Override
    public String toString() {
        return "VDToNodeModel{" +
                "vd='" + vd + '\'' +
                ", node='" + node + '\'' +
                '}';
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
}
