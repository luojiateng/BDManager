package peopleManager.view.base;


import peopleManager.bean.Department;
import peopleManager.bean.Teacher;
import peopleManager.dao.DeptDao;
import peopleManager.dao.TeacherDao;
import peopleManager.view.dept.DeptManage;
import peopleManager.view.dept.PositionManager;
import peopleManager.view.dept.TitleManager;
import peopleManager.view.teacher.CreatTeacher;
import peopleManager.view.teacher.ShowTeacher;
import peopleManager.view.teacher.UpdataTeacher;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseFrame extends JFrame {
    private JTable teaTable;
    private JTable depTable;

    public BaseFrame() {
        setTitle("学校人力资源管理系统");
        setLayout(null);
        //主窗体容器
        JPanel mainPane = (JPanel) getContentPane();
        //布局
        JPanel tablepane = new JPanel();
        JPanel teacherpane = new JPanel();
        JPanel depPane = new JPanel();
        JPanel depDataPane = new JPanel();
        mainPane.setBorder(new TitledBorder(null, "*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        mainPane.setBounds(10, 20, 1100, 105);

        tablepane.setBorder(new TitledBorder(null, "教师数据", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tablepane.setBounds(20, 15, 1100, 200);

        teacherpane.setBounds(20, 230, 1100, 100);
        teacherpane.setBorder(new TitledBorder(null, "教师管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        depPane.setBounds(20, 430, 1100, 100);
        depPane.setBorder(new TitledBorder(null, "部门管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        mainPane.add(tablepane);
        mainPane.add(teacherpane);
        mainPane.add(depPane);

        depDataPane.setBounds(20, 330, 1100, 100);
        depDataPane.setBorder(new TitledBorder(null, "部门数据", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        mainPane.add(depDataPane);
        depDataPane.setLayout(null);
        teacherpane.setLayout(null);
        depPane.setLayout(null);
        tablepane.setLayout(null);
        JScrollPane deptScroll = new JScrollPane();
        deptScroll.setBounds(14, 20, 1075, 71);
        depDataPane.add(deptScroll);
        depTable = new JTable();
        deptScroll.setViewportView(depTable);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 20, 1075, 168);
        tablepane.add(scrollPane);
        teaTable = new JTable();
        scrollPane.setViewportView(teaTable);

        showTeacher();


        JLabel teacherName = new JLabel("教师姓名:");
        JTextField jTextField = new JTextField();
        JButton seleTeacher = new JButton("查询教师");
        seleTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jTextField.getText();
                if (name == null || "".equals(name.trim())) {
                    showTeacher();
                    return;
                }
                String nameText = jTextField.getText();
                showOneTeacher(nameText);
            }
        });
        JButton insertTeacher = new JButton("新增教师信息");
        insertTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatTeacher frame = new CreatTeacher();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        JButton updataTeacher = new JButton("更新教师信息");
        updataTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = teaTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要修改的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < teaTable.getColumnCount(); i++) {
                    if ("姓名".equals(teaTable.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                String changeName = teaTable.getValueAt(selectedRow, idColumnIndex).toString();
                UpdataTeacher updataTeacher1 = new UpdataTeacher(changeName);
                updataTeacher1.setLocationRelativeTo(null);
                updataTeacher1.setVisible(true);
            }
        });
        JButton deleteTeacher = new JButton("查看更多信息");
        deleteTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = teaTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要查看的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < teaTable.getColumnCount(); i++) {
                    if ("姓名".equals(teaTable.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                String changeName = teaTable.getValueAt(selectedRow, idColumnIndex).toString();
                ShowTeacher showTeacher = new ShowTeacher(changeName);
                showTeacher.setLocationRelativeTo(null);
                showTeacher.setVisible(true);
            }
        });
        JButton lookMoreTeacher = new JButton("删除教师");
        lookMoreTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = teaTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < teaTable.getColumnCount(); i++) {
                    if ("姓名".equals(teaTable.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                String changeName = teaTable.getValueAt(selectedRow, idColumnIndex).toString();

                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + changeName + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    int delete = new TeacherDao().delete(changeName);
                    if (delete > 0) {
                        JOptionPane.showMessageDialog(null, "删除教师信息成功");
                    }
                    showTeacher();
                }
            }
        });

        teacherName.setBounds(190, 35, 120, 30);
        jTextField.setBounds(250, 35, 150, 30);
        seleTeacher.setBounds(410, 35, 120, 30);
        insertTeacher.setBounds(540, 35, 120, 30);
        updataTeacher.setBounds(670, 35, 120, 30);
        deleteTeacher.setBounds(800, 35, 120, 30);
        lookMoreTeacher.setBounds(930, 35, 140, 30);

        seleTeacher.setFont(Font.getFont("宋体"));
        insertTeacher.setFont(Font.getFont("宋体"));
        updataTeacher.setFont(Font.getFont("宋体"));
        deleteTeacher.setFont(Font.getFont("宋体"));
        lookMoreTeacher.setFont(Font.getFont("宋体"));

        teacherpane.add(jTextField);
        teacherpane.add(teacherName);
        teacherpane.add(seleTeacher);
        teacherpane.add(insertTeacher);
        teacherpane.add(updataTeacher);
        teacherpane.add(deleteTeacher);
        teacherpane.add(lookMoreTeacher);

        JLabel deptName = new JLabel("部门名:");
        JComboBox deptText = new JComboBox();
        deptText.addItem("");
        DeptDao deptDao = new DeptDao();
        for (String s : deptDao.getDepName()) {
            deptText.addItem(s);
        }

        JButton showDept = new JButton("部门信息查询");
        showDept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = deptText.getSelectedItem().toString();
                if (name == null || "".equals(name.trim())) {
                    JOptionPane.showMessageDialog(null, "部门不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showDept(name);
            }
        });
        JButton department = new JButton("部门管理");
        department.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeptManage deptManage = new DeptManage();
                deptManage.setLocationRelativeTo(null);
                deptManage.setVisible(true);
            }
        });
        JButton title = new JButton("职称管理");
        title.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TitleManager deptManage = new TitleManager();
                deptManage.setLocationRelativeTo(null);
                deptManage.setVisible(true);
            }
        });
        JButton position = new JButton("职务管理");
        position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PositionManager deptManage = new PositionManager();
                deptManage.setLocationRelativeTo(null);
                deptManage.setVisible(true);
            }
        });

        deptName.setBounds(190, 35, 120, 30);
        deptText.setBounds(250, 35, 150, 30);
        showDept.setBounds(410, 35, 120, 30);
        department.setBounds(670, 35, 120, 30);
        title.setBounds(800, 35, 120, 30);
        position.setBounds(930, 35, 120, 30);

        deptName.setFont(Font.getFont("宋体"));
        deptText.setFont(Font.getFont("宋体"));
        showDept.setFont(Font.getFont("宋体"));
        department.setFont(Font.getFont("宋体"));
        title.setFont(Font.getFont("宋体"));
        position.setFont(Font.getFont("宋体"));

        depPane.add(deptName);
        depPane.add(deptText);
        depPane.add(showDept);
        depPane.add(department);
        depPane.add(title);
        depPane.add(position);

    }

    public void showTeacher() {
        DefaultTableModel tmodel = new DefaultTableModel();
        tmodel.addColumn("编号");
        tmodel.addColumn("姓名");
        tmodel.addColumn("性别");
        tmodel.addColumn("email");
        tmodel.addColumn("所属部门");
        tmodel.addColumn("职称");
        tmodel.addColumn("职务");
        TeacherDao teacherDao = new TeacherDao();
        for (Teacher teacher : teacherDao.selectAll()) {
            tmodel.addRow(new Object[]{teacher.getTeacherId(),
                    teacher.getTeacherName(), teacher.getGender(),
                    teacher.getEmail(), teacher.getDeptName(),
                    teacher.getTitle(), teacher.getPosition()});
        }
        teaTable.setModel(tmodel);

    }

    public void showDept(String name) {
        DefaultTableModel dmodel = new DefaultTableModel();
        dmodel.addColumn("编号");
        dmodel.addColumn("部门");
        dmodel.addColumn("职称");
        dmodel.addColumn("人数");
        for (Department department : new DeptDao().getAllDep(name)) {
            dmodel.addRow(new Object[]{department.getDeptId(),
                    department.getDeptName(), department.getTitle(),
                    department.getTeaNumber()});
        }

        depTable.setModel(dmodel);
    }

    public void showOneTeacher(String name) {
        DefaultTableModel tomodel = new DefaultTableModel();
        tomodel.addColumn("编号");
        tomodel.addColumn("姓名");
        tomodel.addColumn("性别");
        tomodel.addColumn("email");
        tomodel.addColumn("所属部门");
        tomodel.addColumn("职称");
        tomodel.addColumn("职务");
        TeacherDao teacherDao = new TeacherDao();
        for (Teacher teacher : teacherDao.selectOne(name)) {
            tomodel.addRow(new Object[]{teacher.getTeacherId(),
                    teacher.getTeacherName(), teacher.getGender(),
                    teacher.getEmail(), teacher.getDeptName(),
                    teacher.getTitle(), teacher.getPosition()});
        }
        teaTable.setModel(tomodel);


    }


}
