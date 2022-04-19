package sort;

import java.util.Scanner;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}//�ΰ� -> pl�� pr�� ��ü�ϱ����� �޼ҵ�
	
	static void quicksort(int[]a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr)/2]; //x�� �Ǻ�����, ���� ������ ���� /2
		
		//�������
		System.out.printf("a[%d] ~ a[%d] : {" , left, right);
		for(int i = left; i < right; i++) {
			System.out.printf("%d, ", a[i]);
		}
		System.out.printf("%d}\n", a[right]);
		//�� �κ��� �߰��� -> ������ ��Ÿ�� �� ����
		
		do {
			while(a[pl] < x)
				pl++; //�Ǻ����� �۴ٸ� ����ؼ� �÷���, �׷��ٰ� ū���� ������ ���� pl����
			while(a[pr] > x)
				pr--; //�Ǻ����� ũ�ٸ� ����ؼ� �ٿ�����, �������� ������ ���� pr����
			if(pl <= pr)
				swap(a, pl++, pr--);//swap������ ��ġ�� �ݺ����� �����ϸ� ���������� �ٽ�
		}while(pl <= pr); //pl�� pr�� �����Ҷ�����
		
		if(left < pr)
			quicksort(a, left, pr);
		if(right > pl)
			quicksort(a, pl, right); //while�� Ż���� �̻� pl�� pr��Ÿ �����ʿ� ��ġ�ϰ� �Ǿ����� Ȥ�� ����
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int n = sc.nextInt();
		
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		quicksort(x, 0, n-1); //ó������ left�� 0���� right�� n-1�� �־���
		//���� �ݺ��� �ϸ� ������ �÷����� left, right, �Ǻ��� �پ��ϰ� ������ �ȴ�
		
		System.out.println("������������ �����߽��ϴ�.");
		for(int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] : " + x[i]);
		}
	}
}
