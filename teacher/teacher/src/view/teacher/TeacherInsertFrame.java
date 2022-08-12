package view.teacher;

import dao.impl.DeptDaoImpl;
import dao.impl.PostionDaoImpl;
import dao.impl.TeacherDaoImpl;
import dao.impl.TitleDaoImpl;
import pojo.Teacher;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class TeacherInsertFrame extends JFrame {
    private JTextField teacherId;
    private JTextField teacherName;
    private JRadioButton boy;
    private JRadioButton gril;
    private JTextField birthday;
    private JTextField email;
    private JComboBox deptName;
    private JComboBox positName;
    private JComboBox titleName;

    public TeacherInsertFrame() {
        setTitle("新增教师信息");
        setSize(720, 500);
        setLocation(850, 325);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        //主窗体容器
        JPanel mainPanel = (JPanel) getContentPane();
        //内部容器
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        dataPanel.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        dataPanel.setBounds(23, 53, 658, 315);
        mainPanel.add(dataPanel);

        JButton quitBtn = new JButton("取消");
        quitBtn.setBounds(425, 403, 93, 23);
        mainPanel.add(quitBtn);

        JButton btnOk = new JButton("保存");
        btnOk.setBounds(569, 403, 93, 23);
        mainPanel.add(btnOk);

        JLabel l1 = new JLabel("新增学生信息");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(290, 10, 182, 52);
        mainPanel.add(l1);
//--------------------------------------------------------------------
        JLabel l2 = new JLabel("编号:");
        l2.setBounds(30, 30, 73, 36);
        dataPanel.add(l2);
        teacherId = new JTextField();
        teacherId.setColumns(10);
        teacherId.setBounds(90, 40, 211, 21);
        teacherId.setEditable(false);
        dataPanel.add(teacherId);
        teacherId.setText(new TeacherDaoImpl().getNewTeacherId() + "");

        JLabel l3 = new JLabel("姓名:");
        l3.setBounds(30, 80, 73, 36);
        dataPanel.add(l3);
        teacherName = new JTextField();
        teacherName.setColumns(10);
        teacherName.setBounds(90, 90, 211, 21);
        dataPanel.add(teacherName);

        //性别
        JLabel l4 = new JLabel("性别:");
        l4.setBounds(30, 130, 73, 36);
        dataPanel.add(l4);
        ButtonGroup buttonGroup = new ButtonGroup();
        boy = new JRadioButton("男", true);
        boy.setBounds(80, 138, 63, 23);
        dataPanel.add(boy);
        gril = new JRadioButton("女");
        gril.setBounds(160, 138, 63, 23);
        dataPanel.add(gril);
        buttonGroup.add(boy);
        buttonGroup.add(gril);

        JLabel l5 = new JLabel("生日:");
        l5.setBounds(30, 180, 73, 36);
        dataPanel.add(l5);
        birthday = new JTextField();
        birthday.setColumns(10);
        birthday.setBounds(90, 190, 211, 21);
        dataPanel.add(birthday);

        JLabel l6 = new JLabel("邮箱:");
        l6.setBounds(30, 230, 73, 36);
        dataPanel.add(l6);
        email = new JTextField();
        email.setColumns(10);
        email.setBounds(90, 240, 211, 21);
        dataPanel.add(email);

        JLabel l7 = new JLabel("部门:");
        l7.setBounds(360, 30, 73, 36);
        dataPanel.add(l7);
        deptName = new JComboBox();
        deptName.setBounds(420, 40, 211, 21);
        dataPanel.add(deptName);
        deptName.addItem("");
        for (String s : new DeptDaoImpl().getAllDeptName()) {
            deptName.addItem(s);
        }

        JLabel l8 = new JLabel("职务:");
        l8.setBounds(360, 80, 73, 36);
        dataPanel.add(l8);
        positName = new JComboBox();
        positName.setBounds(420, 90, 211, 21);
        dataPanel.add(positName);
        positName.addItem("");
        for (String s : new PostionDaoImpl().getAllPostionName()) {
            positName.addItem(s);
        }

        JLabel l9 = new JLabel("职称:");
        l9.setBounds(360, 130, 73, 36);
        dataPanel.add(l9);
        titleName = new JComboBox();
        titleName.setBounds(420, 140, 211, 21);
        dataPanel.add(titleName);
        titleName.addItem("");
        for (String s : new TitleDaoImpl().getAllTitleName()) {
            titleName.addItem(s);
        }


        //退出键
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //确认回车
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idText = teacherId.getText();
                String nameText = teacherName.getText();

                String gender = null;
                Enumeration<AbstractButton> elements = buttonGroup.getElements();
                while (elements.hasMoreElements()) {
                    AbstractButton btn = elements.nextElement();
                    if (btn.isSelected()) {
                        gender = btn.getText();
                        break;
                    }
                }
                String birthdayText = birthday.getText();
                String emailText = email.getText();
                String dept = deptName.getSelectedItem().toString();
                String posit = positName.getSelectedItem().toString();
                String title = titleName.getSelectedItem().toString();


                if (nameText == null || "".equals(nameText.trim())) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (birthdayText == null || "".equals(birthdayText.trim())) {
                    JOptionPane.showMessageDialog(null, "生日不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (emailText == null || "".equals(emailText.trim())) {
                    JOptionPane.showMessageDialog(null, "邮箱不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (dept == null || "".equals(dept.trim())) {
                    JOptionPane.showMessageDialog(null, "部门不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (posit == null || "".equals(posit.trim())) {
                    JOptionPane.showMessageDialog(null, "职位不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (title == null || "".equals(title.trim())) {
                    JOptionPane.showMessageDialog(null, "职称不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Teacher teacher = new Teacher(Integer.parseInt(idText), nameText, gender, birthdayText, emailText,
                        title, dept, posit);
                //i为影响数据库的行数
                int i = new TeacherDaoImpl().saveTeacher(teacher);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "新增教师信息成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "新增教师信息失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
}
