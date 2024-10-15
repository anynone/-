import java.awt.*;
import java.util.ArrayList;

public class DemoImpl implements FloodFill{
    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point) {
        // 单侧demo实现
        return new Point[]{
            new Point(1,1),new Point(1,2),new Point(1,3),new Point(1,4),new Point(1,5),new Point(1,6),new Point(1,7),new Point(1,8),new Point(1,9),new Point(1,10),
            new Point(2,1),new Point(2,2),new Point(2,3),new Point(2,4),new Point(2,5),new Point(2,6),new Point(2,7),new Point(2,8),new Point(2,9),new Point(2,10),
            new Point(3,1),new Point(3,2),new Point(3,4),new Point(3,5),new Point(3,10),
            new Point(4,6),new Point(4,7),new Point(4,10),
            new Point(5,1),new Point(5,2),new Point(5,4),new Point(5,7),new Point(5,9),new Point(5,10),
            new Point(6,1),new Point(6,2),new Point(6,4),new Point(6,5),new Point(6,6),new Point(6,7),new Point(6,8),new Point(6,9),new Point(6,10),
            new Point(7,1),new Point(7,2),new Point(7,3),new Point(7,4),new Point(7,5),new Point(7,6),new Point(7,10),
            new Point(8,1),new Point(8,6),new Point(8,10),
            new Point(9,1),new Point(9,10),
            new Point(10,1),new Point(10,3),new Point(10,4),new Point(10,5),new Point(10,6),new Point(10,7),new Point(10,8),new Point(10,9),new Point(10,10),
        };
    }
}
