package com.DFSNonrecursiveMaze;

import java.awt.*;
import java.util.Stack;

public class AlgoVisualizer {

    private static int DELAY = 5;
    private static int blockSide = 8;

    private MazeData data;
    private AlgoFrame frame;

    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public AlgoVisualizer(String mazeFile){

        // 初始化数据
        data = new MazeData(mazeFile);
        int sceneHeight = data.N() * blockSide;
        int sceneWidth = data.M() * blockSide;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Maze Solver Visualization", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    public void run(){
        setData(-1,-1,false);
        Stack<Position> stack  = new Stack<Position>();
        Position entrance = new Position(data.getEntranceX(),data.getEntranceY());
        stack.push(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;
        boolean isSolved = false;
        /* 跳出while循环有两种情况，一种是isSolved=true，成功后跳出
         * 还有栈为空后跳出，isSolved = false */
        while (!stack.empty()){
            Position curPos = stack.pop();
            setData(curPos.getX(), curPos.getY(), true);
            if(curPos.getX() == data.getExitX() && curPos.getY() == data.getExitY()){
                isSolved = true;
                findPath(curPos);
                break;
            }
            for (int i = 0; i < 4; i++){
                int newX = curPos.getX() + d[i][0];
                int newY = curPos.getY() + d[i][1];

                if( data.inArea(newX,newY)
                        &&  !data.visited[newX][newY]
                        &&  data.getMaze(newX,newY) == MazeData.ROAD){
                    stack.push(new Position(newX,newY,curPos));
                    data.visited[newX][newY] = true;
                }
            }
        }
        if(!isSolved){
            System.out.println("迷宫无解");
        }
        setData(-1,-1,false);
    }

    private void findPath(Position des){
        Position cur = des;
        while (cur != null){
            data.result[cur.getX()][cur.getY()] = true;
            cur = cur.getPrev();
        }
    }

    /*从（x，y）的位置开始求解迷宫，如果求解成功，返回true，否则返回false*/




    private void setData(int x,int y,boolean isPath){
        if(data.inArea(x,y)){
            data.path[x][y] = isPath;
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        String mazeFile = "maze_101_101.txt";

        AlgoVisualizer vis = new AlgoVisualizer(mazeFile);

    }
}