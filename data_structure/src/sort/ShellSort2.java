package sort;

import java.util.Random;
import java.util.Scanner;

public class ShellSort2 {
	// ������(����� �ű� Ƚ���� ��ȯ)
	static int shellSort(int[] a, int n) {
		int count = 0; // �ű� Ƚ��
		int h;
		for (h = 1; h < n / 9; h = h * 3 + 1)
			;

		for (; h > 0; h /= 3)
			System.out.println(h);
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					count++;
				}
				a[j + h] = tmp;
				count++;
			}
		return count;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.println("������(���� 2) ");
		System.out.print("��ڼ���");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]��");
			x[i] = rd.nextInt(1000)+1;
		}

		int count = shellSort(x, nx); // �迭 x�� ������

		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]��" + x[i]);
		System.out.println("����� �ű�Ƚ���� " + count + "ȸ�Դϴ�.");
	}
}
