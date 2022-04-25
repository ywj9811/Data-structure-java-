package set;

import java.util.Random;

public class Q3 {
	public static void main(String[] args) {
		Random rd = new Random();

		IntSet s = new IntSet(5);
		IntSet s1 = new IntSet(5);

		for(int i = 0; i < 10; i++) {
			s.add(rd.nextInt(5));
			s1.add(rd.nextInt(5));
		}
		
		System.out.println("s = " + s);
		System.out.println("s1 = " + s1);
		System.out.println("�� " + s.isSubsetOf(s1));
		System.out.println("�� " + s.isProperSubsetOf(s1));
	}
}
