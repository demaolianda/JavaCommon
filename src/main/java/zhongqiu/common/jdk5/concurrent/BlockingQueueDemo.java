package zhongqiu.common.jdk5.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//http://www.2cto.com/kf/201601/487906.html
//http://blog.csdn.net/ghsau/article/details/7481142
//http://blog.csdn.net/defonds/article/details/44021605#t7
//ʹ�ó�������Ҫ��������ʣ�������߽����������Թ���������߽���������

//ArrayBlockingQueue��ArrayBlockingQueue ��һ���н���������У����ڲ�ʵ���ǽ�����ŵ�һ�������
//�н�Ҳ����ζ�ţ������ܹ��洢���޶�������Ԫ�ء�����һ��ͬһʱ���ܹ��洢Ԫ�����������ޡ�
//������ڶ����ʼ����ʱ���趨������ޣ���֮����޷���������޽����޸���(����ע����Ϊ���ǻ�������ʵ�ֵģ�Ҳ�;�����������ԣ�һ����ʼ������С���޷��޸�)��

//LinkedBlockingQueue��LinkedBlockingQueue �ڲ���һ����ʽ�ṹ(���ӽڵ�)����Ԫ�ؽ��д洢��
//�����Ҫ�Ļ�����һ��ʽ�ṹ����ѡ��һ�����ޡ����û�ж������ޣ���ʹ�� Integer.MAX_VALUE ��Ϊ���ޡ�

//PriorityBlockingQueue��PriorityBlockingQueue ��һ���޽�Ĳ������С�
//��ʹ���˺��� java.util.PriorityQueue һ��������������޷�����������в��� null ֵ��
//���в��뵽 PriorityBlockingQueue ��Ԫ�ر���ʵ�� java.lang.Comparable �ӿڡ���˸ö�����Ԫ�ص������ȡ�������Լ��� Comparable ʵ�֡�

//SynchronousQueue��SynchronousQueue��
//һ���������У�����ÿ�������������ȴ���һ���̵߳Ķ�Ӧ�Ƴ����� ����֮��Ȼ��ͬ������û���κ��ڲ�������������һ�����е�������û�С�
//ͬ������������ CSP �� Ada ��ʹ�õ� rendezvous �ŵ���
//���ǳ��ʺ��ڴ�������ƣ�����������У���һ���߳������еĶ���Ҫ��ĳЩ��Ϣ���¼������񴫵ݸ�����һ���߳������еĶ������ͱ�����ö���ͬ����
public class BlockingQueueDemo {
	private ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(100);
	private LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();

	// ������
	public static class Producer implements Runnable {
		private final BlockingQueue<Integer> blockingQueue;
		private volatile boolean flag;
		private Random random;

		public Producer(BlockingQueue<Integer> blockingQueue) {
			this.blockingQueue = blockingQueue;
			flag = false;
			random = new Random();

		}

		public void run() {
			while (!flag) {
				int info = random.nextInt(100);
				try {
					blockingQueue.put(info);
					System.out.println(Thread.currentThread().getName() + " produce " + info);
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void shutDown() {
			flag = true;
		}
	}

	// ������
	public static class Consumer implements Runnable {
		private final BlockingQueue<Integer> blockingQueue;
		private volatile boolean flag;

		public Consumer(BlockingQueue<Integer> blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		public void run() {
			while (!flag) {
				int info;
				try {
					info = blockingQueue.take();
					System.out.println(Thread.currentThread().getName() + " consumer " + info);
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void shutDown() {
			flag = true;
		}
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(3);
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		// ����5�������ߣ�5��������
		for (int i = 0; i < 6; i++) {
			if (i < 5) {
				new Thread(producer, "producer" + i).start();
			} else {
				new Thread(consumer, "consumer" + (i - 5)).start();
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producer.shutDown();
		consumer.shutDown();
	}
}
