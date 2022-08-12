package StudentManager.view.subPanel;

import StudentManager.dao.ClassDao;
import StudentManager.pojo.ClassInfo;
import StudentManager.view.base.BasePanel;
import StudentManager.view.createFrame.CreatClassInFrame;
import StudentManager.view.updataFrame.ClassInfoUpdataFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ClassInfoPanel extends BasePanel {
    private JTable table;

    public ClassInfoPanel() {
        JLabel studentText = new JLabel("班级：");
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
                CreatClassInFrame frame = new CreatClassInFrame();
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
                    if ("班级名称".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                String changeName = table.getValueAt(selectedRow, idColumnIndex).toString();
                ClassInfoUpdataFrame classInfoUpdataFrame = new ClassInfoUpdataFrame(changeName);
                classInfoUpdataFrame.setLocationRelativeTo(null);
                classInfoUpdataFrame.setVisible(true);
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
                    if ("班级名称".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                String name = table.getValueAt(selectedRow, idColumnIndex).toString();
                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + name + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    ClassDao classDao = new ClassDao();
                    int i = classDao.deleteClassByName(name);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除学生信息成功");
                        getAll();
                    }

                }
            }
        });

        //当程序启动直接加载数据将数据布置在框内
        getAll();
    }

    private void getAll() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("班级编号");
        model.addColumn("班级名称");
        model.addColumn("学生总数");
        model.addColumn("所属专业");
        model.addColumn("所属学院");
        ClassDao classDao = new ClassDao();
        List<ClassInfo> allStudent = classDao.getAllClass();

        for (ClassInfo classInfo : allStudent) {
            model.addRow(new Object[]{classInfo.getClassId(),
                    classInfo.getClassName(), classInfo.getStudentNumber(),
                    classInfo.getMajor(), classInfo.getFaculty(),
            });
        }
        table.setModel(model);

    }

    private void getOneStudent(String className) {
        DefaultTableModel getOne = new DefaultTableModel();
        getOne.addColumn("班级编号");
        getOne.addColumn("班级名称");
        getOne.addColumn("学生总数");
        getOne.addColumn("所属专业");
        getOne.addColumn("所属学院");
        ClassDao classDao = new ClassDao();
        for (ClassInfo classInfo : classDao.getClassByName(className)) {

            getOne.addRow(new Object[]{classInfo.getClassId(),
                    classInfo.getClassName(), classInfo.getStudentNumber(),
                    classInfo.getMajor(), classInfo.getFaculty()});
        }


        table.setModel(getOne);

    }
}
