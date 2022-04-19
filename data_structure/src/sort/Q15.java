package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import sort.PhysicExamSort.PhysicData;

class PhysicExamSort {
	//����Ŭ����
	static class PhysicData{
		String name;
		int height;
		double vision;
		
		PhysicData(String name, int height, double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		static final Comparator<PhysicData> HO = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhysicData> {

			@Override
			public int compare(PhysicData d1, PhysicData d2) {
				return(d1.height > d2.height) ? -1 : (d1.height < d2.height) ? 1 : 0; //�� ũ�� -1, ������ 1, ������ 0
			}//������������ ������������ ������ �ٲٱ� ���ؼ� ����� �ݴ�� �ٲ�
			
		}
	}
}

public class Q15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhysicData[] x = {
				new PhysicData("Lee", 177, 0.3),
				new PhysicData("Yee", 171, 0.1),
				new PhysicData("Aee", 165, 1.5),
				new PhysicData("Leeee", 163, 1.0),
				new PhysicData("Leee", 166, 1.4),
				new PhysicData("Park", 180, 0.7),
				new PhysicData("Lee", 158, 0.4),
				new PhysicData("Kim", 174, 0.5),
		};
		
		Arrays.sort(x, PhysicData.HO);
	 //-1�� 1�� �ݴ�� �ٲ� -> ������������
		System.out.println("��ü�˻� Ű�� �������� �������� ����");
		
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
}
