package data_structure_stack;

import java.util.Scanner;

public class Q2Main {
	public static void main(String[] args) {
		Q2<Integer> q = new Q2<Integer>(64);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("���� ������ �� :" + q.size() + "/" +q.capacity());
			System.out.println("(1)Ǫ��  (2)��  (3)��ũ  (4)����  (0)����");
			
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			
			Integer x;
			switch(menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.nextInt(); 				
				q.push(x);
				break;
			
			case 2 :
				x = (Integer)q.pop();
				System.out.println("���� ������ : " + x);
				break;
				
			case 3 :
				x = (Integer) (q.peek());
				System.out.println("��ũ�� ������ : " + x);
				break;
				
			case 4 :
				q.dump();
				break;
			}
		}
	}
}