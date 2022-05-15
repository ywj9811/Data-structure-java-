package list;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E> {
		private E data;
		private Node<E> next;
		
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; //머리 노드 
	private Node<E> crnt; //선택 노드
	
	public LinkedList() {
		head = crnt = null;
	}
	
	public E search(E obj, Comparator<? super E> c) { //E클래스의 c를 통해 비교
		Node<E> ptr = head; //현재 스캔중인 노드
		
		while (ptr != null) {
			if(c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data; //compare( ) == 0이니 검색 성공
			}
			ptr = ptr.next;
		}
		return null; //return하지 못하고 끝까지 검색해서 나올 경우 검색 실패
	}
	
	public void addFirst(E obj) {
		Node<E> ptr = head; //현재의 head를 ptr에 저장
		head = crnt = new Node<E>(obj, ptr); //obj, ptr 순서대로 생성자에서 데이터와 .next이다
	}
	
	public void addLast(E obj) {
		if(head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while(ptr.next != null) //이 작업이 끝나면 ptr은 꼬리노드를 가리키고 있을것이다
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	public void removeFirst() {
		if(head != null)
			head = crnt = head.next;
		//만약 head가 비어있지 않다면 head를 다시설정함.
	}
	
	public void removeLast() {
		if(head != null) {
			if(head.next == null)
				removeFirst();
			else {
				Node<E> ptr = head;
				Node<E> pre = head;
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				crnt = pre;
			}
		}
	}
	
	public void remove(Node p) { //노드 p를 삭제
		if(head != null) {
			if(p == head)
				removeFirst();
			else {
				Node<E> ptr = head;
				
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null)
						return;
				}
				ptr.next = p.next; //ptr.next를 p.next와 연결하여 p에 접근할 방법을 삭제한다.
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() { //선택노드를 삭제
		remove(crnt);
	}
	
	public void clear() {
		while(head != null)
			removeFirst(); //head가 없어질때가지 head노드를 삭제함
		crnt = null; //선택노드 없음
	}
	
	public boolean next() {
		if(crnt == null || crnt.next == null)
			return false; //선택노드가 없거나 다음이 없다면 움직이기 불가능
		crnt = crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data); //현 선택노드의 데이터를 출력.
	}
	
	public void dump() {
		//현재 모든 데이터 출력
		Node<E> ptr = head;
		
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	public void purge(Comparator<? super E> c) {
		//서로 같은 노드를 찾아서 모두 삭제.
		
	}
//	public E search(E obj, Comparator<? super E> c) { //E클래스의 c를 통해 비교
//		Node<E> ptr = head; //현재 스캔중인 노드
//		
//		while (ptr != null) {
//			if(c.compare(obj, ptr.data) == 0) {
//				crnt = ptr;
//				return ptr.data; //compare( ) == 0이니 검색 성공
//			}
//			ptr = ptr.next;
//		}
//		return null; //return하지 못하고 끝까지 검색해서 나올 경우 검색 실패
//	}
}
