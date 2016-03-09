package com.luckyrui.platform.chartroom.client;

import java.io.IOException;

public interface Client {
	public void start() throws IOException;
	public void stop();
	
	public void send(String msg) throws IOException;
}
