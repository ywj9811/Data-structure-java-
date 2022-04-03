package data_structure_recursive;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int factorial = 1;
		
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		
		System.out.println(factorial);
	}
}
