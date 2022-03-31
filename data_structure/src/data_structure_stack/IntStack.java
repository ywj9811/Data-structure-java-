package data_structure_stack;

public class IntStack {
	private int max; //���� �뷮
	private int ptr; //���� ������
	private int[] stk; //���� ��ü
	
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException { //push ���� ���� á���� ����ó��
		if (ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	public int pop() throws EmptyIntStackException { //pop ���� ������� ����ó��
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	public int peek() throws EmptyIntStackException { //peek ������ ���� Ȯ�� pop�� �������� ����ó��
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr-1];
	}
	
	public int indexOf(int x) { //�ش� index�� ���� ��ȯ��.
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == x) 
				return i;
		}
		return -1;
	}
	
	public void clear() {
		ptr = 0; //ptr�� �������� �����̱� ������ ptr�� 0���� ������ָ� ������ ���°Ͱ� ��������.
	}
	
	public int capacity() {
		return max; //�뷮�� ����
	}
	
	public int size() {
		return ptr; //���� ����ִ� ������ ũ�⸦ ��ȯ
	}
	
	public boolean isEmpty() {
		return ptr <= 0; //ptr�� ���� ���ذ����� 0�̸� ����ִ� ������ 0���� ũ�ٸ� ������� �ʾƼ� false����
	}
	
	public boolean isFull() {
		return ptr >= max; //����ִ��� Ȯ�ΰ� ���������� max�� ������ ������.
	}
	
	public void dump() { //������ ��� �����͸� �ٴڿ��� ����� ������ �����.(����)
		if(ptr <= 0) 
			System.out.println("������ ��� �ֽ��ϴ�.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}