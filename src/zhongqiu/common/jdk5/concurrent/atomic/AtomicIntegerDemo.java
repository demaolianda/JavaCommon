package zhongqiu.common.jdk5.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;


//��ôΪʲô��ʹ�ü������Լ��أ�����count++�����ģ���Ϊ���ּ������̲߳���ȫ�ģ��߲�������ʱͳ�ƻ�����
//��AtomicIntegerΪʲô�ܹ��ﵽ������ң�����߲���Ӧ�������أ�
//������Ӳ���ṩԭ�Ӳ���ָ��ʵ�ֵġ��ڷǼ��Ҿ���������£�������С���ٶȸ��졣Java.util.concurrent��ʵ�ֵ�ԭ�Ӳ����������
//AtomicBoolean��AtomicInteger��AtomicLong��AtomicReference��
public class AtomicIntegerDemo {

}

class CounterSyn {
	private volatile int count = 0;

	public synchronized void increment() {
		count++; // ��Ҫ�̰߳�ȫִ��ִ��count++����Ҫ����
	}

	public int getCount() {
		return count;
	}
}

class CounterAtomic {
	private AtomicInteger count = new AtomicInteger();

	public void increment() {
		count.incrementAndGet();
	}

	// ʹ��AtomicInteger֮�󣬲���Ҫ������Ҳ����ʵ���̰߳�ȫ��
	public int getCount() {
		return count.get();
	}
}
