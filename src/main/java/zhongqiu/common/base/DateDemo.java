package zhongqiu.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;

//Date���
//http://www.runoob.com/java/java-date-time.html
public class DateDemo {
	public static void main(String[] args) {
		simpleDateFormat();
	}

	// ʹ�� SimpleDateFormat ��ʽ������
	public static void simpleDateFormat() {
		Date dNow = new Date();
		
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Current Date: " + ft.format(dNow));
		
		SimpleDateFormat ft1 = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Current Date: " + ft1.format(dNow));
		
		SimpleDateFormat ft2 = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss");
		System.out.println("Current Date: " + ft2.format(dNow));
	}
}
