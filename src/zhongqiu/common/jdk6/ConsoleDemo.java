package zhongqiu.common.jdk6;

import java.io.Console;

//��Console��������̨���� 
/*���������һ��IDE����eclipse, netbeans�������㽫�õ���
No Console!
��Ϊֻ�����������в��ܵõ�Console����*/
public class ConsoleDemo {
	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			String user = new String(console.readLine("Enter User:", new Object[0]));
			String pwd = new String(console.readPassword("Enter Password:", new Object[0]));
			console.printf("User name is:%s", new Object[] { user });
			console.printf("Password is:%s", new Object[] { pwd });
		} else {
			System.out.println("No Console!");
		}
	}
}
