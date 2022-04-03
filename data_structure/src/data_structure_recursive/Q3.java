package data_structure_recursive;


import java.util.Scanner;

public class Q3 {
	static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else
			return gcd(y, x%y);
	}

	static int gcdArray(int a[], int start, int no) {
		if (no == 1)
			return a[start];
		else if (no == 2)
			return gcd(a[start], a[start + 1]);
		else
			return gcd(a[start], gcdArray(a, start + 1, no - 1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� �� ���� �ִ� ������� ���ұ��?��");
		int num;
		do {
			num = sc.nextInt();
		} while (num <= 1);

		int[] x = new int[num]; // ���� num�� �迭

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]��");
			x[i] = sc.nextInt();
		}

		System.out.println("�ִ� ������� " + gcdArray(x, 0, num) + "�Դϴ�.");
	}
}

