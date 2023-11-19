package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> publications;

	public void PublicationCatalog(List<AnPham> publications) {
		this.publications = publications;
	}

	// Phương thức tính tổng tiền của tất cả các ấn phẩm trong nhà sách
	public double getTotalPrice() {
		double totalPrice = 0;
		for (AnPham publication : publications) {
			totalPrice += publication.getPrice();
		}
		return totalPrice;
	}

	// Phương thức tìm quyển sách tham khảo có chương sách nhiều trang nhất
	public SachThamKhao findReferenceBookWithMostPages() {
		SachThamKhao maxPagesBook = null;
		int maxPages = 0;

		for (AnPham publication : publications) {
			if (publication instanceof SachThamKhao) {
				SachThamKhao referenceBook = (SachThamKhao) publication;
				int totalPages = referenceBook.getChapters().stream().mapToInt(ChuongSach::getPageCount).sum();

				if (totalPages > maxPages) {
					maxPages = totalPages;
					maxPagesBook = referenceBook;
				}
			}
		}

		return maxPagesBook;
	}

	// Phương thức kiểm tra xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không?
	public boolean containsMagazineWithName(String magazineName) {
		for (AnPham publication : publications) {
			if (publication instanceof TapChi && ((TapChi) publication).getMagazineName().equals(magazineName)) {
				return true;
			}
		}
		return false;
	}

	// Phương thức lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
	public List<TapChi> getMagazinesPublishedInYear(int year) {
		List<TapChi> result = new ArrayList<>();
		for (AnPham publication : publications) {
			if (publication instanceof TapChi && publication.getPublishYear() == year) {
				result.add((TapChi) publication);
			}
		}
		return result;
	}

	// Phương thức sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản
	public void sortPublications() {
		Collections.sort(publications, (pub1, pub2) -> {
			int titleComparison = pub1.getTitle().compareTo(pub2.getTitle());
			if (titleComparison != 0) {
				return titleComparison;
			} else {
				return Integer.compare(pub2.getPublishYear(), pub1.getPublishYear());
			}
		});
	}

	// Phương thức thống kê số lượng ấn phẩm theo năm xuất bản
	public Map<Integer, Integer> countPublicationsByYear() {
		Map<Integer, Integer> countByYear = new HashMap<>();
		for (AnPham AnPham : publications) {
			int year = AnPham.getPublishYear();
			countByYear.put(year, countByYear.getOrDefault(year, 0) + 1);
		}
		return countByYear;
	}
}
