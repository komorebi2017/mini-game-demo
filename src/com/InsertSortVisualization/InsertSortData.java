package com.InsertSortVisualization;

import java.util.Arrays;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/29 16:36
 * @ Description:
 */
public class InsertSortData {

    public enum Type{
        Default,
        NearlyOrdered
    }

    private int[] numbers;

    /* [0....orderedIndex) 是有序的 */
    public int orderedIndex = -1;

    /* 当前正在处理的元素的索引 */
    public int currentIndex = -1;



    public InsertSortData(int N, int randomBound,Type dataType){
        numbers = new int[N];
        for (int i = 0; i < N; i++){
            numbers[i] = (int)(Math.random()*randomBound)+1;
        }
        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.02 * N);
            for (int i = 0; i < swapTime; i++){
                int a = (int)(Math.random()*N);
                int b = (int)(Math.random()*N);
                swap(a,b);
            }
        }
    }

    public InsertSortData(int N, int randomBound){
        this(N,randomBound,Type.Default);
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
