package view.teacher;


import dao.impl.EducationDaoImpl;
import dao.impl.FamilyDaoImpl;
import dao.impl.SchoolDaoImpl;
import dao.impl.TeacherDaoImpl;
import pojo.Education;
import pojo.Family;
import pojo.Teacher;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EducationFrame extends JFrame {
    private JTable table;

    public EducationFrame(String name) {
        Teacher tea = new Teacher();
        for (Teacher t : new TeacherDaoImpl().getTeacherByName(name)) {
            tea = t;
            break;
        }


        setTitle("教育信息");
        setSize(640, 510);
        setLocation(616, 380);
        setLayout(null);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        setResizable(true);


        JPanel apPane = new JPanel();
        apPane.setBorder(new TitledBorder(null, "教育信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        apPane.setBounds(15, 15, 600, 220);
        mainPane.add(apPane);
        apPane.setLayout(null);

        JPanel doAP = new JPanel();
        doAP.setBorder(new TitledBorder(null, "教育信息操作", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        doAP.setBounds(15, 220, 500, 230);
        mainPane.add(doAP);
        doAP.setLayout(null);

        JScrollPane apScrollPane = new JScrollPane();
        apScrollPane.setBounds(14, 20, 580, 185);
        apPane.add(apScrollPane);
        table = new JTable();
        apScrollPane.setViewportView(table);


        JLabel top2 = new JLabel("教育信息修改");
        top2.setFont(new Font("宋体", Font.PLAIN, 20));
        top2.setBounds(125, 5, 160, 52);
        doAP.add(top2);


        JLabel f1 = new JLabel("选择学历:");
        f1.setFont(new Font("宋体", Font.PLAIN, 20));
        f1.setBounds(20, 48, 100, 35);
        doAP.add(f1);
        JComboBox fbox = new JComboBox();
        fbox.setBounds(125, 55, 120, 21);
        doAP.add(fbox);
        fbox.addItem("");
        for (Education education : new EducationDaoImpl().getTeacherEduByName(name)) {
            fbox.addItem(education.getEduName());
        }

        JLabel f2 = new JLabel("学校:");
        f2.setFont(new Font("宋体", Font.PLAIN, 20));
        f2.setBounds(280, 48, 100, 35);
        doAP.add(f2);
        JComboBox edu = new JComboBox();
        edu.setBounds(330, 55, 120, 21);
        doAP.add(edu);
        edu.addItem("");
        for (String school : new SchoolDaoImpl().getAllSchoolName()) {
            edu.addItem(school);
        }


        JLabel f9 = new JLabel("开始时间:");
        f9.setFont(new Font("宋体", Font.PLAIN, 20));
        f9.setBounds(20, 100, 100, 35);
        doAP.add(f9);
        JTextField fname = new JTextField();
        fname.setColumns(10);
        fname.setBounds(125, 100, 100, 21);
        doAP.add(fname);

        JLabel e1 = new JLabel("结束时间:");
        f9.setFont(new Font("宋体", Font.PLAIN, 20));
        f9.setBounds(250, 100, 100, 35);
        doAP.add(f9);
        JTextField endtime = new JTextField();
        fname.setColumns(10);
        fname.setBounds(375, 100, 100, 21);
        doAP.add(fname);

        JButton fcomit = new JButton("更改");
        fcomit.setFont(new Font("宋体", Font.PLAIN, 20));
        fcomit.setBounds(125, 170, 78, 21);
        doAP.add(fcomit);
        Teacher finalTea = tea;
        fcomit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ftid = finalTea.getTeacherID();

                String fr = fbox.getSelectedItem().toString();
                String fnameText = fname.getText();
                if (fr == null || "".equals(fr.trim())) {
                    JOptionPane.showMessageDialog(null, "家庭关系不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (fnameText == null || "".equals(fnameText.trim())) {
                    JOptionPane.showMessageDialog(null, "家人姓名不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Family family = new Family(ftid, "", fr, fnameText);
                int i = new FamilyDaoImpl().updataTeacherFamily(family);
                System.out.println(family);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "更新失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        JButton deleButton = new JButton("删除");
        deleButton.setFont(new Font("宋体", Font.PLAIN, 20));
        deleButton.setBounds(525, 400, 78, 21);
        mainPane.add(deleButton);
        deleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("编号".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                Integer apid = Integer.parseInt(table.getValueAt(selectedRow, idColumnIndex).toString());

                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + apid + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    //TODO
//                    int i = new FamilyDaoImpl().deleteTeacherFamily(apid);
                    showTeacherEduInfo(name);
                    if (5 > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功");
                    }
                }
            }
        });
        showTeacherEduInfo(name);
    }

    /**
     * 教育信息
     */
    public void showTeacherEduInfo(String name) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("编号");
        model.addColumn("姓名");
        model.addColumn("学历");
        model.addColumn("起始时间");
        model.addColumn("结束时间");
        model.addColumn("学校");
        for (pojo.Education education : new EducationDaoImpl().getTeacherEduByName(name)) {
            model.addRow(new Object[]{
                    education.getTeacherNumber(), education.getTeacherName(),
                    education.getEduName(), education.getBegin(),
                    education.getEnd(), education.getSchoolName(),
            });
        }
        table.setModel(model);

    }

}
