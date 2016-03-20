package com.luckyrui.platform.chartroom.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import com.luckyrui.platform.constants.ConfigConts;
import com.luckyrui.platform.utils.PropertiesHandler;

public abstract class NioServer implements Server {

	private String ipAddr;
	private Integer port;

	public static SelectorLoop connectionBell;
//	public static SelectorLoop readBell;
	public boolean isReadBellRunning = false;

	public NioServer() {
		ipAddr = ph.get(ConfigConts.SERVER_IP);
		port = Integer.parseInt(ph.get(ConfigConts.SERVER_PORT));
	}

	@Override
	public void start() throws IOException {
		// 一个连接轮询线程类,当有新的客户端连接时触发
		connectionBell = new SelectorLoop();
		// 一个消息轮序线程类,但有新消息时触发
//		readBell = new SelectorLoop();

		//打开一个服务端通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//开启非堵塞模式
		serverSocketChannel.configureBlocking(false);
		//获取的服务端的socket
		ServerSocket serverSocket = serverSocketChannel.socket();
		//绑定ip和端口
		serverSocket.bind(new InetSocketAddress(ipAddr, port));
		//给connectionBell中的selector注册连接事件,connectionBell会轮询自己的selector来监视连接事件
		serverSocketChannel.register(connectionBell.getSelector(),
				SelectionKey.OP_ACCEPT);
		System.out.println("Server Start -->" + ipAddr + ":" + port);
		new Thread(connectionBell).start();
		init();
		// listen();

	}

	protected abstract void init();

	/**
	 * 停止服务器
	 */
	@Override
	public void stop() {
		connectionBell.close();
//		readBell.close();
		System.exit(0);
	}

	/**
	 * 给客户端发送消息
	 * @param client
	 * @param msg
	 * @throws IOException
	 */
	protected void sendMsg(SocketChannel client, String msg) throws IOException {
		client.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));
	}
	
	
	/**
	 * 客户端关闭事件
	 * @param client
	 * @throws IOException
	 */
	protected abstract void clientClose(SocketChannel client)
			throws IOException;

	/**
	 * 接收到client发来的信息
	 * 
	 * @param client
	 * @param receiveMsg
	 * @throws IOException
	 */
	protected abstract void receiveMsg(SocketChannel client, String receiveMsg)
			throws IOException;

	/**
	 * 有新的客户端连接
	 * 
	 * @param client
	 * @throws IOException
	 */
	protected abstract void clientAccept(SocketChannel client)
			throws IOException;

	protected void clientClose(SelectionKey key,SocketChannel client)
			throws IOException{
		System.out.println("client disconnect -->client that ip is ["+client.getRemoteAddress()+"] has been disconnected");
		clientClose(client);
		key.cancel();
		client.close();
	}

	/**
	 * Selector轮询线程类
	 * 
	 * @author cr
	 */
	class SelectorLoop implements Runnable {
		private ByteBuffer receivebuffer = ByteBuffer.allocate(Integer
				.parseInt(ph.get(ConfigConts.BLOCK)));
		private Selector selector;

		public SelectorLoop() throws IOException {
			this.selector = Selector.open();
		}

		public Selector getSelector() {
			return this.selector;
		}

		public void close() {
			try {
				this.selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 监听
		 */
		@Override
		public void run() {
			while (true) {
				try {
					// 阻塞,只有当至少一个注册的事件发生的时候才会继续.
					this.selector.select();
					Set<SelectionKey> selectKeys = this.selector.selectedKeys();
					Iterator<SelectionKey> it = selectKeys.iterator();
					while (it.hasNext()) {
						SelectionKey key = it.next();
						it.remove();
						this.handleKey(key);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 事件的处理
		 * @param key
		 * @throws IOException
		 * @throws InterruptedException
		 */
		public void handleKey(SelectionKey key) throws IOException,
				InterruptedException {
			if (key.isAcceptable()) {
				// 这是一个客户端连接(connection accept)事件,
				// 并且这个事件是注册在serversocketchannel上的.
				ServerSocketChannel server = (ServerSocketChannel) key
						.channel();
				// 接受一个连接.
				SocketChannel client = server.accept();

				System.out.println("client accept -->"
						+ client.getRemoteAddress());
				clientAccept(client);

				// 对新的连接的channel注册read事件. 使用readBell闹钟.
				client.configureBlocking(false);
				SelectorLoop readBell = new SelectorLoop();
				client.register(readBell.getSelector(), SelectionKey.OP_READ);
				//如果使用一个readBell 会导致 堵塞在监听上
				new Thread(readBell).start();
				System.out.println(client.getRemoteAddress()+"-->已经开始监听");
				// 如果读取线程还没有启动,那就启动一个读取线程.
//				synchronized (NioServer.this) {
//					if (!NioServer.this.isReadBellRunning) {
//						NioServer.this.isReadBellRunning = true;
//						new Thread(readBell).start();
//					}
//				}

			} else if (key.isReadable()) {
				// 这是一个read事件,并且这个事件是注册在socketchannel上的.
				SocketChannel client = (SocketChannel) key.channel();
				// 写数据到buffer
				int count;
				try {
					count = client.read(receivebuffer);
				} catch (IOException e) {
					count = -1;
				}
				if (count < 0) {
					clientClose(key,client);
					return;
				}
				// 切换buffer到读状态,内部指针归位.
				receivebuffer.flip();
				String msg = Charset.forName("UTF-8").decode(receivebuffer)
						.toString();
				System.out.println("receive message -->"
						+ client.getRemoteAddress() + ":" + msg);
				// 清空buffer
				receivebuffer.clear();
				receiveMsg(client, msg);
//				client.register(readBell.getSelector(), SelectionKey.OP_READ);
			}
		}

	}

	public static PropertiesHandler ph;

	static {
		ph = new PropertiesHandler();
	}

}
