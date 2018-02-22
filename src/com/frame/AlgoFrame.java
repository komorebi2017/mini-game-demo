package com.frame;
import java.awt.*;
import javax.swing.*;


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
        setResizable(false);

        setVisible(true);

        // System.out.println(getContentPane().getBounds());
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    /* JPanel： 是一个面板，图形的绘制都发生在这个面板上 */
    private class AlgoCanvas extends JPanel{


        /* Graphics g： 绘制的上下文环境，连接了用户上层可以看见的控件，比如面板和底层绘制需要的内容
        *               实际上真正的绘制函数全部定义在 Graphics g上*/
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 具体绘制
            AlgoVisHelper.setColor(g2d, Color.BLUE);
            AlgoVisHelper.fillCircle(g2d, canvasWidth/2,canvasHeight/2,200);

            AlgoVisHelper.setStrokeWidth(g2d,5);
            AlgoVisHelper.setColor(g2d, Color.RED);
            AlgoVisHelper.strokeCircle(g2d, canvasWidth/2,canvasHeight/2,200);
        }


        /* 返回画布大小 */
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
