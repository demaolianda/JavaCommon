package zhongqiu.common.base.thread;

//Volatile���η�
//http://www.cnblogs.com/wangzhongqiu/p/6475357.html
/*
 * Volatile ���εĳ�Ա������ÿ�α��̷߳���ʱ����ǿ�ƴӹ����ڴ������¶�ȡ�ó�Ա������ֵ�����ң�����Ա���������仯ʱ����ǿ���߳̽��仯ֵ��д�������ڴ档
 * �������κ�ʱ�̣�������ͬ���߳����ǿ���ĳ����Ա������ͬһ��ֵ��
 * һ�� volatile �������ÿ����� null��
*/


public class VolatileDemo {
	/*
	 * ������£���һ���̵߳��� run() �������� Runnable �������̣߳�������һ���̵߳��� stop() ������ ��� ��һ�� �л�������
	 * active ֵ��ʹ�ã���ô�� �ڶ��� �� active ֵΪ false ʱѭ������ֹͣ�� �������ϴ���������ʹ���� volatile ����
	 * active�����Ը�ѭ����ֹͣ��
	 */
	public static class MyRunnable implements Runnable {
		private volatile boolean active;

		public void run() {
			active = true;
			while (active) // ��һ��
			{
				// ����
				System.out.println("active=" + active);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void stop() {
			System.out.println("active=" + false);
			active = false; // �ڶ���
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable myRunnable = new MyRunnable();

		new Thread(new Runnable() {
			public void run() {
				myRunnable.run();
			}
		}).start();

		Thread.sleep(5000);

		new Thread(new Runnable() {
			public void run() {
				myRunnable.stop();
			}
		}).start();
	}
}
