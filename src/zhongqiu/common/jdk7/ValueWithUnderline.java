package zhongqiu.common.jdk7;

//��ֵ�ɼ��»���
//�ܳ������ֿɶ��Բ��ã���Java 7�п���ʹ���»��߷ָ���int�Լ�long��
public class ValueWithUnderline {
	public static void main(String[] args) {
		 int one_million = 1_000_000; 
		 System.out.println(one_million);
		 int i=1_1 * 10;
		 System.out.println(i);
		 int j=120 - 1_________________0;
		 System.out.println(j);
	}
}
