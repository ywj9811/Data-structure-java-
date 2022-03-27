package data_structure_stack;


import java.util.Scanner;

class IntStack {
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
}

public class Stack_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64); //64���� ���� �� �ִ� stack
	}
}