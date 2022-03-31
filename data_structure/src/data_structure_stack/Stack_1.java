package data_structure_stack;

//import data_structure_stack.IntStack; ��¥�� �� public�̱�� ��.
//Q1�� ������ �߰�
import java.util.Scanner;

public class Stack_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64); //64���� ���� �� �ִ� stack

		while(true) {
			System.out.println("���� ������ �� : " + s.size() + " / " + s.capacity());
			System.out.println("(1)Ǫ��     (2)��     (3)��ũ     (4)����  (5)���� Ŭ����  "
					+ "(6)������ ������� Ȯ��     (7)������ ��á���� Ȯ��     (0)���� ");
			int menu = sc.nextInt();
			if(menu == 0)
				break; //����

			int x; //push�ϰų� pop�ϰų� peak�� ���� ���� ����
			switch(menu) {
			case 1: //menu == 1
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch(IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 2:
				try {
				x = s.pop();
				System.out.println("pop�� �����ʹ� : " + x + "�Դϴ�.");
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("����� ������ �� : " + x); //peak �޼ҵ�� �� ���� ���� Ȯ���Ѵ�.
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ������ϴ�.");
				}
				break;
			case 4:
					System.out.println("��� ���");
					s.dump(); //dump�� ��ȯ�� �ƴ϶� ���ο��� �ݺ����� ���� ��� ���� ���� ���� ������ ����ϰ� �ȴ�.
				break;
			case 5:
				s.clear();
				break;
			case 6:
				System.out.println(s.isEmpty());
				break;
			case 7:
				System.out.println(s.isFull());
				break;
			}
		}
	}
}