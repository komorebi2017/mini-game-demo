package com.MergeSortVisualization;

import javax.swing.*;
import java.awt.*;


/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/26 17:53
 * @ Description:
 */
public class AlgoFrame extends JFrame {

    /* 可绘制区域的宽和高 */
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        //setSize(canvasWidth, canvasHeight);
        AlgoCanvas canvas = new AlgoCanvas();

        // canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        setContentPane(canvas);
        /* 根据加载进来的内容进行布局的整理，自动调整AlgoFrame大小 */
        pack();

        /* 点击×窗口自动关闭 */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 不能自动调整窗口大小*/
        //setResizable(false);

        setVisible(true);

        // System.out.println(getContentPane().getBounds());
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    private MergeSortData data;
    public void render(MergeSortData data){
        this.data = data;
        repaint();
    }


    /* JPanel： 是一个面板，图形的绘制都发生在这个面板上 */
    private class AlgoCanvas extends JPanel{


        /* Graphics g： 绘制的上下文环境，连接了用户上层可以看见的控件，比如面板和底层绘制需要的内容
        *               实际上真正的绘制函数全部定义在 Graphics g上*/
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 具体绘制
            int w = canvasWidth / data.N();
            for (int i = 0; i < data.N(); i++){
                if (i >= data.l && i<= data.r){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Green);
                }else {
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Grey);
                }
                if (i >= data.l && i<=data.mergeIndex){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Red);
                }
                AlgoVisHelper.fillRectangle(g2d,i*w,canvasHeight - data.get(i),w-1,data.get(i));
            }
        }




        /* 返回画布大小 */
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
