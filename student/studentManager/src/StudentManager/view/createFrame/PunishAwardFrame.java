package StudentManager.view.createFrame;


import StudentManager.dao.PunishAwardDao;
import StudentManager.pojo.PunishAward;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class PunishAwardFrame extends JFrame {
    private JTable table;

    public PunishAwardFrame(Integer id) {

        setTitle("奖惩信息");
        setSize(640, 510);
        setLocation(616, 380);
        setLayout(null);
        JPanel mainPane = (JPanel) getContentPane();
        mainPane.setLayout(null);
        setResizable(true);


        JPanel apPane = new JPanel();
        apPane.setBorder(new TitledBorder(null, "奖惩统计", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        apPane.setBounds(15, 15, 600, 220);
        mainPane.add(apPane);
        apPane.setLayout(null);

        JScrollPane apScrollPane = new JScrollPane();
        apScrollPane.setBounds(14, 20, 580, 185);
        apPane.add(apScrollPane);
        table = new JTable();
        apScrollPane.setViewportView(table);


        ButtonGroup APGroup = new ButtonGroup();
        JRadioButton award = new JRadioButton("奖励", true);
        award.setBounds(15, 260, 63, 23);
        mainPane.add(award);
        JRadioButton punish = new JRadioButton("处罚");
        punish.setBounds(100, 260, 63, 23);
        mainPane.add(punish);
        APGroup.add(award);
        APGroup.add(punish);

        JLabel a1 = new JLabel("时间:");
        a1.setBounds(200, 260, 100, 23);
        mainPane.add(a1);
        JTextField aptime = new JTextField();
        aptime.setBounds(242, 263, 100, 21);
        mainPane.add(aptime);

        JLabel apDesc = new JLabel("详细描述:");
        apDesc.setBounds(15, 295, 100, 23);
        mainPane.add(apDesc);

        JTextArea desc = new JTextArea();
        desc.setBounds(15, 323, 330, 120);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        mainPane.add(desc);

        JButton insertAp = new JButton("新增");
        insertAp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                PunishAward punishAward = new PunishAward(0, id, "", ap, aptimeText, text);
                int i = new PunishAwardDao().insertPA(punishAward);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "新增成功");
                }
                showApPane(id);
            }
        });
        insertAp.setFont(new Font("宋体", Font.PLAIN, 20));
        insertAp.setBounds(355, 420, 78, 21);
        mainPane.add(insertAp);


        JButton deleButton = new JButton("删除");
        deleButton.setFont(new Font("宋体", Font.PLAIN, 20));
        deleButton.setBounds(530, 420, 78, 21);
        mainPane.add(deleButton);
        deleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据行!", "错误", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("编号".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }
                }
                Integer apid = Integer.parseInt(table.getValueAt(selectedRow, idColumnIndex).toString());

                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + apid + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int i = new PunishAwardDao().delePA(apid);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功");
                    }
                    showApPane(id);
                }
            }
        });
        showApPane(id);
    }

    public void showApPane(Integer id) {
        DefaultTableModel pamodel = new DefaultTableModel();
        pamodel.addColumn("编号");
        pamodel.addColumn("学生编号");
        pamodel.addColumn("姓名");
        pamodel.addColumn("类型");
        pamodel.addColumn("时间");
        pamodel.addColumn("描述");
        PunishAwardDao punishAwardDao = new PunishAwardDao();
        for (PunishAward pa : punishAwardDao.getAllpa(id)) {
            pamodel.addRow(new Object[]{pa.getApId(),
                    pa.getStudentId(), pa.getStudentName(),
                    pa.getType(), pa.getTime(),
                    pa.getDescribe()});
        }
        table.setModel(pamodel);
    }

//    //    用于单窗口测试
//    public static void main(String[] args) {
////        CreateStudentFrame frame = new CreateStudentFrame();
//        PunishAwardFrame frame = new PunishAwardFrame(1);
//        frame.setVisible(true);
//    }
}
