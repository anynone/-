package flood_fill.impl;

import flood_fill.FloodFill;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class XingZhiBin implements FloodFill {
    private static HashMap<Integer, Integer> hasStep = new HashMap<>();
    public Point[] searchRectPoint(Integer[][] points, Point point){
        //判断第一个点是不是超出了范围
        if (point.x < 0 || point.x >= points.length || point.y < 0 || point.y >= points[0].length) {
            return null;
        }
        int num = points[point.x][point.y];
        List<Point> lastResult = new ArrayList<>();
        Point[] array = floodSearch(points, point, num, lastResult).toArray(new Point[0]);
        hasStep = new HashMap<>();
        return array;
    }


    public List<Point> floodSearch(Integer[][] testData, Point point, int num, List<Point> lastResult) {
        Integer stepX = hasStep.getOrDefault(point.x, -1);
        Integer stepY = hasStep.getOrDefault(point.y, -1);
        if (stepX != -1 && stepY != -1) {
            return lastResult;
        }

        if (point.x < 0 || point.x >= testData.length || point.y < 0 || point.y >= testData[0].length) {
            return lastResult;
        }

        if (num == testData[point.x][point.y] && !lastResult.contains(point)) {
            lastResult.add(point);
            hasStep.put(point.x, point.y);
//            testData[point.x][point.y] = null;
        } else {
//            testData[point.x][point.y] = null;
            hasStep.put(point.x, point.y);
            return lastResult;
        }
        //定义紧邻的四个点
        Point[] around = new Point[4];
        around[0] = new Point(point.x - 1, point.y);//上
        around[1] = new Point(point.x + 1, point.y);//下
        around[2] = new Point(point.x, point.y - 1);//左
        around[3] = new Point(point.x, point.y + 1);//右
        for (Point aroundPoint : around) {
            if (aroundPoint.x < 0 || aroundPoint.x >= testData.length || aroundPoint.y < 0 || aroundPoint.y >= testData[0].length) {
                continue;
            }
            floodSearch(testData, aroundPoint, num, lastResult);
        }

        return lastResult;
    }
}
