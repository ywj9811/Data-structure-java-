package sort;

import java.util.Scanner;

public class MergeSort {
	static int[] buff;
	
	static void mergesort(int[] a, int left, int right) {
		if(left < right) { //left < right�� ���� �������� ������
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;
			
			mergesort(a, left, center); //�迭�� �պκ��� ��������
			mergesort(a, center + 1, right); //�迭�� �޺κ��� ��������
											 //��� ��������� �θ��ٰ� left = right�� �Ǵ� ���� ���� ���ΰ��� ó���ϱ� ������ �Ʒ��� �������°�
			
			for(i = left; i <= center; i++) 
				buff[p++] = a[i];
			
			while(i <= right && j < p) 
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++]; //�� ������ ���ؼ� ������ �̷����(��������)
																 //�۾���迭�� ����ִ� ���� a�迭�� ���� ���Ͽ� �� ��������  a�� �ٽ� �־��ش�.
			
			while(j < p)
				a[k++] = buff[j++]; //�۾��� �迭�� ���� �����ִٸ� a�� �־��ش�.
		}
	}
	
	static void mergeSort(int[] a, int n) {
		buff = new int[n]; //�۾��� �迭�� ������
		 
		mergesort(a, 0, n-1); //�迭 ��ü�� ���� ������
		 
		buff = null; //�۾��� �迭�� ����
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��������");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		mergeSort(x, nx); //�迭 x�� ����ó���Ѵ�. //�ش� �Լ��ȿ��� mergesort(a, a, a)�� �ҷ��� ���ó�� �� ��������
		
		System.out.println("������������ �����߽��ϴ�.");
		for(int i = 0; i < nx; i++)
			System.out.println("x[" + i + "] = " + x[i]);
	}
}