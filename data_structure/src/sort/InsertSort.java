package sort;

import java.util.Scanner;

public class InsertSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		Insert.insertionSort(x, n);
		
		System.out.println("정렬완료");
		for(int i = 0; i < n; i++)
			System.out.print(x[i] + " ");
	}
}
