package com.xiong.Kakou.entity;

import java.io.Serializable;

public class KakouPointModel implements Serializable {
    private Integer FID;

    private String ID_Traffic;

    private String ID_Old;

    private String ID_Link;

    private String ID_Lane;

    private String ID_Station;

    private String positionCo;

    private String longitude;

    private String latitude;

    private String area;

    private String note;

    private String sourceName;

    private String sourceType;

    private String stationLoc;

    private String linkLocati;

    private String status;

    private String nodeParent;

    private String nodeLevel;

    private String laneType;

    private String linkName;

    private String count;

    private String rate;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "KakouPointModel{" +
                "FID=" + FID +
                ", ID_Traffic='" + ID_Traffic + '\'' +
                ", ID_Old='" + ID_Old + '\'' +
                ", ID_Link='" + ID_Link + '\'' +
                ", ID_Lane='" + ID_Lane + '\'' +
                ", ID_Station='" + ID_Station + '\'' +
                ", positionCo='" + positionCo + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", area='" + area + '\'' +
                ", note='" + note + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", stationLoc='" + stationLoc + '\'' +
                ", linkLocati='" + linkLocati + '\'' +
                ", status='" + status + '\'' +
                ", nodeParent='" + nodeParent + '\'' +
                ", nodeLevel='" + nodeLevel + '\'' +
                ", laneType='" + laneType + '\'' +
                ", linkName='" + linkName + '\'' +
                ", count='" + count + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

    public String getID_Traffic() {
        return ID_Traffic;
    }

    public void setID_Traffic(String ID_Traffic) {
        this.ID_Traffic = ID_Traffic == null ? null : ID_Traffic.trim();
    }

    public String getID_Old() {
        return ID_Old;
    }

    public void setID_Old(String ID_Old) {
        this.ID_Old = ID_Old == null ? null : ID_Old.trim();
    }

    public String getID_Link() {
        return ID_Link;
    }

    public void setID_Link(String ID_Link) {
        this.ID_Link = ID_Link == null ? null : ID_Link.trim();
    }

    public String getID_Lane() {
        return ID_Lane;
    }

    public void setID_Lane(String ID_Lane) {
        this.ID_Lane = ID_Lane == null ? null : ID_Lane.trim();
    }

    public String getID_Station() {
        return ID_Station;
    }

    public void setID_Station(String ID_Station) {
        this.ID_Station = ID_Station == null ? null : ID_Station.trim();
    }

    public String getPositionCo() {
        return positionCo;
    }

    public void setPositionCo(String positionCo) {
        this.positionCo = positionCo == null ? null : positionCo.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getStationLoc() {
        return stationLoc;
    }

    public void setStationLoc(String stationLoc) {
        this.stationLoc = stationLoc == null ? null : stationLoc.trim();
    }

    public String getLinkLocati() {
        return linkLocati;
    }

    public void setLinkLocati(String linkLocati) {
        this.linkLocati = linkLocati == null ? null : linkLocati.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNodeParent() {
        return nodeParent;
    }

    public void setNodeParent(String nodeParent) {
        this.nodeParent = nodeParent == null ? null : nodeParent.trim();
    }

    public String getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(String nodeLevel) {
        this.nodeLevel = nodeLevel == null ? null : nodeLevel.trim();
    }

    public String getLaneType() {
        return laneType;
    }

    public void setLaneType(String laneType) {
        this.laneType = laneType == null ? null : laneType.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }
}