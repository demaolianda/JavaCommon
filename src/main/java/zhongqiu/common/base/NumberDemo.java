package zhongqiu.common.base;

//Number�����
public class NumberDemo {
	/*
	 * ��ʵ�ʿ��������У����Ǿ�����������Ҫʹ�ö��󣬶����������������͵����Ρ�Ϊ�˽��������⣬Java ����Ϊÿһ���������������ṩ�˶�Ӧ�İ�װ�ࡣ
	 * ���еİ�װ�ࣨInteger��Long��Byte��Double��Float��Short�����ǳ����� Number �����ࡣ
	 */

	/*
	 * Number���� compareTo() equals() �ȵ�
	 */
	public static void main(String[] args) {
		Integer aInteger = 1;
		Integer bInteger = 1;
		Integer aInteger2 = new Integer(1);
		Integer bInteger2 = new Integer(1);

		System.out.println(aInteger == bInteger);
		System.out.println(aInteger == aInteger2);
		System.out.println(aInteger2 == bInteger2);
	}
}
