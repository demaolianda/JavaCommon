package zhongqiu.common.jdk5.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//��������:10����ȥ����,�涨�ﵽһ���ص����ܼ���ǰ��.
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		int num = 10;
		CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("go on together!");
			}
		});
		for (int i = 1; i <= num; i++) {
			new Thread(new CyclicBarrierWorker(i, barrier)).start();
		}
	}
}

class CyclicBarrierWorker implements Runnable {
	private int id;
	private CyclicBarrier barrier;

	public CyclicBarrierWorker(int id, final CyclicBarrier barrier) {
		this.id = id;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(id + " th people wait");
			barrier.await(); // ��ҵȴ����һ���̵߳���
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
