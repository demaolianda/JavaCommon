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

	// HashMap按照哈希算法来存取键对象，有很好的存取性能
	private static HashMap<String, String> hMap = new HashMap<>();

	// TreeMap实现了SortedMap接口，能对键对象进行排序。支持自然排序和客户化排序两种方式。
	private static TreeMap<String, String> tMap = new TreeMap<>();

	// map的赋值
	public static void init() {
		hMap.put("1", "value1");
		hMap.put("2", "value2");
		hMap.put("3", "value3");
	}

	// map的遍历
	public static void traversal() {
		// 第一种：普遍使用，二次取值
		System.out.println("通过Map.keySet遍历key和value：");
		for (String key : hMap.keySet()) {
			System.out.println("key= " + key + " and value= " + hMap.get(key));
		}

		// 第二种
		System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<String, String>> it = hMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// 第三种：推荐，尤其是容量大时
		System.out.println("通过Map.entrySet遍历key和value");
		for (Map.Entry<String, String> entry : hMap.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// 第四种
		System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
		for (String v : hMap.values()) {
			System.out.println("value= " + v);
		}
	}
}
