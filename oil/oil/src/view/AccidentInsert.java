package view;


import dao.AccidentDao;
import dao.ProcessesDao;
import dao.WellDao;
import domain.Accident;
import domain.Processes;
import domain.Well;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccidentInsert extends JFrame {
    JLabel j1;
    JTextField accidentCnumber;
    JLabel j2;
    JTextField wellNumber;
    JLabel j3;
    JTextField oilName;
    JLabel j4;
    JTextField beginTime;
    JLabel j5;
    JTextField endTime;
    JLabel j6;
    JTextField lose;
    JLabel j7;

    public AccidentInsert(String encoding) {
        this.repaint();
        setTitle("新增油田钻井事故案例");
        setLayout(null);
        setSize(1130, 400);
        setLocation(380, 290);
        setVisible(true);
        setResizable(false);
        //获得主窗体容器
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        JPanel managePane = new JPanel();
        mainPane.setBorder(new TitledBorder(null, "*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        mainPane.setBounds(10, 20, 1100, 105);
        //设置布局方式为手动设置位置
        //将其添加到主窗体容器中
        //新建操作容器
        managePane.setBorder(new TitledBorder(null, "新增事故", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        managePane.setBounds(10, 10, 1100, 300);
        mainPane.add(managePane);
        managePane.setLayout(null);

/**
 * 事件编码，井号，油田，起始井深，结束井深，对应编码，地层，岩性，开始时间，结束时间，损失金额，经过，处理结果
 */
        //新增组件
        j1 = new JLabel("事件编码:");
        managePane.add(j1);
        j1.setBounds(10, 35, 100, 20);
        accidentCnumber = new JTextField();
        managePane.add(accidentCnumber);
        accidentCnumber.setBounds(70, 35, 100, 20);
        accidentCnumber.setText(new WellDao().getAccidentId(encoding));
        accidentCnumber.setEditable(false);

        j2 = new JLabel("井号:");
        managePane.add(j2);
        j2.setBounds(200, 35, 100, 20);
        wellNumber = new JTextField();
        managePane.add(wellNumber);
        wellNumber.setBounds(230, 35, 100, 20);

        j3 = new JLabel("油田:");
        managePane.add(j3);
        j3.setBounds(360, 35, 100, 20);
        oilName = new JTextField();
        managePane.add(oilName);
        oilName.setBounds(390, 35, 100, 20);

        JLabel n1 = new JLabel("起始井深:");
        managePane.add(n1);
        n1.setBounds(550, 35, 100, 20);
        JTextField bdep = new JTextField();
        managePane.add(bdep);
        bdep.setBounds(610, 35, 100, 20);

        JLabel n2 = new JLabel("结束井深:");
        managePane.add(n2);
        n2.setBounds(740, 35, 100, 20);
        JTextField edep = new JTextField();
        managePane.add(edep);
        edep.setBounds(810, 35, 100, 20);


        //-------------------------------------------
        JLabel n4 = new JLabel("对应编码:");
        managePane.add(n4);
        n4.setBounds(10, 80, 100, 20);
        JTextField encod = new JTextField();
        managePane.add(encod);
        encod.setBounds(70, 80, 100, 20);
        encod.setText(encoding);
        encod.setEditable(false);

        JLabel n5 = new JLabel("地层:");
        managePane.add(n5);
        n5.setBounds(200, 80, 100, 20);
        JTextField floor = new JTextField();
        managePane.add(floor);
        floor.setBounds(230, 80, 100, 20);

        JLabel n6 = new JLabel("岩性:");
        managePane.add(n6);
        n6.setBounds(360, 80, 100, 20);
        JTextField stratum = new JTextField();
        managePane.add(stratum);
        stratum.setBounds(390, 80, 100, 20);


        j4 = new JLabel("起始时间:");
        managePane.add(j4);
        j4.setBounds(550, 80, 100, 20);
        beginTime = new JTextField();
        managePane.add(beginTime);
        beginTime.setBounds(610, 80, 100, 20);


        j5 = new JLabel("结束时间");
        managePane.add(j5);
        j5.setBounds(740, 80, 100, 20);
        endTime = new JTextField();
        managePane.add(endTime);
        endTime.setBounds(810, 80, 100, 20);

//////////////////////////
        j6 = new JLabel("损失金额:");
        managePane.add(j6);
        j6.setBounds(10, 125, 100, 20);
        lose = new JTextField();
        managePane.add(lose);
        lose.setBounds(70, 125, 100, 20);

        JLabel n3 = new JLabel("经过:");
        managePane.add(n3);
        n3.setBounds(200, 125, 50, 20);
        JTextArea pass = new JTextArea();
        managePane.add(pass);
        pass.setBounds(230, 125, 260, 150);
        pass.setWrapStyleWord(true);
        pass.setLineWrap(true);

        j7 = new JLabel("处理结果:");
        managePane.add(j7);
        j7.setBounds(550, 125, 100, 20);
        JTextArea trpross = new JTextArea();
        managePane.add(trpross);
        trpross.setBounds(610, 125, 260, 150);
        trpross.setLineWrap(true);
        trpross.setWrapStyleWord(true);

        JButton comit = new JButton("提交");
        managePane.add(comit);
        comit.setBounds(70, 255, 100, 20);

        comit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accidentCnumberText = accidentCnumber.getText();
                int well = Integer.parseInt(wellNumber.getText());
                String oilNameText = oilName.getText();
                String bdepText = bdep.getText();
                String edepText = edep.getText();
                //对应编码 encoding
                String floorText = floor.getText();
                String stratumText = stratum.getText();

                String beginText = beginTime.getText();
                String endText = endTime.getText();
                String loseText = lose.getText();
                String passText = pass.getText();
                String trprossText = trpross.getText();

                if (accidentCnumberText == null || "".equals(accidentCnumberText.trim())) {
                    JOptionPane.showMessageDialog(null, "事件编码不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (wellNumber == null) {
                    JOptionPane.showMessageDialog(null, "井号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (oilNameText == null || "".equals(oilNameText.trim())) {
                    JOptionPane.showMessageDialog(null, "油田不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (bdepText == null || "".equals(bdepText.trim())) {
                    JOptionPane.showMessageDialog(null, "起始井深不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (edepText == null || "".equals(edepText.trim())) {
                    JOptionPane.showMessageDialog(null, "结束井深不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (floorText == null || "".equals(floorText.trim())) {
                    JOptionPane.showMessageDialog(null, "地层不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (stratumText == null || "".equals(stratumText.trim())) {
                    JOptionPane.showMessageDialog(null, "岩性不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (beginText == null || "".equals(beginText.trim())) {
                    JOptionPane.showMessageDialog(null, "开始时间不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (endText == null || "".equals(endText.trim())) {
                    JOptionPane.showMessageDialog(null, "结束时间不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (loseText == null || "".equals(loseText.trim())) {
                    JOptionPane.showMessageDialog(null, "损失金额不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (passText == null || "".equals(passText.trim())) {
                    JOptionPane.showMessageDialog(null, "经过不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (trprossText == null || "".equals(trprossText.trim())) {
                    JOptionPane.showMessageDialog(null, "处理结果不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Well well1 = new Well(accidentCnumberText, well, oilNameText);
                Accident accident = new Accident(accidentCnumberText, well, "",
                        bdepText, edepText, encoding, floorText, stratumText
                        , beginText, endText, loseText, passText, "");
                Processes processes = new Processes(accidentCnumberText, trprossText);

                int i = new WellDao().insertWellAccient(well1);
                int i1 = new AccidentDao().insertAccident(accident);
                int i2 = new ProcessesDao().insertProcess(processes);


                if ((i + i1 + i2) == 3) {
                    JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }
}
