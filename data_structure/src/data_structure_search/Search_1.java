package data_structure_search;

import java.util.Scanner;

class Seqsearch {
	static int seqSearch(int[] a, int n, int key) { //n�� �迭�� ��ڼ�.(����)
		int i = 0;
		
		while (true) {
			if (i == n)//�迭�� ���� �Ѿ����
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
		
		System.out.print("��ڼ� : " );
		int a = sc.nextInt();
		
		int[] x = new int[a];
		
		for(int i = 0; i < a; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int key = sc.nextInt();
		
		int idx = Seqsearch.seqSearch(x, a, key);
		
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");
	}
}
