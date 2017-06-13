package zhongqiu.common.base.collections;

//�������
public class ArrayDemo {
	public static int[] intArray={1,2,3,4}; // ��ѡ�ķ���

	// public static int doubleArray2[]; Ч����ͬ����������ѡ����������c/c++��д��

	public static void main(String[] args) {
		initArray();
		printArray(intArray);
		intArray = reverse(intArray);
		printArray(intArray);
	}

	// ��������
	public static void initArray() {
		int[] intArray1 = new int[10];
		int[] intArray2={1,2,3,4};
	}

	// ������Ϊ�����Ĳ���
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	// ������Ϊ�����ķ���ֵ
	public static int[] reverse(int[] list) {
		int[] result = new int[list.length];

		for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
			result[j] = list[i];
		}
		return result;
	}

}
