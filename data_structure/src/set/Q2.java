package set;

import java.util.Random;

public class Q2 {
	public static void main(String[] args) {
		Random rd = new Random();

		IntSet s = new IntSet(20);
		IntSet s1 = new IntSet(20);
		
		for(int i = 0; i < 10; i++) {
			s.add(rd.nextInt(100));
			s1.add(rd.nextInt(100));
		}
		
		System.out.println("s = " + s );
		System.out.println("s1 = " + s1);
		
		System.out.println(s1.add(s));
		System.out.println("��ġ�°� ���� ��ħ : " + s1);
		
		System.out.println(s1.remove(s));
		System.out.println("s�� �͵� ��ġ�°� ���� : " + s1);
		
		System.out.println(s1.add(s));
		System.out.println("�ٽ� ���󺹱� : " + s1);
		System.out.println(s1.retain(s));
		System.out.println("s�� �͵� ���� ���� : " + s1);
	}
}
