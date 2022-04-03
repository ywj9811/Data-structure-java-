package sort;

public class BinarySort {
	static void insertion(int a[], int n) {
		int i;
		for(i = 1; i < n; i++) {
			int tmp = a[i]; //�ϴ� tmp�� ������ ���� �־��
			if(a[i-1] > tmp) { //���� ���ĵ� ���� ū���� ������ ������ �۰ų� ���ٸ�
							   //�̹� ������ �����ؼ� ������ ���ִ� ���� ���� �ǳʶٸ� ��
				int pl = 0; //�̹� ���ĵ� �κп��� �����˻��� �ϱ� ������ ���� �Ǿ�
				int pr = i-1; //���������� �̹� ���ĵ� �κ��� �ִ�.
				int pc = (pl + pr)/2; //�߾Ӱ�
				
				do {
					if(a[pc] == tmp) {
						pl = pc; break; //pl�� �� �����Ұ��� ã��
					}
					else if(a[pc] > tmp)
						pr = pc - 1;
					else
						pl = pc + 1;
				} while(pl <= pr);//pl�� pr�� �������� ���� �˻��� ����������
				//������ tmp�� ���� ���ĵ� �������� ���ٴ� �����ϱ�
				
				for(int j = i; j > pl; j--) {
					//pl�������� ������ �Ϸ�� ����
					//�̶��� ���� pl�� pr�� �Ȱ��ų�
					//������ pl = pc�� ���� pc���� pl�� �����ִ� ����
					//���� pl���� ������ �ڷ� �̷�� pl�� tmp�� ������
						a[j] = a[j-1];
				}
				
				a[pl] = tmp;
			}
		}
	}
}
