package zhongqiu.common.jdk5;

import java.util.Scanner;

//scanner�࣬������ȡ�û�������
public class ScannerDemo {
	public static void main(String[] args) {
		next();
		nextLine();
		scannerDemo1();
		scannerDemo2();
	}

	// next() �� nextLine() ����
	// next():
	// 1��һ��Ҫ��ȡ����Ч�ַ���ſ��Խ������롣
	// 2����������Ч�ַ�֮ǰ�����Ŀհף�next() �������Զ�����ȥ����
	// 3��ֻ��������Ч�ַ���Ž����������Ŀհ���Ϊ�ָ������߽����������ܵõ����пո���ַ�����
	// nextLine()��
	// 1����EnterΪ������,Ҳ����˵nextLine()�������ص�������س�֮ǰ�������ַ���
	// 2�����Ի�ÿհס�

	public static void next() {
		Scanner scan = new Scanner(System.in);
		// �Ӽ��̽�������

		// next��ʽ�����ַ���
		System.out.println("next��ʽ���գ�");
		// �ж��Ƿ�������
		if (scan.hasNext()) {
			String str1 = scan.next();
			System.out.println("���������Ϊ��" + str1);
		}
	}

	public static void nextLine() {
		Scanner scan = new Scanner(System.in);
		// �Ӽ��̽�������

		// nextLine��ʽ�����ַ���
		System.out.println("nextLine��ʽ���գ�");
		// �ж��Ƿ�������
		if (scan.hasNextLine()) {
			String str2 = scan.nextLine();
			System.out.println("���������Ϊ��" + str2);
		}
	}

	// ���Ҫ���� int �� float ���͵����ݣ��� Scanner ����Ҳ��֧�֣�����������֮ǰ�����ʹ�� hasNextXxx()
	// ����������֤����ʹ�� nextXxx() ����ȡ��
	public static void scannerDemo1() {
		Scanner scan = new Scanner(System.in);
		// �Ӽ��̽�������
		int i = 0;
		float f = 0.0f;
		System.out.print("����������");
		if (scan.hasNextInt()) {
			// �ж�������Ƿ�������
			i = scan.nextInt();
			// ��������
			System.out.println("�������ݣ�" + i);
		} else {
			// ����������Ϣ
			System.out.println("����Ĳ���������");
		}
		System.out.print("����С����");
		if (scan.hasNextFloat()) {
			// �ж�������Ƿ���С��
			f = scan.nextFloat();
			// ����С��
			System.out.println("С�����ݣ�" + f);
		} else {
			// ����������Ϣ
			System.out.println("����Ĳ���С����");
		}
	}

	// ���ǿ������������֣��������ܺ���ƽ������ÿ����һ�������ûس�ȷ�ϣ�ͨ��������������������벢���ִ�н��
	public static void scannerDemo2() {
		Scanner scan = new Scanner(System.in);

		double sum = 0;
		int m = 0;
		System.out.println("����������ƽ������������ֽ�����");
		while (scan.hasNextDouble()) {
			double x = scan.nextDouble();
			m = m + 1;
			sum = sum + x;
		}

		System.out.println(m + "�����ĺ�Ϊ" + sum);
		System.out.println(m + "������ƽ��ֵ��" + (sum / m));
	}
}
