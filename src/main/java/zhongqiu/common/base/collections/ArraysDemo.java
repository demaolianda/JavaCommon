package zhongqiu.common.base.collections;

import java.util.Arrays;
import java.util.List;

//Arrays�����
public class ArraysDemo {
	public static void main(String[] args) {
		byte[] test1 = { 23, 34 };

		byte[] test2 = { 23, 34 };

		int[] test3 = { 4, 5, 6, 7 };

		// ���ݵڶ���������Ϊ�����ҳ���Ӧ���±꣬���ַ������㷨
		System.out.println(Arrays.binarySearch(test3, 7));

		// toString����
		System.out.println(test1.toString());
		System.out.println(Arrays.toString(test1));// ��дTostring����

		// Equals����
		System.out.println(test1.equals(test2));
		System.out.println(Arrays.equals(test1, test2));// ��д��Equals����
		System.out.println(test1 == test2);
		System.out.println(test1.getClass());
		// fill����
		// ��ָ���� byte ֵ�����ָ��byte������ָ����Χ�е�ÿ��Ԫ�ء�
		Arrays.fill(test1, 0, 1, (byte) 56);
		System.out.println(Arrays.toString(test1));

		// hashCode����
		System.out.println(test1.hashCode());
		System.out.println(Arrays.hashCode(test1));// ����ָ����������ݷ��ع�ϣ��

		// aslist
		List list = Arrays.asList(test1);
		
	}

}
