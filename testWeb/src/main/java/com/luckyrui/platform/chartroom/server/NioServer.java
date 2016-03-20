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
		// һ��������ѯ�߳���,�����µĿͻ�������ʱ����
		connectionBell = new SelectorLoop();
		// һ����Ϣ�����߳���,��������Ϣʱ����
//		readBell = new SelectorLoop();

		//��һ�������ͨ��
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//�����Ƕ���ģʽ
		serverSocketChannel.configureBlocking(false);
		//��ȡ�ķ���˵�socket
		ServerSocket serverSocket = serverSocketChannel.socket();
		//��ip�Ͷ˿�
		serverSocket.bind(new InetSocketAddress(ipAddr, port));
		//��connectionBell�е�selectorע�������¼�,connectionBell����ѯ�Լ���selector�����������¼�
		serverSocketChannel.register(connectionBell.getSelector(),
				SelectionKey.OP_ACCEPT);
		System.out.println("Server Start -->" + ipAddr + ":" + port);
		new Thread(connectionBell).start();
		init();
		// listen();

	}

	protected abstract void init();

	/**
	 * ֹͣ������
	 */
	@Override
	public void stop() {
		connectionBell.close();
//		readBell.close();
		System.exit(0);
	}

	/**
	 * ���ͻ��˷�����Ϣ
	 * @param client
	 * @param msg
	 * @throws IOException
	 */
	protected void sendMsg(SocketChannel client, String msg) throws IOException {
		client.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));
	}
	
	
	/**
	 * �ͻ��˹ر��¼�
	 * @param client
	 * @throws IOException
	 */
	protected abstract void clientClose(SocketChannel client)
			throws IOException;

	/**
	 * ���յ�client��������Ϣ
	 * 
	 * @param client
	 * @param receiveMsg
	 * @throws IOException
	 */
	protected abstract void receiveMsg(SocketChannel client, String receiveMsg)
			throws IOException;

	/**
	 * ���µĿͻ�������
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
	 * Selector��ѯ�߳���
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
		 * ����
		 */
		@Override
		public void run() {
			while (true) {
				try {
					// ����,ֻ�е�����һ��ע����¼�������ʱ��Ż����.
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
		 * �¼��Ĵ���
		 * @param key
		 * @throws IOException
		 * @throws InterruptedException
		 */
		public void handleKey(SelectionKey key) throws IOException,
				InterruptedException {
			if (key.isAcceptable()) {
				// ����һ���ͻ�������(connection accept)�¼�,
				// ��������¼���ע����serversocketchannel�ϵ�.
				ServerSocketChannel server = (ServerSocketChannel) key
						.channel();
				// ����һ������.
				SocketChannel client = server.accept();

				System.out.println("client accept -->"
						+ client.getRemoteAddress());
				clientAccept(client);

				// ���µ����ӵ�channelע��read�¼�. ʹ��readBell����.
				client.configureBlocking(false);
				SelectorLoop readBell = new SelectorLoop();
				client.register(readBell.getSelector(), SelectionKey.OP_READ);
				//���ʹ��һ��readBell �ᵼ�� �����ڼ�����
				new Thread(readBell).start();
				System.out.println(client.getRemoteAddress()+"-->�Ѿ���ʼ����");
				// �����ȡ�̻߳�û������,�Ǿ�����һ����ȡ�߳�.
//				synchronized (NioServer.this) {
//					if (!NioServer.this.isReadBellRunning) {
//						NioServer.this.isReadBellRunning = true;
//						new Thread(readBell).start();
//					}
//				}

			} else if (key.isReadable()) {
				// ����һ��read�¼�,��������¼���ע����socketchannel�ϵ�.
				SocketChannel client = (SocketChannel) key.channel();
				// д���ݵ�buffer
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
				// �л�buffer����״̬,�ڲ�ָ���λ.
				receivebuffer.flip();
				String msg = Charset.forName("UTF-8").decode(receivebuffer)
						.toString();
				System.out.println("receive message -->"
						+ client.getRemoteAddress() + ":" + msg);
				// ���buffer
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
