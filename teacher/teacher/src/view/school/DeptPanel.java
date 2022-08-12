package view.school;


import dao.impl.DeptDaoImpl;
import dao.impl.PostionDaoImpl;
import pojo.Department;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeptPanel extends JPanel {
    JTable table;

    public DeptPanel() {
        setSize(700, 300);
        setLocation(624, 325);
        setLayout(null);
        setVisible(false);

        JPanel data = new JPanel();
        data.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        data.setBounds(680, 15, 400, 220);
        add(data);
        data.setLayout(null);

        JScrollPane tablePanel = new JScrollPane();
        tablePanel.setBounds(15, 10, 370, 200);
        data.add(tablePanel);
        table = new JTable();
        tablePanel.setViewportView(table);

        JPanel queryPan = new JPanel();
        queryPan.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        queryPan.setBounds(15, 240, 1070, 200);
        add(queryPan);

        JLabel deptName = new JLabel("部门名称：");
        deptName.setLayout(null);
        deptName.setBounds(0, 29, 91, 18);
        queryPan.add(deptName);
        JTextField textField = new JTextField();
        textField.setBounds(82, 26, 159, 24);
        textField.setColumns(10);
        queryPan.add(textField);
        JButton queryBtn = new JButton("查询");
        queryBtn.setLayout(null);
        queryPan.add(queryBtn);
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deptText = textField.getText();
                showDeptInfoByName(deptText);
            }
        });


        JPanel baseMessPane = new JPanel();
        baseMessPane.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        baseMessPane.setBounds(15, 15, 650, 220);
        add(baseMessPane);
        baseMessPane.setLayout(null);


        JPanel insert = new JPanel();
        insert.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        insert.setBounds(10, 5, 200, 210);
        baseMessPane.add(insert);
        insert.setLayout(null);
        JLabel insDep = new JLabel("新增部门");
        insDep.setBounds(80, 5, 100, 30);
        insert.add(insDep);

        JLabel t7 = new JLabel("部门编号:");
        t7.setBounds(20, 50, 100, 30);
        insert.add(t7);
        JTextField insertText = new JTextField();
        insertText.setBounds(75, 55, 100, 20);
        insert.add(insertText);
        insertText.setText(new DeptDaoImpl().getNextIndex() + "");
        insertText.setEditable(false);

        JLabel t9 = new JLabel("名  称:");
        t9.setBounds(20, 100, 100, 30);
        insert.add(t9);
        JTextField DepName = new JTextField();
        DepName.setBounds(75, 105, 100, 21);
        insert.add(DepName);
        JButton insertComit = new JButton("提交");
        insertComit.setBounds(80, 150, 70, 21);
        insert.add(insertComit);
        insertComit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = DepName.getText();
                if (text.equals("") || text == null) {
                    JOptionPane.showMessageDialog(null, "部门名不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                Department department = new Department(0, text, "", 0);
                int insert1 = new DeptDaoImpl().insertDept(department);
                if (insert1 > 0) {
                    JOptionPane.showMessageDialog(null, "添加部门信息成功");
                }
            }
        });


        JPanel delete = new JPanel();
        delete.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        delete.setBounds(225, 5, 200, 210);
        baseMessPane.add(delete);
        delete.setLayout(null);
        JLabel upDes = new JLabel("删除部门");
        upDes.setBounds(80, 5, 100, 30);
        delete.add(upDes);
        JLabel t4 = new JLabel("名 称:");
        t4.setBounds(20, 50, 100, 30);
        delete.add(t4);
        JComboBox deleSelect = new JComboBox();
        deleSelect.setBounds(70, 55, 100, 20);
        delete.add(deleSelect);
        deleSelect.addItem("");
        for (String s : new DeptDaoImpl().getAllDeptName()) {
            deleSelect.addItem(s);
        }

        JButton deleComit = new JButton("删除");
        deleComit.setBounds(80, 150, 70, 21);
        delete.add(deleComit);
        deleComit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = deleSelect.getSelectedItem().toString();

                if (s.equals("")) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + s + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    int i = new DeptDaoImpl().deleteDept(s);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除部门信息成功");
                    }

                }
            }
        });

        JPanel updata = new JPanel();
        updata.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        updata.setBounds(440, 5, 200, 210);
        baseMessPane.add(updata);
        updata.setLayout(null);
        JLabel delDp = new JLabel("修改部门");
        delDp.setBounds(80, 5, 100, 30);
        updata.add(delDp);

        JLabel t2 = new JLabel("名 称:");
        t2.setBounds(20, 50, 100, 30);
        updata.add(t2);
        JComboBox updataSelect = new JComboBox();
        updataSelect.setBounds(70, 55, 100, 20);
        updata.add(updataSelect);
        updataSelect.addItem("");
        for (String s : new DeptDaoImpl().getAllDeptName()) {
            updataSelect.addItem(s);
        }


        JLabel t3 = new JLabel("重命名:");
        t3.setBounds(20, 100, 100, 30);
        updata.add(t3);

        JTextField newDepName = new JTextField();
        newDepName.setBounds(70, 105, 100, 21);
        updata.add(newDepName);
        JButton upComit = new JButton("提交");
        upComit.setBounds(80, 150, 70, 21);
        updata.add(upComit);
        upComit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newDepNameText = newDepName.getText();
                String oldname = updataSelect.getSelectedItem().toString();
                if (oldname.equals("")) {
                    JOptionPane.showMessageDialog(null, "请选择要修改的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (newDepNameText.trim().equals("") || newDepNameText == null) {
                    JOptionPane.showMessageDialog(null, "名称不能为空!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int result = JOptionPane.showConfirmDialog(null, "您确定要修改[" + oldname + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    int i = new DeptDaoImpl().updataDept(oldname, newDepNameText);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "修改部门信息成功");
                    }

                }


            }
        });

        JButton flush = new JButton("刷新");
        flush.setLayout(null);
        queryPan.add(flush);
        flush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleSelect.removeAllItems();
                updataSelect.removeAllItems();
                deleSelect.addItem("");
                updataSelect.addItem("");
                for (String s : new DeptDaoImpl().getAllDeptName()) {
                    deleSelect.addItem(s);
                    updataSelect.addItem(s);
                }
            }
        });
        showTable();
    }

    public void showDeptInfoByName(String name) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("部门编号");
        model.addColumn("部门名");
        model.addColumn("职称");
        model.addColumn("职称人数");
        for (Department department : new DeptDaoImpl().getAllDeptInfo(name)) {
            model.addRow(new Object[]{department.getDeptNumber(),
                    department.getDeptName(), department.getTitleName(),
                    department.getTitleCount()});
        }
        table.setModel(model);
    }

    public void showTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("部门编号");
        model.addColumn("部门名");
        model.addColumn("职称");
        model.addColumn("职称人数");

        table.setModel(model);
    }


}
