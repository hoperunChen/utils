package com.luckyrui.platform.chartroom.client.frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.alibaba.fastjson.JSONArray;
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
		this.setSize(FrameConts.CONTENT_PANEL_WIDTH+FrameConts.USER_PANEL_WIDTH,FrameConts.CONTENT_PANEL_HEIGHT+FrameConts.INPUT_PANEL_HEIGHT+20);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		contentPanel = new ContentPanel();
		userPanel = new UserPanel(client);
		inputPanel = new InputPanel(client);
		this.add(inputPanel);
		this.add(userPanel);
		this.add(contentPanel);
		this.setTitle("chartRoom");
	}

	public void receiveMsg(String receiveMsg) {
		contentPanel.addMsg(receiveMsg);
	}
	
	public void showUsers(JSONArray users){
		userPanel.showUsers(users);
	}

}
