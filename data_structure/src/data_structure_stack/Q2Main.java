package data_structure_stack;

import java.util.Scanner;

public class Q2Main {
	public static void main(String[] args) {
		Q2<Integer> q = new Q2<Integer>(64);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("현재 데이터 수 :" + q.size() + "/" +q.capacity());
			System.out.println("(1)푸시  (2)팝  (3)피크  (4)덤프  (0)종료");
			
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			
			Integer x;
			switch(menu) {
			case 1 : 
				System.out.print("데이터 : ");
				x = sc.nextInt(); 				
				q.push(x);
				break;
			
			case 2 :
				x = (Integer)q.pop();
				System.out.println("팝한 데이터 : " + x);
				break;
				
			case 3 :
				x = (Integer) (q.peek());
				System.out.println("피크한 데이터 : " + x);
				break;
				
			case 4 :
				q.dump();
				break;
			}
		}
	}
}