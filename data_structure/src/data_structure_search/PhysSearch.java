package data_structure_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysSearch {
	static class Physicdata {
		private String name; //�̸�
		private int height; //Ű
		private double vision; //�÷�
		
		public Physicdata(String name, int height, double vision) {
			this.name = name; this.height = height; this.vision = vision;
		} // ������
		
		public String toString() {
			return name + " " + height + " " + vision;
		} //�̸�, Ű, �÷� ���� ������ִ� �޼ҵ�.
		
		public static final Comparator<Physicdata> comp = new HeightOrderComparator(); //�Ʒ��� HeightOrderComparator�� ��ü�� ����. comp�� ����ϸ� �ȴ�.
		
		public static class HeightOrderComparator implements Comparator<Physicdata> {
			public int compare(Physicdata d1, Physicdata d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0; //�� ũ�� 1, ������ 0, ������ -1 
			} //��
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Physicdata[] x = {
				new Physicdata("�̳���", 162, 0.3),
				new Physicdata("�̴���", 164, 0.5),
				new Physicdata("�����", 167, 0.2),
				new Physicdata("����ǥ", 168, 0.7),
				new Physicdata("�輮��", 172, 1.2),
				new Physicdata("����ȯ", 177, 0.9)
		};
		
		System.out.print("Ű�� �� cm�� ����� ã�� �ֳ��� : ");
		int height = sc.nextInt();
		//Ű�� �־���
		
		int idx = Arrays.binarySearch(x, new Physicdata("", height, 0.0), Physicdata.comp);
		//Physicdata�� ��ü�迭 x�� Ű�� height���� ����� ��ü�� Pysicdata.comp�� ���ؼ� ã�ƺ���.
		
		if (idx < 0)
			System.out.println("��Ұ� �����ϴ�.");
		else {
			System.out.println("x[" + idx + "]�� �ֽ��ϴ�.");
			System.out.println("ã�� ������ : " + x[idx]);
		}
	}
}
