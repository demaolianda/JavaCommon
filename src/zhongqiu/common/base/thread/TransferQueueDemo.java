package zhongqiu.common.base.thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

//Java7�м�����JSR 166y�淶�Լ�����Ͳ������ĸĽ������е�һ���������˽ӿ�TransferQueue����ʵ����LinkedTransferQueue��
//TransferQueue�̳���BlockingQueue��BlockingQueue�ּ̳���Queue������չ��һЩ�·�����
//TransferQueue�����һ���������߻�һֱ����ֱ������ӵ����е�Ԫ�ر�ĳһ�������������ѣ�����������ӵ�����������£���
//����ӵ�transfer��������ʵ������Լ��������˼�壬�������Ƿ�����Ԫ�ش�һ���߳�transfer����һ���̵߳Ĺ����У�
//����Ч��ʵ����Ԫ�����߳�֮��Ĵ��ݣ��Խ���Java�ڴ�ģ���е�happens-before��ϵ�ķ�ʽ����
//LinkedTransferQueueʵ������ConcurrentLinkedQueue��SynchronousQueue����ƽģʽ����LinkedBlockingQueue�ĳ�����
public class TransferQueueDemo {
	private static TransferQueue<String> queue = new LinkedTransferQueue<String>();

	public static void main(String[] args) throws Exception {
		// queue.transfer�÷�
		new Productor1(1).start();
		Thread.sleep(100);
		System.out.println("over.size=" + queue.size());

		// queue.tryTransfer(result, 1, TimeUnit.SECONDS); �÷�
		new Productor2(1).start();
		Thread.sleep(100);
		System.out.println("over.size=" + queue.size());// 2
		Thread.sleep(1500);
		System.out.println("over.size=" + queue.size());// 1
	}

	// transfer(E e)
	// ����ǰ����һ�����ڵȴ���ȡ���������̣߳������̽�e�ƽ�֮������Ԫ��e���뵽����β�������ҵ�ǰ�߳̽�������״̬��ֱ�����������߳�ȡ�߸�Ԫ�ء�
	static class Productor1 extends Thread {
		private int id;

		public Productor1(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				String result = "id=" + this.id;
				System.out.println("begin to produce." + result);
				queue.transfer(result);
				System.out.println("success to produce." + result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// tryTransfer(E e, long timeout, TimeUnit unit)
	// ����ǰ����һ�����ڵȴ���ȡ���������̣߳��������������;
	// ����Ԫ��e���뵽����β�������ҵȴ����������̻߳�ȡ���ѵ�������ָ����ʱ����Ԫ��e�޷����������̻߳�ȡ���򷵻�false��ͬʱ��Ԫ�شӶ������Ƴ���
	static class Productor2 extends Thread {
		private int id;

		public Productor2(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				String result = "id=" + this.id;
				System.out.println("begin to produce." + result);
				queue.tryTransfer(result, 1, TimeUnit.SECONDS);
				System.out.println("success to produce." + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
