package zhongqiu.common.base.thread;

//����������
// ���������̣߳�A�̴߳�ӡ10��A��B�̴߳�ӡ10��B,C�̴߳�ӡ10��C��Ҫ���߳�ͬʱ���У������ӡ10��ABC��
// ��Ҫ����obj.wait()��obj.notify() ���÷�
public class PrintABC extends Thread {
	public static void main(String[] args) throws InterruptedException {
		// ����������
		SYNPo a = new SYNPo("a");
		SYNPo b = new SYNPo("b");
		SYNPo c = new SYNPo("c");
		PrintABC pa = new PrintABC("A", c, a);
		PrintABC pb = new PrintABC("B", a, b);
		PrintABC pc = new PrintABC("C", b, c);
		new Thread(pa).start();
		Thread.sleep(100); // ȷ����˳��A��B��Cִ��
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
	}

	private String name;
	private SYNPo prev;
	private SYNPo self;

	private PrintABC(String name, SYNPo prev, SYNPo self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			// System.out.println("�߳�" + name + "�����ö���" + prev.getName() +
			// "����");
			synchronized (prev) {
				// System.out.println("�߳�" + name + "����˶���" + prev.getName() +
				// "����");
				// System.out.println("�߳�" + name + "�����ö���" + self.getName() +
				// "����");
				synchronized (self) {
					// System.out.println("�߳�" + name + "����˶���" + self.getName()
					// + "����");
					System.out.println(name);
					count--;

					// notify()���ú󣬲��������Ͼ��ͷŶ������ģ���������Ӧ��synchronized(){}����ִ�н�����
					// �Զ��ͷ�����,JVM����wait()���������߳������ѡȡһ�̣߳�������������������̣߳�����ִ�С�
					self.notify();
					// System.out.println("����" + self.getName() +
					// "��������˵ȴ��Ľ���" + "�����Ѳ���!!!��");
				}
				// System.out.println("�߳�" + name + "�ͷ��˶���" + self.getName() +
				// "����");
				try {
					// Thread.sleep()��Object.wait()���߶�������ͣ��ǰ�̣߳��ͷ�CPU����Ȩ��
					// ��Ҫ����������Object.wait()���ͷ�CPUͬʱ���ͷ��˶������Ŀ��ơ�
					// System.out.println("�߳�" + name + "�ͷ��˶���" + prev.getName()
					// + "����");
					// System.out.println("�߳�" + name + "��������״̬���ȴ���ȡ" +
					// prev.getName() + "����" + "���ȴ��С�������");
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static class SYNPo {
		public SYNPo(String name) {
			setName(name);
		}

		public String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
