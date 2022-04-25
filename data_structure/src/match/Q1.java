package match;

import java.util.Scanner;

public class Q1 {
	static int bfMatch(String txt, String pat) {
		int pt = 0;
		int pp = 0;
		
		//int cnt = 0;
		
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
//				System.out.print(cnt + " ");
//				System.out.println(txt);
//				if(pp==0)
//					System.out.println("  +");
//				for(int i = 0; i < pp; i++) {
//					System.out.print(" ");
//					if(i == pp-1)
//						System.out.println("  +");
//				}
//				System.out.println("  " + pat + "\n");
				pt++;
				pp++;
			} else {
//				System.out.print(cnt + " ");
//				System.out.println(txt);
//				if(pp==0)
//					System.out.println("  |");
//				for(int i = 0; i < pp; i++) {
//					System.out.print(" ");
//					if(i == pp-1)
//						System.out.println("  |");
//				}
//				System.out.println("  " + pat + "\n");
				pt = pt - pp + 1;
				pp = 0;
//				cnt++;
			}
		}
		
		if(pp == pat.length())
			return pt-pp;
		
		return -1;
	}
	
	static int bfMatchLast(String txt, String pat) {
		int pt = txt.length()-1;
		int pp = pat.length()-1;
		
		int cnt = 0;
		
		while(pt >= 0 && pp >= 0) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt--;
				pp--;
				cnt++;
			} else {
				pt = pt + cnt - 1;
				pp = pat.length()-1;
				cnt = 0;
			}
		}
		
		if(pp < 0)
			return pt + cnt;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = sc.next();
		
		System.out.print("패턴 : ");
		String s2 = sc.next();
		
		int idx = bfMatch(s1, s2);
		
		if(idx == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			int len = 0;
			for(int i = 0; i < idx; i++)
				len += s1.substring(i, i+1).getBytes().length;
			len += s2.length();
		
			System.out.println((idx + 1) + "번재 문자부터 일치합니다.");
			System.out.println("텍스트 :" + s1);
			System.out.printf(String.format("패턴:%%%ds\n", len), s2);
		}
		
		int idx2 = bfMatchLast(s1, s2);
		
		if(idx2 == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			System.out.println((idx2 - 1) + "번재 문자부터 일치합니다.");
			System.out.println("텍스트 :" + s1);
			System.out.println(s2);
			
		}
	}
}
