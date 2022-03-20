package data_structure_search;

import java.util.Scanner;

class Seqsearch {
	static int seqSearch(int[] a, int n, int key) { //n은 배열의 요솟수.(길이)
		int i = 0;
		
		while (true) {
			if (i == n)//배열의 끝을 넘어버림
				return -1;
			if (a[i] == key)
				return i;
			i++;
		}
	}
}

public class Search_1 {
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
		
		int idx = Seqsearch.seqSearch(x, a, key);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
	}
}
