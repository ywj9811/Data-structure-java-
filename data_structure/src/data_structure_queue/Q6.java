package data_structure_queue;

public class Q6<E> {
	private int max;
	private int front;
	private int rear;
	private int num;
	private E [] que; //큐 본체
	
	public static class EmptyQ6Exception extends RuntimeException{
		public EmptyQ6Exception() {} //큐가 비었을때 예외.
	}
	
	public static class OverQ6Exception extends RuntimeException{
		public OverQ6Exception() {}
	}
	
	public Q6(int capacity) { //생성자!
		max = capacity;
		num = front = rear = 0; //시작은 front와 rear모두 0
		try {
			que =(E[]) new Object[max];
		} catch(OutOfMemoryError e) {
			max = 0; //생성할 수 없음
		}
	}
	
	public E enque(E x) throws OverQ6Exception { //큐에 데이터를 인큐
		if(num >= max)
			throw new OverQ6Exception(); //예외를 강제로 실행시킴
		que[rear++] = x; //x를 인큐하고 선입선출이니 rear을 +1함.
		num++;
		if(rear == max)
			rear = 0;
		
		return x; 
	}
	
	public E deque() throws EmptyQ6Exception {
		if(num <= 0)
			throw new EmptyQ6Exception();
		E x = que[front++];
		num--;
		if(front == max) //front증가시키니 max와 같아지면 0으로 초기화
			front = 0;
		
		return x;
	}
	
	public E peek() throws EmptyQ6Exception {
		if(num <= 0)
			throw new EmptyQ6Exception();
		return que[front]; //맨앞에 위치한 값을 확인함.
	} //peak은 그저 확인하는 것이기 때문에 아무것도 변동이 없다.
	
	public int indexOf(E x) { //x를 찾는 메소드
		for(int i = 0; i < num; i++) { //num은 현재 데이터의 수
			int idx = (i + front)%max; //이렇게 해야 현재 데이터가 존재하는 인덱스만 확인할 수 있다.
			if(que[idx] == x)
				return idx;
		}
		return -1; //for문을 다 돌았는데 return하지 못했으면 해당하는 인덱스를 찾지 못한것으로 -1 리턴
	}
	
	public void clear() {
		front = rear = num = 0; //모두 0으로 초기화하면 기준이 모두 0이 되므로 clear가 된다.
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public void dump() {
		if(num <= 0)
			throw new EmptyQ6Exception();
		else {
			for(int i = 0; i < num; i++)
				System.out.print(que[(i + front)%max] + " "); //(i+front)%max하면 현재 front의 인덱스 값이 나오게 된다. 그냥 i만 하면 0~num이라서 안됨.
			System.out.println();
		}
	}
	
	public int search(E x) {
		for(int i = 0; i < num; i++) { //num은 현재 데이터의 수
			int idx = (i + front)%max; //이렇게 해야 현재 데이터가 존재하는 인덱스만 확인할 수 있다.
			if(que[idx].equals(x)) {
				if(idx >= front)
					return idx - front + 1;
				else {
					idx = rear + max;
					return (idx - front + 1);
				}
			}
		}
		return 0;
	}
}
