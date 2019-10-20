public class LibraryMain {
	public static void main(String[] args) {
		int whileTrue = 1;
		Library lib = new Library();
		while(whileTrue == 1) {
			whileTrue = lib.selMenu();
		}
	}
}
