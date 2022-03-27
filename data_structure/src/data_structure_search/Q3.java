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
		
		System.out.println("��ġ�ϴ� index �� : " + cnt);
		System.out.println("index ��ȣ : " + idx);
	}
}

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� �Է� : ");
		int n = sc.nextInt(); //��� ��Ҹ� �������ΰ�.
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.print("key���� �������� : ");
		int key = sc.nextInt();
		
		ArrayList<Integer> idx = new ArrayList<Integer>(); //idx�� ����Ʈ�� ����.
		
		Search.searchIdx(a, n, key, idx);
	}
}