package sort;

import java.util.Scanner;

public class Fsort {
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1]; //0 ~ 매개변수 배열의 값중 0부터 최다값까지 각각 몇개씩 있는지 저장해야함 -> 없으면 0
		int[] b = new int[n]; //그저 작업용 배열 -> 존재하지 않는 값은 저장을 안해도 되기때문에 n개의 요소만 있으면 된다(a[]와 똑같음)
		
		for(int i = 0; i < n; i++)
			f[a[i]]++; //매개변수로 받은 배열a[]의 각각 값을 인덱스로 하여 해당 값의 개수 저장
		for(int i = 1; i <= max; i++) 
			f[i] += f[i - 1]; //0~max까지 해당 값의 누적개수
		for(int i = n-1; i >= 0; i--)
			b[--f[a[i]]] = a[i]; //누적 개수를 이용해서 각 인덱스에 값을 넣는다.
		for(int i = 0; i < n; i++)
			a[i] = b[i]; //복사
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도수 정렬");
		System.out.print("요솟수 입력 : ");
		int n = sc.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while(x[i] < 0); //음수를 입력했다면 다시
		}
		
		int max = x[0];
		for(int i = 0; i < n; i++) {
			if(x[i] > max)
				max = x[i];
		}
		
		fSort(x, n, max);
		
		System.out.println("오름차순 정렬");
		for(int i = 0; i < n; i++)
			System.out.println("x[" + i + "] : " + x[i]);
	}
}
