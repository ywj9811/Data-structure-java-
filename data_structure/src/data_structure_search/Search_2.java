package data_structure_search;

import java.util.Scanner;

class Seqsearch2 {
	static int seqSearch(int[] a, int n, int key) { //n�� �迭�� ��ڼ�.(����)
		int i = 0;
		
		while (true) {
			if (a[i] == key)
				break; //��ġ�ϴ� ���� Ż��;
			i++;
		}
		
		return (i == n) ? -1 : 1; //i�� n�� ������ -1 �ƴϸ� 1�� ����(key���� a[n]�� ���� ���� ���ٸ� n��ġ���� ��ġ�Ұ�)
	}
}

public class Search_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : " );
		int a = sc.nextInt();
		
		int[] x = new int[a+1];
		
		for(int i = 0; i < a; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int key = sc.nextInt();
		x[a] = key; 
		
		int idx = Seqsearch2.seqSearch(x, a, key);
		
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");
	}
}