package com.MazeGeneration;

import java.awt.*;

import static sun.misc.PostVMInitHook.run;

public class AlgoVisualizer {

    private static int blockSize = 8;
    private static int DELAY = 5;
    private MazeData data;
    private AlgoFrame frame;

    public AlgoVisualizer(int N,int M){
        /* 初始化数据 */
        data = new MazeData(N,M);
        int sceneHeight = data.N() * blockSize;
        int sceneWidth = data.M() * blockSize;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("生成迷宫", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run(){
        setData();
    }
    private void setData(){
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }
    public static void main(String[] args) {
        int N = 101;
        int M = 101;

        AlgoVisualizer vis = new AlgoVisualizer(N,M);

    }
}