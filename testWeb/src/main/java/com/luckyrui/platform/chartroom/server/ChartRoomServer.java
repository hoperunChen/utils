package com.luckyrui.platform.chartroom.server;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luckyrui.platform.chartroom.bean.ClientBean;
import com.luckyrui.platform.constants.Constants;

public class ChartRoomServer extends NioServer {

	private ReadWriteLock rwLock = new ReentrantReadWriteLock();

	int visitorsNo = 0;

	private Map<SocketAddress, ClientBean> clients = new HashMap<SocketAddress, ClientBean>();

	@Override
	protected void receiveMsg(SocketChannel client, String receiveMsg) throws IOException {
		SocketAddress clientAddr = client.getRemoteAddress();
		ClientBean fromCB = clients.get(clientAddr);
		if (receiveMsg.startsWith(Constants.MSG_FN_ID)) {
			getFnMsg(fromCB, receiveMsg);
		} else {
			rwLock.readLock().lock();
			String msg = fromCB.getName() + ":" + receiveMsg;
			sendToEveryOne(msg);
			rwLock.readLock().unlock();
		}
	}

	/**
	 * 收到功能性消息
	 * @param fromCB
	 * @param receiveMsg
	 */
	private void getFnMsg(ClientBean fromCB, String receiveMsg) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 给所有人发送消息
	 * @param msg
	 * @throws IOException
	 */
	private void sendToEveryOne(String msg) throws IOException {
		for (ClientBean cb : clients.values()) {
			sendMsg(cb.getClient(), msg);
		}
	}

	@Override
	protected void clientAccept(SocketChannel client) throws IOException {
		SocketAddress clientAddr = client.getRemoteAddress();
		ClientBean crClient = new ClientBean();
		crClient.setClient(client);
		crClient.setName("visitor" + visitorsNo++);
		rwLock.writeLock().lock();
		clients.put(clientAddr, crClient);
		rwLock.writeLock().unlock();
	}

	@Override
	protected void clientClose(SocketChannel client) throws IOException {
		SocketAddress key = client.getRemoteAddress();
		if (clients.containsKey(key)) {
			rwLock.writeLock().lock();
			clients.remove(key);
			rwLock.writeLock().unlock();
		}
	}

	@Override
	protected void init() {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					JSONArray jArray = new JSONArray();
					for (ClientBean client : clients.values()) {
						JSONObject obj = new JSONObject();
						String addr = null;
						String name = null;
						try {
							addr = client.getClient().getRemoteAddress().toString();
							name = client.getName();
						} catch (IOException e) {
							e.printStackTrace();
						}
						obj.put("addr", addr);
						obj.put("name", name);
						jArray.add(obj);
					}
					String msg = Constants.MSG_FN_ID + Constants.MSG_FN_GET_USER + jArray.toJSONString();
					try {
						sendToEveryOne(msg);
						Thread.sleep(1000*10);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();

	}

}
