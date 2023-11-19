package task2;

abstract class AnPham {
	protected String title;
	protected int pageCount;
	protected int publishYear;
	protected String author;
	protected double price;

	public AnPham(String title, int pageCount, int publishYear, String author, double price) {
		this.title = title;
		this.pageCount = pageCount;
		this.publishYear = publishYear;
		this.author = author;
		this.price = price;
	}

	// Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo)
	public abstract String getType();

	// Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây 10
	// năm hay không
	public abstract boolean isMagazinePublishedLastDecade();

	// Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
	public boolean hasSameTypeAndAuthor(AnPham other) {
		return this.getType().equals(other.getType()) && this.author.equals(other.author);
	}

	// Getter methods

	public String getTitle() {
		return title;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
}
