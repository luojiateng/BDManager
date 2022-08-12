package peopleManager.view.teacher;


import peopleManager.bean.Teacher;
import peopleManager.dao.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class CreatTeacher extends JFrame {
    //当基本信息提交完成之后，才可以提交
    boolean baseconmit = false;

    public CreatTeacher() {
        setTitle("新增教师信息");
        setSize(700, 575);
        setLocation(624, 325);
        setLayout(null);
        setResizable(false);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);

        JPanel baseMessPane = new JPanel();
        baseMessPane.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        baseMessPane.setBounds(15, 15, 650, 220);
        mainPane.add(baseMessPane);
        baseMessPane.setLayout(null);

        JPanel famliyPane = new JPanel();
        famliyPane.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        famliyPane.setBounds(15, 250, 650, 130);
        mainPane.add(famliyPane);
        famliyPane.setLayout(null);

        JPanel edupane = new JPanel();
        edupane.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        edupane.setBounds(15, 390, 650, 130);
        mainPane.add(edupane);
        edupane.setLayout(null);


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
        tid.setText(new TeacherDao().getIndex() + "");

        baseMessPane.add(tid);

        JLabel l3 = new JLabel("职工姓名:");
        l3.setFont(new Font("宋体", Font.PLAIN, 20));
        l3.setBounds(20, 90, 100, 25);
        baseMessPane.add(l3);
        JTextField tname = new JTextField();
        tname.setColumns(10);
        tname.setBounds(125, 93, 150, 21);
        baseMessPane.add(tname);

        JLabel l5 = new JLabel("性  别:");
        l5.setFont(new Font("宋体", Font.PLAIN, 20));
        l5.setBounds(20, 135, 100, 25);
        baseMessPane.add(l5);
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton boy = new JRadioButton("男", true);
        boy.setBounds(123, 138, 63, 23);
        baseMessPane.add(boy);
        JRadioButton gril = new JRadioButton("女");
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
        baseMessPane.add(temail);

        JLabel l2 = new JLabel("所属部门:");
        l2.setFont(new Font("宋体", Font.PLAIN, 20));
        l2.setBounds(370, 45, 100, 25);
        baseMessPane.add(l2);
        JComboBox dept = new JComboBox();
        dept.setBounds(475, 48, 150, 21);
        baseMessPane.add(dept);
        dept.addItem("");
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
        title.addItem("");
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
        position.addItem("");
        for (String s : new PositionDao().getPositionName()) {
            position.addItem(s);
        }


        JButton lcomit = new JButton("提交");
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
                int i = teacherDao.insertTeacher(teacher);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    baseconmit = true;
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

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
        for (String s : new FamilyDao().getFamilyType()) {
            fbox.addItem(s);
        }


        JLabel f2 = new JLabel("姓  名:");
        f2.setFont(new Font("宋体", Font.PLAIN, 20));
        f2.setBounds(370, 48, 100, 35);
        famliyPane.add(f2);
        JTextField fname = new JTextField();
        fname.setColumns(10);
        fname.setBounds(475, 55, 150, 21);
        famliyPane.add(fname);

        JButton fcomit = new JButton("提交");
        fcomit.setFont(new Font("宋体", Font.PLAIN, 20));
        fcomit.setBounds(550, 85, 78, 21);
        famliyPane.add(fcomit);
        fcomit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baseconmit == false) {
                    JOptionPane.showMessageDialog(null, "请先提交教师基本信息!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
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

                int i = new FamilyDao().insertFamily(ftid, fr, fnameText);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        JLabel top3 = new JLabel("学籍经历");
        top3.setFont(new Font("宋体", Font.PLAIN, 20));
        top3.setBounds(285, 1, 182, 52);
        edupane.add(top3);

        JLabel e1 = new JLabel("学历:");
        e1.setFont(new Font("宋体", Font.PLAIN, 20));
        e1.setBounds(5, 38, 100, 35);
        edupane.add(e1);
        JComboBox grade = new JComboBox();
        grade.setBounds(65, 43, 100, 25);
        edupane.add(grade);
        grade.addItem("");
        for (String s : new EducationDao().getEduType()) {
            grade.addItem(s);
        }


        JLabel e2 = new JLabel("学校:");
        e2.setFont(new Font("宋体", Font.PLAIN, 20));
        e2.setBounds(175, 38, 100, 35);
        edupane.add(e2);
        JComboBox school = new JComboBox();
        school.setBounds(230, 43, 100, 25);
        edupane.add(school);
        school.addItem("");
        for (String s : new EducationDao().getSchoolType()) {
            school.addItem(s);
        }


        JLabel e3 = new JLabel("时间:");
        e3.setFont(new Font("宋体", Font.PLAIN, 20));
        e3.setBounds(335, 40, 100, 25);
        edupane.add(e3);
        JTextField btime = new JTextField();
        btime.setBounds(390, 43, 100, 25);
        edupane.add(btime);

        JTextField etime = new JTextField();
        etime.setBounds(520, 43, 100, 25);
        edupane.add(etime);

        JButton ecomit = new JButton("提交");
        ecomit.setFont(new Font("宋体", Font.PLAIN, 20));
        ecomit.setBounds(547, 85, 78, 21);
        edupane.add(ecomit);
        ecomit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baseconmit == false) {
                    JOptionPane.showMessageDialog(null, "请先提交教师基本信息!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
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
                int i = new EducationDao().insertEdu(ftid, gradeSele, schoolText, btimeText, etimeText);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

}
