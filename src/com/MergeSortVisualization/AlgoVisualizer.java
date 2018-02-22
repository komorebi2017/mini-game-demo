package com.MergeSortVisualization;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/26 17:56
 * @ Description:
 */
public class AlgoVisualizer {


    private static int DELAY = 200;

    private MergeSortData  data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int N){

        // 初始化数据
        data = new MergeSortData(N,sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("归并排序可视化", sceneWidth, sceneHeight);

            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        setData(-1,-1,-1);
        mergeSort(0,data.N()-1);
        setData(0,data.N()-1,data.N()-1);
    }

    private void mergeSort(int l,int r){
        if(l >= r){
            return;
        }
        setData(l,r,-1);
        int mid = (l+r)/2;
        mergeSort(l,mid);
        mergeSort(mid+1,r);
        merge(l,mid,r);

    }

    private void merge(int l,int mid,int r){

        int[] aux = Arrays.copyOfRange(data.numbers,l,r+1);
        int i = l;
        int j = mid + 1;
        for (int k=l; k<=r; k++){
            if (i > mid){
                data.numbers[k] = aux[j-l];
                j++;
            }else if(j > r) {
                data.numbers[k] = aux[i-l];
                i++;
            }
            else if(aux[i-l] < aux[j-l]){
                data.numbers[k] = aux[i-l];
                i++;
            }else {
                data.numbers[k] = aux[j-l];
                j++;
            }
            setData(l,r,k);
        }
    }

    private void setData(int l,int r,int mergeIndex){
        data.l = l;
        data.r = r;
        data.mergeIndex =mergeIndex;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N);
    }

}
