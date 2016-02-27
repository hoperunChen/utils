package com.luckyrui.platform.chartroom.client.frame.panel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class ChartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882248024091261536L;

	public ChartPanel() {
		super();
		init(null, null);
	}

	public ChartPanel(Integer width, Integer height) {
		super();
		init(width, height);
		init();
	}

	private void init(Integer width, Integer height) {
		this.setSize(width == null ? 100 : width, height == null ? 100 : height);
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 189, 189)));
	}

	protected abstract void init();
}
