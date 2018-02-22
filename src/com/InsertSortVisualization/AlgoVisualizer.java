package com.InsertSortVisualization;



import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/26 17:56
 * @ Description:
 */
public class AlgoVisualizer {


    private static int DELAY = 100;


    private InsertSortData data;        // 数据
    private AlgoFrame frame;               // 视图


    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N,InsertSortData.Type dataType){

        // 初始化数据
        data = new InsertSortData(N, sceneHeight,dataType);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("插入排序可视化", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        this(sceneWidth,sceneHeight,N,InsertSortData.Type.Default);
    }


    // 动画逻辑
    private void run(){
        setData(0,-1);
        for (int i = 1; i < data.N(); i++){
            setData(i,i);
            for (int j = i; j > 0 && data.get(j)< data.get(j-1); j--){
                data.swap(j,j-1);
                setData(i+1,j-1);
            }
        }
        setData(data.N(),-1);


    }

    private void setData(int orderedIndex,int currentIndex){
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        // TODO: 根据需要设置其他参数，初始化visualizer
         AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N,InsertSortData.Type.NearlyOrdered);
    }

}
