package zhongqiu.common.base.thread;

//Volatile���η�
//http://www.runoob.com/java/java-modifier-types.html
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
	public class MyRunnable implements Runnable {
		private volatile boolean active;

		public void run() {
			active = true;
			while (active) // ��һ��
			{
				// ����
			}
		}

		public void stop() {
			active = false; // �ڶ���
		}
	}
}
