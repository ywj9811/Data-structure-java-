package data_structure_stack;


import java.util.Scanner;

class IntStack {
	private int max; //스택 용량
	private int ptr; //스택 포인터
	private int[] stk; //스택 본체
	
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
	
	public int push(int x) throws OverflowIntStackException { //push 만약 가득 찼으면 예외처리
		if (ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	public int pop() throws EmptyIntStackException { //pop 만약 비었으면 예외처리
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	public int peek() throws EmptyIntStackException { //peek 맨위의 스택 확인 pop과 마찬가지 예외처리
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr-1];
	}
}

public class Stack_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64); //64개를 가질 수 있는 stack
	}
}