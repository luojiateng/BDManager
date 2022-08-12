package peopleManager.view.teacher;


import peopleManager.bean.Education;
import peopleManager.bean.Family;
import peopleManager.bean.PunishAward;
import peopleManager.dao.EducationDao;
import peopleManager.dao.FamilyDao;
import peopleManager.dao.PADao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowTeacher extends JFrame {
    private JTable fTable;
    private JTable mTable;
    private JTable edTable;


    public ShowTeacher(String name) {
        setTitle("教师详细信息");
        setSize(690, 640);
        setLocation(651, 278);
        setLayout(null);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        setResizable(false);

        JPanel baseMessPane = new JPanel();
        baseMessPane.setBorder(new TitledBorder(null, "教师奖惩信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        baseMessPane.setBounds(15, 15, 650, 180);
        mainPane.add(baseMessPane);
        baseMessPane.setLayout(null);


        JPanel famliyPane = new JPanel();
        famliyPane.setBorder(new TitledBorder(null, "教师家庭关系", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        famliyPane.setBounds(15, 210, 650, 180);
        mainPane.add(famliyPane);
        famliyPane.setLayout(null);


        JPanel eduPan = new JPanel();
        eduPan.setBorder(new TitledBorder(null, "教师学籍经历", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        eduPan.setBounds(15, 405, 650, 180);
        mainPane.add(eduPan);
        eduPan.setLayout(null);


        JScrollPane baseScrollPane = new JScrollPane();
        baseScrollPane.setBounds(14, 20, 620, 150);
        baseMessPane.add(baseScrollPane);
        mTable = new JTable();
        baseScrollPane.setViewportView(mTable);

        JScrollPane familyScrollPane = new JScrollPane();
        familyScrollPane.setBounds(14, 20, 620, 150);
        famliyPane.add(familyScrollPane);
        fTable = new JTable();
        familyScrollPane.setViewportView(fTable);

        JScrollPane eduScrollPane = new JScrollPane();
        eduScrollPane.setBounds(14, 20, 620, 150);
        eduPan.add(eduScrollPane);
        edTable = new JTable();
        eduScrollPane.setViewportView(edTable);

        showPunishAward(name);
        showFamily(name);
        showEdu(name);

    }

    public void showPunishAward(String name) {
        DefaultTableModel pamodel = new DefaultTableModel();
        pamodel.addColumn("编号");
        pamodel.addColumn("姓名");
        pamodel.addColumn("类型");
        pamodel.addColumn("时间");
        pamodel.addColumn("描述");
        for (PunishAward punishAward : new PADao().getAllpa(name)) {
            pamodel.addRow(new Object[]{punishAward.getTeacherId(),
                    punishAward.getTeacherName(), punishAward.getType(),
                    punishAward.getTime(), punishAward.getDescribe()});
        }
        mTable.setModel(pamodel);
    }

    public void showFamily(String name) {
        DefaultTableModel fmodel = new DefaultTableModel();
        fmodel.addColumn("编号");
        fmodel.addColumn("姓名");
        fmodel.addColumn("家庭关系");
        fmodel.addColumn("亲属姓名");
        for (Family family : new FamilyDao().getFamily(name)) {
            fmodel.addRow(new Object[]{family.getTeacherId(),
                    family.getTeacherName(), family.getRelation(),
                    family.getMamberName()});
        }
        fTable.setModel(fmodel);
    }

    public void showEdu(String name) {
        DefaultTableModel emodel = new DefaultTableModel();
        emodel.addColumn("编号");
        emodel.addColumn("姓名");
        emodel.addColumn("学习阶段");
        emodel.addColumn("学校");
        emodel.addColumn("开始时间");
        emodel.addColumn("结束时间");
        for (Education education : new EducationDao().getEducation(name)) {
            emodel.addRow(new Object[]{education.getTeacherId(),
                    education.getTeacherName(), education.getEducation(),
                    education.getSchool(), education.getBeginTiem(),
                    education.getEndTime()});
        }
        edTable.setModel(emodel);
    }


}
