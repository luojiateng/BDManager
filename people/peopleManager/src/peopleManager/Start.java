package peopleManager;


import peopleManager.view.base.BaseFrame;

public class Start {
    public static void main(String[] args) {
        BaseFrame baseFrame = new BaseFrame();
        baseFrame.setSize(1160, 595);
        baseFrame.setLocation(380, 290);
        baseFrame.setVisible(true);
        baseFrame.setResizable(false);
    }
}
