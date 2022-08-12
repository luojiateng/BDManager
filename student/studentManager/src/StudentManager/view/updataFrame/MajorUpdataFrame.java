package StudentManager.view.updataFrame;

import StudentManager.dao.FacultyDao;
import StudentManager.dao.MajorDao;
import StudentManager.pojo.Major;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MajorUpdataFrame extends JFrame {

    private JTextField classId;
    private JTextField className;
    private JTextField studentNumber;
    private JTextField boyNumber;
    private JTextField grilNumber;
    private JComboBox majors;
    private JComboBox facultys;

    public MajorUpdataFrame(String name) {
        setTitle("修改专业信息");
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

        JLabel l1 = new JLabel("修改专业信息");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(290, 10, 182, 52);
        mainPanel.add(l1);
//--------------------------------------------------------------------

        MajorDao majorDao = new MajorDao();
        Major majorByName = null;
        for (Major major : majorDao.getMajorByName(name)) {
            majorByName = major;
            break;
        }


        JLabel l2 = new JLabel("专业编号:");
        l2.setBounds(181, 20, 73, 36);
        dataPanel.add(l2);
        classId = new JTextField();
        classId.setColumns(10);
        classId.setBounds(240, 30, 211, 21);
        classId.setEditable(false);
        dataPanel.add(classId);
        classId.setText(majorByName.getMajorId() + "");

        JLabel l3 = new JLabel("专业命名:");
        l3.setBounds(181, 60, 73, 36);
        dataPanel.add(l3);
        className = new JTextField();
        className.setColumns(10);
        className.setBounds(240, 70, 211, 21);
        className.setText(majorByName.getMajorName());
        dataPanel.add(className);

        JLabel l4 = new JLabel("学生总数:");
        l4.setBounds(181, 100, 73, 36);
        dataPanel.add(l4);
        studentNumber = new JTextField();
        studentNumber.setColumns(10);
        studentNumber.setBounds(240, 110, 211, 21);
        studentNumber.setText(majorByName.getStudentNumber() + "");
        studentNumber.setEditable(false);
        dataPanel.add(studentNumber);

        JLabel l7 = new JLabel("女生总数:");
        l7.setBounds(181, 140, 73, 36);
        dataPanel.add(l7);
        grilNumber = new JTextField();
        grilNumber.setColumns(10);
        grilNumber.setBounds(240, 150, 211, 21);
        grilNumber.setText(majorByName.getGirlNumber() + "");
        grilNumber.setEditable(false);
        dataPanel.add(grilNumber);

        JLabel l5 = new JLabel("男生总数:");
        l5.setBounds(181, 180, 73, 36);
        dataPanel.add(l5);
        boyNumber = new JTextField();
        boyNumber.setColumns(10);
        boyNumber.setBounds(240, 190, 211, 21);
        boyNumber.setText(majorByName.getBoyNumber() + "");
        boyNumber.setEditable(false);
        dataPanel.add(boyNumber);


        JLabel l9 = new JLabel("学院:");
        l9.setBounds(181, 220, 73, 36);
        dataPanel.add(l9);
        facultys = new JComboBox();
        facultys.setBounds(240, 230, 211, 21);
        dataPanel.add(facultys);
        FacultyDao facultyDao = new FacultyDao();
        facultys.addItem(majorByName.getFacultyName());
        for (String s : facultyDao.getAllFacultyName()) {
            facultys.addItem(s);
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
                String boyNumberText = boyNumber.getText();
                String grilNumberText = grilNumber.getText();
                String facultyText = facultys.getSelectedItem().toString();

                Integer student = Integer.parseInt(boyNumberText) + Integer.parseInt(grilNumberText);

                if (nameText == null || "".equals(nameText.trim())) {
                    JOptionPane.showMessageDialog(null, "专业名称不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (facultyText == null || "".equals(facultyText.trim())) {
                    JOptionPane.showMessageDialog(null, "学院不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (boyNumberText == null || "".equals(boyNumberText.trim())) {
                    boyNumberText = "0";
                }
                if (grilNumberText == null || "".equals(grilNumberText.trim())) {
                    grilNumberText = "0";
                }

                Major major = new Major(Integer.parseInt(idText), nameText, student,
                        Integer.parseInt(boyNumberText), Integer.parseInt(grilNumberText), facultyText);

                //i为影响数据库的行数
                int i = majorDao.updataMajor(major);
                System.out.println(i);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "修改专业成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "修改专业失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
