package list;

import java.util.Comparator;

public class AryLinkedList<E> {
	
	class Node<E>{
		private E data;
		private int next;
		private int dnext;
		
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E>[] n; //����Ʈ ��ü
	private int tail;
	private int size;
	private int max;
	private int head;
	private int crnt;
	private int deleted; //free����Ʈ�� �Ӹ����
	private static final int NULL = -1; //������尡 ����, ����Ʈ�� ���� ��
	
	public AryLinkedList(int capacity) {
		head = tail =  crnt = max = deleted = NULL; //�ʱ�ȭ��
		try {
			n = new Node[capacity]; //����Ʈ ������. �뷮�� capacity
			for (int i = 0; i < capacity; i++) {
				n[i] = new Node<E>();
			}
		} catch(OutOfMemoryError e) {
			size = 0;
		}
	}
	
	private int getInsertIndex() {
		if(deleted == NULL) {
			if(max < size)
				return ++max; //free����Ʈ�� ����ٸ� �迭�� �ǵڿ� �߰���
			else
				return NULL; //����
		}
		else {
			int rec = deleted; //free����Ʈ�� �Ӹ����
			deleted = n[rec].dnext; //free����Ʈ�� �Ӹ���带 ������
			return rec;
		}			
	}
	
	private void deleteIndex(int idx) {
		if(deleted == NULL) {
			deleted = idx;
			n[idx].dnext = NULL; //free����Ʈ�� ����ٸ� �Ӹ���带 �߰���. �Ӹ���常 ����
		}
		else {
			int rec = deleted;
			deleted = idx;
			n[idx].dnext = rec; //free����Ʈ�� �Ӹ���带 �ְ� ������ �Ӹ���带 ������
		}
	}
	
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;
		//���� ��ĵ���� ���
		
		while(ptr != NULL) {
			if(c.compare(obj, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data; //�˻� ����
			}
			
			ptr = n[ptr].next; //������� Ȯ��
		}
		
		return null; //�˻� ����
	}
	
	public void addFirst(E o) {
		boolean empty = (tail == NULL);
		int ptr = head; // ���� ���� �Ӹ����
		int rec = getInsertIndex();
		if (rec != NULL) {
			head = crnt = rec; // �ε��� rec�� record�� ����
			n[head].set(o, ptr);
			if (empty)
				tail = crnt;
		}
	}
	
	// ������ ��带 ����
	public void addLast(E o) {
		if (head == NULL) // ����Ʈ�� ���������
			addFirst(o); // �Ӹ��� ����
		else {
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[tail].next = crnt = rec;
				n[rec].set(o, NULL);
				tail = rec;
			}
		}
	}

	// �Ӹ���带 ����
	public void removeFirst() {
		if (head != NULL) { // ����Ʈ�� ��� ���� ������
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
			if (head == NULL)
				tail = NULL;
		}
	}

	// ������带 ����
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL) // ��尡 �ϳ��� ������
				removeFirst(); // �Ӹ���带 ����
			else {
				int ptr = head; // ��ĵ���� ���
				int pre = head; // ��ĵ���� ����� ���ʳ��

				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL; // pre�� ���� ���� �������
				deleteIndex(ptr);
				tail = crnt = pre;
			}
		}
	}

	// record p�� ����
	public void remove(int p) {
		if (head != NULL) {
			if (p == head) // p�� �Ӹ�����
				removeFirst(); // �Ӹ���带 ����
			else if (p == tail) // p�� ��������
				removeLast(); // ������带 ����
			else {
				int ptr = head;

				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == NULL)
						return; // p�� ����Ʈ�� �����ϴ�.
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
				crnt = ptr;
			}
		}
	}

	// ���� ��带 ����
	public void removeCurrentNode() {
		remove(crnt);
	}

	// ��� ��带 ����
	public void clear() {
		while (head != NULL) // ��� �� ������
			removeFirst(); // �Ӹ���带 ����
		crnt = NULL;
	}

	// ���� ��带 �ϳ� �������� ����
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false; // ���ư� �� ����
		crnt = n[crnt].next;
		return true;
	}

	// ���� ��带 ���
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("���� ��尡 �����ϴ�.");
		else
			System.out.println(n[crnt].data.toString());
	}

	// ��� ��带 ���
	public void dump() {
		int ptr = head;

		while (ptr != NULL) {
			System.out.println(n[ptr].data.toString());
			ptr = n[ptr].next;
		}
	}
}
