package zhongqiu.common.base;

//�ڲ���
//http://www.cnblogs.com/wangzhongqiu/p/6574019.html
public class InnerClassDemo {
	public static void main(String[] args) {
		// �����ڲ���
		// �ڲ����еı���������ʽ
		Out1.In in = new Out1().new In();
		in.print();

		// ��̬�ڲ���
		Out2.In in2 = new Out2.In();

		// ˽���ڲ���
		Out3 out3 = new Out3();
		out3.outPrint();

		// �ֲ��ڲ���
		Out4 out4 = new Out4();
		out4.Print(5);
		
		// �����ڲ���
		out5 out5=new out5();
		out5.print();
	}
}

// �����ڲ���
// �ڲ����еı���������ʽ
class Out1 {
	private int age = 12;

	// �ڲ���
	class In {
		private int age = 13;

		public void print() {
			int age = 14;
			System.out.println("�ֲ�������" + age);
			System.out.println("�ڲ��������" + this.age);
			System.out.println("�ⲿ�������" + Out1.this.age);
		}
	}
}

// ��̬�ڲ���
class Out2 {
	private static int age = 12;
	private int normalage = 13;

	static class In {
		public void print() {
			System.out.println(age);
			// ��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա����
			// System.out.println(normalage);
		}
	}
}

// ˽���ڲ���
class Out3 {
	private int age = 12;

	private class In {
		public void print() {
			System.out.println(age);
		}
	}

	public void outPrint() {
		new In().print();
	}
}

// �ֲ��ڲ���
class Out4 {
	private int age = 12;

	public void Print(final int x) {
		class In {
			public void inPrint() {
				System.out.println(x);
				System.out.println(age);
			}
		}
		new In().inPrint();
	}
}

// �����ڲ���
class out5 {
	public void print() {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 5; i++) {
					System.out.print(i + " ");
				}
			}
		}).start();
	}
}