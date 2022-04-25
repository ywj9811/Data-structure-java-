package set;

import java.util.ArrayList;
import java.util.Collections;

public class IntSortedSet {
	private int max;
	private int num;
	private ArrayList<Integer> set = new ArrayList<Integer>();

	public IntSortedSet(int capacity) {
		num = 0;
		max = capacity;
	}

	public int capacity() {
		return max;
	}//�ִ�ũ�� ��ȯ

	public int size() {
		return num;
	}//���� ����� ����

	public int indexOf(int n) {
		for(int i = 0; i < num; i++) {
			if(set.get(i) == n) {
				return i;
			}
		}
		return -1;//�ݺ����� �� ���Ҵµ� �ش� �޼ҵ带 ��ȯ���� ���ϸ� �װ��� ���� ���°�
	}

	public boolean contains(int n) {
		//System.out.println(indexOf(n));
		return(indexOf(n) != -1) ? true : false;
	}

	public boolean add(int n) {
		if(num >= max || contains(n) == true) {
			return false;
		}
		else {
			set.add(n);
			num++;
			Collections.sort(set);
			return true;
		}
	}

	public boolean add(IntSortedSet s1) {
		boolean tf = false; 
		for(int i = 0; i < s1.max; i++) {
			if(add(s1.set.get(i)) == true)
				tf = true;
		}

		return tf;
	}

	public boolean remove(int n) {
		int idx;

		if(num <= 0 || (idx = indexOf(n)) == -1) //n�� ���������� �ʴٸ� false
			return false;
		else {
			set.remove(idx);
			num--;
			return true;
		}
	}

	public boolean remove(IntSortedSet s1) {
		boolean tf = false;

		for(int i = 0; i < max; i++) {
			int j = 0;
			for(; j < s1.max; j++) {
				if(set.get(i) == s1.set.get(j)) {
					remove(set.get(i));
					tf = true;
					break;
				}
			}
		}

		return tf;
	}

	public void copyTo(IntSortedSet s) {
		int n = (s.max < num) ? s.max : num; //s�� �ִ��Ұ� ���� set�� ����Һ��� �۴ٸ� s.max��ŭ ����, �ƴ϶�� num��ŭ �� ����
		for(int i = 0; i < n; i++) {
			s.set.add(set.get(i));
			s.num = n; //�����Ѹ�ŭ s�� num����
		}
	}

	public void copyFrom(IntSortedSet s1) {
		int n = (max < s1.num) ? max : s1.num;
		for(int i = 0; i < n; i++) {
			set.add(s1.set.get(i));
			num = n;
		}
	}

	public boolean equalTo(IntSortedSet s) {
		if (num != s.num)
			return false;

		for(int i = 0; i < num; i++) {
			int j = 0;
			for( ; j < s.num; j++)
				if(set.get(i) == s.set.get(j))
					break;
			if(j == s.num)
				return false;
		}
		return true;
	}

	public void unionOf(IntSortedSet s1, IntSortedSet s2) {
		copyFrom(s1);
		for(int i = 0; i < s2.num; i++)
			add(s2.set.get(i));
	}
	//set���ٰ� s1�� s2�� ��� ����

	public String toString() {
		return set.toString();
	}

	public boolean isEmpty() {
		if(num == 0)
			return true;
		else
			return false;
	} //���������� Ȯ��

	public boolean isFull() {
		if(num == max)
			return true;
		else
			return false;
	} //����á���� Ȯ��

	public void clear() {
		for(int i = 0; i < max; i++) {
			remove(set.get(i));
		}
	}

	public boolean retain(IntSortedSet s1) {
		boolean tf = false;

		out : for(int i = 0; i < max; i++) {
			for(int j = 0; j < s1.max; j++) {
				if(set.get(i) == s1.set.get(j))
					continue out;
			}
			remove(set.get(i));
			tf = true;
		}

		return tf;
	}

	public boolean isSubsetOf(IntSortedSet s) {
		boolean tf = true;
		out : for(int i = 0; i < max; i++ ) {
			for(int j = 0; j < s.max; j++) {
				if(set.get(i) == s.set.get(j))
					continue out;
			}
			tf = false;
		}
		return tf;
	}

	public boolean isProperSubsetOf(IntSortedSet s) {
		boolean tf = true;
		out : for(int i = 0; i < max; i++ ) {
			for(int j = 0; j < s.max; j++) {
				if(set.get(i) == s.set.get(j))
					continue out;
			}
			tf = false;
		}
		if(num < s.num)
			return tf;
		else
			return false;
	}

	public void intersectionOf(IntSortedSet s1, IntSortedSet s2) {
		s1.retain(s2);
		copyFrom(s1);
	}

	public void differenceOf(IntSortedSet s1, IntSortedSet s2) {
		s1.remove(s2);
		copyFrom(s1);
	}
}

