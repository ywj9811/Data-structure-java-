package data_structure_search;

import java.util.Arrays;
import java.util.Scanner;

public class Bin1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int n = sc.nextInt();
		int[] x = new int[n]; //nũ���� �迭 ����
		
		System.out.println("������������ �Է��Ͻÿ�.");
		
		System.out.print("x[0] : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while(x[i] < x[i-1]); //�ٷξ��� ������ ������� �ٽ� �Է� (�������� ������ϴ�)
		}
		
		System.out.print("�˻��� �� : ");
		int key = sc.nextInt();
		
		int idx = Arrays.binarySearch(x, key);
		
		if(idx < 0)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "�� x[" + idx + "]�� �ֽ��ϴ�.");
	}
}
