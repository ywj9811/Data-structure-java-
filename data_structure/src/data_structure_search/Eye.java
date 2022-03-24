package data_structure_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//�ǽ� 3-8�� ������ �÷¿� ���� �������� ������ ��ü�˻� �����Ϳ��� Ư�� �÷� ã��
public class Eye {
	static class PhyData {
		private String name; //�̸�
		private int height; //Ű
		private double vision; //�÷�
		
		public PhyData(String name, int height, double vision) {
			this.name = name; this.height = height; this.vision = vision;
		} //������
		
		public String toString() { // ������ ������ִ� �޼ҵ�.
			return name + " " + height + " " + vision;
		}
		
		public static class Visioncomp implements Comparator<PhyData> {
			public int compare(PhyData d1, PhyData d2) {
				return(d1.vision < d2.vision) ? 1 : (d1.vision > d2.vision) ? -1 : 0;
				//������������ �����ϴϱ� ũ�� -1, ������ 0, ������ 1 �̷��� ������.
				//Ȥ�� �ȵȴٸ� �ٽ� ������� ���� ����.
			}
		}
		
		public static final Comparator<PhyData> comp = new Visioncomp();
		//�׸��� ������ �������̽��� ������ Visioncomp�� ��ü�� comp��� ������.
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhyData[] x = {
				new PhyData("�̳���", 162, 1.5),
				new PhyData("�����", 172, 1.3),
				new PhyData("����", 175, 0.9),
				new PhyData("�̿쿬", 162, 0.6),
				new PhyData("������", 165, 0.4),
				new PhyData("�Ǳ⿬", 188, 0.2),
				new PhyData("�����", 160, 0.1)
		}; //������ ����
		
		System.out.print("�÷��� ���� ����� ã�� �ֳ��� : ");
		double vision = sc.nextDouble();
		//�÷� �Է�
		
		int idx = Arrays.binarySearch(x, new PhyData("", 0, vision), PhyData.comp);
		//PhyData�� ��ü�迭 x�� �߰��� ���� vision�� ������ ��ü�� PhyData�� ������ comp�� ���ؼ� ã�ƶ�.
		
		if(idx < 0)
			System.out.println("��Ұ� �����ϴ�.");
		else {
			System.out.println("x[" + idx + "]�� �ֽ��ϴ�.");
			System.out.println("ã�� ������ : " + x[idx]);
		}
	}
}
