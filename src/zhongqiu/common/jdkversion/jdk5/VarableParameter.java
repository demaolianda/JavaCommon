package zhongqiu.common.jdkversion.jdk5;

//�ɱ����
/*�ɱ�������ص㣺
1��ֻ�ܳ����ڲ����б����� 
2��...λ�ڱ������ͺͱ�����֮�䣬ǰ�����޿ո񶼿��ԣ�
3�����ÿɱ�����ķ���ʱ��������Ϊ�ÿɱ������������һ�����飬�ڷ�������һ�������ʽ���ʿɱ������*/
public class VarableParameter {
	public static void main(String[] args) {
		System.out.println(add(2));
		System.out.println(add(2, 3));
		System.out.println(add(2, 3, 5));
	}

	public static int add(int x, int... args) {
		int sum = x;
		/*
		 * ��forѭ����ʽ�� for(int i=0;i<args.length;i++){ sum += args[i]; }
		 */

		// foreachѭ����ʽ
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}
}
