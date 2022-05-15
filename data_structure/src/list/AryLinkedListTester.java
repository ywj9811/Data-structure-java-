package list;

import java.util.Comparator;
import java.util.Scanner;

public class AryLinkedListTester {
	static Scanner sc = new Scanner(System.in);
	
	static class Data{//데이터는 회원번호 + 이름
		static final int No = 1; //번호를 입력받습니까?
		static final int Name = 2; //이름을 입력받습니까?
		
		private Integer no; //회원번호
		private String name; //이름
		
		public String toString() {
			return "(" + no + ")" + name;
		} //문자열로 반환
		
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");
			
			if((sw & No) == No) {
				System.out.print("번호 : ");
				no = sc.nextInt();
			}
			
			if((sw & Name) == Name) {
				System.out.print("이름 : ");
				name = sc.next();
			}
		} //데이터를 입력받음ㅎ 
		
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();
		//회원번호로 순서를 매기는 comparator
		
		private static class NoOrderComparator implements Comparator<Data>{ //구현
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0; //d1이 크면 1 작으면 -1 같으면 0
			}
		}
		
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();
		//회원이름로 순서를 매기는 comparator
		
		private static class NameOrderComparator implements Comparator<Data>{ //구현
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name); //compareTo 메소드를 이용하여 1 0 -1 반환
			}
		}
	}
	
	enum Menu {
		ADD_FIRST(    "머리에 노드 삽입"),
		ADD_LAST(     "꼬리에 노드 삽입"),
		RMV_FIRST(    "머리 노드 삭제"),
		RMV_LAST(     "꼬리 노드 삭제"),
		RMV_CRNT(     "선택 노드를 삭제"),
		CLEAR(        "모든 노드를 삭제"),
		SEARCH_NO(    "번호로 검색"),
		SEARCH_NAME(  "이름으로 검색"),
		NEXT(         "선택 노드를 하나 뒤쪽으로 이동"),
		PRINT_CRNT(   "선택 노드를 출력"),
		DUMP(         "모든 노드를 출력"),
		TERMINATE(    "종료");
		
		private final String message; //출력할 문자열
		
		static Menu MenuAt(int idx) {
			for(Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m; //서수가 idx인 열거를 반환
			return null;
		}
		
		Menu(String string){
			message = string;
		}
		
		String getMessage() {
			return message;
		}
	}
	
	static Menu SelectMenu() {
		int key;
		do {
			for(Menu m : Menu.values()) {
				System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
				if((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		}while(key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();
		
		LinkedList<Data> list = new LinkedList<Data>();
		
		do {
			switch(menu = SelectMenu()) {
			
			case ADD_FIRST : 
				data = new Data();
				data.scanData("머리에 삽입", Data.No | Data.Name);
				list.addFirst(data);
				break;
				
			case ADD_LAST : 
				data = new Data();
				data.scanData("꼬리에 삽입", Data.No | Data.Name);
				list.addFirst(data);
				break;
				
			case RMV_FIRST : 
				data = new Data();
				list.removeFirst();
				break;
				
			case RMV_LAST : 
				data = new Data();
				list.removeLast();
				break;
				
			case RMV_CRNT : 
				data = new Data();
				list.removeCurrentNode();
				break;
				
			case SEARCH_NO : 
				temp.scanData("검색", Data.No);
				ptr = list.search(temp, Data.NO_ORDER);
				
				if(ptr == null)
					System.out.println("그 번호의 데이터가 없습니다.");
				else
					System.out.println("검색 성공 : " + ptr);
				break;
				
			case SEARCH_NAME : 
				temp.scanData("검색", Data.Name);
				ptr = list.search(temp, Data.NAME_ORDER );
				
				if(ptr == null)
					System.out.println("그 이름의 데이터가 없습니다.");
				else
					System.out.println("검색 성공 : " + ptr);
				break;
				
			case NEXT :
				list.next();
				break;
				
			case PRINT_CRNT :
				list.printCurrentNode();
				break;
			
			case DUMP :
				list.dump();
				break;
				
			case CLEAR :
				list.clear();
				break;
			}
		} while( menu != Menu.TERMINATE);
	}
}
