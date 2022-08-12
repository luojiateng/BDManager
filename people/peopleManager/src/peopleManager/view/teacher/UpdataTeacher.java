package peopleManager.view.teacher;


import peopleManager.bean.Education;
import peopleManager.bean.Family;
import peopleManager.bean.PunishAward;
import peopleManager.bean.Teacher;
import peopleManager.dao.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

public class UpdataTeacher extends JFrame {
    private JTable apTable;

    public UpdataTeacher(String name) {
        TeacherDao teacherDao = new TeacherDao();
        Teacher teacher = new Teacher();
        for (Teacher t : teacherDao.selectOne(name)) {
            teacher = t;
            break;
        }

        setTitle("更改教师信息");
        setSize(1350, 450);
        setLocation(200, 380);
        setLayout(null);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        setResizable(false);

        JPanel baseMessPane = new JPanel();
        baseMessPane.setBorder(new TitledBorder(null, "基础信息修改", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        baseMessPane.setBounds(15, 15, 650, 220);
        mainPane.add(baseMessPane);
        baseMessPane.setLayout(null);

        JPanel famliyPane = new JPanel();
        famliyPane.setBorder(new TitledBorder(null, "家庭关系修改", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        famliyPane.setBounds(670, 250, 650, 130);
        mainPane.add(famliyPane);
        famliyPane.setLayout(null);


        JPanel apPane = new JPanel();
        apPane.setBorder(new TitledBorder(null, "奖惩统计", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        apPane.setBounds(670, 15, 650, 220);
        mainPane.add(apPane);
        apPane.setLayout(null);

        JPanel eduPane = new JPanel();
        eduPane.setBorder(new TitledBorder(null, "学籍信息管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        eduPane.setBounds(15, 250, 650, 130);
        mainPane.add(eduPane);
        eduPane.setLayout(null);


        //基础信息框------------------------------------
        JLabel top1 = new JLabel("基本信息");
        top1.setFont(new Font("宋体", Font.PLAIN, 20));
        top1.setBounds(285, 5, 182, 52);
        baseMessPane.add(top1);

        JLabel l1 = new JLabel("职工编号:");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        l1.setBounds(20, 45, 100, 25);
        baseMessPane.add(l1);
        JTextField tid = new JTextField();
        tid.setColumns(10);
        tid.setBounds(125, 48, 150, 21);
        tid.setEditable(false);
        tid.setText(teacher.getTeacherId() + "");
        baseMessPane.add(tid);

        JLabel l3 = new JLabel("职工姓名:");
        l3.setFont(new Font("宋体", Font.PLAIN, 20));
        l3.setBounds(20, 90, 100, 25);
        baseMessPane.add(l3);
        JTextField tname = new JTextField();
        tname.setColumns(10);
        tname.setBounds(125, 93, 150, 21);
        tname.setText(teacher.getTeacherName());
        baseMessPane.add(tname);

        JLabel l5 = new JLabel("性  别:");
        l5.setFont(new Font("宋体", Font.PLAIN, 20));
        l5.setBounds(20, 135, 100, 25);
        baseMessPane.add(l5);
        boolean g = false;
        boolean b = false;
        if (teacher.getGender().equals("男")) {
            b = true;
        } else {
            g = true;
        }
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton boy = new JRadioButton("男", b);
        boy.setBounds(123, 138, 63, 23);
        baseMessPane.add(boy);
        JRadioButton gril = new JRadioButton("女", g);
        gril.setBounds(190, 138, 63, 23);
        baseMessPane.add(gril);
        buttonGroup.add(boy);
        buttonGroup.add(gril);


        JLabel l7 = new JLabel("E-mail:");
        l7.setFont(new Font("宋体", Font.PLAIN, 20));
        l7.setBounds(20, 180, 100, 25);
        baseMessPane.add(l7);
        JTextField temail = new JTextField();
        temail.setColumns(10);
        temail.setBounds(125, 183, 150, 21);
        temail.setText(teacher.getEmail());
        baseMessPane.add(temail);

        JLabel l2 = new JLabel("所属部门:");
        l2.setFont(new Font("宋体", Font.PLAIN, 20));
        l2.setBounds(370, 45, 100, 25);
        baseMessPane.add(l2);
        JComboBox dept = new JComboBox();
        dept.setBounds(475, 48, 150, 21);
        baseMessPane.add(dept);
        dept.addItem(teacher.getDeptName());
        for (String s : new DeptDao().getDepName()) {
            dept.addItem(s);
        }


        JLabel l4 = new JLabel("职  称:");
        l4.setFont(new Font("宋体", Font.PLAIN, 20));
        l4.setBounds(370, 90, 100, 25);
        baseMessPane.add(l4);
        JComboBox title = new JComboBox();
        title.setBounds(475, 93, 150, 21);
        baseMessPane.add(title);
        title.addItem(teacher.getTitle());
        for (String s : new TitleDao().getTitleName()) {
            title.addItem(s);
        }

        JLabel l6 = new JLabel("职  务:");
        l6.setFont(new Font("宋体", Font.PLAIN, 20));
        l6.setBounds(370, 135, 100, 25);
        baseMessPane.add(l6);
        JComboBox position = new JComboBox();
        position.setBounds(475, 138, 150, 21);
        baseMessPane.add(position);
        position.addItem(teacher.getPosition());
        for (String s : new PositionDao().getPositionName()) {
            position.addItem(s);
        }


        JButton lcomit = new JButton("更改");
        lcomit.setFont(new Font("宋体", Font.PLAIN, 20));
        lcomit.setBounds(550, 180, 78, 25);
        baseMessPane.add(lcomit);
        lcomit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tid.getText());
                String tnameText = tname.getText();
                String gender = null;
                Enumeration<AbstractButton> elements = buttonGroup.getElements();
                while (elements.hasMoreElements()) {
                    AbstractButton btn = elements.nextElement();
                    if (btn.isSelected()) {
                        gender = btn.getText();
                        break;
                    }
                }
                String emialtext = temail.getText();
                String depttext = dept.getSelectedItem().toString();
                String titletext = title.getSelectedItem().toString();
                String positiontext = position.getSelectedItem().toString();

                if (tnameText == null || "".equals(tnameText.trim())) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (emialtext == null || "".equals(emialtext.trim())) {
                    JOptionPane.showMessageDialog(null, "邮箱不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (depttext == null || "".equals(depttext.trim())) {
                    JOptionPane.showMessageDialog(null, "部门不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (titletext == null || "".equals(titletext.trim())) {
                    JOptionPane.showMessageDialog(null, "职称不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (positiontext == null || "".equals(positiontext.trim())) {
                    JOptionPane.showMessageDialog(null, "职务不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Teacher teacher = new Teacher(id, tnameText, gender, emialtext, depttext, titletext, positiontext);
                TeacherDao teacherDao = new TeacherDao();
                int i = teacherDao.updataTeacher(teacher);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "更新失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //奖惩统计框
        JScrollPane apScrollPane = new JScrollPane();
        apScrollPane.setBounds(14, 20, 300, 185);
        apPane.add(apScrollPane);
        apTable = new JTable();
        apScrollPane.setViewportView(apTable);

        JButton deleAp = new JButton("删除");
        deleAp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = apTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < apTable.getColumnCount(); i++) {
                    if ("编号".equals(apTable.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                Integer apid = Integer.parseInt(apTable.getValueAt(selectedRow, idColumnIndex).toString());

                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + apid + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int i = new PADao().delePA(apid);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功");
                    }
                    showApPane(name);
                }
            }
        });
        deleAp.setFont(new Font("宋体", Font.PLAIN, 20));
        deleAp.setBounds(340, 180, 78, 21);
        apPane.add(deleAp);

        ButtonGroup APGroup = new ButtonGroup();
        JRadioButton award = new JRadioButton("奖励", true);
        award.setBounds(340, 20, 63, 23);
        apPane.add(award);
        JRadioButton punish = new JRadioButton("处罚");
        punish.setBounds(400, 20, 63, 23);
        apPane.add(punish);
        APGroup.add(award);
        APGroup.add(punish);

        JLabel a1 = new JLabel("时间:");
        a1.setBounds(480, 20, 100, 23);
        apPane.add(a1);
        JTextField aptime = new JTextField();
        aptime.setBounds(520, 20, 100, 21);
        apPane.add(aptime);

        JLabel apDesc = new JLabel("详细描述:");
        apDesc.setBounds(345, 40, 100, 23);
        apPane.add(apDesc);

        JTextArea desc = new JTextArea();
        desc.setBounds(343, 65, 300, 100);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        apPane.add(desc);

        JButton insertAp = new JButton("新增");
        insertAp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int teaid = Integer.parseInt(tid.getText());
                String tnameText = tname.getText();
                String ap = null;
                Enumeration<AbstractButton> elements = APGroup.getElements();
                while (elements.hasMoreElements()) {
                    AbstractButton btn = elements.nextElement();
                    if (btn.isSelected()) {
                        ap = btn.getText();
                        break;
                    }
                }
                String aptimeText = aptime.getText();
                if (aptimeText == null || "".equals(aptimeText.trim())) {
                    JOptionPane.showMessageDialog(null, "时间为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String text = desc.getText();
                if (text == null || "".equals(text.trim())) {
                    JOptionPane.showMessageDialog(null, "文本为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                PunishAward punishAward = new PunishAward(teaid, tnameText, ap, aptimeText, text);
                int i = new PADao().insertPA(punishAward);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "新增成功");
                    showApPane(name);
                }

            }
        });
        insertAp.setFont(new Font("宋体", Font.PLAIN, 20));
        insertAp.setBounds(540, 180, 78, 21);
        apPane.add(insertAp);


        //家庭关系-------------------------------------------------
        JLabel top2 = new JLabel("家庭关系");
        top2.setFont(new Font("宋体", Font.PLAIN, 20));
        top2.setBounds(285, 5, 182, 52);
        famliyPane.add(top2);


        JLabel f1 = new JLabel("成员关系:");
        f1.setFont(new Font("宋体", Font.PLAIN, 20));
        f1.setBounds(20, 48, 100, 35);
        famliyPane.add(f1);
        JComboBox fbox = new JComboBox();
        fbox.setBounds(125, 55, 150, 21);
        famliyPane.add(fbox);
        fbox.addItem("");
        for (Family f : new FamilyDao().getFamily(name)) {
            fbox.addItem(f.getRelation());
        }


        JLabel f2 = new JLabel("姓  名:");
        f2.setFont(new Font("宋体", Font.PLAIN, 20));
        f2.setBounds(370, 48, 100, 35);
        famliyPane.add(f2);
        JTextField fname = new JTextField();
        fname.setColumns(10);
        fname.setBounds(475, 55, 150, 21);
        famliyPane.add(fname);

        JButton fcomit = new JButton("更改");
        fcomit.setFont(new Font("宋体", Font.PLAIN, 20));
        fcomit.setBounds(550, 85, 78, 21);
        famliyPane.add(fcomit);
        fcomit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ftid = Integer.parseInt(tid.getText());

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

                int i = new FamilyDao().updataFamily(ftid, fr, fnameText);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "更新失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        //学籍经历管理
        JLabel top3 = new JLabel("学籍经历");
        top3.setFont(new Font("宋体", Font.PLAIN, 20));
        top3.setBounds(285, 1, 182, 52);
        eduPane.add(top3);

        EducationDao educationDao = new EducationDao();
        Education education = new Education();
        for (Education e : educationDao.getEducation(name)) {
            education = e;
            break;
        }

        JLabel e1 = new JLabel("学历:");
        e1.setFont(new Font("宋体", Font.PLAIN, 20));
        e1.setBounds(5, 48, 100, 35);
        eduPane.add(e1);
        JComboBox grade = new JComboBox();
        grade.setBounds(65, 55, 100, 21);
        eduPane.add(grade);
        grade.addItem(education.getEducation());
        for (String s : new EducationDao().getEduType()) {
            grade.addItem(s);
        }


        JLabel e2 = new JLabel("学校:");
        e2.setFont(new Font("宋体", Font.PLAIN, 20));
        e2.setBounds(175, 48, 100, 35);
        eduPane.add(e2);
        JComboBox school = new JComboBox();
        school.setBounds(230, 55, 100, 21);
        eduPane.add(school);
        school.addItem(education.getSchool());
        for (String s : new EducationDao().getSchoolType()) {
            school.addItem(s);
        }


        JLabel e3 = new JLabel("时间:");
        e3.setFont(new Font("宋体", Font.PLAIN, 20));
        e3.setBounds(335, 48, 100, 25);
        eduPane.add(e3);
        JTextField btime = new JTextField();
        btime.setBounds(390, 55, 100, 21);
        eduPane.add(btime);
        btime.setText(education.getBeginTiem() + "");

        JTextField etime = new JTextField();
        etime.setBounds(520, 55, 100, 21);
        eduPane.add(etime);
        etime.setText(education.getEndTime() + "");


        JButton ecomit = new JButton("更改");
        ecomit.setFont(new Font("宋体", Font.PLAIN, 20));
        ecomit.setBounds(540, 85, 78, 21);
        eduPane.add(ecomit);
        ecomit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ftid = Integer.parseInt(tid.getText());
                String gradeSele = grade.getSelectedItem().toString();
                String schoolText = school.getSelectedItem().toString();
                String btimeText = btime.getText();
                String etimeText = etime.getText();
                if (gradeSele == null || "".equals(gradeSele.trim())) {
                    JOptionPane.showMessageDialog(null, "学位不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (schoolText == null || "".equals(schoolText.trim())) {
                    JOptionPane.showMessageDialog(null, "学校不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (btimeText == null || "".equals(btimeText.trim())) {
                    JOptionPane.showMessageDialog(null, "开始时间不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (etimeText == null || "".equals(etimeText.trim())) {
                    JOptionPane.showMessageDialog(null, "结束时间不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int i = new EducationDao().updataEdu(ftid, gradeSele, schoolText, btimeText, etimeText);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "更新失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        showApPane(name);
    }

    public void showApPane(String name) {
        DefaultTableModel pamodel = new DefaultTableModel();
        pamodel.addColumn("编号");
        pamodel.addColumn("教师编号");
        pamodel.addColumn("姓名");
        pamodel.addColumn("类型");
        pamodel.addColumn("时间");
        pamodel.addColumn("描述");
        PADao paDao = new PADao();
        for (PunishAward punishAward : paDao.getAllpa(name)) {
            pamodel.addRow(new Object[]{punishAward.getApId(),
                    punishAward.getTeacherId(), punishAward.getTeacherName(),
                    punishAward.getType(), punishAward.getTime(),
                    punishAward.getDescribe()});
        }
        apTable.setModel(pamodel);
    }

}
