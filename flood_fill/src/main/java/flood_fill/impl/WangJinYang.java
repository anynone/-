package flood_fill.impl;

import com.sun.scenario.effect.Flood;
import flood_fill.FloodFill;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WangJinYang implements FloodFill {
    // 上、下、左、右
    private static final int[] rowDirection = {-1, 1, 0, 0};
    private static int[] colDirection = {0, 0, -1, 1};

    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point)  {
        int rows = points.length; // 行
        int cols = points[0].length; // 列
        // 获取起始点的值
        int target = points[point.x][point.y];
        // 记录访问过的点 防止重复遍历
        boolean[][] visited = new boolean[rows][cols];
        // 存储与起始点相连的所有点
        List<Point> result = new ArrayList<>();
        // 递归调用dfs函数
        dfs(points, point.x, point.y, target, visited, result);
        // 将列表result转换为数组
        return result.toArray(new Point[]{});
    }

    private void dfs(Integer[][] points, int row, int col, int target, boolean[][] visited, List<Point> result) {
        int rows = points.length;// 行
        int cols = points[0].length;// 列
        // 如果当前点 超出矩阵边界 已被访问 值不相等
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || !points[row][col].equals(target)) {
            return;
        }
        // 符合条件 标记为已访问
        visited[row][col] = true;
        result.add(new Point(row, col));
        // 递归探索四个方向
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDirection[i];
            int newCol = col + colDirection[i];
            dfs(points, newRow, newCol, target, visited, result);
        }
    }
}
