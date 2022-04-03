package sort;

import java.util.Scanner;

public class BubbleSort {
	static int cnt = 0;//�� Ƚ��
	static int count = 0;//��ȯ Ƚ��
	static int pass = 0;
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t; //idx2�� ���� idx1�� ���� �ٲٴ°� -> idx2�� �� ������� ����
	}
	
	static void bubbleSort(int[] a, int n) {//�迭 a, n���� ��ڼ�
		int k = 0;
		int k2 = n-1;
		out : while(true) {
			int change = 0;
			for(int i = 0; i < n; i++) {
				pass++;
				int last = n-1;
				int last2 = 0;
				if(i % 2 == 0) {//�� ������ ����
					for(int j = n-1; j > k; j--) {
						cnt++;
						if(a[j-1] > a[j]) {
							count++;
							swap(a, j-1, j);
							change++;
							last = j;
							k = last;
						}
					}
					if(change == 0)
						break out;
				}
				else {//Ȧ���϶� �ǵڷ� ����
					for(int j = 0; j < k2; j++) {
						cnt++;
						if(a[j] > a[j+1]) {
							count++;
							swap(a, j, j+1);
							change++;
							last2 = j;
							k2 = last2;
						}
					}
					if(change == 0)
						break out;
				}
			}
			k = change;//k = last�� �����ָ� �н����� ������ last������ �����ϰ� �ȴ�.
			//���� �� �� ������ �Ȼ���� if�� �������� �ʱ⶧���� last=0�� ������ �Ǹ� k=0�� �Ǹ鼭 while���� Ż���ϰ� �ȴ�.
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ����ver1");
		System.out.print("��ڼ� : ");
		int n = sc.nextInt();
		
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("n[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		bubbleSort(x, n);
		System.out.println("���� �Ϸ�");
		for(int i = 0; i < n; i++)
			System.out.print(x[i] + " ");
		System.out.println("\n��Ƚ�� : " + cnt);
		System.out.println("��ȯȽ�� : " + count);
		System.out.println("�н� : " + pass);
	}
}
