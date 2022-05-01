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
	
	private Node<E> head; //�Ӹ� ��� 
	private Node<E> crnt; //���� ���
	
	public LinkedList() {
		head = crnt = null;
	}
	
	public E search(E obj, Comparator<? super E> c) { //EŬ������ c�� ���� ��
		Node<E> ptr = head; //���� ��ĵ���� ���
		
		while (ptr != null) {
			if(c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data; //compare( ) == 0�̴� �˻� ����
			}
			ptr = ptr.next;
		}
		return null; //return���� ���ϰ� ������ �˻��ؼ� ���� ��� �˻� ����
	}
	
	public void addFirst(E obj) {
		Node<E> ptr = head; //������ head�� ptr�� ����
		head = crnt = new Node<E>(obj, ptr); //obj, ptr ������� �����ڿ��� �����Ϳ� .next�̴�
	}
	
	public void addLast(E obj) {
		if(head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while(ptr.next != null) //�� �۾��� ������ ptr�� ������带 ����Ű�� �������̴�
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	public void removeFirst() {
		if(head != null)
			head = crnt = head.next;
		//���� head�� ������� �ʴٸ� head�� �ٽü�����.
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
	
	public void remove(Node p) { //��� p�� ����
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
				ptr.next = p.next; //ptr.next�� p.next�� �����Ͽ� p�� ������ ����� �����Ѵ�.
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() { //���ó�带 ����
		remove(crnt);
	}
	
	public void clear() {
		while(head != null)
			removeFirst(); //head�� ������������ head��带 ������
		crnt = null; //���ó�� ����
	}
	
	public boolean next() {
		if(crnt == null || crnt.next == null)
			return false; //���ó�尡 ���ų� ������ ���ٸ� �����̱� �Ұ���
		crnt = crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("������ ��尡 �����ϴ�.");
		else
			System.out.println(crnt.data); //�� ���ó���� �����͸� ���.
	}
	
	public void dump() {
		//���� ��� ������ ���
		Node<E> ptr = head;
		
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	
}
