package com.xiong.Kakou.entity;

import java.io.Serializable;

public class LinkModel implements Serializable {
    private String ID_Link;

    private String from_node;

    private String to_node;

    private Float link_length;

    private String link_type;

    private String road_name;

    private String lane_num;

    private String shape_len;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "LinkModel{" +
                "ID_Link='" + ID_Link + '\'' +
                ", from_node='" + from_node + '\'' +
                ", to_node='" + to_node + '\'' +
                ", link_length=" + link_length +
                ", link_type='" + link_type + '\'' +
                ", road_name='" + road_name + '\'' +
                ", lane_num='" + lane_num + '\'' +
                ", shape_len='" + shape_len + '\'' +
                '}';
    }

    public String getID_Link() {
        return ID_Link;
    }

    public void setID_Link(String ID_Link) {
        this.ID_Link = ID_Link == null ? null : ID_Link.trim();
    }

    public String getFrom_node() {
        return from_node;
    }

    public void setFrom_node(String from_node) {
        this.from_node = from_node == null ? null : from_node.trim();
    }

    public String getTo_node() {
        return to_node;
    }

    public void setTo_node(String to_node) {
        this.to_node = to_node == null ? null : to_node.trim();
    }

    public Float getLink_length() {
        return link_length;
    }

    public void setLink_length(Float link_length) {
        this.link_length = link_length;
    }

    public String getLink_type() {
        return link_type;
    }

    public void setLink_type(String link_type) {
        this.link_type = link_type == null ? null : link_type.trim();
    }

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name == null ? null : road_name.trim();
    }

    public String getLane_num() {
        return lane_num;
    }

    public void setLane_num(String lane_num) {
        this.lane_num = lane_num == null ? null : lane_num.trim();
    }

    public String getShape_len() {
        return shape_len;
    }

    public void setShape_len(String shape_len) {
        this.shape_len = shape_len == null ? null : shape_len.trim();
    }
}