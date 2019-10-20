import java.util.Scanner;

public class Library {
	
	private Scanner sc;
	private BookShelf bookshelf;
	private makeBook makebook;
	public Library() {		
		sc = new Scanner(System.in);
		bookshelf = new BookShelf();
		makebook = new makeBook(sc);
	}
	
	public void showMenu() {
		System.out.println("1. 대출");
		System.out.println("2. 반납");
		System.out.println("3. 대출현황");
		System.out.println("9. 책 추가");
		System.out.println("q. 종료");
	}
	
	public int selMenu() {
		String num;
		showMenu();
		num = sc.nextLine();
		
		if( num.equals("1")) {
			bookshelf.Lent();
			return 1;
		}
		else if( num.equals("2")) {
			bookshelf.returnBook();
			return 1;
		}
		else if( num.equals("3")) {
			bookshelf.showListLent();
			return 1;
		}
		else if( num.equals("9")) {
			makebook.addBook(bookshelf);
			return 1;
		}
		else if( num.equals("q") || num.equals("Q")) {
			System.out.println("프로그램을 종료합니다.");
			return 2;
		}
		else {
			System.out.println("제대로 쳐주세요");
			return 1;
		}
		
	}
}
