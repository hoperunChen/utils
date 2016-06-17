package com.luckyrui.test.test;

import com.luckyrui.test.transfer.MongodbTransferHandler;

public class Test {
	public static void main(String[] args) {
		MongodbTransferHandler t = new MongodbTransferHandler();
		try {
			t.transfer();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
