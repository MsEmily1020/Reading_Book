package book.vo;

public class BookVO {
	int isbn;
	String bookName;
	String publish;
	String author;
	int price;
	String category;
	
	public BookVO() {};
	
	public BookVO(int isbn, String bookName, String publish, String author, int price, String category) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.publish = publish;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getPublish() {
		return publish;
	}
	
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", bookName=" + bookName + ", publish=" + publish + ", price=" + price
				+ ", category=" + category + "]";
	}
}
