package zhongqiu.common.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//��(Stream)���ļ�(File)��IO
//http://www.runoob.com/java/java-files-io.html
public class FileIODemo {
	public static void main(String[] args) {
		// BRRead();
		// BRReadLine();
		// Write();

		mkdirs();
		fileStream();
		dirList("mkdirs");
	}

	// ��ȡ������ַ�
	public static void BRRead() {
		char c = 0;
		// ʹ�� System.in ���� BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����ַ�, ���� 'q' ���˳���");
		// ��ȡ�ַ�
		do {
			try {
				c = (char) br.read();
				System.out.println("��������ַ��ǣ�" + c);
			} catch (IOException e) {
				System.out.println("��ȡ��������ʧ��");
			}
		} while (c != 'q');
	}

	// ��ȡ������ַ���
	public static void BRReadLine() {
		// ʹ�� System.in ���� BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'end' to quit.");
		do {
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��������ǣ�" + str);
		} while (!str.equals("end"));
	}

	// ����̨���
	public static void Write() {
		char b;
		b = 'A';
		System.out.write(b);
		System.out.write('\n');
		System.out.println("�ڶ����������");
	}

	// Ŀ¼����
	// mkdir()��������һ���ļ��У��ɹ��򷵻�true��ʧ���򷵻�false��ʧ�ܱ���File����ָ����·���Ѿ����ڣ�������������·���������ڣ����ļ��в��ܱ�������
	// mkdirs()��������һ���ļ��к��������и��ļ��С�
	public static void mkdirs() {
		String dirname = "mkdirs/test";
		File d = new File(dirname);
		// ���ڴ���Ŀ¼
		d.mkdirs();
		System.out.println("�ɹ�");
	}

	// �ļ�����
	public static void fileStream() {
		try {
			File f = new File("mkdirs/test/filetest.txt");
			FileOutputStream fop = new FileOutputStream(f);
			// ����FileOutputStream����,�ļ������ڻ��Զ��½�

			OutputStreamWriter writer = new OutputStreamWriter(fop, "gbk");
			// ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk

			writer.append("��������");
			// д�뵽������

			writer.append("\r\n");
			// ����

			writer.append("English");
			// ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��

			writer.close();
			// �ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�

			fop.close();
			// �ر������,�ͷ�ϵͳ��Դ

			FileInputStream fip = new FileInputStream(f);
			// ����FileInputStream����

			InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
			// ����InputStreamReader����,������д����ͬ

			StringBuffer sb = new StringBuffer();
			while (reader.ready()) {
				sb.append((char) reader.read());
				// ת��char�ӵ�StringBuffer������
			}
			System.out.println(sb.toString());
			reader.close();
			// �رն�ȡ��

			fip.close();
			// �ر�������,�ͷ�ϵͳ��Դ
		} catch (Exception e) {
		}
	}

	//��ȡĿ¼�µ�������Ŀ¼���ļ�
	public static void dirList(String dirName) {
		File f1 = new File(dirName);
		if (f1.isDirectory()) {
			System.out.println("Ŀ¼��" + dirName);
			String s[] = f1.list();
			for (int i = 0; i < s.length; i++) {
				dirList(dirName + "/" + s[i]);
			}
		} else {
			System.out.println("�ļ���" + dirName);
		}
	}
}
