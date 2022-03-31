package data_structure_queue;

public class Q6<E> {
	private int max;
	private int front;
	private int rear;
	private int num;
	private E [] que; //ť ��ü
	
	public static class EmptyQ6Exception extends RuntimeException{
		public EmptyQ6Exception() {} //ť�� ������� ����.
	}
	
	public static class OverQ6Exception extends RuntimeException{
		public OverQ6Exception() {}
	}
	
	public Q6(int capacity) { //������!
		max = capacity;
		num = front = rear = 0; //������ front�� rear��� 0
		try {
			que =(E[]) new Object[max];
		} catch(OutOfMemoryError e) {
			max = 0; //������ �� ����
		}
	}
	
	public E enque(E x) throws OverQ6Exception { //ť�� �����͸� ��ť
		if(num >= max)
			throw new OverQ6Exception(); //���ܸ� ������ �����Ŵ
		que[rear++] = x; //x�� ��ť�ϰ� ���Լ����̴� rear�� +1��.
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
		if(front == max) //front������Ű�� max�� �������� 0���� �ʱ�ȭ
			front = 0;
		
		return x;
	}
	
	public E peek() throws EmptyQ6Exception {
		if(num <= 0)
			throw new EmptyQ6Exception();
		return que[front]; //�Ǿտ� ��ġ�� ���� Ȯ����.
	} //peak�� ���� Ȯ���ϴ� ���̱� ������ �ƹ��͵� ������ ����.
	
	public int indexOf(E x) { //x�� ã�� �޼ҵ�
		for(int i = 0; i < num; i++) { //num�� ���� �������� ��
			int idx = (i + front)%max; //�̷��� �ؾ� ���� �����Ͱ� �����ϴ� �ε����� Ȯ���� �� �ִ�.
			if(que[idx] == x)
				return idx;
		}
		return -1; //for���� �� ���Ҵµ� return���� �������� �ش��ϴ� �ε����� ã�� ���Ѱ����� -1 ����
	}
	
	public void clear() {
		front = rear = num = 0; //��� 0���� �ʱ�ȭ�ϸ� ������ ��� 0�� �ǹǷ� clear�� �ȴ�.
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
				System.out.print(que[(i + front)%max] + " "); //(i+front)%max�ϸ� ���� front�� �ε��� ���� ������ �ȴ�. �׳� i�� �ϸ� 0~num�̶� �ȵ�.
			System.out.println();
		}
	}
	
	public int search(E x) {
		for(int i = 0; i < num; i++) { //num�� ���� �������� ��
			int idx = (i + front)%max; //�̷��� �ؾ� ���� �����Ͱ� �����ϴ� �ε����� Ȯ���� �� �ִ�.
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
