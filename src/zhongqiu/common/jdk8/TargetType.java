package zhongqiu.common.jdk8;

//Ŀ������
//���ڸ����� lambda ���ʽ�����������������������Ƶ�����
//�����Զ��Ƶ�
public class TargetType {

	// ����Ŀ�����ͣ�����ʽ�ӿڣ��Ѿ���֪���� lambda ���ʽ����ʽ������Formal
	// parameter�����ͣ���������û�б�Ҫ����֪�������ظ�һ�顣Ҳ����˵��lambda ���ʽ�Ĳ������Ϳ��Դ�Ŀ�������еó���
	// Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2);
	// �����������������������Ƶ��� s1 �� s2 �������� String�����⣬�� lambda
	// �Ĳ���ֻ��һ�������������Ϳ��Ա��Ƶ���֪ʱ���ò����б���������ſ��Ա�ʡ�ԣ�
	//
	// FileFilter java = f -> f.getName().endsWith(".java");
	// button.addActionListener(e -> ui.dazzle(e.getModifiers()));
	// ��Щ�Ľ���һ��չʾ�����ǵ����Ŀ�꣺����Ҫ�Ѹ߶�����ת���ɿ�����⡣������ϣ���﷨Ԫ���ܹ������ܵ��٣��Ա����Ķ����ܹ�ֱ�� lambda
	// ���ʽ�ĺ��Ĳ��֡�
	//
	// lambda ���ʽ�����ǵ�һ��ӵ��������������͵� Java ���ʽ�����ͷ������ú͡����Ρ�����������Ҳͨ��Ŀ�����������������Ƶ���
	// List<String> ls = Collections.emptyList();
	// List<Integer> li =Collections.emptyList(); Map<String, Integer> m1 = new
	// HashMap<>();
	// Map<Integer, String> m2 = new HashMap<>();

}