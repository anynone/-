package com.tanikawa.algorithm.flood_fill.impl;

import com.sun.scenario.effect.Flood;
import flood_fill.FloodFill;
import flood_fill.impl.*;
import flood_fill.TestData;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;

public class FloodFillTest {

    @Test
     void searchRectPointTest() {

        // 实现类demo
//        DemoImpl demo = new DemoImpl();
        // 张育豪
//        FloodFill demo = new ZhangYuHao();
//        FloodFill demo = new LiuRuYan();
//        FloodFill demo = new LiuWenJing();
//        FloodFill demo = new WuZhiMin();
//        FloodFill demo = new WangJinYang();
//        FloodFill demo = new HanLongGang();
        FloodFill demo = new XingZhiBin();


        // 结果
        boolean isRigth = true;
        for (int i = 0; i < 10000; i++) {
            Point randomPoint = getRandomPoint();
            isRigth = checkResult(demo.searchRectPoint(TestData.testData, randomPoint), randomPoint, false);
//            System.out.println("验证点：" + randomPoint + "," + "正确性检测:" +isRigth);
            if (!isRigth){
                System.out.println("未通过正确性检测");
                System.exit(0);
                break;
            }
        }

        System.out.println("已通过正确性检测");
        System.out.println("开始压测性能");
//        System.exit(0);
        //性能
        long totalTime = 0L;
        for (int j = 0; j < 10; j++) {
        long startMilli = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                demo.searchRectPoint(TestData.testData, new Point(1, 1));
            }
            long durationMill = System.currentTimeMillis() - startMilli;
            totalTime += durationMill;
        }

        System.out.println("10次平均时间:" + (totalTime/10));
    }



    private boolean checkResult(Point[] testResult, Point testPoint, boolean revert){
        // 选取验证后的算法
        FloodFill wangJinYang = new HanLongGang();
        Point[] rightPoint = wangJinYang.searchRectPoint(TestData.testData, testPoint);

        Set<String> testPString = null;
        if (revert){
            testPString = pointsToStringRev(testResult);
        }else{
            testPString = pointsToStringRev(testResult);
        }
        if (testPString.containsAll(pointsToString(rightPoint))){
            return  true;
        }
        System.out.println("检测点:" + testPoint);
        System.out.println("待检测序列:" + new ArrayList<>(testPString));
        System.out.println("正确序列：" + new ArrayList<>(pointsToString(rightPoint)));
        return false;
    }

    private Set<String> pointsToString(Point[] points){
        TreeSet<String> pStr = new TreeSet<>();
        for (Point point : points) {
            pStr.add((int)point.getX() + "," + (int)point.getY());
        }

        return pStr;
    }

    private Set<String> pointsToStringRev(Point[] points){
        TreeSet<String> pStr = new TreeSet<>();
        for (Point point : points) {
            pStr.add((int)point.getY() + "," + (int)point.getX());
        }


        return pStr;
    }

    private Point getRandomPoint(){
        double x = Math.random();
        double y = Math.random();
        return new Point((int)Math.round(x * 11), (int)Math.round(y * 11));
    }
}