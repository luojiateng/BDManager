package StudentManager.view.createFrame;


import StudentManager.dao.ScoreDao;
import StudentManager.dao.StudentDao;
import StudentManager.pojo.Score;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScoreFrame extends JFrame {
    private JTextField studentId;
    private JTextField studentName;
    private JRadioButton boy;
    private JRadioButton gril;
    private JTextField GPA;
    private JTextField award;
    private JTextField scoretext;
    private JComboBox classs;
    private JComboBox majors;
    private JComboBox facultys;
    private JTable table;

    public ScoreFrame(String name) {
        setTitle("成绩管理");
        setSize(720, 500);
        setLocation(850, 325);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        //主窗体容器
        JPanel mainPanel = (JPanel) getContentPane();
        //内部容器
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        dataPanel.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        dataPanel.setBounds(23, 53, 658, 315);
        mainPanel.add(dataPanel);

        JButton quitBtn = new JButton("取消");
        quitBtn.setBounds(569, 403, 93, 23);
        mainPanel.add(quitBtn);


        JLabel l1 = new JLabel("成绩管理");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(290, 10, 182, 52);
        mainPanel.add(l1);


        ScoreDao scoreDao = new ScoreDao();
        Score stuscore = new Score();
        for (Score s : scoreDao.getAllScore(name)) {
            stuscore = s;
            break;
        }

        JLabel l2 = new JLabel("学号:");
        l2.setBounds(31, 20, 73, 36);
        dataPanel.add(l2);
        studentId = new JTextField();
        studentId.setColumns(10);
        studentId.setBounds(90, 30, 211, 21);
        studentId.setEditable(false);
        dataPanel.add(studentId);
        studentId.setText(stuscore.getStuId() + "");

        JLabel l3 = new JLabel("姓名:");
        l3.setBounds(340, 20, 73, 36);
        dataPanel.add(l3);
        studentName = new JTextField();
        studentName.setColumns(10);
        studentName.setBounds(400, 30, 211, 21);
        studentName.setText(name);
        studentName.setEditable(false);
        dataPanel.add(studentName);


        JScrollPane tablePanel = new JScrollPane();
        tablePanel.setBounds(31, 66, 600, 140);
        add(tablePanel);
        table = new JTable();
        tablePanel.setViewportView(table);
        dataPanel.add(tablePanel);
        //将数据填充
        getAll(name);


        JLabel l7 = new JLabel("科目:");
        l7.setBounds(30, 210, 73, 36);
        dataPanel.add(l7);
        classs = new JComboBox();
        classs.setBounds(90, 220, 211, 21);
        dataPanel.add(classs);
        List<Score> thisAllScore = scoreDao.getAllScore(name);
        //如果已经选过课程了，就不继续将课程添加到备选框中
        classs.addItem("");
        String coursStr = "";
        for (Score score : thisAllScore) {
            coursStr += score.getCourseName();
        }
        for (String s : scoreDao.getAllCourseName()) {
            if (!coursStr.contains(s)) {
                classs.addItem(s);
            }
        }


        JLabel l5 = new JLabel("分数:");
        l5.setBounds(340, 210, 73, 36);
        dataPanel.add(l5);
        scoretext = new JTextField();
        scoretext.setColumns(10);
        scoretext.setBounds(400, 220, 211, 21);
        dataPanel.add(scoretext);


        JButton deleteOne = new JButton("删除");
        deleteOne.setBounds(40, 270, 93, 23);
        dataPanel.add(deleteOne);
        deleteOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stuid = Integer.parseInt(studentId.getText());

                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择删除的行");
                    return;
                }

                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("科目".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                String courseName = table.getValueAt(selectedRow, idColumnIndex).toString();

                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + courseName + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int i = new ScoreDao().deletScore(stuid, courseName);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除学生信息成功");
                        getAll(name);
                    }
                }
            }
        });


        JButton insertScore = new JButton("提交");
        insertScore.setBounds(518, 270, 93, 23);
        dataPanel.add(insertScore);
        Score finalStuscore = stuscore;
        insertScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Score score = new Score(finalStuscore.getStuId(), classs.getSelectedItem().toString(), Double.parseDouble(scoretext.getText()));
                int i = scoreDao.insertScore(score);
                //i为影响数据库的行数
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "新增学生成绩成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    getAll(name);
                } else {
                    JOptionPane.showMessageDialog(null, "新增学生成绩失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    private void getAll(String name) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("学号");
        model.addColumn("姓名");
        model.addColumn("科目");
        model.addColumn("分数");
        StudentDao studentDao = new StudentDao();
        ScoreDao scoreDao = new ScoreDao();
        for (Score score : scoreDao.getAllScore(name)) {
            model.addRow(new Object[]{score.getStuId(),
                    score.getStuName(), score.getCourseName(),
                    score.getScore()});
        }
        table.setModel(model);
    }


}
