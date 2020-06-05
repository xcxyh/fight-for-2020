package com.xiong.Kakou.entity;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/4 17:55
 * @description：
 * @modified By：
 * @version: $
 */
public class EmmeNodeModel {

    private Integer id;
    private String geom;


    @Override
    public String toString() {
        return "EmmeNodeModel{" +
                "id=" + id +
                ", geom='" + geom + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
