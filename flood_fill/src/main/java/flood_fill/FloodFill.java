package flood_fill;

import java.awt.*;

/**
 * @author yuechenxing
 */
public interface FloodFill {

    /**
     * 查找point从横向和竖向有关联的所有点的坐标，左上角坐标从0，0开始
     * @param points 点数据
     * @param point 选中的坐标点
     * @return 返回相关的坐标数组
     */
    Point[] searchRectPoint(Integer[][] points, Point point);
}
