package StudentManager.view.updataFrame;

import StudentManager.dao.ClassDao;
import StudentManager.dao.MajorDao;
import StudentManager.pojo.ClassInfo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassInfoUpdataFrame extends JFrame {

    private JTextField classId;
    private JTextField className;
    private JTextField studentNumber;
    private JTextField boyNumber;
    private JTextField grilNumber;
    private JComboBox majors;

    public ClassInfoUpdataFrame(String name) {
        setTitle("修改班级信息");
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

        JLabel l1 = new JLabel("修改班级信息");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(290, 10, 182, 52);
        mainPanel.add(l1);
//--------------------------------------------------------------------
        ClassDao classDao = new ClassDao();
        ClassInfo classByName = null;
        for (ClassInfo classInfo : classDao.getClassByName(name)) {
            classByName = classInfo;
            break;
        }
        JLabel l2 = new JLabel("班级编号:");
        l2.setBounds(181, 20, 73, 36);
        dataPanel.add(l2);
        classId = new JTextField();
        classId.setColumns(10);
        classId.setBounds(240, 30, 211, 21);
        classId.setEditable(false);
        dataPanel.add(classId);
        classId.setText(classByName.getClassId() + "");

        JLabel l3 = new JLabel("班级命名:");
        l3.setBounds(181, 60, 73, 36);
        dataPanel.add(l3);
        className = new JTextField();
        className.setColumns(10);
        className.setBounds(240, 70, 211, 21);
        className.setText(classByName.getClassName());
        dataPanel.add(className);

        JLabel l4 = new JLabel("学生总数:");
        l4.setBounds(181, 100, 73, 36);
        dataPanel.add(l4);
        studentNumber = new JTextField();
        studentNumber.setColumns(10);
        studentNumber.setBounds(240, 110, 211, 21);
        studentNumber.setText(classByName.getStudentNumber() + "");
        studentNumber.setEditable(false);
        dataPanel.add(studentNumber);

        JLabel l7 = new JLabel("女生总数:");
        l7.setBounds(181, 180, 73, 36);
        dataPanel.add(l7);
        grilNumber = new JTextField();
        grilNumber.setColumns(10);
        grilNumber.setBounds(240, 190, 211, 21);
        grilNumber.setText(classByName.getGrilNumber() + "");
        grilNumber.setEditable(false);
        dataPanel.add(grilNumber);

        JLabel l5 = new JLabel("男生总数:");
        l5.setBounds(181, 140, 73, 36);
        dataPanel.add(l5);
        boyNumber = new JTextField();
        boyNumber.setColumns(10);
        boyNumber.setBounds(240, 150, 211, 21);
        boyNumber.setText(classByName.getBoyNumber() + "");
        boyNumber.setEditable(false);
        dataPanel.add(boyNumber);


        JLabel l6 = new JLabel("专业:");
        l6.setBounds(181, 220, 73, 36);
        dataPanel.add(l6);
        majors = new JComboBox();
        majors.setBounds(240, 230, 211, 21);
        dataPanel.add(majors);
        MajorDao majorDao = new MajorDao();
        majors.addItem(classByName.getMajor());
        for (String s : majorDao.getAllMajorName()) {
            majors.addItem(s);
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

                String idText = classId.getText();
                String nameText = className.getText();
                String maojorText = majors.getSelectedItem().toString();


                if (nameText == null || "".equals(nameText.trim())) {
                    JOptionPane.showMessageDialog(null, "班级名称不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (maojorText == null || "".equals(maojorText.trim())) {
                    JOptionPane.showMessageDialog(null, "专业不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ClassInfo classInfo = new ClassInfo(Integer.parseInt(idText), nameText, maojorText);

                //i为影响数据库的行数
                int i = classDao.updataClass(classInfo);
                System.out.println(i);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "修改班级成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "修改班级失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
