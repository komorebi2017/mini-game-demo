package com.SelectionSortVisualization;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/29 15:42
 * @ Description: 选择排序的数据模型
 */

public class SelectionSortData {

    private int[] numbers;

    /* [0....orderedIndex) 是有序的 */
    public int orderedIndex = -1;

    /* 当前找到的最小元素的索引 */
    public int currentMinIndex = -1;

    /* 当前正在比较的元素索引 */
    public int currentCompareIndex = -1;

    public SelectionSortData(int N, int randomBound){
        numbers = new int[N];
        for (int i = 0; i < N; i++){
            numbers[i] = (int)(Math.random()*randomBound)+1;
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
