package zhongqiu.common.base.thread;

// wait��notify��demo
//������������wait�����ͻ�ʹ���иö�����̰߳Ѹö���Ŀ���Ȩ����ȥ��Ȼ���ڵȴ��������Ŀ���Ȩ��״̬��
//������������notify�����ͻ�֪ͨĳ�����ڵȴ��������Ŀ���Ȩ���߳̿��Լ������С�
//������������notifyAll�����ͻ�֪ͨ���еȴ�����������Ȩ���̼߳������С�

//�κ�һ��ʱ�̣�����Ŀ���Ȩ��monitor��ֻ�ܱ�һ���߳�ӵ�С�
//������ִ�ж����wait��notify����notifyAll���������뱣֤��ǰ���е��߳�ȡ���˸ö���Ŀ���Ȩ��monitor��
//�����û�п���Ȩ���߳���ִ�ж�����������ַ������ͻᱨjava.lang.IllegalMonitorStateException�쳣��
//JVM���ڶ��̣߳�Ĭ������²��ܱ�֤����ʱ�̵߳�ʱ����

public class WaitNotifyDemo {
	public static void main(String[] args) {

		// wait��notify��Demo
		System.out.println("Main Thread Run!");
		WaitNotifyDemo test = new WaitNotifyDemo();
		NotifyThread notifyThread = test.new NotifyThread("notify01");
		WaitThread waitThread01 = test.new WaitThread("waiter01");
		WaitThread waitThread02 = test.new WaitThread("waiter02");
		WaitThread waitThread03 = test.new WaitThread("waiter03");
		notifyThread.start();
		waitThread01.start();
		waitThread02.start();
		waitThread03.start();
	}

	private StringBuilder flag =new StringBuilder("true");

	class NotifyThread extends Thread {
		public NotifyThread(String name) {
			super(name);
		}

		public void run() {
			try {
				sleep(10000);// �Ƴ�3����֪ͨ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (flag) {
				flag.replace(1, flag.length(), "false");
				flag.notifyAll();
			}
		}
	};

	class WaitThread extends Thread {
		public WaitThread(String name) {
			super(name);
		}

		public void run() {
			synchronized (flag) {
				while (flag.toString().equals("true")) {
					System.out.println(getName() + " begin waiting!");
					long waitTime = System.currentTimeMillis();
					try {
						flag.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					waitTime = System.currentTimeMillis() - waitTime;
					System.out.println("wait time :" + waitTime);
				}
				System.out.println(getName() + " end waiting!");
			}
		}
	}
}
