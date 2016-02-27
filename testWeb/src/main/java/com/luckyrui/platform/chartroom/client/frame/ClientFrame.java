package com.luckyrui.platform.chartroom.client.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.luckyrui.platform.chartroom.client.frame.panel.ContentPanel;
import com.luckyrui.platform.chartroom.client.frame.panel.InputPanel;
import com.luckyrui.platform.chartroom.client.frame.panel.UserPanel;

public class ClientFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3367147909328766754L;
	
	public ClientFrame(){
		super();
		init();
	}

	public void init(){
		this.setSize(1024,768);
		this.getContentPane().setLayout(null);
		JPanel contentPanel = new ContentPanel();
		JPanel userPanel = new UserPanel();
		JPanel inputPanel = new InputPanel();
		this.add(inputPanel);
		this.add(userPanel);
		this.add(contentPanel);
		this.setTitle("chartRoom");
	}
	
	public static void main(String[] args) {
		ClientFrame cf = new ClientFrame();
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cf.setVisible(true);
	}
}
