package data_structure_search;

import java.util.Scanner;

class Bin{
	static int binSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2;
			if(a[pc] == key)
				return pc; //중앙 요소와 겹치게 되었으니 종료.
			else if(a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr); //최소의 인덱스와 최대의 인덱스가 역전되기 전까지 반복.
		
		return -1; //결국 위의 반복문 안에서 return이 되지 않으면 요소가 없던것이기 때문에 return -1이다.
	}
}

public class Binsearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num]; //요솟수 만큼 크기의 배열 생성.
		
		System.out.print("오름차순으로 입력하세요.");
		
		System.out.println("x[0] : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			}while(x[i] < x[i-1]);
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		
		int idx = Bin.binSearch(x, num, key);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
	}
}
