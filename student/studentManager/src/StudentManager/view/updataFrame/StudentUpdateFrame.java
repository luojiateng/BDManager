package StudentManager.view.updataFrame;

import StudentManager.dao.ClassDao;
import StudentManager.dao.StudentDao;
import StudentManager.pojo.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class StudentUpdateFrame extends JFrame {
    private JTextField studentId;
    private JTextField studentName;
    private JRadioButton boy;
    private JRadioButton gril;
    private JTextField GPA;
    private JTextField award;
    private JTextField sacution;
    private JComboBox classs;
    private JTextField majors;
    private JTextField facultys;

    public StudentUpdateFrame(String name) {
        setTitle("修改学生信息");
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

        JLabel l1 = new JLabel("修改学生信息");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(290, 10, 182, 52);
        mainPanel.add(l1);
//--------------------------------------------------------------------
        StudentDao studentDao = new StudentDao();
        Student changeStudent = null;
        for (Student student : studentDao.getStudentByName(name)) {
            changeStudent = student;
            break;
        }

        JLabel l2 = new JLabel("学号:");
        l2.setBounds(181, 60, 73, 36);
        dataPanel.add(l2);
        studentId = new JTextField();
        //学号一经指定，不可改变
        studentId.setEditable(false);
        studentId.setColumns(10);
        studentId.setBounds(240, 70, 211, 21);
        studentId.setText(changeStudent.getStudentId() + "");
        dataPanel.add(studentId);

        JLabel l3 = new JLabel("姓名:");
        l3.setBounds(181, 100, 73, 36);
        dataPanel.add(l3);
        studentName = new JTextField();
        studentName.setColumns(10);
        studentName.setBounds(240, 110, 211, 21);
        studentName.setText(changeStudent.getStudentName());
        dataPanel.add(studentName);

        //性别
        JLabel l4 = new JLabel("性别:");
        l4.setBounds(181, 140, 73, 36);
        dataPanel.add(l4);
        ButtonGroup buttonGroup = new ButtonGroup();
        boolean grilFlag = true;
        boolean boyFlag = true;
        if ("男".equals(changeStudent.getGender())) {
            grilFlag = false;
        } else if ("女".equals(changeStudent.getGender())) {
            boyFlag = false;
        }
        boy = new JRadioButton("男", boyFlag);
        boy.setBounds(240, 145, 63, 23);
        dataPanel.add(boy);
        gril = new JRadioButton("女", grilFlag);
        gril.setBounds(300, 145, 63, 23);
        dataPanel.add(gril);
        buttonGroup.add(boy);
        buttonGroup.add(gril);

        //学院
        JLabel l5 = new JLabel("学院:");
        l5.setBounds(181, 180, 73, 36);
        dataPanel.add(l5);
        facultys = new JTextField();
        facultys.setBounds(240, 190, 211, 21);
        facultys.setText(changeStudent.getFaculty());
        facultys.setEditable(false);
        dataPanel.add(facultys);

        JLabel l6 = new JLabel("专业:");
        l6.setBounds(181, 220, 73, 36);
        dataPanel.add(l6);
        majors = new JTextField();
        majors.setBounds(240, 230, 211, 21);
        majors.setText(changeStudent.getMajor());
        majors.setEditable(false);
        dataPanel.add(majors);

        JLabel l7 = new JLabel("班级:");
        l7.setBounds(181, 260, 73, 36);
        dataPanel.add(l7);
        classs = new JComboBox();
        classs.setBounds(240, 270, 211, 21);
        dataPanel.add(classs);
        ClassDao classDao = new ClassDao();
        classs.addItem(changeStudent.getClassInfo());
        for (String s : classDao.getAllClassName()) {
            classs.addItem(s);
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

                String idText = studentId.getText();
                String nameText = studentName.getText();
                String gender = null;
                Enumeration<AbstractButton> elements = buttonGroup.getElements();
                while (elements.hasMoreElements()) {
                    AbstractButton btn = elements.nextElement();
                    if (btn.isSelected()) {
                        gender = btn.getText();
                        break;
                    }
                }
                String classInfoText = classs.getSelectedItem().toString();


                if (nameText == null || "".equals(nameText.trim())) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (classInfoText == null || "".equals(classInfoText.trim())) {
                    JOptionPane.showMessageDialog(null, "班级不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                Student student = new Student(Integer.parseInt(idText), nameText, gender,
                        classInfoText);
                //i为影响数据库的行数
                int i = studentDao.updataStudent(student);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "修改学生信息成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "修改学生信息失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
