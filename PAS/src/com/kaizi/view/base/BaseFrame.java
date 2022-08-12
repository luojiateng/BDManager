package com.kaizi.view.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class BaseFrame extends JFrame{
		private JLabel lblMsg = null;
		//受保护的子类才能直接访问
		protected JPanel mainPanel = null;
		public BaseFrame() {
			JPanel msgPanel = new JPanel();
			msgPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			FlowLayout flowLayout = (FlowLayout) msgPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(msgPanel, BorderLayout.SOUTH);

			JLabel lblNewLabel = new JLabel("提示:");
			msgPanel.add(lblNewLabel);

			lblMsg = new JLabel("");
			msgPanel.add(lblMsg);

			mainPanel = new JPanel();
			getContentPane().add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(null);
		}
		protected void setErrorMsg(String msg) {
			lblMsg.setForeground(Color.RED);
			lblMsg.setText(msg);

		}
		protected void setSuccessMsg(String msg) {
			lblMsg.setForeground(Color.GREEN);
			lblMsg.setText(msg);
		}
		protected void setInfoMsg(String msg) {
			lblMsg.setForeground(Color.BLACK);
			lblMsg.setText(msg);
		}

}
