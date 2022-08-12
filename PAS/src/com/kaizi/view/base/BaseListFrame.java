package com.kaizi.view.base;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BaseListFrame extends BaseFrame {
    private JTextField textField;
    //表的组建
    protected JTable table;
    protected JPanel queryPanel = null;
    protected JLabel lblPageCount;
    protected JButton btnDelete;
    protected JButton btnUpdate;
    protected JButton btnInsert;
    protected JComboBox cbbNowPage;
    protected JButton btnFirst = null;
    protected JButton btnPr = null;
    protected JButton btnNext = null;
    protected JButton btnLast = null;

    public BaseListFrame() {

        queryPanel = new JPanel();
        queryPanel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        queryPanel.setBounds(14, 13, 1056, 60);
        mainPanel.add(queryPanel);
        queryPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("编号：");
        lblNewLabel.setBounds(14, 29, 91, 18);
        queryPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(82, 26, 159, 24);
        queryPanel.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.setBounds(929, 25, 113, 27);
        queryPanel.add(btnNewButton);

        //_________________________________________________________________
        JScrollPane tablePanel = new JScrollPane();
        tablePanel.setBounds(14, 86, 1056, 222);
        mainPanel.add(tablePanel);

        table = new JTable();
        tablePanel.setViewportView(table);

        JPanel pagePanel = new JPanel();
        pagePanel.setBounds(14, 317, 1056, 50);
        mainPanel.add(pagePanel);
        pagePanel.setLayout(null);

        //复选框
        cbbNowPage = new JComboBox();
        cbbNowPage.setBounds(20, 13, 113, 27);
        pagePanel.add(cbbNowPage);


        btnFirst = new JButton("首页");
        btnFirst.setBounds(602, 13, 113, 27);
        pagePanel.add(btnFirst);

        btnPr = new JButton("上一页");
        btnPr.setBounds(709, 13, 113, 27);
        pagePanel.add(btnPr);

        btnNext = new JButton("下一页");
        btnNext.setBounds(817, 13, 113, 27);
        pagePanel.add(btnNext);

        btnLast = new JButton("尾页");
        btnLast.setBounds(929, 13, 113, 27);
        pagePanel.add(btnLast);

        lblPageCount = new JLabel("New label");
        lblPageCount.setBounds(486, 17, 72, 18);
        pagePanel.add(lblPageCount);

        JPanel iudpanel = new JPanel();
        iudpanel.setBorder(new TitledBorder(null, "\u9AD8\u7EA7\u6743\u9650", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        iudpanel.setBounds(27, 365, 1043, 50);
        mainPanel.add(iudpanel);

        btnInsert = new JButton("新增");
        btnInsert.setBounds(696, 13, 113, 27);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        iudpanel.setLayout(null);
        iudpanel.add(btnInsert);

        btnUpdate = new JButton("修改");
        btnUpdate.setBounds(806, 13, 113, 27);
        iudpanel.add(btnUpdate);

        btnDelete = new JButton("删除");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnDelete.setBounds(916, 13, 113, 27);
        iudpanel.add(btnDelete);
    }

    public static void main(String[] args) {
        BaseListFrame baseListFrame = new BaseListFrame();
        baseListFrame.setSize(870, 500);
        baseListFrame.setVisible(true);
    }
}
