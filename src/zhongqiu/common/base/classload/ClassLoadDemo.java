package zhongqiu.common.base.classload;

public class ClassLoadDemo {
	static {
		System.out.println("ClassLoadDemo��̬��ʼ����ִ���ˣ�");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// һ������ع��̣�
		// 1��Ѱ��jreĿ¼��Ѱ��jvm.dll������ʼ��JVM��
		// 2������һ��Bootstrap Loader�����������������
		// 3��Bootstrap Loader�Զ�����Extended Loader����׼��չ����������������丸Loader��ΪBootstrap
		// Loader��
		// 4��Bootstrap Loader�Զ�����AppClass Loader��ϵͳ����������������丸Loader��ΪExtended
		// Loader��
		// 5�������AppClass Loader����HelloWorld�ࡣ
		ClassLoader loader1 = ClassLoadDemo.class.getClassLoader();
		System.out.println(loader1);
		System.out.println(loader1.getParent());
		System.out.println(loader1.getParent().getParent());

		// ��������������ַ�ʽ��
		// 1������������Ӧ��ʱ����JVM��ʼ������
		// 2��ͨ��Class.forName()������̬����
		// 3��ͨ��ClassLoader.loadClass()������̬����
		ClassLoader loader2 = ClassLoadDemo.class.getClassLoader();
		System.out.println(loader2);
		// ʹ��ClassLoader.loadClass()�������࣬����ִ�г�ʼ����
		// loader2.loadClass("zhongqiu.test.Test");
		// ʹ��Class.forName()�������࣬Ĭ�ϻ�ִ�г�ʼ����
		// Class.forName("zhongqiu.test.Test");
		// ʹ��Class.forName()�������࣬��ָ��ClassLoader����ʼ��ʱ��ִ�о�̬��
		Class.forName("zhongqiu.test.Test", false, loader2);
	}
}