package zhongqiu.common.base;

//������������
//http://www.runoob.com/java/java-basic-datatypes.html
/*
��һ�ࣺ���� byte short int long 
�ڶ��ࣺ������ float double
�����ࣺ�߼��� boolean(��ֻ������ֵ��ȡtrue false)
�����ࣺ�ַ��� char

��ջ�п���ֱ�ӷ����ڴ�������ǻ����������͡�
�����������ͣ������ݵ�������ջ�У��������Ķ����ڶ��С�

�ֽڣ�
boolean ������              1/8 
byte �ֽ�����                1
char �ַ���                  2  һ���ַ��ܴ洢һ�����ĺ���
short ������                 2
int ��������                 4
long ������                  8
float �������ͣ������ȣ�     4
double ˫�������ͣ�˫���ȣ�  8
һ���ֽڵ���8λ��һ���ֽڵ���256����������-128��127һ��256
*/

/*�����ظ���
java�л������͵İ�װ��Ĵ󲿷ֶ�ʵ���˳����ؼ�������Щ���� Byte,Short,Integer,Long,Character,Boolean,
�������ָ��������͵İ�װ����û��ʵ�֡����� Byte,Short,Integer,Long,Character��5�����͵İ�װ��Ҳֻ���ڶ�Ӧֵ>= -128 &&<= 127ʱ�ſ�ʹ�ö���أ�
Ҳ�����󲻸��𴴽��͹������127����Щ��Ķ���*/
public class BaseTypeDemo {
	public static void main(String[] args) {
		// ValueTypeDemo.test();
		ReferenceTypeDemo.test();
		// CharDemo.test();
		// StringDemo.test();
		// StringDemo.test1();
		// StringDemo.test2();
	}

	// ֵ����Demo
	public static class ValueTypeDemo {
		public static void test() {
			int i = 1;
			process(i);
			System.out.println(i);
			process(i, 2);
			System.out.println(i);
			StringBuffer str = new StringBuffer("a");
			process(str);
			System.out.println(str);
			// ����� 1 1 ab
		}

		public static void process(int i) {
			i = 2;
		}

		public static void process(int i, int j) {
			i = i + j;
		}

		public static void process(StringBuffer str) {
			str.append("b");
		}
	}

	// ��������char�������Ƚ�
	public static class CharDemo {
		public static void test() {
			char a = 'a';
			char b = 'b';
			char c = 'a';
			System.out.println(a == b);
			System.out.println(a == c);

			// �����false true
		}
	}

	// ��������String�������Ƚ�
	public static class StringDemo {
		public static void test() {
			String aString = "ab";
			System.out.println(aString == "ab");
			System.out.println("ab" == "ab");
			System.out.println("ab" == new String("ab"));
			System.out.println("ab" == String.valueOf("ab"));

			// ����kv���͡�ill��Ҳ�����ַ�
			// ����������һ���ַ����ɶ���ַ����������Ӷ���ʱ�����Լ��϶�Ҳ���ַ�������������s7Ҳͬ���ڱ����ھͱ�����Ϊһ���ַ�������������s7Ҳ�ǳ�������
			// ��kvill����һ�����á�
			String s6 = "kvill";
			String s7 = "kv" + "ill";
			System.out.println(s6 == s7);
			System.out.println(new String("ab").equals(new String("ab")));
		}

		public static void test1() {
			// ������.class�ļ��еĳ����أ��������ڱ�JVMװ�أ����ҿ������䡣String��intern()�����������䳣���ص�һ��
			// ��������һ��Stringʵ��str����intern()����ʱ��Java���ҳ��������Ƿ�����ͬUnicode���ַ�������������У��򷵻�������ã�
			// ���û�У����ڳ�����������һ��Unicode����str���ַ�����������������
			String s0 = "kvill"; // ������һ���������ڳ������������ַ���kvill
			String s1 = new String("kvill");// new ���������ڳ������������ַ���
			String s2 = new String("kvill");
			System.out.println(s0 == s1);
			System.out.println("**********");
			s1.intern();
			s2 = s2.intern(); // �ѳ������С�kvill�������ø���s2
			System.out.println(s0 == s1);
			System.out.println(s0 == s1.intern());
			System.out.println(s0 == s2);
			// ���Ϊ��
			//
			// false
			// **********
			// false //��Ȼִ����s1.intern(),�����ķ���ֵû�и���s1
			// true //˵��s1.intern()���ص��ǳ������С�kvill��������
			// true
		}

		public static void test2() {
			String s1 = new String("kvill");
			String s2 = s1.intern();
			System.out.println(s1 == s1.intern());
			System.out.println(s1 + " " + s2);
			System.out.println(s2 == s1.intern());
			// �����
			//
			// false
			// kvill kvill
			// true
			// �������������û������һ����kvill�����������Գ�������һ��ʼ��û�С�kvill���ģ������ǵ���s1.intern()����ڳ������������
			// ��һ����kvill��������ԭ���Ĳ��ڳ������еġ�kvill����Ȼ���ڣ�Ҳ�Ͳ��ǡ����Լ��ĵ�ַע�ᵽ�������С��ˡ�
			//
			// s1==s1.intern()Ϊfalse˵��ԭ���ġ�kvill����Ȼ���ڣ�
			//
			// s2����Ϊ�������С�kvill���ĵ�ַ��������s2==s1.intern()Ϊtrue��
		}
	}

	// ��������Demo
	// ��ȥ�������ͣ������Ķ�����������
	public static class ReferenceTypeDemo {
		/*
		 * �����еĲ���ʱ�ֲ��������ģ������һ����˵�ɣ� ����public static void process(String str,
		 * StringBuffer sb) �в���str��sb���Ǿֲ�������
		 * ����process(str,sb)�����þֲ�����������Ĳ���ָ��ͬһ������str = new String("A");
		 * ֻ�ǽ��ֲ�����strָ����һ���������ã����ⲿ��strû�й�ϵ������str��Ϊa,��sb.append("A");
		 * �ǽ��ֲ�����sbָ��Ķ���׷��"A"�������ھֲ�����ָ��Ķ�����ⲿ��sbָ��ͬһ�����������ⲿ��sbҲ�ͱ��aA�ˡ�
		 */
		public static void test() {
			String str = "a";
			StringBuffer sb = new StringBuffer("a");
			process(str);
			System.out.println(str);
			process(sb);
			System.out.println(sb);
			process(str, sb);
			System.out.println(str);
			System.out.println(sb);
		}

		public static void process(String str) {
			str = "A";
		}

		public static void process(StringBuffer sb) {
			sb = new StringBuffer();
			sb.append("A");
		}

		public static void process(String str, StringBuffer sb) {
			str = new String("A");
			sb.append("A");
		}
	}

}
