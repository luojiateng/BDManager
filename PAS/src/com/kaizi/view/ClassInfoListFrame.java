package com.kaizi.view;

import com.kaizi.view.base.BaseListFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClassInfoListFrame extends BaseListFrame {

	private JTextField textField;
	public ClassInfoListFrame() {
		queryPanel.setLocation(14, 13);

		JLabel lblNewLabel = new JLabel("班级名称:");
		lblNewLabel.setBounds(250, 29, 72, 18);
		queryPanel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(323, 23, 86, 24);
		queryPanel.add(textField);
		textField.setColumns(10);
		setTitle("班级信息列表");
		setSize(900,520);
	}
	public static void main(String[] args) {
		ClassInfoListFrame frame=new ClassInfoListFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
