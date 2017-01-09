package zhongqiu.common.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//�������
//http://www.runoob.com/java/java-regular-expressions.html
public class RegexDemo {
	public static void main(String[] args) {
		match();
		replace();
	}

	public static void match() {
		// ��ָ��ģʽ���ַ�������
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";

		// ���� Pattern ����
		Pattern r = Pattern.compile(pattern);

		// ���ڴ��� matcher ����
		Matcher m = r.matcher(line);
		if (m.groupCount() > 0) {
			System.out.println(m.groupCount());
			for (int i = 0; i < m.groupCount(); i++) {
				System.out.println("Found value: " + m.group(i));
			}
		} else {
			System.out.println("NO MATCH");
		}
	}

	public static void replace() {
		String REGEX = "dog";
		String INPUT = "The dog says meow. " + "All dogs say meow.";

		// ȫ���滻
		System.out.println(Pattern.compile(REGEX).matcher(INPUT).replaceAll("cat"));

		// �滻��һ��
		System.out.println(Pattern.compile(REGEX).matcher(INPUT).replaceFirst("cat"));

	}

}
