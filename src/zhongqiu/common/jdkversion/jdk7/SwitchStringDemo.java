package zhongqiu.common.jdkversion.jdk7;

//switch�п���ʹ���ִ��ˡ�������������ڱ�������������ʵ�ֵ�
//һ��caseƥ��,�ͻ�˳��ִ�к���ĳ������,�����ܺ����case�Ƿ�ƥ��,ֱ������break,������һ���Կ����úü���caseִ��ͳһ���.
public class SwitchStringDemo {
	public static void main(String[] args) {
		String s = "test";
		switch (s) {
		case "test":
			System.out.println("test");
			break;
		case "a":
			System.out.println("a");
			break;
		case "test1":
			System.out.println("test1");
			break;
		default:
			System.out.println("break");
			break;
		}
	}
}
