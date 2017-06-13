package zhongqiu.common.base.thread;

//���߳���Դͬ��
/*
1��synchronized�ؼ��ֵ��������ж��֣� 
1����ĳ������ʵ���ڣ�synchronized aMethod(){}���Է�ֹ����߳�ͬʱ������������synchronized���������һ�������ж��synchronized������
       ֻҪһ���̷߳��������е�һ��synchronized�����������̲߳���ͬʱ��������������κ�һ��synchronized��������
       ��ʱ����ͬ�Ķ���ʵ����synchronized�����ǲ�����ŵġ�Ҳ����˵�������߳���������ͬʱ������ͬ�����һ������ʵ���е�synchronized������ 
2����ĳ����ķ�Χ��synchronized static aStaticMethod{}��ֹ����߳�ͬʱ����������е�synchronized static �����������Զ�������ж���ʵ�������á� 
2�����˷���ǰ��synchronized�ؼ��֣�synchronized�ؼ��ֻ��������ڷ����е�ĳ�������У���ʾֻ������������Դʵ�л�����ʡ�
       �÷���: synchronized(this){����}�������������ǵ�ǰ���� 
3��synchronized�ؼ����ǲ��ܼ̳еģ�Ҳ����˵������ķ���synchronized f(){} �ڼ̳����в����Զ���synchronized f(){}��
       ���Ǳ����f(){}���̳�����Ҫ����ʽ��ָ������ĳ������Ϊsynchronized������ 
*/
public class SynchronizedDemo implements Runnable {
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}

	// synchronized(this)ͬ�������
	public void run() {
		System.out.println("�߳�" + Thread.currentThread().getName() + "������syn����");
		synchronized (this) {
			System.out.println("�߳�" + Thread.currentThread().getName() + "�����syn����");
			for (int i = 0; i < 200; i++) {
				System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
			}
		}
	}

	// synchronized(this)ͬ�������
	public void SYN() {
		System.out.println("�߳�" + Thread.currentThread().getName() + "������syn����");
		synchronized (this) {
			System.out.println("�߳�" + Thread.currentThread().getName() + "�����syn����");
			for (int i = 0; i < 200; i++) {
				System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
			}
		}
	}

	// ��synchronized(this)ͬ�������
	public void notSYN() {
		System.out.println("�����synchronized(this)ͬ������鲻������Ӱ��");
		System.out.println("�߳�" + Thread.currentThread().getName() + "����ʹ�ö���syn��������synchronized(this)����");
		for (int i = 0; i < 200; i++) {
			System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
		}
	}

	/*
	 * ����һ����ȷ�Ķ�����Ϊ��ʱ���Ϳ�������д���򣬵���û����
	 * 
	 * ȷ�Ķ�����Ϊ����ֻ������һ�δ���ͬ��ʱ�����Դ���һ�������instance������������һ���������䵱����
	 */
	/*
	 * ע���㳤�ȵ�byte������󴴽����������κζ��󶼾��èD�D�鿴�������ֽ��룺�����㳤�ȵ�byte[]����ֻ��3�������룬��Object lock
	 * 
	 * = new Object()����Ҫ7�в����롣
	 */
	private byte[] lock1 = new byte[0]; // �����instance����

	void methodA() {
		synchronized (lock1) {
			for (int i = 0; i < 200; i++) {
				System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
			}
		}
	}

	/*
	 * �����������̷߳���ͬһ������object�е����synchronized(this)ͬ�������ʱ��
	 * һ��ʱ����ֻ����һ���̵߳õ�ִ�С���һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ����ִ�иô���顣
	 */
	public static void test1() {
		SynchronizedDemo syn = new SynchronizedDemo();
		Thread ta = new Thread(syn, "A");
		Thread tb = new Thread(syn, "B");
		ta.start();
		tb.start();
	}

	/*
	 * ��һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
	 * ��һ���߳���Ȼ���Է��ʸ�object�еķ�synchronized(this)ͬ������顣
	 */
	public static void test2() {
		/*
		 * final���ε��಻�ܱ��̳С� Sting����һ����final���ε��࣬����ֻ���ã����ü̳�
		 * final�������������࣬���������α�������final���εı�������һ��������ֻ�ܸ�ֵһ��
		 */
		final SynchronizedDemo syn = new SynchronizedDemo();
		new Thread(new Runnable() {
			public void run() {
				syn.run();
			}
		}, "t1").start();
		
		new Thread(new Runnable() {
			public void run() {
				syn.notSYN();
			}
		}, "t2").start();
	}

	/*
	 * ��һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
	 * �����̶߳�object����������synchronized(this)ͬ�������ķ��ʽ���������
	 * Ҳ����˵����һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ�����ͻ�������object�Ķ�������
	 * ����������̶߳Ը�object��������ͬ�����벿�ֵķ��ʶ�����ʱ������
	 */
	public static void test3() {
		final SynchronizedDemo syn = new SynchronizedDemo();
		
		new Thread(new Runnable() {
			public void run() {
				syn.run();
			}
		}, "t1").start();
		
		new Thread(new Runnable() {
			public void run() {
				syn.SYN();
			}
		}, "t2").start();
		
		new Thread(new Runnable() {
			public void run() {
				syn.methodA();
			}
		}, "t3").start();
	}

}
