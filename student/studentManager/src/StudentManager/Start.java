package StudentManager;

import StudentManager.view.base.BaseFrame;

import javax.swing.*;

public class Start extends JFrame {


    //程序启动入口
    public static void main(String[] args) {
        BaseFrame baseFrame = new BaseFrame();
        //设置主窗体大小
        baseFrame.setSize(1111, 500);
        //设置主窗体位置
        baseFrame.setLocation(484, 293);
        //设置主窗体可见
        baseFrame.setVisible(true);
        //设置主窗体不可放大
        baseFrame.setResizable(false);
    }


}
