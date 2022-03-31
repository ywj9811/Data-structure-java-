package data_structure_stack;

//import data_structure_stack.IntStack; 어짜피 다 public이기는 함.
//Q1의 내용을 추가
import java.util.Scanner;

public class Stack_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64); //64개를 가질 수 있는 stack

		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.println("(1)푸시     (2)팝     (3)피크     (4)덤프  (5)스택 클리어  "
					+ "(6)스택이 비었는지 확인     (7)스택이 꽉찼는지 확인     (0)종료 ");
			int menu = sc.nextInt();
			if(menu == 0)
				break; //종료

			int x; //push하거나 pop하거나 peak한 값을 받을 변수
			switch(menu) {
			case 1: //menu == 1
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch(IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2:
				try {
				x = s.pop();
				System.out.println("pop한 데이터는 : " + x + "입니다.");
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("꼭대기 데이터 값 : " + x); //peak 메소드는 맨 위의 값을 확인한다.
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			case 4:
					System.out.println("모두 출력");
					s.dump(); //dump는 반환이 아니라 내부에서 반복문을 통해 모든 값을 선입 선출 식으로 출력하게 된다.
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