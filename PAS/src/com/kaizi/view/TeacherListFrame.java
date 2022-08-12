package com.kaizi.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kaizi.config.Config;
import com.kaizi.dao.TeacherDAO;
import com.kaizi.entity.Teacher;


import com.kaizi.view.base.BaseListFrame;
import com.kaizi.view.others.SaveTeacherFrame;
import com.kaizi.view.others.UpdateTeacherFrame;

import javax.swing.JComboBox;

public class TeacherListFrame extends BaseListFrame {
    private int nowPage = 1;
    private JTextField textField;
    private int pageCount = 1;

    public TeacherListFrame() {
        queryPanel.setSize(1083, 60);
        lblPageCount.setLocation(200, 19);
        cbbNowPage.setSize(117, 25);
        cbbNowPage.setLocation(268, 13);
        table.setBounds(15, 87, 817, 223);
        setTitle("老师信息列表");
        setSize(1149, 520);
        queryPanel.setLocation(14, 13);

        JLabel lblNewLabel = new JLabel("老师姓名:");
        lblNewLabel.setBounds(250, 29, 72, 18);
        queryPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(321, 26, 86, 24);
        queryPanel.add(textField);
        textField.setColumns(10);

        JComboBox cbbQueryzc = new JComboBox();
        cbbQueryzc.setBounds(518, 26, 86, 24);
        queryPanel.add(cbbQueryzc);
        cbbQueryzc.addItem("所有");
        cbbQueryzc.addItem("教授");
        cbbQueryzc.addItem("副教授");
        cbbQueryzc.addItem("讲师");
        cbbQueryzc.addItem("助教");

        JLabel label = new JLabel("老师职称:");
        label.setBounds(432, 29, 72, 18);
        queryPanel.add(label);

        JLabel label_1 = new JLabel("老师类型:");
        label_1.setBounds(694, 32, 72, 18);
        queryPanel.add(label_1);

        JComboBox cbbQueryType = new JComboBox();
        cbbQueryType.setBounds(780, 29, 86, 24);
        queryPanel.add(cbbQueryType);
        cbbQueryType.addItem("所有");
        cbbQueryType.addItem("授课老师");
        cbbQueryType.addItem("导员");

        btnInsert.addActionListener(new ActionListener() {
            //TODO 新窗口的弹出
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SaveTeacherFrame frame = new SaveTeacherFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要修改的数据行");
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("编号".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }
                //if(!"编号".equals(table.getColumnName(0))) {
                //setErrorMsg("请把编号列放在第一列");
                //return;
                //}
                String teaNum = table.getValueAt(selectedRow, idColumnIndex).toString();
                UpdateTeacherFrame updateTeacherFrame = new UpdateTeacherFrame(teaNum);
                updateTeacherFrame.setModal(true);
                updateTeacherFrame.setLocationRelativeTo(null);
                updateTeacherFrame.setVisible(true);

                loadData();


            }
        });
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                setInfoMsg("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    setErrorMsg("请选择要删除的数据行");
                    return;
                }
                int idColumnIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if ("编号".equals(table.getColumnName(i))) {
                        idColumnIndex = i;
                        break;
                    }

                }

                String teaNum = table.getValueAt(selectedRow, idColumnIndex).toString();
                int result = JOptionPane.showConfirmDialog(null, "您确定要删除[" + teaNum + "]吗?", "删除确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    TeacherDAO teacherDAO = new TeacherDAO();
                    if (teacherDAO.delete(teaNum)) {
                        JOptionPane.showMessageDialog(null, "删除老师信息成功");
                        loadData();
                    }

                }
            }
        });
        btnFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nowPage = 1;
                loadData();

            }
        });
        btnPr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nowPage -= 1;
                loadData();

            }
        });
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nowPage += 1;
                loadData();
            }
        });
        btnLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nowPage = pageCount;
                loadData();

            }
        });
		/*cbbNowPage.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			nowPage=cbbNowPage.getSelectedIndex()+1;
			loadData();
			}
		});*/

        loadData();
    }

    private void loadData() {
        //TODO 给创建列表以及给列表加值
        DefaultTableModel model = new DefaultTableModel();
        //设置标题
        model.addColumn("编号");
        model.addColumn("姓名");
        model.addColumn("职称");
        model.addColumn("类型");
        model.addColumn("生日");
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teas = teacherDAO.getNowPageData(nowPage, Config.PAGE_SIZE);

        for (Teacher t : teas) {
            model.addRow(new Object[]{t.getTeaNum(), t.getTeaName(), t.getTeaTitle(), t.getTeaTypeId(), t.getTeaBtd()});
        }

        //TODO 将model加入
        table.setModel(model);
        pageCount = teacherDAO.getPageCount(Config.PAGE_SIZE);
        lblPageCount.setText("共" + pageCount + "页");

        if (cbbNowPage.getItemCount() != 0) {
            cbbNowPage.removeAllItems();
        }
        for (int i = 1; i <= pageCount; i++) {
            cbbNowPage.addItem("第" + i + "页");//自动装箱 int->integer


        }
        cbbNowPage.setSelectedIndex(nowPage - 1);
        //首页 上一页那些按钮的显示与否
        btnFirst.setEnabled(true);
        btnPr.setEnabled(true);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        if (nowPage == 1) {
            btnFirst.setEnabled(false);
            btnPr.setEnabled(false);
        }
        if (nowPage == pageCount) {
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
        }


    }

    public static void main(String[] args) {
        TeacherListFrame frame = new TeacherListFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
