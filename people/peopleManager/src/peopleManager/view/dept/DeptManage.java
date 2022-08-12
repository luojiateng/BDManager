package peopleManager.view.dept;


import peopleManager.dao.DeptDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeptManage extends JFrame {

    public DeptManage() {
        setTitle("部门信息管理");
        setSize(700, 300);
        setLocation(624, 325);
        setLayout(null);
        setVisible(false);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        setResizable(false);

        JPanel baseMessPane = new JPanel();
        baseMessPane.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        baseMessPane.setBounds(15, 15, 650, 220);
        mainPane.add(baseMessPane);
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
        insertText.setText(new DeptDao().getIndex() + "");
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
                int insert1 = new DeptDao().insert(DepName.getText());
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
        for (String s : new DeptDao().getDepName()) {
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
                    int i = new DeptDao().delete(s);
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
        for (String s : new DeptDao().getDepName()) {
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
                    int i = new DeptDao().updata(oldname, newDepNameText);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "修改部门信息成功");
                    }

                }


            }
        });

    }

}
