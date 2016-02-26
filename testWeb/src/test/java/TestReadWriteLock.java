import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestReadWriteLock {
	
	public static void main(String[] args) {
		writeT w1 = new writeT("w1");
		writeT w2 = new writeT("w2");
		new Thread(w1).start();
		new Thread(w2).start();
	}
	
//	class readT implements Runnable{
//
//		@Override
//		public void run() {
//			System.out.println("准备读");
//			rwLock.readLock().lock();
//			System.out.println("读到了");
//			rwLock.readLock().unlock();
//			
//		}
//		
//	}
	
}
class writeT implements Runnable{
	public static ReadWriteLock rwLock = new ReentrantReadWriteLock();
	String name = "";
	public writeT(String name) {
		this.name  = name;
	}
	
	@Override
	public void run() {
		System.out.println("准备写"+name);
		rwLock.writeLock().lock();
		System.out.println("正在写"+name);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rwLock.writeLock().unlock();
		System.out.println("写完了"+name);
	}
	
}
