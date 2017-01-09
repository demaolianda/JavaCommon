package zhongqiu.common.jdkversion.jdk8;

import java.util.Optional;

//Optional 
//http://www.runoob.com/java/java8-optional-class.html

//Optional ����һ������Ϊnull�������������ֵ������isPresent()�����᷵��true������get()�����᷵�ظö���
//Optional �Ǹ������������Ա�������T��ֵ�����߽�������null��Optional�ṩ�ܶ����õķ������������ǾͲ�����ʽ���п�ֵ��⡣
//Optional �������ܺõĽ����ָ���쳣��
public class OptionalDemo {
	public static void main(String[] args) {
		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - ������Ϊ null ����
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - ������ݵĲ����� null���׳��쳣 NullPointerException
		Optional<Integer> b = Optional.of(value2);
		System.out.println(sum(a, b));
	}

	public static Integer sum(Optional<Integer> a, Optional<Integer> b) {

		// Optional.isPresent - �ж�ֵ�Ƿ����
		System.out.println("��һ������ֵ����: " + a.isPresent());
		System.out.println("�ڶ�������ֵ����: " + b.isPresent());

		// Optional.orElse - ���ֵ���ڣ������������򷵻�Ĭ��ֵ
		Integer value1 = a.orElse(new Integer(0));

		// Optional.get - ��ȡֵ��ֵ��Ҫ����
		Integer value2 = b.get();
		return value1 + value2;
	}
}
