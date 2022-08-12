package StudentManager.view.subPanel;

import StudentManager.dao.StudentDao;
import StudentManager.pojo.Student;
import StudentManager.view.base.BasePanel;
import StudentManager.view.createFrame.CreateStudentFrame;
import StudentManager.view.createFrame.PunishAwardFrame;
import StudentManager.view.createFrame.ScoreFrame;
import StudentManager.view.updataFrame.StudentUpdateFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentPanel extends BasePanel {

    private JTable table;

    public StudentPanel() {


        JLabel studentText = new JLabel("学生姓名：");
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

        JButton pa = new JButton("奖惩管理");
        pa.setLayout(null);
        pa.setBounds(929, 25, 113, 27);
        iudpanel.add(pa);
        pa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要修改的数据行");
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("学号".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                Integer getValue = Integer.parseInt(table.getValueAt(selectedRow, idColumnIndex).toString());
                PunishAwardFrame punishAwardFrame = new PunishAwardFrame(getValue);
                punishAwardFrame.setLocationRelativeTo(null);
                punishAwardFrame.setVisible(true);
                getAll();
            }
        });

        JButton score = new JButton("成绩管理");
        score.setLayout(null);
        score.setBounds(929, 25, 113, 27);
        iudpanel.add(score);

        score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要修改的数据行");
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("姓名".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                String changeName = table.getValueAt(selectedRow, idColumnIndex).toString();

                ScoreFrame scoreFrame = new ScoreFrame(changeName);
                scoreFrame.setLocationRelativeTo(null);
                scoreFrame.setVisible(true);
                getAll();
            }
        });


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
                CreateStudentFrame frame = new CreateStudentFrame();
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
                    if ("姓名".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                String changeName = table.getValueAt(selectedRow, idColumnIndex).toString();
                StudentUpdateFrame updateTeacherFrame = new StudentUpdateFrame(changeName);
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
                    if ("姓名".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }

                String name = table.getValueAt(selectedRow, idColumnIndex).toString();
                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + name + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    StudentDao studentDao = new StudentDao();
                    int i = studentDao.deleteStudent(name);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除学生信息成功");
                        getAll();
                    }

                }
            }
        });


        getAll();
    }

    private void getAll() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("学号");
        model.addColumn("姓名");
        model.addColumn("性别");
        model.addColumn("所属学院");
        model.addColumn("所属专业");
        model.addColumn("所属班级");
        StudentDao studentDao = new StudentDao();

        List<Student> allStudent = studentDao.getAllStudent();
        for (Student student : allStudent) {
            model.addRow(new Object[]{student.getStudentId(),
                    student.getStudentName(), student.getGender(),
                    student.getFaculty(), student.getMajor(),
                    student.getClassInfo()});
        }
        table.setModel(model);
    }

    private void getOneStudent(String name) {
        DefaultTableModel getOne = new DefaultTableModel();
        getOne.addColumn("学号");
        getOne.addColumn("姓名");
        getOne.addColumn("性别");
        getOne.addColumn("所属学院");
        getOne.addColumn("所属专业");
        getOne.addColumn("所属班级");
        StudentDao studentDao = new StudentDao();


        for (Student student : studentDao.getStudentByName(name)) {
            getOne.addRow(new Object[]{student.getStudentId(),
                    student.getStudentName(), student.getGender(),
                    student.getFaculty(), student.getMajor(),
                    student.getClassInfo()});
        }


        table.setModel(getOne);
    }


}
