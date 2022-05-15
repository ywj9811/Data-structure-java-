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
	
	private Node<E>[] n; //리스트 본체
	private int tail;
	private int size;
	private int max;
	private int head;
	private int crnt;
	private int deleted; //free리스트의 머리노드
	private static final int NULL = -1; //다음노드가 없다, 리스트가 가득 참
	
	public AryLinkedList(int capacity) {
		head = tail =  crnt = max = deleted = NULL; //초기화함
		try {
			n = new Node[capacity]; //리스트 생성함. 용량은 capacity
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
				return ++max; //free리스트가 비었다면 배열의 맨뒤에 추가함
			else
				return NULL; //꽉참
		}
		else {
			int rec = deleted; //free리스트의 머리노드
			deleted = n[rec].dnext; //free리스트의 머리노드를 수정함
			return rec;
		}			
	}
	
	private void deleteIndex(int idx) {
		if(deleted == NULL) {
			deleted = idx;
			n[idx].dnext = NULL; //free리스트가 비었다면 머리노드를 추가함. 머리노드만 존재
		}
		else {
			int rec = deleted;
			deleted = idx;
			n[idx].dnext = rec; //free리스트에 머리노드를 넣고 원래의 머리노드를 연결함
		}
	}
	
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;
		//현재 스캔중인 노드
		
		while(ptr != NULL) {
			if(c.compare(obj, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data; //검색 성공
			}
			
			ptr = n[ptr].next; //다음노드 확인
		}
		
		return null; //검색 실패
	}
	
	public void addFirst(E o) {
		boolean empty = (tail == NULL);
		int ptr = head; // 삽입 전의 머리노드
		int rec = getInsertIndex();
		if (rec != NULL) {
			head = crnt = rec; // 인덱스 rec인 record에 삽입
			n[head].set(o, ptr);
			if (empty)
				tail = crnt;
		}
	}
	
	// 꼬리에 노드를 삽입
	public void addLast(E o) {
		if (head == NULL) // 리스트가 비어있으면
			addFirst(o); // 머리에 삽입
		else {
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[tail].next = crnt = rec;
				n[rec].set(o, NULL);
				tail = rec;
			}
		}
	}

	// 머리노드를 삭제
	public void removeFirst() {
		if (head != NULL) { // 리스트가 비어 있지 않으면
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
			if (head == NULL)
				tail = NULL;
		}
	}

	// 꼬리노드를 삭제
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL) // 노드가 하나만 있으면
				removeFirst(); // 머리노드를 삭제
			else {
				int ptr = head; // 스캔중인 노드
				int pre = head; // 스캔중인 노드의 앞쪽노드

				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL; // pre는 삭제 뒤의 꼬리노드
				deleteIndex(ptr);
				tail = crnt = pre;
			}
		}
	}

	// record p를 삭제
	public void remove(int p) {
		if (head != NULL) {
			if (p == head) // p가 머리노드면
				removeFirst(); // 머리노드를 삭제
			else if (p == tail) // p가 꼬리노드면
				removeLast(); // 꼬리노드를 삭제
			else {
				int ptr = head;

				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == NULL)
						return; // p가 리스트에 없습니다.
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
				crnt = ptr;
			}
		}
	}

	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}

	// 모든 노드를 삭제
	public void clear() {
		while (head != NULL) // 비게 될 때까지
			removeFirst(); // 머리노드를 삭제
		crnt = NULL;
	}

	// 선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false; // 나아갈 수 없음
		crnt = n[crnt].next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("선택 노드가 없습니다.");
		else
			System.out.println(n[crnt].data.toString());
	}

	// 모든 노드를 출력
	public void dump() {
		int ptr = head;

		while (ptr != NULL) {
			System.out.println(n[ptr].data.toString());
			ptr = n[ptr].next;
		}
	}
}
