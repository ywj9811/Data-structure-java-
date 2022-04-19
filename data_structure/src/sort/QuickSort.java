package sort;

import java.util.Scanner;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}//두개 -> pl과 pr을 교체하기위한 메소드
	
	static void quicksort(int[]a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr)/2]; //x를 피봇으로, 왼쪽 오른쪽 합의 /2
		
		//여기부터
		System.out.printf("a[%d] ~ a[%d] : {" , left, right);
		for(int i = left; i < right; i++) {
			System.out.printf("%d, ", a[i]);
		}
		System.out.printf("%d}\n", a[right]);
		//이 부분을 추가함 -> 과정을 나타낼 수 있음
		
		do {
			while(a[pl] < x)
				pl++; //피봇보다 작다면 계속해서 늘려감, 그러다가 큰값이 나오는 순간 pl고정
			while(a[pr] > x)
				pr--; //피봇보다 크다면 계속해서 줄여나감, 작은값이 나오는 순간 pr고정
			if(pl <= pr)
				swap(a, pl++, pr--);//swap과정을 마치고 반복조건 성립하면 위에서부터 다시
		}while(pl <= pr); //pl과 pr이 교차할때까지
		
		if(left < pr)
			quicksort(a, left, pr);
		if(right > pl)
			quicksort(a, pl, right); //while을 탈출한 이상 pl은 pr보타 오른쪽에 위치하게 되어있음 혹은 동일
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		quicksort(x, 0, n-1); //처음에는 left는 0으로 right는 n-1을 넣어줌
		//이후 반복을 하면 가지를 늘려가며 left, right, 피봇이 다양하게 나오게 된다
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] : " + x[i]);
		}
	}
}
