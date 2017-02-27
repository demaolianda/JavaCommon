package zhongqiu.common.jdk5.concurrent.locks;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//http://blog.csdn.net/ghsau/article/details/7461369/
//
//1. Lock�ļ����ͽ���������java�������native���������ò���ϵͳ����ط�����ʵ�ֵģ���synchronize�ļ����ͽ����Ĺ�������JVM�����
//
//2. ��һ���߳�ʹ��synchronize��ȡ��ʱ�������������߳�ռ���ţ���ô��ǰֻ�ܱ�������ֱ���ɹ���ȡ������Lock���ṩ��ʱ���Ϳ��жϵȸ������ķ�ʽ����δ�ܻ�ȡ����     �������ṩһ���˳��Ļ��ơ�
//
//3. һ�����ڲ������ж��Conditionʵ�������ж�·�������У���synchronizeֻ��һ·�������У�ͬ��ConditionҲ�ṩ����������ʽ����δ���֪֮ͨǰ����ͨ���ж��߳���    �����õȴ�ʱ�޵ȷ�ʽ�˳��������С�
//
//4. synchronize���̵߳�ͬ�����ṩ��ռģʽ����Lock�������ṩ��ռģʽ��Ҳ�����ṩ����ģʽ
public class ReentrantReadWriteLockDemo {
	public static void main(String[] args) {
		final Data data = new Data();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.set(new Random().nextInt(30));
					}
				}
			}).start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.get();
					}
				}
			}).start();
		}
	}
}

class Data {
	private int data;// ��������
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public void set(int data) {
		rwl.writeLock().lock();// ȡ��д����
		try {
			System.out.println(Thread.currentThread().getName() + "׼��д������");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "д��" + this.data);
		} finally {
			rwl.writeLock().unlock();// �ͷ�д��
		}
	}

	public void get() {
		rwl.readLock().lock();// ȡ����ȡ��
		try {
			System.out.println(Thread.currentThread().getName() + "׼����ȡ����");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "��ȡ" + this.data);
		} finally {
			rwl.readLock().unlock();// �ͷŶ���
		}
	}
}
