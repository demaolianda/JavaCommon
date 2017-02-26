package zhongqiu.common.jdk5;

//ö��
/*1��switch��ö���÷�
2��ö�ٵ��Զ��巽��
3��ö��ʵ�ֽӿ�
4��ö�ټ��ϵ�ʹ�á�java.util.EnumSet��java.util.EnumMap������ö�ټ��ϡ�
  EnumSet��֤�����е�Ԫ�ز��ظ���EnumMap�е�key��enum���ͣ���value��������������͡�*/
public class EnumDemo {
	public static void main(String[] args) {
		EnumSwitch();
	}

	public enum Color {
		RED, GREEN, BLANK, YELLOW
	}

	// �Զ���ö��
	public enum ColorExt {
		RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLOW("��ɫ", 4);
		// ��Ա����
		private String name;
		private int index;

		// ���췽��
		private ColorExt(String name, int index) {
			this.name = name;
			this.index = index;
		}

		// ��ͨ����
		public static String getName(int index) {
			for (ColorExt c : ColorExt.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		// ���Ƿ���
		@Override
		public String toString() {
			return this.index + "_" + this.name;
		}

		// get set ����
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}

	// ö�ٵ�switch�÷�
	public static void EnumSwitch() {
		Color color = Color.RED;
		System.out.println(color);
		switch (color) {
		case RED:
			color = Color.GREEN;
			System.out.println(color);
			break;
		case YELLOW:
			color = Color.RED;
			System.out.println(color);
			break;
		case GREEN:
			color = Color.YELLOW;
			System.out.println(color);
			break;
		}
	}

	// ö��ʵ�ֽӿ�
	public interface Behaviour {
		void print();

		String getInfo();
	}

	public enum ColorImpl implements Behaviour {
		RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLOW("��ɫ", 4);
		// ��Ա����
		private String name;
		private int index;

		// ���췽��
		private ColorImpl(String name, int index) {
			this.name = name;
			this.index = index;
		}

		// �ӿڷ���
		@Override
		public String getInfo() {
			return this.name;
		}

		// �ӿڷ���
		@Override
		public void print() {
			System.out.println(this.index + ":" + this.name);
		}
	}
}
