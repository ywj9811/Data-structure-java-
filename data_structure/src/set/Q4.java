package set;

import java.util.Random;

public class Q4 {
	public static void main(String[] args) {
		Random rd = new Random();

		IntSet s = new IntSet(5);
		IntSet s1 = new IntSet(5);
		IntSet s2 = new IntSet(10);
		IntSet s3 = new IntSet(10);
 		
		for(int i = 0; i < s.capacity(); i++) {
			s.add(rd.nextInt(5));
			s1.add(rd.nextInt(5));
		}
		for(int i = 0; i < s2.capacity(); i++) {
			s2.add(rd.nextInt(10));
			s3.add(rd.nextInt(10));
		}
		
		System.out.println(s.toString());
		System.out.println(s1.toString());
		
		s.intersectionOf(s, s1);
		System.out.println(s.toString());
		System.out.println();
		
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		s2.differenceOf(s2, s3);
		System.out.println(s2.toString());
	}
}
