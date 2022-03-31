package data_structure_stack;

public class Q2<E>{
	private int max; //스택 용량
	private int ptr; //스택 포인터
	private E[] stk; //스택 본체
	
	static public class EmptyQ2Exception extends RuntimeException {
		public EmptyQ2Exception() {}
	}
	
	static public class OverflowQ2Exception extends RuntimeException {
		public OverflowQ2Exception() {}
	}

	public Q2(int capacity) { //생성자
		ptr = 0;
		max = capacity;
		try {
			stk = (E[])new Object[max]; //배열을 생성할 때 제네릭 클래스의 경우 Object로 생성하되 
										//(E[])로 강제 형변환이 필요하다
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
//	public Object push(E x){ //push 만약 가득 찼으면 예외처리
//		if (ptr >= max)
//			return null;
//		return stk[ptr++] = x;
//	}

	public E push(E x) throws OverflowQ2Exception {
		if (ptr >= max) // 스택이 가득 참
			throw new OverflowQ2Exception();
		return stk[ptr++] = x;
	}
	
//	public Object pop(){ //pop 만약 비었으면 예외처리
//		if(ptr <= 0) {
//			System.out.println("스택이 비었음");
//			return null ;
//		}
//		return stk[--ptr];
//	}
	
	public E pop() throws EmptyQ2Exception {
		if (ptr <= 0) // 스택이 비어 있음
			throw new EmptyQ2Exception();
		return stk[--ptr];
	}
	
	public E peek() throws EmptyQ2Exception{ //peek 맨위의 스택 확인 pop과 마찬가지 예외처리
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
			System.out.println("스택이 비었습니다.");
		}
		else {
			for(int i = 0; i < ptr; i++) {
				System.out.println(stk[i] + " ");
			}
			System.out.println();
		}
	}
}