package zhongqiu.common.base;

//�������Math.random() -- ����0��1֮���α����� ����Ϊ0��������С��1��[0,1)
public class MathRandomDemo {
	public static void main(String[] args) {
		intAndChar();
		for (int i = 0; i < 100; i++) {
			System.out.println(Math.random());
		}
		for (int i = 0; i < 10; i++) {
			sixRandomStr();
		}

	}

	// int��char��Ӧ��ϵ
	public static void intAndChar() {
		for (int i = 1; i < 257; i++) {
			System.out.println(i + "��Ӧ:" + (char) i);
		}
	}

	// ����һ��6λ������ַ���
	public static void sixRandomStr() {
		String result = "";
		for (int i = 0; i < 6; i++) {
			// ����97-122��int�͵�����
			int intValue = (int) (Math.random() * 25 + 97);
			// ��intValueǿ��ת����char���ͺ�ӵ�result����
			result = result + (char) intValue;
		}
		// ����ַ���
		System.out.println(result);
	}
}
