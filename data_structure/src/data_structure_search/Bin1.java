package data_structure_search;

import java.util.Arrays;
import java.util.Scanner;

public class Bin1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		int[] x = new int[n]; //n크기의 배열 생성
		
		System.out.println("오름차순으로 입력하시오.");
		
		System.out.print("x[0] : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while(x[i] < x[i-1]); //바로앞의 값보다 작을경우 다시 입력 (오름차순 맞춰야하니)
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		
		int idx = Arrays.binarySearch(x, key);
		
		if(idx < 0)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "는 x[" + idx + "]에 있습니다.");
	}
}
