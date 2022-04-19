package sort;

import java.util.Random;
import java.util.Scanner;

public class ShellSrot {
	static int shellsort(int[] a, int n) {
		int count = 0;
		for(int h = n/2; h > 0; h /= 2) {
			System.out.println(h);
			for(int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for(j = i - h; j >= 0 && a[j] >tmp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = tmp;
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("�� ���� v1");
		System.out.print("��ڼ� : ");
		int n = sc.nextInt();
		int x[] = new int[n];///������ ����
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = rd.nextInt(1000) + 1;
			System.out.println();
		}
		
		int count = shellsort(x, n);
		
		System.out.println("�������� ���� �Ϸ�");
		for(int i = 0; i < n; i++)
			System.out.println("x[" + i + "] : " + x[i]);
		System.out.println(count);
	}
}
