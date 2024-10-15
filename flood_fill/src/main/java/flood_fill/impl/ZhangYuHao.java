package flood_fill.impl;

import flood_fill.FloodFill;
import flood_fill.TestData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ZhangYuHao implements FloodFill {

    public static boolean[][] msg = new boolean[TestData.testData.length][TestData.testData[0].length];
    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point) {
        return findSameNumbers(points, point.x, point.y);
    }
    public static Point[] findSameNumbers(Integer[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return null;
        }
        int target = matrix[row][col];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Point> points = new ArrayList<>();
        dfs(matrix, row, col, target, visited,points);
        return points.toArray(new Point[0]);

    }

    public static void dfs(Integer[][] matrix , int row, int col, int target, boolean[][] visited,List<Point> points) {

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length || visited[row][col] ||msg[row][col]){
            return;
        }else {
            msg[row][col] = true;
            if (matrix[row][col] != target) {
                return;
            }
        }
        visited[row][col] = true;
        points.add(new Point(row, col));
        dfs(matrix, row + 1, col, target, visited, points);
        dfs(matrix, row - 1, col, target, visited,points);
        dfs(matrix, row, col + 1, target, visited,points);
        dfs(matrix, row, col - 1, target, visited,points);
    }
}
