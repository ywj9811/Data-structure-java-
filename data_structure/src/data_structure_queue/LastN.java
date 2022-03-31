package data_structure_queue;

import java.util.Scanner;

public class LastN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = 10; //�迭�� ũ��� ����� ����
		int[] arr = new int[N];
		int cnt = 0; //����� �Է��� �ִ°�.
		int retry;
		
		System.out.println("������ �Է½ÿ�.");
		
		do {
			System.out.printf("%d��° ���� : ", cnt+1);
			arr[cnt++%N] = sc.nextInt(); //cnt%N ���� �� cnt 1����
			
			System.out.print("��� �ұ�� (��.1/�ƴϿ�.2) : ");
			retry = sc.nextInt();
		}while(retry == 1);
		
		int i = cnt - N;
		if(i < 0)
			i = 0;
		
		for(; i < cnt; i++) {
			System.out.printf("%2d��° ���� :%d ", i + 1, arr[i%N]);
		}
	}
}
