package data_structure_search;
//�̿ϼ�.
import java.util.Arrays;
import java.util.Scanner;

class Binary {
	static int search(int[] a, int key, int n) {
		int start = 0; //���� ��
		int fin = n - 1; //ó���� ������ ��
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
} //���� Ž���� ������.

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ� : ");
		int n = sc.nextInt();

		int arr[] = new int[n];
		System.out.println("���� �������� ������ �Է�");

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

			if(i > 0) {
				if(arr[i] < arr[i-1]) {
					System.out.println("�������� �ƴ� \n �ٽ��Է�");
					i = i-1;
					continue;
				}//�������� Ȯ�� �κ�.
			}

		}

		System.out.print("���ϴ� key�� �Է� : ");
		int key = sc.nextInt();

		System.out.print("  | ");//2ĭ ����.
		for(int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n--+---------------");

		System.out.println("arr[" + Binary.search(arr, key, n) + "]�� �ִ�.");
	}
}
