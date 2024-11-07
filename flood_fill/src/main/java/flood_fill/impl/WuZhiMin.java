package flood_fill.impl;

import flood_fill.FloodFill;
import flood_fill.TestData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WuZhiMin implements FloodFill {
    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point) {

        int xlength = points.length;
        if (xlength < point.x) return null;
        int ylength = points[0].length;
        if (ylength < point.y) return null;

       // Integer val = points[point.x][point.y];
       //
       // Point[] result = new Point[xlength * ylength];
       // int[][] points1 = new int[xlength][ylength];
       // int index = 0;
       // result[index++] = point;
       //
       // points1[point.x][point.y] = 1;
       // int jindex = 0;
       // List<Point> aa = aa(point.x, point.y, points1, xlength, ylength);
       // while (aa.size() > 0) {
       //     Point point1 = aa.remove(0);
       //     if (Objects.equals(points[point1.x][point1.y], val)) {
       //         result[index++] = new Point(point1.x, point1.y);
       //         aa.addAll(aa(point1.x, point1.y, points1, xlength, ylength));
       //     }
       //     jindex++;
       // }
       // System.out.println(jindex);
       // System.out.println(index);
       // return result;

        Integer val = points[point.x][point.y];

        int index = 0;
        int jindex = 0;
        List<Point> result = new ArrayList<>();
        Point[][] points1 = new Point[xlength][ylength];
        result.add(new Point(point.x, point.y));
        points1[point.x][point.y] = point;
        List<Point> aa = aa(point.x, point.y, points1, xlength, ylength);
        while (aa.size() > 0) {
            Point point1 = aa.remove(0);
            if (Objects.equals(points[point1.x][point1.y], val)) {
                index++;
                result.add(new Point(point1.x, point1.y));
                aa.addAll(aa(point1.x, point1.y, points1, xlength, ylength));
            }
            jindex++;
        }
//        System.out.println(jindex);
//        System.out.println(index);
        return result.toArray(new Point[result.size()]);
    }

    private List<Point> aa(int x, int y, Point[][] points1, int xLength, int yLength) {
        List<Point> result = new ArrayList<>();
        int x1 = x - 1;
        int x2 = x + 1;
        int y1 = y - 1;
        int y2 = y + 1;
        if (x1 >= 0 && x1 < xLength && points1[x1][y] == null) {
            result.add(new Point(x1, y));
            points1[x1][y] = new Point(x1, y);
        }
        if (x2 >= 0 && x2 < xLength && points1[x2][y] == null) {
            result.add(new Point(x2, y));
            points1[x2][y] = new Point(x2, y);
        }
        if (y1 >= 0 && y1 < yLength && points1[x][y1] == null) {
            result.add(new Point(x, y1));
            points1[x][y1] = new Point(x, y1);
        }
        if (y2 >= 0 && y2 < yLength && points1[x][y2] == null) {
            result.add(new Point(x, y2));
            points1[x][y2] = new Point(x, y2);
        }
        return result;
    }

    private List<Point> aa(int x, int y, int[][] points1, int xLength, int yLength) {
        List<Point> result = new ArrayList<>();
        int x1 = x - 1;
        int x2 = x + 1;
        int y1 = y - 1;
        int y2 = y + 1;
        if (x1 >= 0 && x1 < xLength && points1[x1][y] == 0) {
            result.add(new Point(x1, y));
            points1[x1][y] = 1;
        }
        if (x2 >= 0 && x2 < xLength && points1[x2][y] == 0) {
            result.add(new Point(x2, y));
            points1[x2][y] = 1;
        }
        if (y1 >= 0 && y1 < yLength && points1[x][y1] == 0) {
            result.add(new Point(x, y1));
            points1[x][y1] = 1;
        }
        if (y2 >= 0 && y2 < yLength && points1[x][y2] == 0) {
            result.add(new Point(x, y2));
            points1[x][y2] = 1;
        }
        return result;
    }
}
