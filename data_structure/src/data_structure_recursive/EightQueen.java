package data_structure_recursive;

public class EightQueen {
	static boolean[] flag_a = new boolean[8];
	static boolean[] flag_b = new boolean[15];//���� �밢��
	static boolean[] flag_c = new boolean[15];//�Ʒ��� �밢��
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
					print();//print�޼ҵ� ȣ��
				}
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = true;
					set(i + 1);//������ i+1�Ͽ� �ٽ� ȣ�� //���� �ݺ��ϴ°�
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
					//������ �θ��� ���� i == 7���� ��� ��ġ�� ���ƿ��鼭 �����ܰ� �����ϸ� false�� �ٽ� �ʱ�ȭ �ϴ� ����
					//���� j++�� �����Ͽ� ���� for���� �ݺ��ϰԵ�
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
