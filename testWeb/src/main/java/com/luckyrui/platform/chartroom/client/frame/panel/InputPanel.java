package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;

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
		this.setLayout(null);
		this.setLocation(0,FrameConts.CONTENT_PANEL_HEIGHT);
		JButton sendBtn =new JButton("发送");
		sendBtn.setSize(60,25);
		sendBtn.setLocation(FrameConts.INPUT_PANEL_WIDTH-60,FrameConts.INPUT_PANEL_HEIGHT-25);
//		sendBtn.setBorder(BorderFactory.createLineBorder(Color.red));
		this.add(sendBtn);
		JTextArea inputText = new JTextArea();
		inputText.setLineWrap(true);
		inputText.setSize(FrameConts.INPUT_PANEL_WIDTH,FrameConts.INPUT_PANEL_HEIGHT-25);
		this.add(inputText);
	}

	
	
}
