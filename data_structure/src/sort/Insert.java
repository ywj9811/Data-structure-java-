package sort;

public class Insert {
	static void insertionSort(int[] a, int n) {
		for(int i = 0; i < n; i++) {
			int j;
			int tmp = a[i];
			for(j = i; j > 0 && a[j-1] > tmp; j--) 
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}
}
