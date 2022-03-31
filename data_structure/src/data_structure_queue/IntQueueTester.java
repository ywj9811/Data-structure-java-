package data_structure_queue;

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue q = new IntQueue(64); //64크기의 큐를 생성

		while(true) {
			System.out.println("현재 데이터 수 : " + q.size() + " / " + q.capacity());
			System.out.println("(1)인큐  (2)디큐  (3)피크  (4)덤프  (5)찾기  (0)종료");

			int menu = sc.nextInt(); //1~4를 입력
			if(menu == 0)
				break;

			int x;
			switch(menu) {
			case 1 :
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					q.enque(x);
				} catch(IntQueue.OverflowQueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2 :
				try {
					x = q.deque();
					System.out.println("디큐한 데이터는 : " + x + "입니다.");
				} catch(IntQueue.EmptyIntQueException e) {
					System.out.println("큐가 비었습니다.");
				}
				break;

			case 3 :
				try{
					x = q.peek();
					System.out.println("제일 앞의 데이터 : " + x);
				} catch(IntQueue.EmptyIntQueException e) {
					System.out.println("큐가 비었습니다.");
				}
				break;
				
			case 4 :
				q.dump();
				break;
				
			case 5 :
				System.out.print("숫자 몇을 찾겠습니까 : ");
				x = sc.nextInt();
				try {
					System.out.println(x + "는 " + q.search(x) + "번째에 있습니다.");
				} catch(IntQueue.EmptyIntQueException e) {
					System.out.println("큐가 비었습니다.");
				}
			}
		}
		sc.close();
	}
}