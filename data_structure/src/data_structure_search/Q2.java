package data_structure_search;

import java.util.Scanner;

class Seq {
	int search(int a[], int n, int key) { //a�� ã�� �迭, n�� ��ڼ�, key�� ���ϴ� ��		
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
		
		return (i == n) ? -1 : i; //key���� ã���� i�� ������.a[i]�� key�� ����.
	}
}

public class Q2 {
	public static void main(String[] args) {
		Seq sq = new Seq();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : " );
		int a = sc.nextInt();
		
		int[] x = new int[a];
		
		for(int i = 0; i < a; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int key = sc.nextInt();
		
		int idx = sq.search(x, a, key);
		
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");
	}
}
