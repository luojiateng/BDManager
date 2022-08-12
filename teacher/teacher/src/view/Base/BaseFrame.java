package view.Base;

import view.school.DeptPanel;
import view.school.PositionPanel;
import view.school.TitlePanel;
import view.teacher.TeacherPanel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主窗体
 */

public class BaseFrame extends JFrame {
    private JLabel lblMsg = null;
    //受保护的子类才能直接访问
    protected JPanel mainPanel = null;

    protected JPanel queryPanel;
    private JTextField textField;
    protected JLabel lblPageCount;
    protected JTable table;
    protected JButton btnDelete;
    protected JButton btnUpdate;
    protected JButton btnInsert;

    public BaseFrame() {
        CardLayout cardLayout = new CardLayout();
        setTitle("高校教师信息管理系统");
        // 菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        JMenu choose = new JMenu("选项");
        JMenuItem teacher = new JMenuItem("教师管理");
        JMenuItem dept = new JMenuItem("部门管理");
        JMenuItem position = new JMenuItem("职务管理");
        JMenuItem title = new JMenuItem("职称管理");
        choose.add(teacher);
        choose.add(dept);
        choose.add(position);
        choose.add(title);
        jMenuBar.add(choose);
        setJMenuBar(jMenuBar);
        teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "teacher");
            }
        });
        dept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "dept");
            }
        });
        position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "postion");
            }
        });
        title.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "title");
            }
        });
        mainPanel = new JPanel();
        mainPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        //设置窗体中的卡片布局
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        TeacherPanel teacherPanel = new TeacherPanel();
        DeptPanel deptManage = new DeptPanel();
        PositionPanel positionManager = new PositionPanel();
        TitlePanel titleManager = new TitlePanel();

        mainPanel.setLayout(cardLayout);
        mainPanel.add(teacherPanel, "teacher");
        mainPanel.add(deptManage, "dept");
        mainPanel.add(positionManager, "postion");
        mainPanel.add(titleManager, "title");
    }

}
