package task2;

import java.util.List;

public class SachThamKhao extends AnPham {
	private String field;
	private List<ChuongSach> chapters;

	public SachThamKhao(String title, int pageCount, int publishYear, String author, double price, String field,
			List<ChuongSach> chapters) {
		super(title, pageCount, publishYear, author, price);
		this.field = field;
		this.chapters = chapters;
	}

	@Override
	public String getType() {
		return "Reference Book";
	}

	@Override
	public boolean isMagazinePublishedLastDecade() {
		return false; // Sách tham khảo không áp dụng cho việc kiểm tra thời gian xuất bản của tạp chí
	}

	// Getter method for field
	public String getField() {
		return field;
	}

	// Getter method for chapters
	public List<ChuongSach> getChapters() {
		return chapters;
	}
}
