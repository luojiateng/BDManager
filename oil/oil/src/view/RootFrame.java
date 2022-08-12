package view;


import com.sun.xml.internal.bind.v2.TODO;
import dao.AccidentDao;
import dao.ProcessesDao;
import dao.SignDao;
import dao.WellDao;
import domain.Accident;
import domain.Processes;
import domain.Sign;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootFrame extends JFrame {
    JTable table = null;
    JButton insertBut;
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
    JComboBox sings;
    JLabel j7;
    JTextField accidentPross;
    JLabel j8;
    JTextField oilNameCout;
    JLabel j9;
    JTextField wellCount;
    JLabel j10;
    JTextField timeAccidentCnumber;

    public RootFrame() {
        this.repaint();
        setTitle("油田钻井事故案例管理系统");
        setLayout(null);
        setSize(1160, 500);
        setLocation(380, 290);
        setVisible(true);
        setResizable(true);
        //获得主窗体容器
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        //新建数据容器
        JPanel datapane = new JPanel();
        JPanel managePane = new JPanel();
        mainPane.setBorder(new TitledBorder(null, "*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        mainPane.setBounds(10, 20, 1100, 105);
        datapane.setBorder(new TitledBorder(null, "事故详情", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        datapane.setBounds(20, 15, 1100, 200);
        //设置布局方式为手动设置位置
        //将其添加到主窗体容器中
        //新建操作容器
        managePane.setBorder(new TitledBorder(null, "事故管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        managePane.setBounds(20, 230, 1100, 200);
        mainPane.add(datapane);
        mainPane.add(managePane);
        datapane.setLayout(null);
        managePane.setLayout(null);


        //放table，带有拖动条的数据展示框
        JScrollPane deptScroll = new JScrollPane();
        deptScroll.setBounds(14, 20, 1075, 170);
        datapane.add(deptScroll);
        table = new JTable();
        deptScroll.setViewportView(table);
        //数据展示
        showAllAccident();

        //新增组件

        j1 = new JLabel("新增:");
        managePane.add(j1);
        j1.setBounds(10, 170, 100, 20);
        accidentCnumber = new JTextField();

        JComboBox encoding = new JComboBox();
        encoding.addItem("请选择事故类型");
        for (String s : new AccidentDao().getAllApattern()) {
            encoding.addItem(s);
        }
        managePane.add(encoding);
        encoding.setBounds(50, 170, 100, 20);
        insertBut = new JButton("新增事故");
        managePane.add(insertBut);
        insertBut.setBounds(170, 170, 100, 20);
        insertBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = encoding.getSelectedItem().toString();
                String encod = null;
                if (!"请选择事故类型".equals(s)) {
                    encod = new AccidentDao().getEncodingByAppttern(s);
                } else {
                    JOptionPane.showMessageDialog(null, "请选择类型!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                AccidentInsert accidentInsert = new AccidentInsert(encod);
                accidentInsert.setLocationRelativeTo(null);
                accidentInsert.setVisible(true);
            }
        });


        j1 = new JLabel("案例号:");
        managePane.add(j1);
        j1.setBounds(10, 35, 100, 20);
        accidentCnumber = new JTextField();
        managePane.add(accidentCnumber);
        accidentCnumber.setBounds(50, 35, 100, 20);
        JButton accidentBut = new JButton("查询");
        managePane.add(accidentBut);
        accidentBut.setBounds(170, 35, 100, 20);
        accidentBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accidentCnumberText = accidentCnumber.getText();
                if (accidentCnumberText == null || "".equals(accidentCnumberText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showAccidentByCnumber(accidentCnumberText);

            }
        });

        j2 = new JLabel("井号:");
        managePane.add(j2);
        j2.setBounds(385, 35, 100, 20);
        wellNumber = new JTextField();
        managePane.add(wellNumber);
        wellNumber.setBounds(430, 35, 100, 20);
        JButton wellBut = new JButton("查询");
        managePane.add(wellBut);
        wellBut.setBounds(530, 35, 100, 20);
        wellBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wellNumberText = wellNumber.getText();
                if (wellNumberText == null || "".equals(wellNumberText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showAccidentByWellNumber(Integer.parseInt(wellNumberText));

            }
        });

        j3 = new JLabel("油田:");
        managePane.add(j3);
        j3.setBounds(740, 35, 100, 20);
        oilName = new JTextField();
        managePane.add(oilName);
        oilName.setBounds(810, 35, 100, 20);
        JButton oilBut = new JButton("查询");
        managePane.add(oilBut);
        oilBut.setBounds(910, 35, 100, 20);
        oilBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oilNameText = oilName.getText();
                if (oilNameText == null || "".equals(oilNameText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showAccidentByOilFileName(oilNameText);

            }
        });

        //-------------------------------------------

        j4 = new JLabel("时间:");
        managePane.add(j4);
        j4.setBounds(10, 80, 100, 20);
        beginTime = new JTextField();
        managePane.add(beginTime);
        beginTime.setBounds(50, 80, 100, 20);
        j5 = new JLabel("到");
        managePane.add(j5);
        j5.setBounds(152, 80, 100, 20);
        endTime = new JTextField();
        managePane.add(endTime);
        endTime.setBounds(170, 80, 100, 20);
        JButton timeBut = new JButton("查询");
        managePane.add(timeBut);
        timeBut.setBounds(272, 80, 100, 20);
        timeBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String beginTimeText = beginTime.getText();
                String endText = endTime.getText();

                if (beginTimeText == null || "".equals(beginTimeText.trim()) && (endText == null || "".equals(endText.trim()))) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showAccidentByTime(beginTimeText, endText);
            }
        });


        j6 = new JLabel("征兆:");
        managePane.add(j6);
        j6.setBounds(385, 80, 100, 20);
        sings = new JComboBox();
        managePane.add(sings);
        sings.setBounds(430, 80, 50, 20);
        sings.addItem(" ");
        sings.addItem("before");
        sings.addItem("after");
        JLabel n1 = new JLabel("事故号:");
        managePane.add(n1);
        n1.setBounds(485, 80, 50, 20);
        JTextField signCnumber = new JTextField();
        managePane.add(signCnumber);
        signCnumber.setBounds(530, 80, 100, 20);
        JButton signBut = new JButton("查询");
        managePane.add(signBut);
        signBut.setBounds(635, 80, 100, 20);
        signBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = sings.getSelectedItem().toString();
                String Cnumber = signCnumber.getText();
                if (s.equals("") && Cnumber == null || "".equals(Cnumber.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showSign(Cnumber, s);
            }
        });


        j7 = new JLabel("案例编号:");
        managePane.add(j7);
        j7.setBounds(740, 80, 100, 20);
        accidentPross = new JTextField();
        managePane.add(accidentPross);
        accidentPross.setBounds(810, 80, 100, 20);
        JButton proBut = new JButton("事故处理查询");
        managePane.add(proBut);
        proBut.setBounds(910, 80, 120, 20);
        proBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accidentProssText = accidentPross.getText();
                if (accidentProssText == null || "".equals(accidentProssText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showProcesses(accidentProssText);
            }
        });

        ///
        j8 = new JLabel("油田:");
        managePane.add(j8);
        j8.setBounds(10, 125, 100, 20);
        oilNameCout = new JTextField();
        managePane.add(oilNameCout);
        oilNameCout.setBounds(50, 125, 100, 20);
        JButton oilAccBut = new JButton("事故数量统计");
        managePane.add(oilAccBut);
        oilAccBut.setBounds(170, 125, 120, 20);
        oilAccBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oilNameCoutText = oilNameCout.getText();
                if (oilNameCoutText == null || "".equals(oilNameCoutText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //TODO
                showAccidentCountByOilFiledName(oilNameCoutText);
            }
        });

        j9 = new JLabel("井号:");
        managePane.add(j9);
        j9.setBounds(385, 125, 100, 20);
        wellCount = new JTextField();
        managePane.add(wellCount);
        wellCount.setBounds(430, 125, 100, 20);
        JButton wellACcBut = new JButton("事故数量统计");
        managePane.add(wellACcBut);
        wellACcBut.setBounds(530, 125, 120, 20);
        wellACcBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wellCountText = wellCount.getText();
                if (wellCountText == null || "".equals(wellCountText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showAccidentCountByWellId(Integer.parseInt(wellCountText));
            }
        });

        j10 = new JLabel("事故编号:");
        managePane.add(j10);
        j10.setBounds(740, 125, 100, 20);
        timeAccidentCnumber = new JTextField();
        managePane.add(timeAccidentCnumber);
        timeAccidentCnumber.setBounds(810, 125, 100, 20);
        JButton timeDiffBut = new JButton("持续时间统计");
        managePane.add(timeDiffBut);
        timeDiffBut.setBounds(910, 125, 120, 20);
        timeDiffBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeAccidentCnumberText = timeAccidentCnumber.getText();
                if (timeAccidentCnumberText == null || "".equals(timeAccidentCnumberText.trim())) {
                    JOptionPane.showMessageDialog(null, "方框内的值不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                showBtoEtime(timeAccidentCnumberText);
            }
        });

    }

    /**
     * 给视图中的表格添加所有的事故数据
     */
    public void showAllAccident() {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("井号");
        model.addColumn("油田");
        model.addColumn("起始井深(米)");
        model.addColumn("终止井深(米)");
        model.addColumn("事故编码");
        model.addColumn("钻遇底层");
        model.addColumn("岩性");
        model.addColumn("起始时间");
        model.addColumn("解除时间");
        model.addColumn("损失金额(元)");
        model.addColumn("经过");
        model.addColumn("事故类型");
        for (Accident accident : new AccidentDao().getAllAccident()) {
            model.addRow(new Object[]{accident.getcNumber(),
                    accident.getWellNumber(), accident.getOname(),
                    accident.getInDepth(), accident.getEndDepth(),
                    accident.getEncoding(), accident.getGfloor(),
                    accident.getStratum(), accident.getOctime(),
                    accident.getRetime(), accident.getLossMoney(),
                    accident.getPass(), accident.getApattern()});
        }
        table.setModel(model);
    }

    /**
     * 给视图中的表格添加事故征兆数据
     *
     * @param time 征兆类型
     */
    public void showSign(String Cnumber, String time) {

        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("征兆发生时间");
        model.addColumn("征兆描述");
        for (Sign sign : new SignDao().getSignBy(Cnumber, time)) {
            model.addRow(new Object[]{sign.getCnumber(),
                    sign.getTime(), sign.getSymbol(),});
        }
        table.setModel(model);
    }

    /**
     * 查看全部的数据
     */
    public void showProcesses(String Cnumber) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("处理过程");
        Processes processByCnumebr = new ProcessesDao().getProcessByCnumebr(Cnumber);
        model.addRow(new Object[]{processByCnumebr.getCnumber(), processByCnumebr.getTrpocesses()});
        table.setModel(model);
    }

    /**
     * 通过案例标号进行查询事故
     */
    public void showAccidentByCnumber(String Cumber) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("井号");
        model.addColumn("油田");
        model.addColumn("起始井深(米)");
        model.addColumn("终止井深(米)");
        model.addColumn("事故编码");
        model.addColumn("钻遇底层");
        model.addColumn("岩性");
        model.addColumn("起始时间");
        model.addColumn("解除时间");
        model.addColumn("损失金额(元)");
        model.addColumn("经过");
        model.addColumn("事故类型");
        Accident accidentByCnumber = new AccidentDao().getAccidentByCnumber(Cumber);
        model.addRow(new Object[]{accidentByCnumber.getcNumber(),
                accidentByCnumber.getWellNumber(), accidentByCnumber.getOname(),
                accidentByCnumber.getInDepth(), accidentByCnumber.getEndDepth(),
                accidentByCnumber.getEncoding(), accidentByCnumber.getGfloor(),
                accidentByCnumber.getStratum(), accidentByCnumber.getOctime(),
                accidentByCnumber.getRetime(), accidentByCnumber.getLossMoney(),
                accidentByCnumber.getPass(), accidentByCnumber.getApattern()});
        table.setModel(model);

    }

    /**
     * 通过井号进行查询
     */
    public void showAccidentByWellNumber(Integer wellNumber) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("井号");
        model.addColumn("油田");
        model.addColumn("起始井深(米)");
        model.addColumn("终止井深(米)");
        model.addColumn("事故编码");
        model.addColumn("钻遇底层");
        model.addColumn("岩性");
        model.addColumn("起始时间");
        model.addColumn("解除时间");
        model.addColumn("损失金额(元)");
        model.addColumn("经过");
        model.addColumn("事故类型");
        for (Accident accident : new AccidentDao().getAccidentByWnumber(wellNumber)) {

            model.addRow(new Object[]{accident.getcNumber(),
                    accident.getWellNumber(), accident.getOname(),
                    accident.getInDepth(), accident.getEndDepth(),
                    accident.getEncoding(), accident.getGfloor(),
                    accident.getStratum(), accident.getOctime(),
                    accident.getRetime(), accident.getLossMoney(),
                    accident.getPass(), accident.getApattern()});
        }

        table.setModel(model);
    }

    /**
     * 通过油田名查询事故详情
     */
    public void showAccidentByOilFileName(String Oname) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("井号");
        model.addColumn("油田");
        model.addColumn("起始井深(米)");
        model.addColumn("终止井深(米)");
        model.addColumn("事故编码");
        model.addColumn("钻遇底层");
        model.addColumn("岩性");
        model.addColumn("起始时间");
        model.addColumn("解除时间");
        model.addColumn("损失金额(元)");
        model.addColumn("经过");
        model.addColumn("事故类型");
        for (Accident accident : new AccidentDao().getAccidentByOname(Oname)) {

            model.addRow(new Object[]{accident.getcNumber(),
                    accident.getWellNumber(), accident.getOname(),
                    accident.getInDepth(), accident.getEndDepth(),
                    accident.getEncoding(), accident.getGfloor(),
                    accident.getStratum(), accident.getOctime(),
                    accident.getRetime(), accident.getLossMoney(),
                    accident.getPass(), accident.getApattern()});
        }

        table.setModel(model);
    }

    /**
     * 通过时间区间进行查询
     */
    public void showAccidentByTime(String beginTime, String endTime) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("井号");
        model.addColumn("油田");
        model.addColumn("起始井深(米)");
        model.addColumn("终止井深(米)");
        model.addColumn("事故编码");
        model.addColumn("钻遇底层");
        model.addColumn("岩性");
        model.addColumn("起始时间");
        model.addColumn("解除时间");
        model.addColumn("损失金额(元)");
        model.addColumn("经过");
        model.addColumn("事故类型");
        for (Accident accident : new AccidentDao().getAccidentByDate(beginTime, endTime)) {

            model.addRow(new Object[]{accident.getcNumber(),
                    accident.getWellNumber(), accident.getOname(),
                    accident.getInDepth(), accident.getEndDepth(),
                    accident.getEncoding(), accident.getGfloor(),
                    accident.getStratum(), accident.getOctime(),
                    accident.getRetime(), accident.getLossMoney(),
                    accident.getPass(), accident.getApattern()});
        }

        table.setModel(model);
    }

    /**
     * 通过油田名对事故数量进行统计
     */
    public void showAccidentCountByOilFiledName(String Oname) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("油田");
        model.addColumn("发生事故总数");
        int accidentCountByOilName = new AccidentDao().getAccidentCountByOilName(Oname);
        model.addRow(new Object[]{Oname, accidentCountByOilName});
        table.setModel(model);
    }

    /**
     * 通过井号对事故数量进行统计
     */
    public void showAccidentCountByWellId(Integer wellId) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("油井编号");
        model.addColumn("发生事故总数");
        int accidentCountByOilName = new AccidentDao().getAccidentCountByWell(wellId);
        model.addRow(new Object[]{wellId, accidentCountByOilName});
        table.setModel(model);
    }

    /**
     * 通过事故编号查询事故持续时间
     */
    public void showBtoEtime(String Cnumber) {
        DefaultTableModel model = new DefaultTableModel();
        //增加列名
        model.addColumn("事故编号");
        model.addColumn("持续时间");
        String accidentTimeDiff = new AccidentDao().getAccidentTimeDiff(Cnumber);
        model.addRow(new Object[]{Cnumber, accidentTimeDiff});
        table.setModel(model);
    }

}
