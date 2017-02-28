package zhongqiu.common.jdk5.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//�̳߳����
public class ExecutorsDemo {
	public static void main(String[] args) {
		// CachedThreadPool.demo();
		// FixedThreadPool.demo();
		// SingleThreadExecutor.demo();
		// ScheduledThreadPool.demo();
	}
}

// Executors.newCachedThreadPool()
// ����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ���������ǡ�
// �������͵��̳߳��ص��ǣ�
// �����̵߳Ĵ�����������û������(��ʵҲ�����Ƶ�,��ĿΪInterger. MAX_VALUE), �������������̳߳�������̡߳�
// �����ʱ��û�����̳߳����ύ���񣬼���������߳̿�����ָ����ʱ��(Ĭ��Ϊ1����)����ù����߳̽��Զ���ֹ��
// ��ֹ����������ύ���µ��������̳߳����´���һ�������̡߳�
// ��ʹ��CachedThreadPoolʱ��һ��Ҫע�����������������������ڴ����߳�ͬʱ���У����л����ϵͳ̱����
class CachedThreadPool {
	static void demo() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}
}

// Executors.newFixedThreadPool(3);
// ����һ��ָ�������߳��������̳߳ء�ÿ���ύһ������ʹ���һ�������̣߳���������߳������ﵽ�̳߳س�ʼ������������ύ��������뵽�ض����С�
// FixedThreadPool��һ��������������̳߳أ��������̳߳���߳���Ч�ʺͽ�ʡ�����߳�ʱ���ĵĿ������ŵ㡣
// ���ǣ����̳߳ؿ���ʱ�����̳߳���û�п���������ʱ���������ͷŹ����̣߳�����ռ��һ����ϵͳ��Դ��
class FixedThreadPool {
	static void demo() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}

// Executors.newSingleThreadExecutor();
// ����һ�����̻߳���Executor����ֻ����Ψһ�Ĺ������߳���ִ��������ֻ����Ψһ�Ĺ����߳���ִ�����񣬱�֤����������ָ��˳��(FIFO, LIFO,
// ���ȼ�)ִ�С�
// �������߳��쳣������������һ��ȡ��������֤˳��ִ�С��������߳������ص��ǿɱ�֤˳���ִ�и������񣬲��������������ʱ�䲻���ж���߳��ǻ�ġ�
class SingleThreadExecutor {
	static void demo() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}

// Executors.newScheduledThreadPool(5);
// ����һ���������̳߳أ�����֧�ֶ�ʱ���Լ������Ե�����ִ�У�֧�ֶ�ʱ������������ִ�С�
class ScheduledThreadPool {
	static void demo() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		// �ӳ�3��ִ��
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);

		// ��ʾ�ӳ�1���ÿ3��ִ��һ��
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);
	}
}
