package zhongqiu.common.jdk5.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	public static void main(String[] args) {
		final Outputter1 output = new Outputter1();
		new Thread() {
			public void run() {
				output.output("zhangsan");
			};
		}.start();
		new Thread() {
			public void run() {
				output.output("lisi");
			};
		}.start();
	}
}

class Outputter1 {
	private Lock lock = new ReentrantLock();// ������

	public void output(String name) {
		// TODO �߳��������
		lock.lock();// �õ���
		try {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
		} finally {
			lock.unlock();// �ͷ���
		}
	}
}
