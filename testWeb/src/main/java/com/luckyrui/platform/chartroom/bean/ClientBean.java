package com.luckyrui.platform.chartroom.bean;

import java.io.Serializable;
import java.nio.channels.SocketChannel;

public class ClientBean implements Serializable{
	private static final long serialVersionUID = 2142252294430720725L;
	
	SocketChannel client;
	String name;
	
	public SocketChannel getClient() {
		return client;
	}
	public void setClient(SocketChannel client) {
		this.client = client;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
