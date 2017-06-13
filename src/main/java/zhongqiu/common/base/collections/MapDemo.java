package zhongqiu.common.base.collections;

import java.net.Inet4Address;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import zhongqiu.common.jdk7.ValueWithUnderline;

//Map
public class MapDemo {

	public static void main(String[] args) {
		init();
		// traversal();
		String str = "sdk,gljgl,;ldogl,ljkjg,dog,cat,dog";
		String subStr = "dog";
		statis(str, 40);
		count(str);
		subCounter(str, subStr);
	}

	// HashMap���չ�ϣ�㷨����ȡ�������кܺõĴ�ȡ����
	private static HashMap<Integer, Integer> hMap = new HashMap<>();

	// TreeMapʵ����SortedMap�ӿڣ��ܶԼ������������֧����Ȼ����Ϳͻ����������ַ�ʽ��
	private static TreeMap<Integer, Integer> tMap = new TreeMap<>();

	// map�ĸ�ֵ
	public static void init() {
		hMap.put(1, 1);
		hMap.put(2, 2);
		hMap.put(3, 3);
	}

	// map�ı���
	public static void traversal() {
		// ��һ�֣��ձ�ʹ�ã�����ȡֵ
		System.out.println("ͨ��Map.keySet����key��value��");
		for (Integer key : hMap.keySet()) {
			System.out.println("key= " + key + " and value= " + hMap.get(key));
		}

		// �ڶ���
		System.out.println("ͨ��Map.entrySetʹ��iterator����key��value��");
		Iterator<Map.Entry<Integer, Integer>> it = hMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// �����֣��Ƽ���������������ʱ
		System.out.println("ͨ��Map.entrySet����key��value");
		for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// ������
		System.out.println("ͨ��Map.values()�������е�value�������ܱ���key");
		for (Integer v : hMap.values()) {
			System.out.println("value= " + v);
		}
	}

	// ͳ���ַ�����ÿ���ַ����ֵĴ���
	public static void statis(String str, int top) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		char[] cs = str.toCharArray();
		for (char c : cs) {
			if (null == hashMap.get(c)) {
				hashMap.put(c, 1);
			} else {
				hashMap.put(c, hashMap.get(c) + 1);
			}
		}
		// ��entryȡ������������
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(hashMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		for (int i = 0; i < top; i++) {
			if (i < list.size()) {
				System.out.println(list.get(i).getKey() + "--" + list.get(i).getValue());
			}
		}
		// ֻ��valueȡ����
		List<Integer> valueList = new ArrayList<>(hashMap.values());
		Collections.sort(valueList, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
		for (int i = 0; i < top; i++) {
			if (i < valueList.size()) {
				System.out.println(valueList.get(i));
			}
		}
	}

	// ͳ���ַ����еĴ�д��Сд�����֣������ַ�����
	public static void count(String s) {
		int low, upper, num, others;
		low = upper = num = others = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num++;
				continue;
			}
			if (Character.isLowerCase(s.charAt(i))) {
				low++;
				continue;
			}
			if (Character.isUpperCase(s.charAt(i))) {
				upper++;
				continue;
			} else {
				others++;
			}
		}
		System.out
				.println(" ��д��ĸ�ĸ���Ϊ��" + upper + "\n Сд��ĸ�ĸ���Ϊ��" + low + "\n ���ֵĸ���Ϊ�� " + num + "\n �����ַ��ĸ���Ϊ�� " + others);
	}

	// ͳ���ַ��������ַ������ֵĴ���
	public static void subCounter(String str1, String str2) {
		int counter = 0;
		for (int i = 0; i <= str1.length() - str2.length(); i++) {
			if (str1.substring(i, i + str2.length()).equalsIgnoreCase(str2)) {
				counter++;
			}
		}
		System.out.println("���ַ����ĸ���Ϊ�� " + counter);
	}
}