package zhongqiu.common.jdk7.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveTask;

//RecursiveAction������û�з��ؽ��������
//RecursiveTask �������з��ؽ��������
//˫�˶��У�������ȡ����дcompute����
//���ڿɺܺ÷ֽ��������ĳ���
public class ForkJoinTaskDemo {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 1; i < 10; i++) {
			count = count + i;
			Thread.sleep(1000);
		}
		System.out.println(count);
		long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 " + (startTime - endTime) + "ms");

		long startTime1 = System.currentTimeMillis();
		CountTask countTask = new CountTask(1, 10);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Integer> futureTask = forkJoinPool.submit(countTask);
		try {
			System.out.println(futureTask.get());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime1 = System.currentTimeMillis(); // ��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 " + (startTime1 - endTime1) + "ms");

	}
}

// RecursiveTask�÷���ͳ��1+2+3+....
class CountTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 2;
	private Integer start;
	private Integer end;

	public CountTask(Integer start, Integer end) {
		this.setStart(start);
		this.setEnd(end);
	}

	@Override
	protected Integer compute() {
		int count = 0;
		if (start - end <= THRESHOLD) {
			for (int i = start; i < end; i++) {
				count += i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			int middle = (end + start) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			leftTask.fork();
			rightTask.fork();
			count = leftTask.join() + rightTask.join();
		}
		return count;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
}
