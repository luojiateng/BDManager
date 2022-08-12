package StudentManager.view.createFrame;

import StudentManager.dao.FacultyDao;
import StudentManager.dao.MajorDao;
import StudentManager.pojo.Major;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMajorFrame extends JFrame {
    private JTextField classId;
    private JTextField className;
    private JComboBox facultys;

    public CreateMajorFrame() {
        setTitle("新增专业");
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

        JLabel l1 = new JLabel("新增专业");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(290, 10, 182, 52);
        mainPanel.add(l1);
//--------------------------------------------------------------------
        MajorDao majorDao = new MajorDao();

        JLabel l2 = new JLabel("专业编号:");
        l2.setBounds(181, 20, 73, 36);
        dataPanel.add(l2);
        classId = new JTextField();
        classId.setColumns(10);
        classId.setBounds(240, 30, 211, 21);
        //编号只能由系统指定分配
        classId.setEditable(false);
        dataPanel.add(classId);
        int index = majorDao.getIndex();
        classId.setText(index + "");

        JLabel l3 = new JLabel("专业命名:");
        l3.setBounds(181, 60, 73, 36);
        dataPanel.add(l3);
        className = new JTextField();
        className.setColumns(10);
        className.setBounds(240, 70, 211, 21);
        dataPanel.add(className);


        //学院
        JLabel l5 = new JLabel("所属学院:");
        l5.setBounds(181, 100, 73, 36);
        dataPanel.add(l5);
        facultys = new JComboBox();
        facultys.setBounds(240, 110, 211, 21);
        dataPanel.add(facultys);
        FacultyDao facultyDao = new FacultyDao();
        facultys.addItem("");
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
                String facultyText = facultys.getSelectedItem().toString();

                if (nameText == null || "".equals(nameText.trim())) {
                    JOptionPane.showMessageDialog(null, "专业名称不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (facultyText == null || "".equals(facultyText.trim())) {
                    JOptionPane.showMessageDialog(null, "学院不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Major major = new Major(Integer.parseInt(idText), nameText, 0, 0, 0, facultyText);

                //i为影响数据库的行数
                int i = majorDao.insertMajor(major);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "新增专业成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "新增专业失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
}
