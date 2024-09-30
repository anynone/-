import org.junit.jupiter.api.Test;

import java.awt.*;

class FloodFillTest {

    @Test
    void searchRectPointTest() {
        long startMilli = System.currentTimeMillis();
        DemoImpl demo = new DemoImpl();
        for (int i = 0; i < 100000; i++) {
            demo.searchRectPoint(TestData.testData, new Point(1, 1));
        }
        System.out.println(System.currentTimeMillis() - startMilli);
    }
}