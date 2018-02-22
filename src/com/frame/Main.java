package com.frame;

import java.awt.*;

/**
 * @ Author: 陌北有棵树
 * @ Date: 2018/1/26 18:13
 * @ Description:
 */
public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcome",500,500);
        });
    }

}
