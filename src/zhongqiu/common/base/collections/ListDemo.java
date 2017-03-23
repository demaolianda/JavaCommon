package zhongqiu.common.base.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

//List��ز���
public class ListDemo {
	public static void main(String[] args) {
		initList();
		traversal();
		// sort();
		// reverse();
		// userDefinedSort();
		// shuffle();
		// copy();
		// min();
		// max();
		// lastIndexOfSubList();
		// indexOfSubList();
		// rotate();
		// fill();
		Iterator<String> iterator = list.iterator();
	}

	private static ArrayList<String> list = new ArrayList<>();
	private static ArrayList<CollectionPo> arrayList = new ArrayList<>();// ��ͬ�����ɱ�����
	private static LinkedList<CollectionPo> linkedList = new LinkedList<>();// ��ͬ��������
	private static Vector<CollectionPo> vector = new Vector<>();// ͬ��

	// ��ʼ������
	public static void initList() {
		// Arrays.asList����
		list = new ArrayList<String>(Arrays.asList("Apple", "Banan", "Orange"));

		arrayList = new ArrayList<CollectionPo>(Arrays.asList(new CollectionPo(1, "��", 30),
				new CollectionPo(0, "Ǯ", 22), new CollectionPo(0, "��", 66)));

		// add����
		CollectionPo cPo = new CollectionPo(1, "��", 7);
		arrayList.add(cPo);

		arrayList.add(new CollectionPo(1, "��", 87));

		list.add("Pear");

	}

	// ��������
	public static void traversal() {
		// foreach������ֻ�Ǳ��������ܸı������е�Ԫ��
		for (String string : list) {
			System.out.println(string);
		}
		for (CollectionPo cPo : arrayList) {
			System.out.println(cPo.name);
		}
		// for���������Զ������е�Ԫ�ؽ��в���
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).name);
		}
		// ����������
		Iterator<String> ite = list.iterator();
		while (ite.hasNext())// �ж���һ��Ԫ��֮����ֵ
		{
			System.out.println(ite.next());
		}
	}

	// ��������
	public static void sort() {
		Collections.sort(list);
		System.out.println(list);
	}

	// ��������
	public static void reverse() {
		Collections.reverse(list);
		System.out.println(list);
	}

	// �Զ�������
	public static void userDefinedSort() {
		// ����List<String>,����String����
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		System.out.println(list);
		// ����List<CollectionPo>,����age��������
		Collections.sort(arrayList, new Comparator<CollectionPo>() {
			@Override
			public int compare(CollectionPo a, CollectionPo b) {
				return b.age.compareTo(a.age);
			}
		});
		for (CollectionPo cPo : arrayList) {
			System.out.println(cPo.getAge() + "--" + cPo.getName());
		}
	}

	// ���ţ���������
	public static void shuffle() {
		Collections.shuffle(list);
		System.out.println(list);
	}

	// ȫ���滻
	public static void fill() {
		Collections.fill(list, "aaa");
		System.out.println(list);
	}

	// ����
	public static void copy() {
		// ��Ҫ��ǰ���ú�Ŀ��list��size������ᱨ��
		ArrayList<String> newlist = new ArrayList<>(Arrays.asList(new String[list.size()]));

		Collections.copy(newlist, list);
		System.out.println(newlist);
	}

	// ��Сֵ
	public static void min() {
		System.out.println(Collections.min(list));
	}

	// ���ֵ
	public static void max() {
		System.out.println(Collections.max(list));
	}

	// ���һ�γ��ֵ�λ��
	public static void lastIndexOfSubList() {
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 7, 3));
		ArrayList<Integer> targetList = new ArrayList<>(Arrays.asList(6));
		System.out.println(Collections.lastIndexOfSubList(intList, targetList));
	}

	// ��һ�γ��ֵ�λ��
	public static void indexOfSubList() {
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 7, 3));
		ArrayList<Integer> targetList = new ArrayList<>(Arrays.asList(6));
		System.out.println(Collections.indexOfSubList(intList, targetList));
	}

	// �ƶ��б��е�Ԫ�أ����������ƶ������������ƶ�
	public static void rotate() {
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(intList);
		Collections.rotate(intList, 1);
		System.out.println(intList);
	}
}
