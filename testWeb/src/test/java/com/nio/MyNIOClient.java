package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class MyNIOClient {
	public static void main(String[] args) {
		try {
			SocketChannel socket = SocketChannel.open();
			socket.configureBlocking(false);
			Selector selector = Selector.open();
			socket.register(selector, SelectionKey.OP_CONNECT);
			socket.connect(new InetSocketAddress("192.168.1.112",8888));
			
//			Scanner in = new Scanner(System.in);
//			String msg = in.next();
			selector.select();
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			socket.finishConnect();
			ByteBuffer bb = ByteBuffer.allocate(4096);
			bb.put("hello,server".getBytes());
			bb.flip();
			socket.write(bb);
			bb.clear();
			while (true) {
				
			}
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
