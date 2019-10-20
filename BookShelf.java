import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class BookShelf {
	private String[] serial;
	private String[] author;
	private String[] title;
	private String[] category;
	private String[] date;
	private int num;
	private Vector<String> book_List;
	private Vector<String> lent_Vector;
	private Vector<String> lentDate;
	private Scanner sc;
	private Date d;
	private SimpleDateFormat Date;

	public BookShelf() {
		serial = new String[100];
		author = new String[100];
		title = new String[100];
		category = new String[100];
		date = new String[100];
		num = 0;
		book_List = new Vector<String>();
		lent_Vector = new Vector<String>();
		lentDate = new Vector<String>();
		sc = new Scanner(System.in);
		Date = new SimpleDateFormat("yyyy-MM-dd");
	}

	public void push_Book(String serial, String author, String title, String category, String date) {
		this.serial[num] = serial;
		this.author[num] = author;
		this.title[num] = title;
		this.category[num] = category;
		this.date[num] = date;
		book_List.addElement(title);
		num++;
	}

	public void searchBook_BookNum(String bookNum) {
		System.out.println(bookNum + "");
	}

	public void Lent() {
		String num;
		String YorN;
		String date;
		int whileTrue = 1;
		showList();
		System.out.println("���� å�� �������ּ���.(��. 2)");
		num = sc.nextLine();
		String selectBook = book_List.get(Integer.parseInt(num) - 1);
		showBookInfo(selectBook);
		while (whileTrue == 1) {
			System.out.println("�����ðڽ��ϱ�? (y or n)");
			YorN = sc.nextLine();
			if (YorN.equals("y") || YorN.equals("Y")) {
				lent_Vector.addElement(selectBook);
				book_List.removeElement(selectBook);
				d = new Date();
				date = Date.format(d);
				lentDate.addElement(date);
				whileTrue = 2;
			} 
			else if (YorN.equals("n") || YorN.equals("N")) {
				System.out.println("ó������ ���ư��ϴ�.");
				whileTrue = 2;
			} 
			else {
				System.out.println("�ٽ� �Է����ּ���");
			}
		}
	}
	
	public void returnBook() {
		String num;
		int put;
		String YorN;
		int whileTrue = 1;
		System.out.print("�ݳ��� å�� �ø����ȣ�� �Է��ϼ���: ");
		num = sc.nextLine();
		put = findVector(num);
		if(put == -1) {
			System.out.println("�������� �ʴ� �ø����ȣ�Դϴ�.");
		}
		else {
			showInfoOneLine(put);
			while (whileTrue == 1) {
				System.out.println("�ݳ��Ͻðڽ��ϱ�? (y or n)");
				YorN = sc.nextLine();
				if (YorN.equals("y") || YorN.equals("Y")) {
					book_List.addElement(this.title[put]);
					lent_Vector.removeElement(this.title[put]);					
					lentDate.remove(put);
					whileTrue = 2;
				} 
				else if (YorN.equals("n") || YorN.equals("N")) {
					System.out.println("ó������ ���ư��ϴ�.");
					whileTrue = 2;
				} 
				else {
					System.out.println("�ٽ� �Է����ּ���");
				}
			}
		}
	}

	public void showInfoOneLine(int k) {
		System.out.println("��ȣ: " + this.serial[k]);
		System.out.println("����: " + this.author[k]);
		System.out.println("����: " + this.title[k]);
		System.out.println("����: " + this.category[k]);
		System.out.println("��ϳ�¥: " + this.date[k]);
	}
	
	public void showBookInfo(String book) {
		for (int k = 0; k < this.num; k++) {
			if (title[k].equals(book)) {
				System.out.println("��ȣ: " + this.serial[k]);
				System.out.println("����: " + this.author[k]);
				System.out.println("����: " + this.title[k]);
				System.out.println("����: " + this.category[k]);
				System.out.println("��ϳ�¥: " + this.date[k]);
				break;
			}
		}
	}
	
	public int findVector(String serial) {
		for(int k = 0; k < num; k++) {
			if(this.serial[k].equals(serial)){
				return k;
			}
		}
		return -1;
	}
	
	public void showList() {
		System.out.println("�ѤѤѤѵ�����ϤѤѤѤ�");
		List();
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤ�");
	}
	
	public void showListLent() {
		System.out.println("�ѤѤѤѴ�����Ȳ�ѤѤѤ�");
		listLent();
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤ�");
	}

	private void List() {
		for (int k = 0; k < book_List.size(); k++) {
			System.out.println((k + 1) + ": " + this.book_List.get(k) + " ��ϳ�¥: " + this.date[k]);
		}
	}

	private void listLent() {
		for (int k = 0; k < lent_Vector.size(); k++) {
			System.out.println((k + 1) + ": " + this.lent_Vector.get(k) + " ���⳯¥: " + this.lentDate.get(k));
		}
	}
}