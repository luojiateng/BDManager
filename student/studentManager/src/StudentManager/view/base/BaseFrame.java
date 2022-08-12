package StudentManager.view.base;

import StudentManager.view.subPanel.ClassInfoPanel;
import StudentManager.view.subPanel.FacultyPanel;
import StudentManager.view.subPanel.MajorPanel;
import StudentManager.view.subPanel.StudentPanel;

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
        setTitle("学籍管理系统");
        //--------------------------------------
        // 菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        JMenu choose = new JMenu("选项");
        JMenuItem student = new JMenuItem("学生");
        JMenuItem classInfo = new JMenuItem("班级");
        JMenuItem major = new JMenuItem("专业");
        JMenuItem faculty = new JMenuItem("学院");
        choose.add(student);
        choose.add(classInfo);
        choose.add(major);
        choose.add(faculty);
        jMenuBar.add(choose);
        setJMenuBar(jMenuBar);
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "stu");

            }
        });
        classInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "class");
            }
        });
        major.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "major");
            }
        });
        faculty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "fac");

            }
        });

        mainPanel = new JPanel();
        mainPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        //设置窗体中的卡片布局
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        StudentPanel studentPanel = new StudentPanel();
        ClassInfoPanel classInfoPanel = new ClassInfoPanel();
        MajorPanel majorPanel = new MajorPanel();
        FacultyPanel facultyPanel = new FacultyPanel();

        mainPanel.setLayout(cardLayout);

        mainPanel.add(studentPanel, "stu");
        mainPanel.add(classInfoPanel, "class");
        mainPanel.add(majorPanel, "major");
        mainPanel.add(facultyPanel, "fac");
    }

}
