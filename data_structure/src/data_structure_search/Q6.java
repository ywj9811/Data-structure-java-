package data_structure_search;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int n = sc.nextInt();
		int[] x = new int[n]; //���̰� n�� �迭
		
		System.out.println("������������ �Է�");
		System.out.print("1��° : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < n; i++) {
			do {
				System.out.print((i + 1) + "��° : ");
				x[i] = sc.nextInt();
			} while(x[i] < x[i-1]); //������ �ٽ� �Է� 
		}
		
		System.out.print("key�� : ");
		int key = sc.nextInt();
		
		int idx = Arrays.binarySearch(x, key);
		if(idx >= 0) {
			System.out.println(idx + "��°�� ������");
		}
		else {
			idx = (-1) * (idx + 1);
			System.out.println("��ȯ�� : " + idx);
		}
			
	}
}