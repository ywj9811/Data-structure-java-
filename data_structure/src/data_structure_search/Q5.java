package data_structure_search;

import java.util.Scanner;

public class Q5 {
	static int binSearch2(int[] a, int n, int key) {
		int start = 0;
		int fin = n-1;
		int center = n/2; //첫 기준값.
		
		out : for(int i = 0; i < n; i++) {
			if(a[center] == key) {
				for(int j = 0; j < center+1; j++) {
					if(a[j] == key) {
						center = j;
						break out;
					}
				}
			}
			
			if(a[center] > key) {
				fin = center - 1;
			}
			
			if(a[center] < key) {
				start = center + 1;
			}
		}
		
		return center;
	}
//이진탐색에서 첫 key값 일치 인덱스 리턴.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수 몇개 : ");
		int n = sc.nextInt();
		
		int a[] = new int[n];
		System.out.println("오름차순으로 값 입력");
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if(i > 0) {
				if(a[i] < a[i-1]) {
					System.out.println("오름차순으로 다시 입력");
					i = i-1;
					continue;
				}
			}
		}
		
		System.out.print("key값 : ");
		int key = sc.nextInt();
		
		System.out.println("첫번째" + key + "는(은) a[" + Q5.binSearch2(a, n, key) + "]에 있습니다.");
	}
}
