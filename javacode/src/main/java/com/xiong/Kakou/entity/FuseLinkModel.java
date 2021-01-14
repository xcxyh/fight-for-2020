package com.xiong.Kakou.entity;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/19 15:31
 * @description：
 * @modified By：
 * @version: $
 */
public class FuseLinkModel {

    private String ID_Link;
    private String StartTime;
    private String VehicleCount;

    public String getID_Link() {
        return ID_Link;
    }

    public void setID_Link(String ID_Link) {
        this.ID_Link = ID_Link;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getVehicleCount() {
        return VehicleCount;
    }

    public void setVehicleCount(String vehicleCount) {
        VehicleCount = vehicleCount;
    }

    @Override
    public String toString() {
        return "FuseLinkModel{" +
                "ID_Link='" + ID_Link + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", VehicleCount='" + VehicleCount + '\'' +
                '}';
    }
}
