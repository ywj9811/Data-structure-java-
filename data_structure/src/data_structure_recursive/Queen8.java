package data_structure_recursive;


public class Queen8 {
	static int[] pos = new int[8];
	
	static void print() {
		for(int i = 0; i < 8; i++) {
			System.out.printf("%2d", pos[i]); //2d는 공간을 두개 마련
		}
		System.out.println();
	}
	
	static void set(int i) {
		for(int j = 0; j < 8; j++) {
			pos[i] = j;//각 열에 하나씩 배치하는 경우의 수
			if(i == 7)
				print();//print메소드 호출
			else
				set(i + 1);//i값을 하나씩 증가시킨다.
				//1씩 증가시킴과 동시에 자기 자신을 다시 호출
		}
	}
	
	public static void main(String[] args) {
		set(0); //i에 0을 넣어주면서 스타트.
	}
}
