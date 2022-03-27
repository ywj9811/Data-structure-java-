package data_structure_search;

import java.util.ArrayList;
import java.util.Scanner;

class Search {
	static void searchIdx(int[] a, int n, int key, ArrayList<Integer> idx) {
		int cnt = 0;
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(a[i] == key) {
				idx.add(i);
				j++;
				cnt++;
			}
		}
		
		System.out.println("일치하는 index 수 : " + cnt);
		System.out.println("index 번호 : " + idx);
	}
}

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 입력 : ");
		int n = sc.nextInt(); //몇개의 요소를 넣을것인가.
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.print("key값을 무엇으로 : ");
		int key = sc.nextInt();
		
		ArrayList<Integer> idx = new ArrayList<Integer>(); //idx는 리스트로 생성.
		
		Search.searchIdx(a, n, key, idx);
	}
}