package zhongqiu.common.jdkversion.jdk8;

//����ʽ�ӿڣ����ǰ���Щֻӵ��һ�������Ľӿڳ�Ϊ ����ʽ�ӿڡ�Ҳ���� �����󷽷�����
// ��Ϊ Ĭ�Ϸ��� ������󷽷���������Ҳ���Ը���ĺ���ʽ�ӿ����Ĭ�Ϸ�����
// Lambda���ʽ�ᱻ������ת������Ӧ����ʽ�ӿڵ�һ��ʵ��
// FI<String, Integer> fI = (from) -> Integer.valueOf(from);
// Integer converted = fI.convert("123");
// System.out.println(converted);
@FunctionalInterface
public interface FI<F, T> {
	T convert(F from);
}
