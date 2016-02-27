package com.luckyrui.platform.chartroom.client.frame;

public  class MidVar {
	private static boolean isScroll = true;

	public static boolean isScroll() {
		return isScroll;
	}

	public synchronized static void setScroll(boolean isScroll) {
		MidVar.isScroll = isScroll;
	}
	
	
}
