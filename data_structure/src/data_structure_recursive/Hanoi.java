package data_structure_recursive;

import java.util.Scanner;

public class Hanoi {
	static void move(int n, char x, char y) {//���� ��, ���� ��� ��ȣ, ��ǥ ��� ��ȣ
		if(n > 1) 
			move(n - 1, x, (char)(198 - x - y)); 
		//A B C�� �� ����� �̸����� ����߱� ������ �ƽ�Ű�ڵ��� ���� 198���� �̿���.
		
		System.out.println("����[" + n + "]��" + x + "��տ��� " + y + "������� �ű�");
		
		if(n > 1)
			move(n-1, (char)(198 - x - y), y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		System.out.println("�ϳ����� ž");
		System.out.print("���� ���� : ");
		
		int n = sc.nextInt();
		
		move(n, a, b); //n���� ������ 1������ 3�� ������� �ű���
	}
}
