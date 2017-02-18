package zhongqiu.common.jdkversion.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Lambda ���ʽ
//�����빹�캯������
public class Lambda {
	public static List<String> fruitList = Arrays.asList("Apple", "Banan", "Orange", "Pear");
	public static ArrayList<String> values = new ArrayList<>(1000000);

	public static void main(String[] args) {
		// StreamDemo.filter();
		// StreamDemo.sorted();
		// StreamDemo.match();
		// StreamDemo.count();
		// StreamDemo.reduce();
		// StreamDemo.map();
		StreamDemo.flagMap();
		// ParallelStreamDemo.init();
		// ParallelStreamDemo.stream();
		// ParallelStreamDemo.parallelStream();
		// ReuseLambda.reUseLambda();
	}

	// Stream �ӿ�
	// Stream������Ϊ�м�����������ղ������֣����ղ�������һ�ض����͵ļ����������м��������Stream����������Ϳ��Խ�����������δ�������
	// ���ղ�����forEach,match,count,reduce,collect
	// �м������filter,sorted,map,flagMap
	public static class StreamDemo {
		// forEach ����
		public static void forEach() {
			fruitList.forEach(fruit -> System.out.println(fruit));
			fruitList.forEach(System.out::println); // ��д��ʽ���������ã�
		}

		// match ƥ��
		public static void match() {
			boolean anyStartsWithA = fruitList.stream().anyMatch((s) -> s.startsWith("A"));

			System.out.println(anyStartsWithA); // true

			boolean allStartsWithA = fruitList.stream().allMatch((s) -> s.startsWith("A"));

			System.out.println(allStartsWithA); // false

			boolean noneStartsWithZ = fruitList.stream().noneMatch((s) -> s.startsWith("z"));

			System.out.println(noneStartsWithZ);// true
		}

		// count
		public static void count() {
			long count = fruitList.stream().count();
			System.out.println(count);
		}

		// reduce ��Լ
		public static void reduce() {
			Optional<String> reduced = fruitList.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
			reduced.ifPresent(System.out::println);
		}

		// Filter ����
		public static void filter() {
			fruitList.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);

			// ��stream��ֵ���µ�List<String>
			List<String> tempList = fruitList.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
		}

		// sort ����
		public static void sorted() {
			// Ĭ����������
			fruitList.stream().sorted().forEach(System.out::println);
			// ��������
			fruitList.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		}

		// map ӳ�� 1��1
		public static void map() {
			// ����������ֵĴ�д��ʽ
			fruitList.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.print(name + " "));
			fruitList.stream().map(String::toUpperCase).forEach(System.out::println);// �����빹�캯������

			// �������ÿ�����ֵĳ���
			fruitList.stream().map(String::length).forEach(count -> System.out.print(count + " "));
			fruitList.stream().map(String::length).forEach(System.out::println);
		}

		// flagMap ӳ�� һ�Զ�
		public static void flagMap() {
			Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3),
					Arrays.asList(4, 5, 6));
			Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
			outputStream.forEach(System.out::println);
		}

		// ��ת�������������ݽṹ
		public static void streamConvert() {
			Stream<String> stream = fruitList.stream();
			// 1. Array
			String[] strArray1 = stream.toArray(String[]::new);
			// 2. Collection
			List<String> list1 = stream.collect(Collectors.toList());
			List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
			Set set1 = stream.collect(Collectors.toSet());
			Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
			// 3. String
			String str = stream.collect(Collectors.joining()).toString();
		}
	}

	// ����Streams
	public static class ParallelStreamDemo {
		// ��ʼ��
		public static void init() {
			for (int i = 0; i < 1000000; i++) {
				UUID uuid = UUID.randomUUID();
				values.add(uuid.toString());
			}
		}

		// ����stream
		public static void stream() {
			long t0 = System.nanoTime();

			long count = values.stream().sorted().count();
			System.out.println(count);

			long t1 = System.nanoTime();

			long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
			System.out.println(String.format("sequential sort took: %d ms", millis));
		}

		// ����stream
		public static void parallelStream() {
			long t0 = System.nanoTime();

			long count = values.parallelStream().sorted().count();
			System.out.println(count);

			long t1 = System.nanoTime();

			long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
			System.out.println(String.format("parallel sort took: %d ms", millis));

		}
	}

	public static class ReuseLambda {
		// ��̬����Lambda���ʽ�ĸ߽׺�����ӵ�бհ�����
		public static Predicate<String> checkIfStartsWith(final String letter) {
			return name -> name.startsWith(letter);
		}

		public static void reUseLambda() {
			// Lambda���ʽ������
			System.out.println(fruitList.stream().filter(checkIfStartsWith("A")).count());
			System.out.println(fruitList.stream().filter(checkIfStartsWith("B")).collect(Collectors.toList()));
		}
	}

}
