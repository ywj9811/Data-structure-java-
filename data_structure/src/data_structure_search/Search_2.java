package data_structure_search;

import java.util.Scanner;

class Seqsearch2 {
	static int seqSearch(int[] a, int n, int key) { //n은 배열의 요솟수.(길이)
		int i = 0;
		
		while (true) {
			if (a[i] == key)
				break; //일치하는 순간 탈출;
			i++;
		}
		
		return (i == n) ? -1 : 1; //i가 n과 같으면 -1 아니면 1을 리턴(key값을 a[n]에 저장 따라서 없다면 n위치에서 일치할것)
	}
}

public class Search_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : " );
		int a = sc.nextInt();
		
		int[] x = new int[a+1];
		
		for(int i = 0; i < a; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		x[a] = key; 
		
		int idx = Seqsearch2.seqSearch(x, a, key);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
	}
}