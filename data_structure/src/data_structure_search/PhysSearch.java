package data_structure_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysSearch {
	static class Physicdata {
		private String name; //이름
		private int height; //키
		private double vision; //시력
		
		public Physicdata(String name, int height, double vision) {
			this.name = name; this.height = height; this.vision = vision;
		} // 생성자
		
		public String toString() {
			return name + " " + height + " " + vision;
		} //이름, 키, 시력 정보 출력해주는 메소드.
		
		public static final Comparator<Physicdata> comp = new HeightOrderComparator(); //아래의 HeightOrderComparator를 객체로 생성. comp로 사용하면 된다.
		
		public static class HeightOrderComparator implements Comparator<Physicdata> {
			public int compare(Physicdata d1, Physicdata d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0; //더 크면 1, 같으면 0, 작으면 -1 
			} //비교
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Physicdata[] x = {
				new Physicdata("이나연", 162, 0.3),
				new Physicdata("이다현", 164, 0.5),
				new Physicdata("김우현", 167, 0.2),
				new Physicdata("김진표", 168, 0.7),
				new Physicdata("김석희", 172, 1.2),
				new Physicdata("김태환", 177, 0.9)
		};
		
		System.out.print("키가 몇 cm인 사람을 찾고 있나요 : ");
		int height = sc.nextInt();
		//키를 주어줌
		
		int idx = Arrays.binarySearch(x, new Physicdata("", height, 0.0), Physicdata.comp);
		//Physicdata의 객체배열 x에 키가 height만한 사람인 객체를 Pysicdata.comp에 의해서 찾아본다.
		
		if (idx < 0)
			System.out.println("요소가 없습니다.");
		else {
			System.out.println("x[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}
}
