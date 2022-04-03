package sort;

import java.util.Scanner;

public class BubbleSort {
	static int cnt = 0;//비교 횟수
	static int count = 0;//교환 횟수
	static int pass = 0;
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t; //idx2의 값과 idx1의 값을 바꾸는것 -> idx2가 더 작을경우 시행
	}
	
	static void bubbleSort(int[] a, int n) {//배열 a, n개의 요솟수
		int k = 0;
		int k2 = n-1;
		out : while(true) {
			int change = 0;
			for(int i = 0; i < n; i++) {
				pass++;
				int last = n-1;
				int last2 = 0;
				if(i % 2 == 0) {//맨 앞으로 정렬
					for(int j = n-1; j > k; j--) {
						cnt++;
						if(a[j-1] > a[j]) {
							count++;
							swap(a, j-1, j);
							change++;
							last = j;
							k = last;
						}
					}
					if(change == 0)
						break out;
				}
				else {//홀수일때 맨뒤로 정렬
					for(int j = 0; j < k2; j++) {
						cnt++;
						if(a[j] > a[j+1]) {
							count++;
							swap(a, j, j+1);
							change++;
							last2 = j;
							k2 = last2;
						}
					}
					if(change == 0)
						break out;
				}
			}
			k = change;//k = last로 정해주면 패스에서 정렬을 last전까지 시행하게 된다.
			//만약 그 후 정렬이 안생기면 if를 진행하지 않기때문에 last=0이 유지가 되며 k=0이 되면서 while문을 탈출하게 된다.
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("버블 정렬ver1");
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("n[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		bubbleSort(x, n);
		System.out.println("정렬 완료");
		for(int i = 0; i < n; i++)
			System.out.print(x[i] + " ");
		System.out.println("\n비교횟수 : " + cnt);
		System.out.println("교환횟수 : " + count);
		System.out.println("패스 : " + pass);
	}
}
