package data_structure_recursive;

import java.util.Scanner;

public class Hanoi {
	static void move(int n, char x, char y) {//원반 수, 시작 기둥 번호, 목표 기둥 번호
		if(n > 1) 
			move(n - 1, x, (char)(198 - x - y)); 
		//A B C를 각 기두의 이름으로 사용했기 때문에 아스키코드의 합이 198임을 이용함.
		
		System.out.println("원반[" + n + "]을" + x + "기둥에서 " + y + "기둥으로 옮김");
		
		if(n > 1)
			move(n-1, (char)(198 - x - y), y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 : ");
		
		int n = sc.nextInt();
		
		move(n, a, b); //n개의 원반을 1번에서 3번 기둥으로 옮기자
	}
}
