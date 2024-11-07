package flood_fill.impl;

import flood_fill.FloodFill;

import java.awt.*;
import java.util.List;

public class LiuWenJing implements FloodFill {
    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point) {
        // 单侧demo实现
        int value = points[point.y][point.x];
        List<Point> list = new java.util.ArrayList<>();
        int count = 0;
        searchQianGe(points, point.x, point.y, list, value);
        Point[] result = new Point[list.size()];
        for (Point pointTemp :list) {
            result[count] = pointTemp;
            count++;
        }
        return result;
    }
    private void searchQianGe(Integer[][] points, int x, int y, List<Point> list,  int value) {
        if(x < 0 || y < 0 || x >= points.length || y >= points[0].length){
            return;
        }
        if (points[x][y] == value) {
            if(list.contains(new Point(x, y))){
                return;
            }
            list.add(new Point(x, y));
            searchQianGe(points, x, y + 1, list, value);
            searchQianGe(points, x + 1, y, list,  value);
            searchQianGe(points, x, y - 1, list,  value);
            searchQianGe(points, x - 1, y, list,  value);
        }
    }
}
