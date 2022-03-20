package data_structure_search;

import java.util.Scanner;

class Seq {
	int search(int a[], int n, int key) { //a는 찾을 배열, n은 요솟수, key는 원하는 값		
		int i;
		
		for(i = 0; i <= n; i++) {		
			System.out.print("  |");
			
			for(int k = 0; k < i; k++)
				System.out.print("  ");
			
			System.out.println(" *");
			System.out.print(i + " | ");
			
			for(int j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			
			System.out.println();
			
			if(a[i] == key)
				break;
		}
		
		return (i == n) ? -1 : i; //key값을 찾으면 i로 리턴함.a[i]에 key값 존재.
	}
}

public class Q2 {
	public static void main(String[] args) {
		Seq sq = new Seq();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : " );
		int a = sc.nextInt();
		
		int[] x = new int[a];
		
		for(int i = 0; i < a; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		
		int idx = sq.search(x, a, key);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
	}
}
