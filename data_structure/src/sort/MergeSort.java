package sort;

import java.util.Scanner;

public class MergeSort {
	static int[] buff;
	
	static void mergesort(int[] a, int left, int right) {
		if(left < right) { //left < right로 아직 나뉘어져 있을때
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;
			
			mergesort(a, left, center); //배열의 앞부분을 병합정렬
			mergesort(a, center + 1, right); //배열의 뒷부분을 병합정렬
											 //계속 재귀적으로 부르다가 left = right가 되는 순간 이제 본인것을 처리하기 시작함 아래로 내려가는것
			
			for(i = left; i <= center; i++) 
				buff[p++] = a[i];
			
			while(i <= right && j < p) 
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++]; //이 과정을 통해서 정렬이 이루어짐(병합정렬)
																 //작업용배열에 들어있는 값과 a배열의 값을 비교하여 더 작은값을  a에 다시 넣어준다.
			
			while(j < p)
				a[k++] = buff[j++]; //작업용 배열에 값이 남아있다면 a에 넣어준다.
		}
	}
	
	static void mergeSort(int[] a, int n) {
		buff = new int[n]; //작업용 배열을 생성함
		 
		mergesort(a, 0, n-1); //배열 전체를 병합 정렬함
		 
		buff = null; //작업용 배열을 해제
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("병합정렬");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		mergeSort(x, nx); //배열 x를 병합처리한다. //해당 함수안에서 mergesort(a, a, a)를 불러서 재귀처리 후 병합정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++)
			System.out.println("x[" + i + "] = " + x[i]);
	}
}