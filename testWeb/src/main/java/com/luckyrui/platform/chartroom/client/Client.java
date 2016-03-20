package com.luckyrui.platform.chartroom.client;

import java.io.IOException;
import java.util.List;

import com.luckyrui.platform.chartroom.bean.ClientBean;

public interface Client {
	public void start() throws IOException;
	public void stop();
	
	public void send(String msg) throws IOException;
}
