package set;

import java.util.Random;

public class Q1 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		IntSet s = new IntSet(20);
		
		System.out.println("����� : " + s.isEmpty());
		
		for(int i = 0; i < 20; i++) {
			s.add(rd.nextInt(1000));
		}
		
		System.out.println("��á�� : " + s.isFull());
		
		s.clear();
		
		System.out.println("�ʱ�ȭ �ߴ� ����� : " + s.isEmpty());
	}
}
