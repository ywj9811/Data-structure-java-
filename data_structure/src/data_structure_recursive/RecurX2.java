package data_structure_recursive;

import java.util.Scanner;
import data_structure_stack.IntStack;

public class RecurX2 {

	static void recur(int n) {
		IntStack s = new IntStack(n);
		
		while(true) {
			if(n>0) {
				s.push(n);
				n = n - 1;
				continue;
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.print(n + " ");
				n = n - 2;
				continue;
			}

			break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �Է��ϼ���.��");
		int x = sc.nextInt();

		recur(x);
	}
}
