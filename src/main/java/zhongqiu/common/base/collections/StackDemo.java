package zhongqiu.common.base.collections;

import java.util.Stack;

//ջ��Vector������
public class StackDemo {
	// ��Ԫ�ط���ջ��
	static void showpush(Stack st, int a) {
		st.push(new Integer(a));
		System.out.println("push(" + a + ")");
		System.out.println("stack: " + st);
	}

	// ��ջ��ɾ��Ԫ��
	static void showpop(Stack st) {
		System.out.print("pop -> ");
		// �ж�ջ�Ƿ�Ϊ��
		if (st.empty()) {
			System.out.println("Stack is empty.");
		} else {
			Integer a = (Integer) st.pop();
			System.out.println(a);
			System.out.println("stack: " + st);
		}
	}

	// �鿴ջ��Ԫ��
	static void showpeek(Stack st) {
		System.out.print("peek -> ");
		if (st.empty()) {
			System.out.println("Stack is empty.");
		} else {
			Integer a = (Integer) st.peek();
			System.out.println(a);
			System.out.println("stack: " + st);
		}
	}

	// ��ѯָ��Ԫ��
	static void showsearch(Stack st, int i) {
		System.out.print("search -> " + i);
		Integer index = (Integer) st.search(i);
		System.out.println("--index -> " + index);
		System.out.println("stack: " + st);
	}

	public static void main(String args[]) {
		Stack st = new Stack();
		System.out.println("stack: " + st);
		showpush(st, 42);
		showpush(st, 66);
		showpeek(st);
		showsearch(st, 66);
		showsearch(st, 88);
		showpop(st);
		showpop(st);
		showpop(st);
	}
}
