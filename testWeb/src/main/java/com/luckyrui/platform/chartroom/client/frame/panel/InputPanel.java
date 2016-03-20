package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;

import com.luckyrui.platform.chartroom.client.Client;
import com.luckyrui.platform.chartroom.client.frame.FrameConts;

public class InputPanel extends ChartPanel{
	
	Client client;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518941263934027629L;
	
	JTextArea inputText;
	
	int beforKeyCode = -1;
	
	public InputPanel(){
		super(FrameConts.INPUT_PANEL_WIDTH,FrameConts.INPUT_PANEL_HEIGHT);
	}
	
	public InputPanel(Client client){
		super(FrameConts.INPUT_PANEL_WIDTH,FrameConts.INPUT_PANEL_HEIGHT);
		this.client = client;
	}
	
	public InputPanel(Integer width,Integer height){
		super(width,height);
	}

	@Override
	protected void init() {
		this.setLayout(null);
		this.setLocation(0,FrameConts.CONTENT_PANEL_HEIGHT);
		JButton sendBtn =new JButton("·¢ËÍ");
		sendBtn.setSize(60,25);
		sendBtn.setLocation(FrameConts.INPUT_PANEL_WIDTH-60,FrameConts.INPUT_PANEL_HEIGHT-25);
//		sendBtn.setBorder(BorderFactory.createLineBorder(Color.red));
		this.add(sendBtn);
		inputText = new JTextArea();
		inputText.setLineWrap(true);
		inputText.setSize(FrameConts.INPUT_PANEL_WIDTH,FrameConts.INPUT_PANEL_HEIGHT-25);
		this.add(inputText);
		sendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
			
		});
		inputText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				if(keycode==10)
					if(beforKeyCode == 157)
						sendMessage();
				beforKeyCode = keycode;
				super.keyPressed(e);
			}
			
		});
	}
	
	private void sendMessage() {
		String msg = inputText.getText();
//		JOptionPane.showMessageDialog(null,msg );
		try {
			client.send(msg);
			inputText.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
