package com.xiong.Kakou.entity;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/7 14:06
 * @description：
 * @modified By：
 * @version: $
 */
public class NycTaxiModel {

    private String id;
    private String startTime;
    private String endTime;
    private Integer origin;
    private Integer dist;

    @Override
    public String toString() {
        return "NycTaxiModel{" +
                "id='" + id + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", origin=" + origin +
                ", dist=" + dist +
                '}';
    }

    public NycTaxiModel(String startTime, String endTime, Integer origin, Integer dist) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.origin = origin;
        this.dist = dist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }
}
