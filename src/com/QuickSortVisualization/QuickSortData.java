package com.QuickSortVisualization;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/26 20:53
 * @ Description:
 */

public class QuickSortData {

    private int[] numbers;

    public int l,r;

    public int curPivot;

    public int curElement;

    public boolean[] fixedPivot;

    public QuickSortData(int N, int randomBound) {
        numbers = new int[N];
        fixedPivot = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
            fixedPivot[i] = false;
        }
    }

    public int N(){
        return numbers.length;
    }

    /* 根据索引位置获得数据 */
    public int get(int index){
        if(index < 0 || index >= numbers.length){
            throw new IllegalArgumentException("索引位置越界");
        }
        return numbers[index];
    }

    public void swap(int i,int j){
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}
