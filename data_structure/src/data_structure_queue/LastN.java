package data_structure_queue;

import java.util.Scanner;

public class LastN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = 10; //배열의 크기는 상수로 지정
		int[] arr = new int[N];
		int cnt = 0; //몇번의 입력이 있는가.
		int retry;
		
		System.out.println("정수를 입력시오.");
		
		do {
			System.out.printf("%d번째 정수 : ", cnt+1);
			arr[cnt++%N] = sc.nextInt(); //cnt%N 수행 후 cnt 1증가
			
			System.out.print("계속 할까요 (예.1/아니오.2) : ");
			retry = sc.nextInt();
		}while(retry == 1);
		
		int i = cnt - N;
		if(i < 0)
			i = 0;
		
		for(; i < cnt; i++) {
			System.out.printf("%2d번째 정수 :%d ", i + 1, arr[i%N]);
		}
	}
}
