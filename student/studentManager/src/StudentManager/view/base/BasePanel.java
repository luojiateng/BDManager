package StudentManager.view.base;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasePanel extends JPanel {
    private JLabel lblMsg = null;
    protected JTextField textField;
    protected JPanel queryPanel;
    //    protected JTable table;
    protected JButton btnDelete;
    protected JButton btnUpdate;
    protected JButton btnInsert;
    protected JPanel iudpanel;

    public BasePanel() {
        setLayout(null);
        //查询框---------------------------------------------------------------------------------------
        queryPanel = new JPanel();
        queryPanel.setBorder(new TitledBorder(null, "查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        queryPanel.setBounds(14, 13, 1056, 60);
        add(queryPanel);

        //数据显示框---------------------------------------------------------------------------------------
        //由子类分别实现

        //增改查框---------------------------------------------------------------------------------------
        iudpanel = new JPanel();
        iudpanel.setBorder(new TitledBorder(null, "更改", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        iudpanel.setBounds(14, 331, 1056, 50);
        btnInsert = new JButton("新增");
        btnInsert.setBounds(696, 13, 113, 27);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
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
        add(iudpanel);

        //提示框---------------------------------------------------------------------------------------
        JPanel msgPanel = new JPanel();
        msgPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        FlowLayout flowLayout = (FlowLayout) msgPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        //将这个组件添加到主窗体上397 396
        msgPanel.setBounds(14, 396, 1056, 27);
        JLabel lblNewLabel = new JLabel("提示:");
        msgPanel.add(lblNewLabel);
        lblMsg = new JLabel("");
        msgPanel.add(lblMsg);//添加
        add(msgPanel);

    }


    /**
     * 设置错误信息：
     */
    protected void setErrorMsg(String msg) {
        lblMsg.setForeground(Color.RED);
        lblMsg.setText(msg);

    }

    /**
     * 设置成功信息
     */
    protected void setSuccessMsg(String msg) {
        lblMsg.setForeground(Color.GREEN);
        lblMsg.setText(msg);
    }

    /**
     * 设置信息
     *
     * @param msg
     */
    protected void setInfoMsg(String msg) {
        lblMsg.setForeground(Color.BLACK);
        lblMsg.setText(msg);
    }


}
