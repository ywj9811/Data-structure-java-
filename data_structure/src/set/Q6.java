package set;

import java.util.Random;

public class Q6 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		IntSortedSet s1 = new IntSortedSet(10);

		try{
			for(int i = 0; i < s1.capacity(); i++) {
				s1.add(rd.nextInt(15));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(s1.size());
		System.out.println(s1.toString());
	}

}
