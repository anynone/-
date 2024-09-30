import java.awt.*;
import java.util.ArrayList;

public class DemoImpl implements FloodFill{
    @Override
    public Point[] searchRectPoint(Integer[][] points, Point point) {
        ArrayList<Point> retPoints = new ArrayList<>();
        retPoints.add(new Point(0, 0));
        return retPoints.toArray(new Point[0]);
    }
}
