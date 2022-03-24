package data_structure_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//실습 3-8을 응용한 시력에 대한 내림차순 정렬의 신체검사 데이터에서 특정 시력 찾기
public class Eye {
	static class PhyData {
		private String name; //이름
		private int height; //키
		private double vision; //시력
		
		public PhyData(String name, int height, double vision) {
			this.name = name; this.height = height; this.vision = vision;
		} //생성자
		
		public String toString() { // 정보를 출력해주는 메소드.
			return name + " " + height + " " + vision;
		}
		
		public static class Visioncomp implements Comparator<PhyData> {
			public int compare(PhyData d1, PhyData d2) {
				return(d1.vision < d2.vision) ? 1 : (d1.vision > d2.vision) ? -1 : 0;
				//내림차순으로 정렬하니까 크면 -1, 같으면 0, 작으면 1 이렇게 정의함.
				//혹시 안된다면 다시 원래대로 돌릴 생각.
			}
		}
		
		public static final Comparator<PhyData> comp = new Visioncomp();
		//그리고 위에서 인터페이스를 구현한 Visioncomp의 객체를 comp라고 생성함.
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhyData[] x = {
				new PhyData("이나연", 162, 1.5),
				new PhyData("김순태", 172, 1.3),
				new PhyData("김상면", 175, 0.9),
				new PhyData("이우연", 162, 0.6),
				new PhyData("양현모", 165, 0.4),
				new PhyData("권기연", 188, 0.2),
				new PhyData("김수연", 160, 0.1)
		}; //데이터 세팅
		
		System.out.print("시력이 몇인 사람을 찾고 있나요 : ");
		double vision = sc.nextDouble();
		//시력 입력
		
		int idx = Arrays.binarySearch(x, new PhyData("", 0, vision), PhyData.comp);
		//PhyData의 객체배열 x에 중간에 넣은 vision을 가지는 객체를 PhyData에 정의한 comp에 의해서 찾아라.
		
		if(idx < 0)
			System.out.println("요소가 없습니다.");
		else {
			System.out.println("x[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}
}
