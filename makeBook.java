import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class makeBook {
	private String serial;
	private String author;
	private String title;
	private String category;
	private String date;
	private Scanner sc;
	
	public makeBook(Scanner sc) {
		this.sc = sc;
	}
	public void addBook(BookShelf bookshelf) {
		System.out.print("��ȣ: ");
		this.serial = sc.nextLine();
		System.out.print("����: ");
		this.author = sc.nextLine();
		System.out.print("����: ");
		this.title = sc.nextLine();
		System.out.print("����: ");
		this.category = sc.nextLine();
		Date d = new Date();
		SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
		date = Date.format(d);
		bookshelf.push_Book(serial, author, title, category, date);
	}
}
