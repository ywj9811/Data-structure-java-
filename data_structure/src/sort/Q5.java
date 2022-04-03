package sort;

import java.util.Scanner;

public class Q5 {
	// �迭�� ��� a[idx1]�� a[idx2]�� ��ȯ
		static void swap(int[] a, int idx1, int idx2) {
			int t = a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = t;
		}

		// ����� ��������(����Ŀ����)
		static void shakerSort(int[] a, int n) {
			int left = 0;
			int right = n - 1;
			int last = right;

			while (left < right) { //1 3 5 7��° �н�
				for (int j = right; j > left; j--) {
					if (a[j - 1] > a[j]) {
						swap(a, j - 1, j);
						last = j;
					}
				}
				left = last; //left�� ������.

				for (int j = left; j < right; j++) { //2 4 6 8��° �н�
					if (a[j] > a[j + 1]) {
						swap(a, j, j + 1);
						last = j;
					}
				}
				right = last; //right�� ������
			}
		}

		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);

			System.out.println("����� ��������(����Ŀ����)");
			System.out.print("��ڼ���");
			int nx = stdIn.nextInt();
			int[] x = new int[nx];

			for (int i = 0; i < nx; i++) {
				System.out.print("x[" + i + "]��");
				x[i] = stdIn.nextInt();
			}

			shakerSort(x, nx); // �迭 x�� ����� ��������

			System.out.println("������������ �����߽��ϴ�.");
			for (int i = 0; i < nx; i++)
				System.out.println("x[" + i + "]��" + x[i]);
		}
}
