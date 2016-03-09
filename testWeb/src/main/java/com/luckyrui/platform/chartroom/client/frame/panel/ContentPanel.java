package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.luckyrui.platform.chartroom.client.frame.FrameConts;
import com.luckyrui.platform.chartroom.client.frame.MidVar;

public class ContentPanel extends ChartPanel{
	
	private JTextArea chartText;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518941263934027629L;
	
	public ContentPanel(){
		super(FrameConts.CONTENT_PANEL_WIDTH,FrameConts.CONTENT_PANEL_HEIGHT);
	}
	
	public ContentPanel(Integer width,Integer height){
		super(width,height);
	}

	@Override
	protected void init() {
		this.setLayout(new GridLayout(1, 1));
		chartText = new JTextArea();
		chartText.setLineWrap(true);
		chartText.setEnabled(false);
		JScrollPane jsp = new JScrollPane(chartText,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension(FrameConts.CONTENT_PANEL_WIDTH,FrameConts.CONTENT_PANEL_HEIGHT-5));
		this.add(jsp);
	}

	public void addMsg(String receiveMsg) {
		chartText.append(receiveMsg+"\n");
		//滚到最底部 (MidVar.isScroll():是否允许滚动)
		if(MidVar.isScroll())
			chartText.setCaretPosition(chartText.getText().length()); 
	}


	
	
}
