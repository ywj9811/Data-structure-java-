package data_structure_queue;

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue q = new IntQueue(64); //64ũ���� ť�� ����

		while(true) {
			System.out.println("���� ������ �� : " + q.size() + " / " + q.capacity());
			System.out.println("(1)��ť  (2)��ť  (3)��ũ  (4)����  (5)ã��  (0)����");

			int menu = sc.nextInt(); //1~4�� �Է�
			if(menu == 0)
				break;

			int x;
			switch(menu) {
			case 1 :
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					q.enque(x);
				} catch(IntQueue.OverflowQueException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;

			case 2 :
				try {
					x = q.deque();
					System.out.println("��ť�� �����ʹ� : " + x + "�Դϴ�.");
				} catch(IntQueue.EmptyIntQueException e) {
					System.out.println("ť�� ������ϴ�.");
				}
				break;

			case 3 :
				try{
					x = q.peek();
					System.out.println("���� ���� ������ : " + x);
				} catch(IntQueue.EmptyIntQueException e) {
					System.out.println("ť�� ������ϴ�.");
				}
				break;
				
			case 4 :
				q.dump();
				break;
				
			case 5 :
				System.out.print("���� ���� ã�ڽ��ϱ� : ");
				x = sc.nextInt();
				try {
					System.out.println(x + "�� " + q.search(x) + "��°�� �ֽ��ϴ�.");
				} catch(IntQueue.EmptyIntQueException e) {
					System.out.println("ť�� ������ϴ�.");
				}
			}
		}
		sc.close();
	}
}