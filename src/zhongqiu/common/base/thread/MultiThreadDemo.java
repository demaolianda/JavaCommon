package zhongqiu.common.base.thread;

import java.util.concurrent.Callable;

//���߳�    http://www.mamicode.com/info-detail-517008.html
//     http://www.runoob.com/java/java-multithreading.html

//��java�У�ÿ�γ���������������2���̡߳�һ����main�̣߳�һ���������ռ��̡߳�
//��Ϊÿ��ʹ��java����ִ��һ�����ʱ��ʵ���϶�������һ���ʣ֣ͣ�ÿһ����֣;����ڲ���ϵͳ��������һ�����̡�
//�߳����һЩ���÷����� 
//sleep(): ǿ��һ���߳�˯�ߣκ��롣 
//isAlive(): �ж�һ���߳��Ƿ�� 
//join(): �ȴ��߳���ֹ�� 
//activeCount(): �����л�Ծ���߳����� 
//enumerate(): ö�ٳ����е��̡߳� 
//currentThread(): �õ���ǰ�̡߳� 
//isDaemon(): һ���߳��Ƿ�Ϊ�ػ��̡߳� 
//setDaemon(): ����һ���߳�Ϊ�ػ��̡߳�(�û��̺߳��ػ��̵߳��������ڣ��Ƿ�ȴ����߳����������߳̽���������) 
//setName(): Ϊ�߳�����һ�����ơ� 
//wait(): ǿ��һ���̵߳ȴ��� 
//notify(): ֪ͨһ���̼߳������С� 
//setPriority(): ����һ���̵߳����ȼ���

//������������wait�����ͻ�ʹ���иö�����̰߳Ѹö���Ŀ���Ȩ����ȥ��Ȼ���ڵȴ��������Ŀ���Ȩ��״̬��
//������������notify�����ͻ�֪ͨĳ�����ڵȴ��������Ŀ���Ȩ���߳̿��Լ������С�
//������������notifyAll�����ͻ�֪ͨ���еȴ�����������Ȩ���̼߳������С�
public class MultiThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		// ������ʵ�ֶ��߳�
		// new Thread(new Runnable() {
		// public void run() {
		// for (int i = 0; i < 10; i++) {
		// System.out.println("�߳�1");
		// }
		// }
		// }).start();
		// new Thread(new FutureTask<>(new Callable<Integer>() {
		// public Integer call()
		// {
		// System.out.println("�߳�2");
		// return 1;
		// }
		// })).start();

		// start()�����ĵ��ú󲢲�������ִ�ж��̴߳��룬����ʹ�ø��̱߳�Ϊ������̬��Runnable����ʲôʱ���������ɲ���ϵͳ�����ġ�
		// new ThreadDemo("A").start();
		// new ThreadDemo("B").start();

		// ���߳���Դ����
		// RunnableDemo my = new RunnableDemo();
		// new Thread(my, "C").start();
		// new Thread(my, "D").start();

		// ͨ�� Callable �� Future �����߳�
		// 1. ���� Callable �ӿڵ�ʵ���࣬��ʵ�� call() �������� call() ��������Ϊ�߳�ִ���壬�����з���ֵ��
		// 2. ���� Callable ʵ�����ʵ����ʹ�� FutureTask ������װ Callable ���󣬸� FutureTask
		// �����װ�˸� Callable ����� call() �����ķ���ֵ��
		// 3. ʹ�� FutureTask ������Ϊ Thread ����� target �������������̡߳�
		// 4. ���� FutureTask ����� get() ������������߳�ִ�н�����ķ���ֵ��
		// FutureTask�����漸����Ҫ�ķ�����
		// 1.get()
		// ����һֱ�ȴ�ִ������õ����
		// 2.get(int timeout, TimeUnit timeUnit)
		// ����һֱ�ȴ�ִ������õ����������ڳ�ʱʱ���ڣ�û���õ��׳��쳣
		// 3.isCancelled()
		// �Ƿ�ȡ��
		// 4.isDone()
		// �Ƿ��Ѿ����
		// 5.cancel(boolean mayInterruptIfRunning)
		// ��ͼȡ������ִ�е�����
		// CallableDemo cDemo = new CallableDemo();
		// FutureTask<Integer> fTask = new FutureTask<>(cDemo);
		// for (int i = 0; i < 100; i++) {
		// System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ" +
		// i);
		// if (i == 20) {
		// new Thread(fTask, "�з���ֵ���߳�").start();
		// }
		// }
		// try {
		// System.out.println("���̵߳ķ���ֵ��" + fTask.get());
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// e.printStackTrace();
		// }
	}

	// �̳�Thread��ʵ�ֶ��߳�
	public static class ThreadDemo extends Thread {
		private int count = 5;

		public ThreadDemo(String name) {
			super(name);
		}

		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(this.getName() + "����  count= " + count--);
				try {
					// Thread.sleep()��������Ŀ���ǲ��õ�ǰ�̶߳��԰�ռ�ý�������ȡ��CPU��Դ��������һ��ʱ��������߳�ִ�еĻ��ᡣ
					sleep((int) Math.random() * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ʵ��Runnable�ӿڡ� ������Դ����
	public static class RunnableDemo implements Runnable {
		private int count = 5;

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				if (count > 0) {
					System.out.println(Thread.currentThread().getName() + "����  count= " + count--);
				}
				try {
					Thread.sleep((int) Math.random() * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ʵ��Callable �ӿڡ���ʵ�� call() �������� call() ��������Ϊ�߳�ִ���壬�����з���ֵ��
	public static class CallableDemo implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int i = 0;
			for (; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
			return i;
		}
	}

	public static class SYNPo {
		public SYNPo(String name) {
			setName(name);
		}

		public String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
