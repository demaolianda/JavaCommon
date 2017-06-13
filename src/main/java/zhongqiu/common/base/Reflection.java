package zhongqiu.common.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//�������������״̬�� Java  ���еĸ��ֳɷ�ӳ�����Ӧ��Ӧ�� Java  �࣬���Զ�̬�û�ȡ���е������Լ���̬��������һ��������
//1).һ��java�����ڳ���������ڼ�ᾭ�������׶Σ�source-->class-->runtime
//2).Class����
//       ��java����һ��Class��������ʾһ��java���class�׶�
//       Class�����װ��һ��java�ඨ��ĳ�Ա��������Ա���������췽���������������ȡ�
public class Reflection {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		// ͨ������������һ�����ʵ��
		Class cls_str = Class.forName("java.lang.String");
		// �����������죬��Ϊʹ�ù� JDBC �������ݿ���˶��ù� J
		Object str = cls_str.newInstance();
		// �൱�� String str = new String();

		// ͨ��������������һ������
		String methodName = "length";
		Method m = cls_str.getMethod(methodName, null);
		System.out.println("length is " + m.invoke(str, null));
		// �൱�� System.out.println(str.length());
	}
}
