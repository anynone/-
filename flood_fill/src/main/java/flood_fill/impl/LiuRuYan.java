package flood_fill.impl;

import flood_fill.FloodFill;
import flood_fill.TestData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class LiuRuYan implements FloodFill {
    public Point[] searchRectPoint(int row, int column) {
        //矩阵
        Integer[][] matrix = {
                {1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,1,0,0,1,1,1,1,0,1},
                {1,1,1,0,1,1,0,0,1,1,0,1},
                {1,0,0,1,0,1,1,0,1,0,0,1},
                {1,0,0,1,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,1,1,1,0,1},
                {1,0,1,1,1,1,0,1,1,1,0,1},
                {1,0,1,1,1,1,1,1,1,1,0,1},
                {1,0,1,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1},
        };
        List<Point> result = new ArrayList<>();
        result.add(new Point(row, column));
        result = getAroundSameData(matrix, row, column, result);
        return result.toArray(new Point[0]);
    }

    /**
     * 根据矩阵、行、列及结果集获取横向&纵向相同的数据
     * @author liuruyan
     * @date 2024/10/18 11:08
     * @param matrix 矩阵
     * @param row 行
     * @param column 列
     * @param result 相同的结果集
     * @return java.util.List<int[]>
     */
    public static List<Point> getAroundSameData(Integer[][] matrix, int row, int column, List<Point> result) {
        //先判断行和列是否在矩阵
        if (matrix == null) {
            return new ArrayList<>();
        }
        int rows = matrix.length;
        if (rows == 0) {
            return new ArrayList<>();
        }
        int cols = matrix[0].length;
        //如果给定的行/列小于0  或者大于等于行/列的长度 表示不在矩阵中
        if (row < 0 || row >= rows && column < 0 || column >= cols) {
            return new ArrayList<>();
        }

        int targetValue = matrix[row][column];

        //统一先向右找 右边相同继续往右找
        for (int i = column + 1; i < matrix[row].length; i++) {
            //如果右一个和当前不一致 或者已经添加到结果集中 就跳出循环
            Point rightRowAndCol = new Point(row, i);
            if (targetValue != matrix[row][i] || result.contains(rightRowAndCol)) {
                break;
            }
            //添加到结果中 同时递归调此方法
            result.add(rightRowAndCol);
            result = getAroundSameData(matrix, row, i, result);
        }
        //向下找
        for (int j = row + 1; j < matrix.length; j++) {
            //如果下一个和当前不一致 或者已经添加到结果集中 就跳出循环
            Point downRowAndCol = new Point(j, column);
            if (targetValue != matrix[j][column] || result.contains(downRowAndCol)) {
                break;
            }
            //添加到结果中 同时递归调此方法
            result.add(downRowAndCol);
            result = getAroundSameData(matrix, j, column, result);
        }

        //向左找
        for (int k = column - 1; k >= 0; k--) {
            //如果左一个和当前不一致 或者已经添加到结果集中 就跳出循环
            Point leftRowAndCol = new Point(row, k);
            if (targetValue != matrix[row][k] || result.contains(leftRowAndCol)) {
                break;
            }
            //添加到结果中 同时递归调此方法
            result.add(leftRowAndCol);
            result = getAroundSameData(matrix, row, k, result);
        }

        //向上找
        for (int l = row - 1; l >= 0; l--) {
            //如果下一个和当前不一致 或者已经添加到结果集中 就跳出循环
            Point upRowAndCol = new Point(l, column);
            if (targetValue != matrix[l][column] || result.contains(upRowAndCol)) {
                break;
            }
            //添加到结果中 同时递归调此方法
            result.add(upRowAndCol);
            result = getAroundSameData(matrix, l, column, result);
        }
        return result;
    }

    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point) {
        List<Point> result = new ArrayList<>();
        result = getAroundSameData(points, point.y, point.x, result);
        return result.toArray(new Point[0]);
    }
}
