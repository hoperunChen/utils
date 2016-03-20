package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.Color;

import com.luckyrui.platform.chartroom.client.Client;
import com.luckyrui.platform.chartroom.client.frame.FrameConts;

public class UserPanel extends ChartPanel{
	
	Client client;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518941263934027629L;
	
	public UserPanel(){
		super(FrameConts.USER_PANEL_WIDTH,FrameConts.USER_PANEL_HEIGHT);
	}
	
	public UserPanel(Client client){
		super(FrameConts.INPUT_PANEL_WIDTH,FrameConts.INPUT_PANEL_HEIGHT);
		this.client = client;
	}
	
	public UserPanel(Integer width,Integer height){
		super(width,height);
	}

	@Override
	protected void init() {
//		this.setBackground(new Color(0, 100, 0));
		this.setLocation(FrameConts.CONTENT_PANEL_WIDTH, 0);
	}
	
	public void showUsers(){
		//TODO
	}

	
	
}
