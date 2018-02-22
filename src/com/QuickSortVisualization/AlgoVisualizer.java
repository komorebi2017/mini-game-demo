package com.QuickSortVisualization;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/26 17:56
 * @ Description:
 */
public class AlgoVisualizer {

    private QuickSortData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int N){

        // 初始化数据
        data = new QuickSortData(N,sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        quickSort(0,data.N());
    }

    private void quickSort(int l,int r){

        if( l >= r){
            return;
        }
        int p = partition(l,r);
        quickSort(l, p - 1);
        quickSort(p+1,r);
    }

    private int partition(int l, int r){
        int j = l;
        for (int i=l; i<=r; i++){
            if(data.get(i) < j){
                data.swap(j,i);
            }
            data.swap(j,l);
        }
        return j;

    }



    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N);
    }

}
