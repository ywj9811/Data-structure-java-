package data_structure_search;

import java.util.Scanner;

public class Search_3 {
	static int seqsearch(int[] a, int n, int key) {
		int i;
		for(i = 0; i <= n; i++){//n은 요솟수.
			if(a[i] == key)
				break;
		}
		return (i == n) ? -1 : i;
	}
	
	public static void main(String[] args) {
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
		
		int idx = seqsearch(x, a, key);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
	}
}
