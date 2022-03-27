package data_structure_search;

import java.util.Scanner;

public class Q5 {
	static int binSearch2(int[] a, int n, int key) {
		int start = 0;
		int fin = n-1;
		int center = n/2; //ù ���ذ�.
		
		out : for(int i = 0; i < n; i++) {
			if(a[center] == key) {
				for(int j = 0; j < center+1; j++) {
					if(a[j] == key) {
						center = j;
						break out;
					}
				}
			}
			
			if(a[center] > key) {
				fin = center - 1;
			}
			
			if(a[center] < key) {
				start = center + 1;
			}
		}
		
		return center;
	}
//����Ž������ ù key�� ��ġ �ε��� ����.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ� � : ");
		int n = sc.nextInt();
		
		int a[] = new int[n];
		System.out.println("������������ �� �Է�");
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if(i > 0) {
				if(a[i] < a[i-1]) {
					System.out.println("������������ �ٽ� �Է�");
					i = i-1;
					continue;
				}
			}
		}
		
		System.out.print("key�� : ");
		int key = sc.nextInt();
		
		System.out.println("ù��°" + key + "��(��) a[" + Q5.binSearch2(a, n, key) + "]�� �ֽ��ϴ�.");
	}
}
