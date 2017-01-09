package zhongqiu.common.base;

//String���
public class StringDemo {
	/*
	 * String ���ͺ� StringBuffer ���͵���Ҫ����������ʵ���� String �ǲ��ɱ�Ķ���, �����ÿ�ζ� String
	 * ���ͽ��иı��ʱ����ʵ����ͬ��������һ���µ� String ����Ȼ��ָ��ָ���µ� String �������Ծ����ı����ݵ��ַ�����ò�Ҫ��
	 * String ����Ϊÿ�����ɶ��󶼻��ϵͳ���ܲ���Ӱ�죬�ر��ڴ��������ö�������Ժ� JVM �� GC �ͻῪʼ���������ٶ���һ�����൱���ġ�
	 */

	// StringBuffer �ַ����������̰߳�ȫ��
	// StringBuilder �ַ������������̰߳�ȫ��
	// �󲿷������ StringBuilder>StringBuffer>String

	public static void main(String[] args) {
		stringBuilderDemo();
	}

	// StringBuilder
	public static void stringBuilderDemo() {
		// ����ʵ��������
		StringBuilder sb = new StringBuilder("Hello World!");

		// apend�÷�
		sb.append("aaaa");
		System.out.println(sb);

		// insert�÷�.�����4��ǰ�����
		sb.insert(4, "23456");
		System.out.println(sb);

		// StringBuffer delete(start,end):ɾ���������е����ݣ�����Start,������end
		// StringBuffer deleteCharAt(index)��ɾ��������ָ��λ�õ�����
		sb.delete(1, 3);
		System.out.println(sb.toString());
		sb.deleteCharAt(0);
		System.out.println(sb.toString());
		// sb.delete(0,sb.length()):��ջ�����

		// ��ȡ
		char c = sb.charAt(2);
		System.out.println(c);
		int index = sb.indexOf("a");
		System.out.println(index);

		// �޸ģ�Ҳ�������Ϊ�滻
		sb.replace(1, 3, "java");
		System.out.println(sb.toString());
		sb.setCharAt(2, 'm');
		System.out.println(sb.toString());
	}

}
