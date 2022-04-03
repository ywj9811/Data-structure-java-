package sort;

import java.util.Scanner;

public class Q5 {
	// 배열의 요소 a[idx1]과 a[idx2]를 교환
		static void swap(int[] a, int idx1, int idx2) {
			int t = a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = t;
		}

		// 양방향 버블정렬(셰이커정렬)
		static void shakerSort(int[] a, int n) {
			int left = 0;
			int right = n - 1;
			int last = right;

			while (left < right) { //1 3 5 7번째 패스
				for (int j = right; j > left; j--) {
					if (a[j - 1] > a[j]) {
						swap(a, j - 1, j);
						last = j;
					}
				}
				left = last; //left를 설정함.

				for (int j = left; j < right; j++) { //2 4 6 8번째 패스
					if (a[j] > a[j + 1]) {
						swap(a, j, j + 1);
						last = j;
					}
				}
				right = last; //right를 설정함
			}
		}

		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);

			System.out.println("양방향 버블정렬(셰이커정렬)");
			System.out.print("요솟수：");
			int nx = stdIn.nextInt();
			int[] x = new int[nx];

			for (int i = 0; i < nx; i++) {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			}

			shakerSort(x, nx); // 배열 x를 양방향 버블정렬

			System.out.println("오름차순으로 정렬했습니다.");
			for (int i = 0; i < nx; i++)
				System.out.println("x[" + i + "]＝" + x[i]);
		}
}
