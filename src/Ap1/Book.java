package Ap1;

public class Book extends Item implements IRenewable {

	private String isbn;
	private String author;
	
	public Book(String isbn, String title, String author, String publisher, int year) {
		super(title, publisher, year);
		this.isbn = isbn;
		this.author = author;
	}
	
	@Override
	public void renew() {
		if(isAvailable) {
			borrow();
		} else {
			System.out.println("Livro '" + this.title + "' renovado.");
		}
	}
	
	@Override
	public void showDetails() {
		System.out.println("Livro: '" + this.title + "'(ISBN:" + this.isbn + "), autoria de "
				+ this.author + ", publicado por " + this.publisher + " em " + this.year);
	}
	
	@Override
	public String toString() {
		return "LIVRO ISBN: " + this.isbn;
	}
}
