package com.xiong.Kakou.util;

import java.text.DecimalFormat;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/4 15:52
 * @description：
 * @modified By：
 * @version: $
 */
public class PointUtil {

    private static final double EARTH_RADIUS = 6378.137;

    private static final double LAMBDA = Math.sqrt(2);

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/6/4 17:16
     *  @Description:  判断点 w 是否在 range 内部
     */
    public static boolean isWithinRange(double[] range, double[] latlon){

        double[] xy_w = millierConvertion(latlon[0], latlon[1]);

        double xw = xy_w[0];
        double yw = xy_w[1];

        double xc = range[0];
        double yc = range[1];
        double range_x = range[2];
        double range_y = range[3];

        return Math.abs(xw - xc) <= range_x && Math.abs(yw - yc) <= range_y;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/6/4 16:01
     * @Description:  得到  最大矩形 搜索范围和 中心点坐标
     */
    public static double[] getRange(double lat1, double lng1, double lat2, double lng2) {

        double[] xy_s = millierConvertion(lat1, lng1);
        double[] xy_t = millierConvertion(lat2, lng2);
        double d_st = getXYDist(xy_s[0], xy_s[1], xy_t[0], xy_t[1]);

        // 中心点坐标
        double xc = (xy_s[0] + xy_t[0]) / 2.0;
        double yc = (xy_s[1] + xy_t[1]) / 2.0;


        double theta = Math.atan((xy_t[1] - xy_s[1]) / (xy_t[0] - xy_s[0]));
        double sin_theta = Math.sin(theta);
        double temp_x = Math.pow(LAMBDA, 2) - sin_theta * sin_theta;
        double range_x = d_st * Math.sqrt(temp_x);


        double cos_theta = Math.cos(theta);
        double temp_y = Math.pow(LAMBDA, 2) - cos_theta * cos_theta;
        double range_y = d_st * Math.sqrt(temp_y);

        return new double[]{xc, yc, range_x, range_y};
    }

    private static double getXYDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

    }

    // 米勒投影法 转为 平面坐标
    public static double[] millierConvertion(double lat, double lon) {
        double L = 6381372 * Math.PI * 2;//地球周长
        double W = L;// 平面展开后，x轴等于周长
        double H = L / 2;// y轴约等于周长一半
        double mill = 2.3;// 米勒投影中的一个常数，范围大约在正负2.3之间
        double x = lon * Math.PI / 180;// 将经度从度数转换为弧度
        double y = lat * Math.PI / 180;// 将纬度从度数转换为弧度
        y = 1.25 * Math.log(Math.tan(0.25 * Math.PI + 0.4 * y));// 米勒投影的转换
        // 弧度转为实际距离
        x = (W / 2) + (W / (2 * Math.PI)) * x;
        y = (H / 2) - (H / (2 * mill)) * y;
        double[] result = new double[2];
        result[0] = x;
        result[1] = y;
        return result;
    }

    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return km
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        DecimalFormat df = new DecimalFormat("#.000");
        s = Double.parseDouble(df.format(s));

        //返回距离默认为km，乘 1000 返回 米 如果需要其他单位请记得换算
        return s * 1000.0;
    }
}
