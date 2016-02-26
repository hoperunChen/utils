package com.luckyrui.platform.chartroom.server;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.luckyrui.platform.chartroom.bean.ClientBean;

public class ChartRoomServer extends NioServer{
	
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	int visitorsNo = 0;
	
	private Map<SocketAddress, ClientBean> clients = new HashMap<SocketAddress, ClientBean>();

	@Override
	protected void receiveMsg(SocketChannel client, String receiveMsg) throws IOException {
		
	}

	@Override
	protected void clientAccept(SocketChannel client) throws IOException {
		SocketAddress clientAddr = client.getRemoteAddress();
		ClientBean crClient = new ClientBean();
		crClient.setClient(client);
		crClient.setName("сн©м"+visitorsNo++);
		rwLock.writeLock().lock();
		clients.put(clientAddr, crClient);
		rwLock.writeLock().unlock();
	}

	@Override
	protected void clientClose(SocketChannel client) throws IOException {
		if(clients.containsKey(client)){
			rwLock.writeLock().lock();
			clients.remove(client);
			rwLock.writeLock().unlock();
		}
	}

}
