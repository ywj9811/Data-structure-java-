package data_structure_search;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		int[] x = new int[n]; //길이가 n인 배열
		
		System.out.println("오름차순으로 입력");
		System.out.print("1번째 : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < n; i++) {
			do {
				System.out.print((i + 1) + "번째 : ");
				x[i] = sc.nextInt();
			} while(x[i] < x[i-1]); //작으면 다시 입력 
		}
		
		System.out.print("key값 : ");
		int key = sc.nextInt();
		
		int idx = Arrays.binarySearch(x, key);
		if(idx >= 0) {
			System.out.println(idx + "번째에 존재함");
		}
		else {
			idx = (-1) * (idx + 1);
			System.out.println("반환값 : " + idx);
		}
			
	}
}