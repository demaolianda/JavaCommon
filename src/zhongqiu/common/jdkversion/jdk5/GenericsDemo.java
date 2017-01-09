package zhongqiu.common.jdkversion.jdk5;

import java.util.Random;

//�����÷���
//�����࣬���ͽӿڣ����ͷ�����ͨ����÷�extends��super
/*����Java�еķ�����һ���������Ŀ�ģ�������ֻ�������ڴ������׶Σ�
�ڱ�������У�������ȷ���鷺�ͽ���󣬻Ὣ���͵������Ϣ������Ҳ����˵��
�ɹ���������class�ļ����ǲ������κη�����Ϣ�ġ�������Ϣ������뵽����ʱ�׶Ρ�*/
public class GenericsDemo {
	public static void main(String[] args) {
		// ������Ϊ����
		Container<String, String> c1 = new Container<String, String>("name", "findingsea");
		Container<String, Integer> c2 = new Container<String, Integer>("age", 24);
		Container<Double, Double> c3 = new Container<Double, Double>(1.1, 2.2);
		getContainer(c1);
		getContainer(c2);
		getContainer(c3);
		getContainerExtends(c1);// getContainerExtends(c2);�ᱨ��

		// ���ͽӿ�
		FruitGenerator generator = new FruitGenerator();
		System.out.println(generator.next());
		System.out.println(generator.next());

		// ���ͷ���
		out("findingsea");
		out(123);
		out("abc", "lkj", "sgh");
	}

	// ������
	public static class Container<K, V> {
		private K key;
		private V value;

		public Container(K k, V v) {
			key = k;
			value = v;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	// ͨ������ܷ���
	public static void getContainer(Container<?, ?> data) {
		System.out.println("key :" + data.getKey());
		System.out.println("value :" + data.getValue());
	}

	// ͨ������ܷ���(extends�÷�)
	public static void getContainerExtends(Container<?, ? extends String> data) {
		System.out.println("key :" + data.getKey());
		System.out.println("value :" + data.getValue());
	}

	// ͨ������ܷ���(super�÷�)
	public static void getContainerSuper(Container<?, ? super String> data) {
		System.out.println("key :" + data.getKey());
		System.out.println("value :" + data.getValue());
	}

	// ���ͽӿ�
	public interface Generator<T> {
		public T next();
	}

	// ���ͽӿڵ�ʵ����
	public static class FruitGenerator implements Generator<String> {

		private String[] fruits = new String[] { "Apple", "Banana", "Pear" };

		@Override
		public String next() {
			Random rand = new Random();
			return fruits[rand.nextInt(3)];
		}
	}

	// ���ͷ���
	public static <T> void out(T t) {
		System.out.println(t);
	}

	// ���ͷ����Ϳɱ����
	public static <T> void out(T... args) {
		for (T t : args) {
			System.out.println(t);
		}
	}

}
