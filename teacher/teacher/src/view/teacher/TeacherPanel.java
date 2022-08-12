package view.teacher;

import dao.impl.TeacherDaoImpl;
import pojo.Teacher;
import view.Base.BasePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherPanel extends BasePanel {

    JTable table;
    String teacherName;

    public TeacherPanel() {
        setLayout(null);

        JLabel teacherText = new JLabel("教师姓名：");
        teacherText.setLayout(null);
        teacherText.setBounds(0, 29, 91, 18);
        queryPanel.add(teacherText);
        textField = new JTextField();
        textField.setBounds(82, 26, 159, 24);
        textField.setColumns(10);
        queryPanel.add(textField);
        JButton queryBtn = new JButton("查询");
        queryBtn.setLayout(null);
        queryPanel.add(queryBtn);
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teacherName = textField.getText();
                if (teacherName == null || "".equals(teacherName.trim())) {
                    showTeacherInfo();
                } else {
                    showTeacherInfoByName(teacherName);
                }
            }
        });
        JButton allBtn = new JButton("刷新");
        allBtn.setLayout(null);
        allBtn.setBounds(929, 25, 113, 27);
        queryPanel.add(allBtn);
        allBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeacherInfo();
            }
        });
        //数据展示框
        JScrollPane teacherScroll = new JScrollPane();
        teacherScroll.setBounds(14, 95, 1056, 222);
        add(teacherScroll);
        table = new JTable();
        teacherScroll.setViewportView(table);

        //对表格进行事件监听，得到教师姓名
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("姓名".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                teacherName = table.getValueAt(selectedRow, idColumnIndex).toString();
            }
        });
        //底下按键操作
        btnInsert = new JButton("新增");
        btnInsert.setBounds(696, 13, 113, 27);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TeacherInsertFrame teacherInsertFrame = new TeacherInsertFrame();
                teacherInsertFrame.setLocationRelativeTo(null);
                teacherInsertFrame.setVisible(true);
            }
        });
        iudpanel.add(btnInsert);
        btnUpdate = new JButton("修改");
        btnUpdate.setBounds(806, 13, 113, 27);
        iudpanel.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherUpdataFrame teacherUpdataFrame = new TeacherUpdataFrame(teacherName);
                teacherUpdataFrame.setLocationRelativeTo(null);
                teacherUpdataFrame.setVisible(true);
            }
        });
        btnDelete = new JButton("删除");
        btnDelete.setBounds(916, 13, 113, 27);
        iudpanel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要删除的数据行");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + teacherName + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int i = new TeacherDaoImpl().deletTeacherByName(teacherName);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除教师信息成功");
                        showTeacherInfo();
                    }

                }
            }
        });

        JButton apBtn = new JButton("奖惩管理");
        btnDelete.setBounds(916, 13, 113, 27);
        iudpanel.add(apBtn);
        apBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AwardPunishFrame awardPunishFrame = new AwardPunishFrame(teacherName);
                awardPunishFrame.setLocationRelativeTo(null);
                awardPunishFrame.setVisible(true);
            }
        });
        JButton familyBtn = new JButton("家庭信息");
        btnDelete.setBounds(916, 13, 113, 27);
        iudpanel.add(familyBtn);
        JButton eduBtn = new JButton("教育经历");
        btnDelete.setBounds(916, 13, 113, 27);
        iudpanel.add(eduBtn);
        familyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要查看的数据行");
                    return;
                }
                //TODO
                FamilyFrame familyFrame = new FamilyFrame(teacherName);
                familyFrame.setLocationRelativeTo(null);
                familyFrame.setVisible(true);
            }
        });
        eduBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要查看的数据行");
                    return;
                }
                EducationFrame educationFrame = new EducationFrame(teacherName);
                educationFrame.setLocationRelativeTo(null);
                educationFrame.setVisible(true);
            }
        });

        showTeacherInfo();
    }

    /**
     * 展示所有的教师信息
     */
    public void showTeacherInfo() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("编号");
        model.addColumn("姓名");
        model.addColumn("性别");
        model.addColumn("出生日期");
        model.addColumn("邮箱");
        model.addColumn("职称");
        model.addColumn("部门");
        model.addColumn("职务");
        for (Teacher teacher : new TeacherDaoImpl().getAllTeacher()) {
            model.addRow(new Object[]{
                    teacher.getTeacherID(), teacher.getTeacherName(),
                    teacher.getSex(), teacher.getBirth(),
                    teacher.getEmail(), teacher.getTitlName(),
                    teacher.getDeptName(), teacher.getPositionName()});
        }
        table.setModel(model);
    }

    /**
     * 根据教师名查询
     *
     * @param name
     */
    public void showTeacherInfoByName(String name) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("编号");
        model.addColumn("姓名");
        model.addColumn("性别");
        model.addColumn("出生日期");
        model.addColumn("邮箱");
        model.addColumn("职称");
        model.addColumn("部门");
        model.addColumn("职务");
        for (Teacher teacher : new TeacherDaoImpl().getTeacherByName(name)) {
            model.addRow(new Object[]{
                    teacher.getTeacherID(), teacher.getTeacherName(),
                    teacher.getSex(), teacher.getBirth(),
                    teacher.getEmail(), teacher.getTitlName(),
                    teacher.getDeptName(), teacher.getPositionName()});
        }
        table.setModel(model);
    }


}
