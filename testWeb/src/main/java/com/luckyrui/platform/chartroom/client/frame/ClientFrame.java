package com.luckyrui.platform.chartroom.client.frame;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.luckyrui.platform.chartroom.client.ChartRoomClient;
import com.luckyrui.platform.chartroom.client.Client;
import com.luckyrui.platform.chartroom.client.frame.panel.ContentPanel;
import com.luckyrui.platform.chartroom.client.frame.panel.InputPanel;
import com.luckyrui.platform.chartroom.client.frame.panel.UserPanel;

public class ClientFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3367147909328766754L;

	ChartRoomClient client = new ChartRoomClient();

	ContentPanel contentPanel;
	UserPanel userPanel;
	InputPanel inputPanel;

	public ClientFrame() {
		super();
		try {
			client.setClientFrame(this);
			client.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		init();
	}

	public void init() {
		this.setSize(1024, 738);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		contentPanel = new ContentPanel();
		userPanel = new UserPanel();
		inputPanel = new InputPanel(client);
		this.add(inputPanel);
		this.add(userPanel);
		this.add(contentPanel);
		this.setTitle("chartRoom");
	}

	public void receiveMsg(String receiveMsg) {
		contentPanel.addMsg(receiveMsg);
	}

}
