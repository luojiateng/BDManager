package com.kaizi.view.others;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.kaizi.dao.TeacherDAO;
import com.kaizi.entity.Teacher;
import com.kaizi.tool.DateConvert;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SaveTeacherFrame1<main> extends JFrame {
    private JTextField txtTeaNum;
    private JTextField txtTeaName;
    private JTextField txtTeaBtd;
    private JPasswordField txtTeaPwd;
    private JTextField txtRoleId;
    private JComboBox cbbTeaTitle;
    private JRadioButton rbDy;
    private JRadioButton rbJy;
    private JRadioButton rbTeazc;
    private JRadioButton brTeaXj;
    private JRadioButton rbTeaTz;
    public SaveTeacherFrame1() {
        setTitle("新增学生信息");
        setSize(658 + 23 * 2 + 13, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        JButton btnOk = new JButton("\u4FDD\u5B58");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //1 验证 check
                String teaNum = txtTeaNum.getText();
                //C/S
                //if (teaNum == null || teaNum.trim().length() == 0) {
                if (teaNum == null || "".equals(teaNum.trim())) {
                    JOptionPane.showMessageDialog(null, "老师编号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (teaNum.length() > 8) {
                    JOptionPane.showMessageDialog(null, "老师编号不能大于8位!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //2 完成业务

                String teaName = txtTeaName.getText();

                String teaTitle = cbbTeaTitle.getSelectedItem().toString();
                System.out.println(teaTitle);
                int teaTypeId = 1;//1上课老师 2 导员
                if (rbDy.isSelected()) teaTypeId = 2;
                String dateStr = txtTeaBtd.getText();
                Date teaBtd = DateConvert.convertToDate(dateStr);
                String pwd = new String(txtTeaPwd.getPassword());
                int state = 1;
                if (brTeaXj.isSelected()) state = 2;
                if (rbTeaTz.isSelected()) state = 3;
                int roleId = Integer.parseInt(txtRoleId.getText());
                Teacher t = new Teacher(teaNum, teaName, teaTitle, teaTypeId, teaBtd, pwd, state, roleId, "", 0);
                TeacherDAO teacherDAO = new TeacherDAO();
                boolean ok = teacherDAO.save(t);
                if (ok) {
                    JOptionPane.showMessageDialog(null, "新增老师信息成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "新增老师信息失败!", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JPanel mainPanel = (JPanel) getContentPane();
        btnOk.setBounds(569, 403, 93, 23);
        mainPanel.add(btnOk);

        JButton btnCS = new JButton("\u53D6\u6D88");
        btnCS.setBounds(452, 403, 93, 23);
        mainPanel.add(btnCS);

        JPanel panel_other = new JPanel();
        panel_other.setToolTipText("");
        panel_other.setLayout(null);
        panel_other.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u89D2\u8272\u5B89\u5168", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_other.setBounds(23, 268, 658, 125);
        mainPanel.add(panel_other);

        JLabel label_6 = new JLabel("老师密码:");
        label_6.setBounds(31, 23, 73, 36);
        panel_other.add(label_6);

        txtTeaPwd = new JPasswordField();
        txtTeaPwd.setBounds(90, 31, 211, 21);
        panel_other.add(txtTeaPwd);

        JLabel label_7 = new JLabel("角     色:");
        label_7.setBounds(346, 23, 73, 36);
        panel_other.add(label_7);

        txtRoleId = new JTextField();
        txtRoleId.setColumns(10);
        txtRoleId.setBounds(409, 31, 211, 21);
        panel_other.add(txtRoleId);

        JLabel label_8 = new JLabel("状     态:");
        label_8.setBounds(31, 68, 73, 36);
        panel_other.add(label_8);


        rbTeazc = new JRadioButton("正常", true);
        rbTeazc.setBounds(96, 75, 63, 23);
        panel_other.add(rbTeazc);
        brTeaXj = new JRadioButton("休假");
        brTeaXj.setBounds(180, 75, 73, 23);
        panel_other.add(brTeaXj);
        rbTeaTz = new JRadioButton("停职");
        rbTeaTz.setBounds(254, 75, 121, 23);
        panel_other.add(rbTeaTz);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(rbTeazc);
        bg2.add(brTeaXj);
        bg2.add(rbTeaTz);

        JPanel panel_Base_Data = new JPanel();
        panel_Base_Data.setLayout(null);
        panel_Base_Data.setBorder(new TitledBorder(null, "\u57FA\u7840\u6570\u636E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_Base_Data.setBounds(23, 53, 658, 197);
        mainPanel.add(panel_Base_Data);

        JLabel label = new JLabel("老师职称:");
        label.setBounds(31, 82, 73, 36);
        panel_Base_Data.add(label);

        JLabel label_1 = new JLabel("\u8001\u5E08\u7F16\u53F7:");
        label_1.setBounds(31, 23, 73, 36);
        panel_Base_Data.add(label_1);

        txtTeaNum = new JTextField();
        txtTeaNum.setColumns(10);
        txtTeaNum.setBounds(90, 31, 211, 21);
        panel_Base_Data.add(txtTeaNum);

        JLabel label_2 = new JLabel("\u8001\u5E08\u59D3\u540D:");
        label_2.setBounds(347, 23, 73, 36);
        panel_Base_Data.add(label_2);

        txtTeaName = new JTextField();
        txtTeaName.setColumns(10);
        txtTeaName.setBounds(410, 31, 211, 21);
        panel_Base_Data.add(txtTeaName);

        cbbTeaTitle = new JComboBox();
        cbbTeaTitle.setBounds(90, 88, 211, 25);
        panel_Base_Data.add(cbbTeaTitle);
        cbbTeaTitle.addItem("教授");
        cbbTeaTitle.addItem("副教授");
        cbbTeaTitle.addItem("讲师");
        cbbTeaTitle.addItem("助教");
        cbbTeaTitle.setSelectedIndex(2);

        JLabel label_4 = new JLabel("老师类别:");
        label_4.setBounds(347, 82, 73, 36);
        panel_Base_Data.add(label_4);

        rbJy = new JRadioButton("教员", true);
        rbJy.setBounds(410, 89, 82, 23);
        panel_Base_Data.add(rbJy);

        rbDy = new JRadioButton("导员");
        rbDy.setBounds(494, 89, 121, 23);
        panel_Base_Data.add(rbDy);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbDy);
        bg.add(rbJy);

        JLabel label_5 = new JLabel("老师生日:");
        label_5.setBounds(31, 141, 73, 36);
        panel_Base_Data.add(label_5);

        txtTeaBtd = new JTextField();
        txtTeaBtd.setColumns(10);
        txtTeaBtd.setBounds(90, 149, 211, 21);
        panel_Base_Data.add(txtTeaBtd);


        JLabel label_3 = new JLabel("\u65B0\u589E\u8001\u5E08\u4FE1\u606F");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        label_3.setBounds(309, 10, 182, 52);
        mainPanel.add(label_3);
    }

    public static void main(String[] args) {
        SaveTeacherFrame1 frame = new SaveTeacherFrame1();
        frame.setVisible(true);
    }
}
