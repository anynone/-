package flood_fill.impl;

import flood_fill.FloodFill;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class XingZhiBin implements FloodFill {
    public Point[] searchRectPoint(Integer[][] points, Point point){
        //判断第一个点是不是超出了范围
        if (point.x < 0 || point.x >= points.length || point.y < 0 || point.y >= points[0].length) {
            return null;
        }
        int num = points[point.x][point.y];
        Set<Point> lastResult = new HashSet<>();
        Integer[][] checked = new Integer[points.length][points[0].length];
        return floodSearch(points, point, num, lastResult, checked).toArray(new Point[0]);
    }


    public Set<Point> floodSearch(Integer[][] testData, Point point, int num, Set<Point> lastResult, Integer[][] checkedPoints) {
        if (point.x < 0 || point.x >= testData.length || point.y < 0 || point.y >= testData[0].length || checkedPoints[point.x][point.y] != null) {
            return lastResult;
        }

        checkedPoints[point.x][point.y] = 1;
        if (num == testData[point.x][point.y]) {
            lastResult.add(point);
        } else {
            return lastResult;
        }
        //定义紧邻的四个点
        Point[] around = new Point[4];
        around[0] = new Point(point.x - 1, point.y);//上
        around[1] = new Point(point.x + 1, point.y);//下
        around[2] = new Point(point.x, point.y - 1);//左
        around[3] = new Point(point.x, point.y + 1);//右

        for (Point aroundPoint : around) {
            if (aroundPoint.x < 0 || aroundPoint.x >= testData.length || aroundPoint.y < 0 || aroundPoint.y >= testData[0].length || checkedPoints[aroundPoint.x][aroundPoint.y] != null) {

            } else {
                floodSearch(testData, aroundPoint, num, lastResult, checkedPoints);
            }

        }

        return lastResult;
    }
}
