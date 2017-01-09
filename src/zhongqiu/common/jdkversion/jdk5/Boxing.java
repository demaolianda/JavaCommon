package zhongqiu.common.jdkversion.jdk5;

public class Boxing {
	public static void main(String[] args) {
		integerBoxing();
	}

	public static void autoBoxing() {
		/*
		 * һ������Ҫ����һ����Ķ���ʵ����ʱ�����ǻ�������
		 * 
		 * Class a = new Class(parameter);
		 * 
		 * �����Ǵ���һ��Integer����ʱ��ȴ����������
		 * 
		 * Integer i = 100; (ע�⣺���� int i = 100; )
		 * 
		 * ʵ���ϣ�ִ�������Ǿ�����ʱ��ϵͳΪ����ִ���ˣ�Integer i = Integer.valueOf(100);
		 * 
		 * �˼������������͵��Զ�װ�书�ܡ�
		 */
		Integer i = 100;
	}

	public static void unBoxing() {
		// �Զ�����(unboxing)��Ҳ���ǽ������еĻ������ݴӶ������Զ�ȡ�������¿�ʵ���Զ����䣺
		Integer i = 10; // װ��
		int t = i; // ���䣬ʵ����ִ���� int t = i.intValue();
	}

	public static void integerBoxing() {
		// integerԴ��
		// public static Integer valueOf(int i) {
		// if(i >= -128 && i <= IntegerCache.high) // û�����õĻ���IngegerCache.high
		// Ĭ����127
		// return IntegerCache.cache[i + 128];
		// else
		// return new Integer(i);
		// }

		// ��-128~127 ֮�����
		Integer i1 = 200;
		Integer i2 = 200;
		System.out.println("i1==i2: " + (i1 == i2));// ��ʾfalse
		// ��-128~127 ֮�ڵ���
		Integer i3 = 100;
		Integer i4 = 100;
		System.out.println("i3==i4: " + (i3 == i4));// ��ʾtrue

		Integer i5 = new Integer(100);
		Integer i6 = new Integer(100);
		System.out.println("i5==i6: " + (i5 == i6));// ��ʾfalse
	}
}
