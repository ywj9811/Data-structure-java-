package data_structure_search;

import java.util.Scanner;

public class Search_3 {
	static int seqsearch(int[] a, int n, int key) {
		int i;
		for(i = 0; i <= n; i++){//n�� ��ڼ�.
			if(a[i] == key)
				break;
		}
		return (i == n) ? -1 : i;
	}
	
	public static void main(String[] args) {
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
		
		int idx = seqsearch(x, a, key);
		
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");
	}
}
