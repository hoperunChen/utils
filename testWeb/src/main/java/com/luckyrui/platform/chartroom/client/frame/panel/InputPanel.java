package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.Color;

import com.luckyrui.platform.chartroom.client.frame.FrameConts;

public class InputPanel extends ChartPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518941263934027629L;
	
	
	public InputPanel(){
		super(FrameConts.INPUT_PANEL_WIDTH,FrameConts.INPUT_PANEL_HEIGHT);
	}
	
	public InputPanel(Integer width,Integer height){
		super(width,height);
	}

	@Override
	protected void init() {
//		this.setBackground(new Color(0, 0, 100));
		this.setLocation(0,FrameConts.CONTENT_PANEL_HEIGHT);
	}

	
	
}
