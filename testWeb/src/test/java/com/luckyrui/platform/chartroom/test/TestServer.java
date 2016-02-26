package com.luckyrui.platform.chartroom.test;

import java.io.IOException;

import com.luckyrui.platform.chartroom.server.ChartRoomServer;
import com.luckyrui.platform.chartroom.server.Server;

public class TestServer {
	public static void main(String[] args) {
		Server server = new ChartRoomServer();
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
