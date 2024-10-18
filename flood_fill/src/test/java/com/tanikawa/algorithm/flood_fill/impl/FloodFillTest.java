package com.tanikawa.algorithm.flood_fill.impl;

import flood_fill.impl.DemoImpl;
import flood_fill.TestData;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class FloodFillTest {

    @Test
     void searchRectPointTest() {
        // 实现类demo
        DemoImpl demo = new DemoImpl();
        // 张育豪
//        FloodFill demo = new ZhangYuHao();
//        FloodFill demo = new LiuRuYan();


        // 结果
        boolean isRigth = checkResult(demo.searchRectPoint(TestData.testData, new Point(1, 1)));
        System.out.println("正确性检测： " + isRigth);
        //性能
        long totalTime = 0L;
        for (int j = 0; j < 10; j++) {
        long startMilli = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                demo.searchRectPoint(TestData.testData, new Point(1, 1));
            }
            long durationMill = System.currentTimeMillis() - startMilli;
            totalTime += durationMill;
        }

        System.out.println("10次平均时间:" + (totalTime/10));
    }

    private boolean checkResult(Point[] testResult){
        // 采样10个1，1位置正确的关键点
        Set<String> rightPString = pointsToString(new Point[]{
            new Point(1,2),new Point(3,5),new Point(2,9),new Point(3,10),new Point(10,3),
            new Point(8,6),new Point(10,1),new Point(5,1),new Point(5,4),new Point(4,6),
        });
        // 采样10个1，1位置错误的关键点
        Set<String> wrongPString = pointsToString(new Point[]{
                new Point(1,0),new Point(4,2),new Point(4,11),new Point(11,10),new Point(8,2),
                new Point(5,6),new Point(6,3),new Point(3,6),new Point(4,9),new Point(7,9),
        });
        Set<String> testPString = pointsToString(testResult);
        if (testPString.containsAll(rightPString) && testPString.stream().noneMatch(wrongPString::contains)){
            return  true;
        }
        return false;
    }

    private Set<String> pointsToString(Point[] points){
        HashSet<String> pStr = new HashSet<>();
        for (Point point : points) {
            pStr.add(point.getX() + "," + point.getY());
        }

        return pStr;
    }
}