package StudentManager.view.subPanel;

import StudentManager.dao.FacultyDao;
import StudentManager.pojo.Faculty;
import StudentManager.view.base.BasePanel;
import StudentManager.view.createFrame.CreateFacultyFrame;
import StudentManager.view.updataFrame.FacultyUpdataFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FacultyPanel extends BasePanel {

    private JTable table;

    public FacultyPanel() {
        JLabel studentText = new JLabel("学院:");
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
                getOneFaculty(trimName);
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
                CreateFacultyFrame frame = new CreateFacultyFrame();
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
                    if ("学院名称".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                String changeName = table.getValueAt(selectedRow, idColumnIndex).toString();
                FacultyUpdataFrame updateTeacherFrame = new FacultyUpdataFrame(changeName);
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
                    if ("学院名称".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }

                String name = table.getValueAt(selectedRow, idColumnIndex).toString();
                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + name + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    FacultyDao facultyDao = new FacultyDao();
                    int i = facultyDao.deleteFacultyByName(name);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除学院信息成功");
                        getAll();
                    }

                }
            }
        });


        getAll();
    }

    public void getAll() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("学院编号");
        model.addColumn("学院名称");
        model.addColumn("学生总数");
        model.addColumn("女生总数");
        model.addColumn("男生总数");
        FacultyDao facultyDao = new FacultyDao();


        for (Faculty faculty : facultyDao.getAllFaculty()) {
            model.addRow(new Object[]{faculty.getFacultyId(),
                    faculty.getFacultyName(), faculty.getStudentNumber(),
                    faculty.getGrilNumber(), faculty.getBoyNumber(),
            });
        }
        table.setModel(model);
    }

    public void getOneFaculty(String className) {
        DefaultTableModel getOne = new DefaultTableModel();
        getOne.addColumn("学院编号");
        getOne.addColumn("学院名称");
        getOne.addColumn("学生总数");
        getOne.addColumn("男生总数");
        getOne.addColumn("女生总数");
        FacultyDao facultyDao = new FacultyDao();

        for (Faculty facultyByName : facultyDao.getFacultyByName(className)) {
            getOne.addRow(new Object[]{facultyByName.getFacultyId(),
                    facultyByName.getFacultyName(), facultyByName.getStudentNumber(),
                    facultyByName.getGrilNumber(), facultyByName.getBoyNumber(),
            });
        }


        table.setModel(getOne);

    }
}
