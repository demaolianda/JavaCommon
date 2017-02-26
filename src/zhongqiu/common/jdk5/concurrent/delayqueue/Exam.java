package zhongqiu.common.jdk5.concurrent.delayqueue;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
//DelayQueue��DelayQueue ��Ԫ�ؽ��г���ֱ��һ���ض����ӳٵ��ڡ�ע�����е�Ԫ�ر���ʵ�� java.util.concurrent.Delayed �ӿڡ�
/*
 ģ��һ�����Ե����ӣ�����ʱ��Ϊ120���ӣ�30���Ӻ�ſɽ�����ʱ�䵽�ˣ���ѧ����������˿��Խ�����
��������м�������Ҫע�⣺
����ʱ��Ϊ120���ӣ�30���Ӻ�ſɽ�����ʼ����������Ծ�ʱ����СӦΪ30����
�����ܹ���120�����ڽ���Ŀ��������ʵ����Щ��������
����120������û����ɿ��ԵĿ�������120���ӿ���ʱ�䵽����Ҫ������ǿ�ƽ���
�����еĿ�������������Ҫ�������̹߳ر�
*/
public class Exam {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int studentNumber = 20;
		DelayQueue<Student> students = new DelayQueue<Student>();
		Random random = new Random();
		for (int i = 0; i < studentNumber; i++) {
			students.put(new Student("student" + (i + 1), 30 + random.nextInt(120)));
		}
		students.put(new Student("student",120));
		Thread teacherThread = new Thread(new Teacher(students));
		teacherThread.start();
	}
}

class Student implements Runnable, Delayed {

	private String name;
	public long workTime;
	private long submitTime;
	private boolean isForce = false;

	public Student() {
	}

	public Student(String name, long workTime) {
		this.name = name;
		this.workTime = workTime;
		this.submitTime = TimeUnit.NANOSECONDS.convert(workTime, TimeUnit.NANOSECONDS) + System.nanoTime();// ���뼶��
	}

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		if (o == null || !(o instanceof Student))
			return 1;
		if (o == this)
			return 0;
		Student s = (Student) o;
		if (this.workTime > s.workTime) {
			return 1;
		} else if (this.workTime == s.workTime) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(submitTime - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (isForce) {
			System.out.println(name + " ����ʵ����ʱ 120����");
		} else {
			System.out.println(name + " ����," + "ʵ����ʱ " + workTime + " ����");
		}
	}

	public boolean isForce() {
		return isForce;
	}

	public void setForce(boolean isForce) {
		this.isForce = isForce;
	}

}

class Teacher implements Runnable {
	private int counter = 20;
	private DelayQueue<Student> students;

	public Teacher(DelayQueue<Student> students) {
		this.students = students;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(" test start");
			while (counter > 0) {
				Student student = students.poll();
				if (student.workTime<120) {
					student.run();
					if (counter > 0) {
						counter--;
					}
				} else {
					System.out.println(" ����ʱ�䵽��ȫ������");
					Student tmpStudent;
					for (Iterator<Student> iterator2 = students.iterator(); iterator2.hasNext();) {
						tmpStudent = iterator2.next();
						tmpStudent.setForce(true);
						tmpStudent.run();
						if (counter > 0) {
							counter--;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
