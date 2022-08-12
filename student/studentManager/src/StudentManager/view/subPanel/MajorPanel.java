package StudentManager.view.subPanel;

import StudentManager.dao.MajorDao;
import StudentManager.dao.StudentDao;
import StudentManager.pojo.Major;
import StudentManager.view.base.BasePanel;
import StudentManager.view.createFrame.CreateMajorFrame;
import StudentManager.view.updataFrame.MajorUpdataFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MajorPanel extends BasePanel {

    private JTable table;

    public MajorPanel() {
        JLabel studentText = new JLabel("专业:");
        studentText.setLayout(null);
        studentText.setBounds(0, 29, 91, 18);
        queryPanel.add(studentText);
        textField = new JTextField();
        textField.setBounds(82, 26, 159, 24);
        textField.setColumns(10);
        queryPanel.add(textField);
        JButton queryBtn = new JButton("查询");
        queryBtn.setLayout(null);
        queryPanel.add(queryBtn);
        JButton allBtn = new JButton("刷新");
        allBtn.setLayout(null);
        allBtn.setBounds(929, 25, 113, 27);
        queryPanel.add(allBtn);
        //表格
        JScrollPane tablePanel = new JScrollPane();
        tablePanel.setBounds(14, 86, 1056, 222);
        add(tablePanel);
        table = new JTable();
        tablePanel.setViewportView(table);

        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String trimName = name.trim();
                getOneStudent(trimName);
            }
        });
        allBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAll();
            }
        });

        //底部操作
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CreateMajorFrame frame = new CreateMajorFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                getAll();
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要修改的数据行");
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("专业名称".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                String changeName = table.getValueAt(selectedRow, idColumnIndex).toString();
                MajorUpdataFrame updateTeacherFrame = new MajorUpdataFrame(changeName);
                updateTeacherFrame.setLocationRelativeTo(null);
                updateTeacherFrame.setVisible(true);

                getAll();

            }
        });
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要删除的数据行");
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("专业名称".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }

                String name = table.getValueAt(selectedRow, idColumnIndex).toString();
                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + name + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    MajorDao majorDao = new MajorDao();
                    int i = majorDao.deleteMajorByName(name);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除专业信息成功");
                        getAll();
                    }

                }
            }
        });


        getAll();
    }

    public void getAll() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("专业编号");
        model.addColumn("专业名称");
        model.addColumn("学生总数");
        model.addColumn("男生总数");
        model.addColumn("女生总数");
//        model.addColumn("所属学院");
        StudentDao studentDao = new StudentDao();
        MajorDao majorDao = new MajorDao();
        for (Major major : majorDao.getAllMajor()) {
            model.addRow(new Object[]{major.getMajorId(),
                    major.getMajorName(), major.getStudentNumber(),
                    major.getGirlNumber(), major.getBoyNumber()});
        }
        table.setModel(model);

    }

    public void getOneStudent(String className) {
        DefaultTableModel getOne = new DefaultTableModel();
        getOne.addColumn("专业编号");
        getOne.addColumn("专业名称");
        getOne.addColumn("学生总数");
        getOne.addColumn("男生总数");
        getOne.addColumn("女生总数");
//        getOne.addColumn("所属学院");
        MajorDao majorDao = new MajorDao();
        for (Major majorByName : majorDao.getMajorByName(className)) {
            getOne.addRow(new Object[]{majorByName.getMajorId(),
                    majorByName.getMajorName(), majorByName.getStudentNumber(),
                    majorByName.getGirlNumber(), majorByName.getBoyNumber()});
        }


        table.setModel(getOne);

    }
}
