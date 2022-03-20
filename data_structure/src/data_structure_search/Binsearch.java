package data_structure_search;

import java.util.Scanner;

class Bin{
	static int binSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2;
			if(a[pc] == key)
				return pc; //�߾� ��ҿ� ��ġ�� �Ǿ����� ����.
			else if(a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr); //�ּ��� �ε����� �ִ��� �ε����� �����Ǳ� ������ �ݺ�.
		
		return -1; //�ᱹ ���� �ݺ��� �ȿ��� return�� ���� ������ ��Ұ� �������̱� ������ return -1�̴�.
	}
}

public class Binsearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num]; //��ڼ� ��ŭ ũ���� �迭 ����.
		
		System.out.print("������������ �Է��ϼ���.");
		
		System.out.println("x[0] : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			}while(x[i] < x[i-1]);
		}
		
		System.out.print("�˻��� �� : ");
		int key = sc.nextInt();
		
		int idx = Bin.binSearch(x, num, key);
		
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");
	}
}
