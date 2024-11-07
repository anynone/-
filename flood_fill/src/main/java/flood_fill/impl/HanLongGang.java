package flood_fill.impl;
/**
 * @Author: Tanikawa
 * @Date: 2024/10/31 16:51
 * @Description:
 */

import flood_fill.FloodFill;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HanLongGang implements FloodFill {


    @Override
    public Point[] searchRectPoint(Integer[][] points, Point startPoint) {
        // 获取起始点的目标值
        int targetValue = points[startPoint.x][startPoint.y].intValue();
        int rows = points.length;
        int cols = points[0].length;

        // 初始化存储结果的列表
        List<Point> result = new ArrayList<>();
        // 初始化访问标记数组
        boolean[][] visited = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<>();

        // BFS 初始化：将起始点加入队列，并标记为访问过
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;

        // BFS 遍历
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            result.add(current);

            // 四个方向：上、下、左、右
            for (int[] direction : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                // 确保新坐标在矩阵边界内，未访问，并且值与目标值一致
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                        !visited[newX][newY] && points[newX][newY].intValue() == targetValue) {

                    // 将新点加入队列，并标记为已访问
                    queue.add(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }

        // 将结果列表转换为数组并返回
        return result.toArray(new Point[0]);
    }

}
