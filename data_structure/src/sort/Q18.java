package sort;

import java.util.Scanner;

public class Q18 {
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1]; //0 ~ �Ű����� �迭�� ���� 0���� �ִٰ����� ���� ��� �ִ��� �����ؾ��� -> ������ 0
		int[] b = new int[n]; //���� �۾��� �迭 -> �������� �ʴ� ���� ������ ���ص� �Ǳ⶧���� n���� ��Ҹ� ������ �ȴ�(a[]�� �Ȱ���)
		
		for(int i = 0; i < n; i++) {
			f[a[i]]++; //�Ű������� ���� �迭a[]�� ���� ���� �ε����� �Ͽ� �ش� ���� ���� ����
			System.out.print("f[" + a[i] + "] = " + f[a[i]] + " ");
		}
		System.out.println();
		for(int i = 1; i <= max; i++) { 
			f[i] += f[i - 1]; //0~max���� �ش� ���� ��������
			System.out.print("f[" + i + "] : " + f[i] + " ");
		}
		System.out.println();
		for(int i = n-1; i >= 0; i--) {
			b[--f[a[i]]] = a[i]; //���� ������ �̿��ؼ� �� �ε����� ���� �ִ´�.
			System.out.print("b[" + f[a[i]] + "] : " + a[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < n; i++)
			a[i] = b[i]; //����
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ����");
		System.out.print("��ڼ� �Է� : ");
		int n = sc.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while(x[i] < 0); //������ �Է��ߴٸ� �ٽ�
		}
		
		int max = x[0];
		for(int i = 0; i < n; i++) {
			if(x[i] > max)
				max = x[i];
		}
		
		fSort(x, n, max);
		
		System.out.println("�������� ����");
		for(int i = 0; i < n; i++)
			System.out.println("x[" + i + "] : " + x[i]);
	}
}
