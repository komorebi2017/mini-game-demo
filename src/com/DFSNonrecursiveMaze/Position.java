package com.DFSNonrecursiveMaze;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/2/2 19:36
 * @ Description:
 */
public class Position {
    private int x,y;

    private Position prev;

    public Position(int x, int y,Position prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

    public Position(int x, int y){
        this(x,y,null);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Position getPrev() {
        return prev;
    }
}
