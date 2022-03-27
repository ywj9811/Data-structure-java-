package data_structure_search;
//미완성.
import java.util.Arrays;
import java.util.Scanner;

class Binary {
	static int search(int[] a, int key, int n) {
		int start = 0; //시작 값
		int fin = n - 1; //처음의 마지막 값
		int center = n/2;

		for(int i = 0; i < n; i++) {
			if(((fin - start)/2 - 1) > 0) {
				System.out.println("  | ");
				System.out.print(" " + ((fin - start)/2 - 1) + "| ");
				for(int j = 0; j < n; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println();
			}
			if(a[center] > key) {
				fin = center - 1;
				center = (fin + 1)/2;
			}

			else if(a[center] < key) {
				start = center + 1;
				center = (start + fin)/2;
			}

			else
				break;
		}
		return center;
	}
} //이진 탐색을 수행함.

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int n = sc.nextInt();

		int arr[] = new int[n];
		System.out.println("값들 오름차순 순으로 입력");

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

			if(i > 0) {
				if(arr[i] < arr[i-1]) {
					System.out.println("오름차순 아님 \n 다시입력");
					i = i-1;
					continue;
				}//오름차순 확인 부분.
			}

		}

		System.out.print("원하는 key값 입력 : ");
		int key = sc.nextInt();

		System.out.print("  | ");//2칸 띄어쓰기.
		for(int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n--+---------------");

		System.out.println("arr[" + Binary.search(arr, key, n) + "]에 있다.");
	}
}
