package zhongqiu.common.base;

//���������
public class OperatorDemo {
	public static void main(String[] args) {
		self();
		three();
		instanceOf();
	}

	// a++��a--�������Լ������
	// 1��ǰ׺�����Լ���(++a,--a): �Ƚ������������Լ����㣬�ٽ��б��ʽ���㡣
	// 2����׺�����Լ���(a++,a--): �Ƚ��б��ʽ���㣬�ٽ������������Լ����� ʵ����
	public static void self() {
		int a = 5;// ����һ��������
		int b = 5;
		int x = 2 * ++a;
		int y = 2 * b++;
		System.out.println("���������ǰ׺�����a=" + a + ",x=" + x);
		System.out.println("�����������׺�����b=" + b + ",y=" + y);
	}

	// ���������(��Ԫ�����)��?:��
	public static void three() {
		int a, b;
		a = 10;
		b = (a == 1) ? 20 : 30;
		System.out.println("Value of b is : " + b);
		b = (a == 10) ? 20 : 30;
		System.out.println("Value of b is : " + b);
	}

	// instanceof�����.
	public static void instanceOf() {
		String name = "James";
		boolean result = name instanceof String;
		System.out.println(result);
	}
}
