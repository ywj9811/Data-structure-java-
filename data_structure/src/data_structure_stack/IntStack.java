package data_structure_stack;

public class IntStack {
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
	
	public int indexOf(int x) { //해당 index의 값을 반환함.
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == x) 
				return i;
		}
		return -1;
	}
	
	public void clear() {
		ptr = 0; //ptr을 기준으로 움직이기 때문에 ptr을 0으로 만들어주면 스택을 비우는것과 마찬가지.
	}
	
	public int capacity() {
		return max; //용량을 리턴
	}
	
	public int size() {
		return ptr; //값이 들어있는 스택의 크기를 반환
	}
	
	public boolean isEmpty() {
		return ptr <= 0; //ptr이 현재 기준값으로 0이면 비어있는 것으로 0보다 크다면 비어있지 않아서 false리턴
	}
	
	public boolean isFull() {
		return ptr >= max; //비어있는지 확인과 마찬가지로 max와 같으면 꽉찬겨.
	}
	
	public void dump() { //스택의 모든 데이터를 바닥에서 꼭대기 순으로 출력함.(역순)
		if(ptr <= 0) 
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}