package data_structure_recursive;

public class EightQueen {
	static boolean[] flag_a = new boolean[8];
	static boolean[] flag_b = new boolean[15];//위쪽 대각선
	static boolean[] flag_c = new boolean[15];//아래쪽 대각선
	static int[] pos = new int[8];

	static void print() {
		for(int i = 0; i < 8; i++) {
			System.out.printf("%2d", pos[i]);
		}
		System.out.println();
	}

	static void set(int i) {
		for(int j = 0; j < 8; j++) {
			if(flag_a[j] == false && flag_b[i + j] == false && flag_c[i-j+7] == false) {
				pos[i] = j;
				if(i == 7) {
					print();//print메소드 호출
				}
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = true;
					set(i + 1);//본인을 i+1하여 다시 호출 //위로 반복하는것
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
					//본인을 부르는 것을 i == 7까지 모두 마치고 돌아오면서 다음단계 실행하며 false로 다시 초기화 하는 과정
					//이후 j++을 실행하여 다음 for문을 반복하게됨
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
