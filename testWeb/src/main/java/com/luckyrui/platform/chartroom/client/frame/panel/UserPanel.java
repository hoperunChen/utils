package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JTextArea;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luckyrui.platform.chartroom.client.Client;
import com.luckyrui.platform.chartroom.client.frame.FrameConts;

public class UserPanel extends ChartPanel{
	
	Client client;
	
	private JTextArea usersText;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518941263934027629L;
	
	public UserPanel(){
		super(FrameConts.USER_PANEL_WIDTH,FrameConts.USER_PANEL_HEIGHT);
	}
	
	public UserPanel(Client client){
		super(FrameConts.USER_PANEL_WIDTH,FrameConts.USER_PANEL_HEIGHT);
		this.client = client;
	}
	
	public UserPanel(Integer width,Integer height){
		super(width,height);
	}

	@Override
	protected void init() {
//		this.setBackground(new Color(0, 100, 0));
		this.setLocation(FrameConts.CONTENT_PANEL_WIDTH, 0);
		this.setLayout(new GridLayout(1, 1));
		usersText = new JTextArea();
		usersText.setLineWrap(true);
		usersText.setEnabled(false);
		this.add(usersText);
	}
	
	public void showUsers(JSONArray users){
		if(null == users || users.size()<1)
			return;
		else{
			usersText.setText("");
			String usersString = "";
			for (Object obj : users) {
				JSONObject user = (JSONObject) obj;
				usersString += user.getString("name")+"\n";
			}
			usersText.setText(usersString);
		}
	}

	
	
}
