package data_structure_queue;

public class IntQueue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que; //ť ��ü
	
	public static class EmptyIntQueException extends RuntimeException{
		public EmptyIntQueException() {} //ť�� ������� ����.
	}
	
	public static class OverflowQueException extends RuntimeException{
		public OverflowQueException() {}
	}
	
	public IntQueue(int capacity) { //������!
		max = capacity;
		num = front = rear = 0; //������ front�� rear��� 0
		try {
			que = new int[max];
		} catch(OutOfMemoryError e) {
			max = 0; //������ �� ����
		}
	}
	
	public int enque(int x) throws OverflowQueException { //ť�� �����͸� ��ť
		if(num >= max)
			throw new OverflowQueException();
		que[rear++] = x; //x�� ��ť�ϰ� ���Լ����̴� rear�� +1��.
		num++;
		if(rear == max)
			rear = 0;
		
		return x; 
	}
	
	public int deque() throws EmptyIntQueException {
		if(num <= 0)
			throw new EmptyIntQueException();
		int x = que[front++];
		num--;
		if(front == max) //front������Ű�� max�� �������� 0���� �ʱ�ȭ
			front = 0;
		
		return x;
	}
	
	public int peek() throws EmptyIntQueException {
		if(num <= 0)
			throw new EmptyIntQueException();
		return que[front]; //�Ǿտ� ��ġ�� ���� Ȯ����.
	} //peak�� ���� Ȯ���ϴ� ���̱� ������ �ƹ��͵� ������ ����.
	
	public int indexOf(int x) { //x�� ã�� �޼ҵ�
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
			throw new EmptyIntQueException();
		else {
			for(int i = 0; i < num; i++)
				System.out.print(que[(i + front)%max] + " "); //(i+front)%max�ϸ� ���� front�� �ε��� ���� ������ �ȴ�. �׳� i�� �ϸ� 0~num�̶� �ȵ�.
			System.out.println();
		}
	}
	
	public int search(int x) {
		for(int i = 0; i < num; i++) { //num�� ���� �������� ��
			int idx = (i + front)%max; //�̷��� �ؾ� ���� �����Ͱ� �����ϴ� �ε����� Ȯ���� �� �ִ�.
			if(que[idx] == x) {
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
