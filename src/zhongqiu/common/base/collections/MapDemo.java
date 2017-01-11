package zhongqiu.common.base.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

//Map
public class MapDemo {
	public static void main(String[] args) {
		init();
		traversal();
	}

	// HashMap���չ�ϣ�㷨����ȡ�������кܺõĴ�ȡ����
	private static HashMap<String, String> hMap = new HashMap<>();

	// TreeMapʵ����SortedMap�ӿڣ��ܶԼ������������֧����Ȼ����Ϳͻ����������ַ�ʽ��
	private static TreeMap<String, String> tMap = new TreeMap<>();

	// map�ĸ�ֵ
	public static void init() {
		hMap.put("1", "value1");
		hMap.put("2", "value2");
		hMap.put("3", "value3");
	}

	// map�ı���
	public static void traversal() {
		// ��һ�֣��ձ�ʹ�ã�����ȡֵ
		System.out.println("ͨ��Map.keySet����key��value��");
		for (String key : hMap.keySet()) {
			System.out.println("key= " + key + " and value= " + hMap.get(key));
		}

		// �ڶ���
		System.out.println("ͨ��Map.entrySetʹ��iterator����key��value��");
		Iterator<Map.Entry<String, String>> it = hMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// �����֣��Ƽ���������������ʱ
		System.out.println("ͨ��Map.entrySet����key��value");
		for (Map.Entry<String, String> entry : hMap.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// ������
		System.out.println("ͨ��Map.values()�������е�value�������ܱ���key");
		for (String v : hMap.values()) {
			System.out.println("value= " + v);
		}
	}
}
