package zhongqiu.common.jdk7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//�����Զ��ƶ�  <>
public class TypeInferenceDemo {

	List<String> tempList = new ArrayList<>();

	// û��ʹ�������ƶ�
	Map<String, List<String>> map1 = new HashMap<String, List<String>>();
	// ͨ�������ƶϺ��ɣ�
	Map<String, List<String>> map2 = new HashMap<>();// ���<>������diamond����ʯ����������������������õ��������ƶ����͡�
}
