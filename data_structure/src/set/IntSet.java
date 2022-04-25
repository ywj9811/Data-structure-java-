package set;

public class IntSet {
	private int max;
	private int num;
	private int[] set;

	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max];
		}
		catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public int capacity() {
		return max;
	}//최대크기 반환

	public int size() {
		return num;
	}//현재 요소의 개수

	public int indexOf(int n) {
		for(int i = 0; i < num; i++) {
			if(set[i] == n)
				return i;
		}
		return -1;//반복문을 다 돌았는데 해당 메소드를 반환하지 못하면 그것은 값이 없는것
	}

	public boolean contains(int n) {
		return(indexOf(n) != -1) ? true : false;
	}

	public boolean add(int n) {
		if(num >= max || contains(n) == true)
			return false;
		else {
			set[num++] = n;
			return true;
		}
	}
	
	public boolean add(IntSet s1) {
		boolean tf = false; 
		for(int i = 0; i < s1.max; i++) {
			if(add(s1.set[i]) == true)
				tf = true;
		}

		return tf;
	}

	public boolean remove(int n) {
		int idx;

		if(num <= 0 || (idx = indexOf(n)) == -1) //n을 가지고있지 않다면 false
			return false;
		else {
			set[idx] = set[--num];
			return true;
		}
	}
	
	public boolean remove(IntSet s1) {
		boolean tf = false;

		for(int i = 0; i < max; i++) {
			int j = 0;
			for(; j < s1.max; j++) {
				if(set[i] == s1.set[j]) {
					remove(set[i]);
					tf = true;
					break;
				}
			}
		}

		return tf;
	}

	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num; //s의 최대요소가 나의 set의 현요소보다 작다면 s.max만큼 복사, 아니라면 num만큼 다 복사
		for(int i = 0; i < n; i++) {
			s.set[i] = set[i];
			s.num = n; //복사한만큼 s의 num수정
		}
	}

	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for(int i = 0; i < n; i++) {
			set[i] = s.set[i];
			num = n;
		}
	}

	public boolean equalTo(IntSet s) {
		if (num != s.num)
			return false;

		for(int i = 0; i < num; i++) {
			int j = 0;
			for( ; j < s.num; j++)
				if(set[i] == s.set[j])
					break;
			if(j == s.num)
				return false;
		}
		return true;
	}

	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1);
		for(int i = 0; i < s2.num; i++)
			add(s2.set[i]);
	}
	//set에다가 s1과 s2를 모두 넣음

	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		for(int i = 0; i < num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}

	public boolean isEmpty() {
		if(num == 0)
			return true;
		else
			return false;
	} //공집합인지 확인

	public boolean isFull() {
		if(num == max)
			return true;
		else
			return false;
	} //가득찼는지 확인

	public void clear() {
		for(int i = 0; i < max; i++) {
			remove(set[i]);
		}
	}

	public boolean retain(IntSet s1) {
		boolean tf = false;

		out : for(int i = 0; i < max; i++) {
			for(int j = 0; j < s1.max; j++) {
				if(set[i] == s1.set[j])
					continue out;
			}
			remove(set[i]);
			tf = true;
		}

		return tf;
	}
	
	public boolean isSubsetOf(IntSet s) {
		boolean tf = true;
		out : for(int i = 0; i < max; i++ ) {
			for(int j = 0; j < s.max; j++) {
				if(set[i] == s.set[j])
					continue out;
			}
			tf = false;
		}
		return tf;
	}
	
	public boolean isProperSubsetOf(IntSet s) {
		boolean tf = true;
		out : for(int i = 0; i < max; i++ ) {
			for(int j = 0; j < s.max; j++) {
				if(set[i] == s.set[j])
					continue out;
			}
			tf = false;
		}
		if(num < s.num)
			return tf;
		else
			return false;
	}
	
	public void intersectionOf(IntSet s1, IntSet s2) {
		s1.retain(s2);
		copyFrom(s1);
	}
	
	public void differenceOf(IntSet s1, IntSet s2) {
		s1.remove(s2);
		copyFrom(s1);
	}
}
