package data_structure_stack;

public class Q2<E>{
	private int max; //���� �뷮
	private int ptr; //���� ������
	private E[] stk; //���� ��ü
	
	static public class EmptyQ2Exception extends RuntimeException {
		public EmptyQ2Exception() {}
	}
	
	static public class OverflowQ2Exception extends RuntimeException {
		public OverflowQ2Exception() {}
	}

	public Q2(int capacity) { //������
		ptr = 0;
		max = capacity;
		try {
			stk = (E[])new Object[max]; //�迭�� ������ �� ���׸� Ŭ������ ��� Object�� �����ϵ� 
										//(E[])�� ���� ����ȯ�� �ʿ��ϴ�
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
//	public Object push(E x){ //push ���� ���� á���� ����ó��
//		if (ptr >= max)
//			return null;
//		return stk[ptr++] = x;
//	}

	public E push(E x) throws OverflowQ2Exception {
		if (ptr >= max) // ������ ���� ��
			throw new OverflowQ2Exception();
		return stk[ptr++] = x;
	}
	
//	public Object pop(){ //pop ���� ������� ����ó��
//		if(ptr <= 0) {
//			System.out.println("������ �����");
//			return null ;
//		}
//		return stk[--ptr];
//	}
	
	public E pop() throws EmptyQ2Exception {
		if (ptr <= 0) // ������ ��� ����
			throw new EmptyQ2Exception();
		return stk[--ptr];
	}
	
	public E peek() throws EmptyQ2Exception{ //peek ������ ���� Ȯ�� pop�� �������� ����ó��
		if(ptr <= 0) {
			throw new EmptyQ2Exception();
		}
		return stk[ptr-1];
	}
	
	public int size() {
		return ptr;
	}
	
	public int capacity() {
		return max;
	}
	public void dump() {
		if(ptr < 0) {
			System.out.println("������ ������ϴ�.");
		}
		else {
			for(int i = 0; i < ptr; i++) {
				System.out.println(stk[i] + " ");
			}
			System.out.println();
		}
	}
}