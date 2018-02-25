package com.MoveBoxData;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;


public class AlgoVisualizer {


    private GameData data;        // 数据
    private AlgoFrame frame;    // 视图
    private static int DELAY = 5;
    private static int blockSide = 80;

    public AlgoVisualizer(String filename){

        data = new GameData(filename);
        int sceneWidth = data.M() * blockSide;
        int sceneHeight = data.N() * blockSide;

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Move the Box Solver", sceneWidth,sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        setData();

    }

    private void setData(){
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter { }
    private class AlgoMouseListener extends MouseAdapter { }

    public static void main(String[] args) {

        String filename = "level/boston_09.txt";

        AlgoVisualizer vis = new AlgoVisualizer(filename);
    }

}

