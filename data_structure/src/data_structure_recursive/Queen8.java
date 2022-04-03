package data_structure_recursive;


public class Queen8 {
	static int[] pos = new int[8];
	
	static void print() {
		for(int i = 0; i < 8; i++) {
			System.out.printf("%2d", pos[i]); //2d�� ������ �ΰ� ����
		}
		System.out.println();
	}
	
	static void set(int i) {
		for(int j = 0; j < 8; j++) {
			pos[i] = j;//�� ���� �ϳ��� ��ġ�ϴ� ����� ��
			if(i == 7)
				print();//print�޼ҵ� ȣ��
			else
				set(i + 1);//i���� �ϳ��� ������Ų��.
				//1�� ������Ŵ�� ���ÿ� �ڱ� �ڽ��� �ٽ� ȣ��
		}
	}
	
	public static void main(String[] args) {
		set(0); //i�� 0�� �־��ָ鼭 ��ŸƮ.
	}
}
