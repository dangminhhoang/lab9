package task2;

public class TapChi extends AnPham {
	private String magazineName;

	public TapChi(String title, int pageCount, int publishYear, String author, double price, String magazineName) {
		super(title, pageCount, publishYear, author, price);
		this.magazineName = magazineName;
	}

	@Override
	public String getType() {
		return "Magazine";
	}

	@Override
	public boolean isMagazinePublishedLastDecade() {
		return getPublishYear() >= 2011 && getPublishYear() <= 2020;
	}

	// Getter method for magazineName
	public String getMagazineName() {
		return magazineName;
	}
}
