package sort;

public class BinarySort {
	static void insertion(int a[], int n) {
		int i;
		for(i = 1; i < n; i++) {
			int tmp = a[i]; //일단 tmp에 현재의 값을 넣어둠
			if(a[i-1] > tmp) { //만약 정렬된 가장 큰값이 현재의 값보다 작거나 같다면
							   //이미 본인을 포함해서 정렬이 돼있는 상태 따라서 건너뛰면 됨
				int pl = 0; //이미 정렬된 부분에만 이진검색을 하기 때문에 왼쪽 맨앞
				int pr = i-1; //마찬가지로 이미 정렬된 부분의 최대.
				int pc = (pl + pr)/2; //중앙값
				
				do {
					if(a[pc] == tmp) {
						pl = pc; break; //pl에 값 삽입할거임 찾음
					}
					else if(a[pc] > tmp)
						pr = pc - 1;
					else
						pl = pc + 1;
				} while(pl <= pr);//pl과 pr이 같아지는 순간 검색이 끝나버리니
				//무조건 tmp의 값이 정렬된 마지막값 보다는 작으니까
				
				for(int j = i; j > pl; j--) {
					//pl전까지는 정렬이 완료된 상태
					//이때는 이제 pl과 pr이 똑같거나
					//위에서 pl = pc를 통해 pc값이 pl에 들어와있는 상태
					//따라서 pl까지 값들을 뒤로 미루고 pl에 tmp를 넣을것
						a[j] = a[j-1];
				}
				
				a[pl] = tmp;
			}
		}
	}
}
