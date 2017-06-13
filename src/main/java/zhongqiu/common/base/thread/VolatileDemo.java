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
	int a = 1;
	int b = 2;

	public void change() {
		a = 3;
		b = a;
	}

	public void print() {
		System.out.println("b=" + b + ";a=" + a);
	}

	public static void test1() {

		for (int i = 0; i < 50; i++) {
			final VolatileDemo test = new VolatileDemo();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.change();
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.print();
				}
			}).start();
		}
	}

	public static void main(String[] args) {
		test1();
	}
}
