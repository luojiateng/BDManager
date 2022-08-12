package view.teacher;


import dao.FamilyDao;
import dao.impl.*;
import pojo.Family;
import pojo.Teacher;
import pojo.TeacherAp;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class FamilyFrame extends JFrame {

    private JTable table;

    public FamilyFrame(String name) {
        Teacher tea = new Teacher();
        for (Teacher t : new TeacherDaoImpl().getTeacherByName(name)) {
            tea = t;
            break;
        }


        setTitle("家庭信息");
        setSize(640, 510);
        setLocation(616, 380);
        setLayout(null);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        setResizable(true);


        JPanel apPane = new JPanel();
        apPane.setBorder(new TitledBorder(null, "家庭信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        apPane.setBounds(15, 15, 600, 220);
        mainPane.add(apPane);
        apPane.setLayout(null);

        JPanel doAP = new JPanel();
        doAP.setBorder(new TitledBorder(null, "家庭信息操作", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        doAP.setBounds(15, 220, 500, 230);
        mainPane.add(doAP);
        doAP.setLayout(null);

        JScrollPane apScrollPane = new JScrollPane();
        apScrollPane.setBounds(14, 20, 580, 185);
        apPane.add(apScrollPane);
        table = new JTable();
        apScrollPane.setViewportView(table);


        JLabel top2 = new JLabel("家庭关系修改");
        top2.setFont(new Font("宋体", Font.PLAIN, 20));
        top2.setBounds(125, 5, 182, 52);
        doAP.add(top2);


        JLabel f1 = new JLabel("成员关系:");
        f1.setFont(new Font("宋体", Font.PLAIN, 20));
        f1.setBounds(20, 48, 100, 35);
        doAP.add(f1);
        JComboBox fbox = new JComboBox();
        fbox.setBounds(125, 55, 150, 21);
        doAP.add(fbox);
        fbox.addItem("");
        for (Family f : new FamilyDaoImpl().getTeacherFamliyByName(name)) {
            fbox.addItem(f.getFamilys());
        }


        JLabel f2 = new JLabel("姓  名:");
        f2.setFont(new Font("宋体", Font.PLAIN, 20));
        f2.setBounds(20, 100, 100, 35);
        doAP.add(f2);
        JTextField fname = new JTextField();
        fname.setColumns(10);
        fname.setBounds(125, 107, 150, 21);
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
                    showTeacherFailyInfo(name);
                    if (5 > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功");
                    }
                }
            }
        });
        showTeacherFailyInfo(name);
    }

    /**
     * 家庭信息
     *
     * @param name
     */
    public void showTeacherFailyInfo(String name) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("编号");
        model.addColumn("姓名");
        model.addColumn("家庭关系");
        model.addColumn("成员姓名");
        for (Family family : new FamilyDaoImpl().getTeacherFamliyByName(name)) {
            model.addRow(new Object[]{
                    family.getTeacherNumber(), family.getTeacherName(),
                    family.getFamilys(), family.getfName(),
            });
        }
        table.setModel(model);

    }

}
