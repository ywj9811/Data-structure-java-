package list;

import java.util.Comparator;
import java.util.Scanner;

public class LinkedListTester {
	static Scanner sc = new Scanner(System.in);
	
	static class Data{//�����ʹ� ȸ����ȣ + �̸�
		static final int No = 1; //��ȣ�� �Է¹޽��ϱ�?
		static final int Name = 2; //�̸��� �Է¹޽��ϱ�?
		
		private Integer no; //ȸ����ȣ
		private String name; //�̸�
		
		public String toString() {
			return "(" + no + ")" + name;
		} //���ڿ��� ��ȯ
		
		void scanData(String guide, int sw) {
			System.out.println(guide + "�� �����͸� �Է��ϼ���.");
			
			if((sw & No) == No) {
				System.out.print("��ȣ : ");
				no = sc.nextInt();
			}
			
			if((sw & Name) == Name) {
				System.out.print("�̸� : ");
				name = sc.next();
			}
		} //�����͸� �Է¹����� 
		
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();
		//ȸ����ȣ�� ������ �ű�� comparator
		
		private static class NoOrderComparator implements Comparator<Data>{ //����
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0; //d1�� ũ�� 1 ������ -1 ������ 0
			}
		}
		
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();
		//ȸ���̸��� ������ �ű�� comparator
		
		private static class NameOrderComparator implements Comparator<Data>{ //����
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name); //compareTo �޼ҵ带 �̿��Ͽ� 1 0 -1 ��ȯ
			}
		}
	}
	
	enum Menu {
		ADD_FIRST(    "�Ӹ��� ��� ����"),
		ADD_LAST(     "������ ��� ����"),
		RMV_FIRST(    "�Ӹ� ��� ����"),
		RMV_LAST(     "���� ��� ����"),
		RMV_CRNT(     "���� ��带 ����"),
		CLEAR(        "��� ��带 ����"),
		SEARCH_NO(    "��ȣ�� �˻�"),
		SEARCH_NAME(  "�̸����� �˻�"),
		NEXT(         "���� ��带 �ϳ� �������� �̵�"),
		PRINT_CRNT(   "���� ��带 ���"),
		DUMP(         "��� ��带 ���"),
		TERMINATE(    "����");
		
		private final String message; //����� ���ڿ�
		
		static Menu MenuAt(int idx) {
			for(Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m; //������ idx�� ���Ÿ� ��ȯ
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
				data.scanData("�Ӹ��� ����", Data.No | Data.Name);
				list.addFirst(data);
				break;
				
			case ADD_LAST : 
				data = new Data();
				data.scanData("������ ����", Data.No | Data.Name);
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
				temp.scanData("�˻�", Data.No);
				ptr = list.search(temp, Data.NO_ORDER);
				
				if(ptr == null)
					System.out.println("�� ��ȣ�� �����Ͱ� �����ϴ�.");
				else
					System.out.println("�˻� ���� : " + ptr);
				break;
				
			case SEARCH_NAME : 
				temp.scanData("�˻�", Data.Name);
				ptr = list.search(temp, Data.NAME_ORDER );
				
				if(ptr == null)
					System.out.println("�� �̸��� �����Ͱ� �����ϴ�.");
				else
					System.out.println("�˻� ���� : " + ptr);
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

