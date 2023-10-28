package task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		int newSize = elements.length * 2;
		E[] newElements = (E[]) new Object[newSize];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("ngoai le");
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("ngoai le");
		}
		E replacedElement = elements[i];
		elements[i] = e;
		return replacedElement;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
	        growSize();
	    }
	    elements[size] = e;
	    size++;
	    return true; // Trả về true để chỉ ra phần tử đã được thêm thành công
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (size == elements.length) {
			growSize();
		}
		System.arraycopy(elements, i, elements, i + 1, size - i);
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		E removedElement = elements[i]; // Lưu trữ phần tử sẽ bị loại bỏ
		System.arraycopy(elements, i + 1, elements, i, size - i - 1);
		elements[size - 1] = null; // Đặt phần tử cuối cùng về null để tránh tham chiếu không mong muốn
		size--; // Giảm kích thước danh sách

		return removedElement; // Trả về phần tử đã bị loại bỏ
	}

	// It is used to clear all elements in the list.
	public void clear() {
		size = 0;
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (elements[i] == null) {
				if (o == null) {
					return i; // Đối tượng là null và phần tử ở vị trí i cũng là null
				}
			} else {
				if (elements[i].equals(o)) {
					return i; // Đối tượng không phải là null và bằng với phần tử ở vị trí i
				}
			}
		}
		return -1; // Không tìm thấy đối tượng trong danh sách
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		E[] array = (E[]) new Object[size]; // Tạo một mảng mới với kích thước là size
		System.arraycopy(elements, 0, array, 0, size); // Sao chép các phần tử từ danh sách sang mảng mới
		return array;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> cloneList = new MyArrayList<>(size); // Tạo một danh sách mới với kích thước bằng với danh sách hiện tại
		// Sao chép các phần tử từ danh sách hiện tại sang danh sách mới
		System.arraycopy(elements, 0, cloneList.elements, 0, size);
		cloneList.size = size; // Cập nhật kích thước của danh sách mới

		return cloneList;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == null) {
				if (o == null) {
					return true; // Nếu cả hai đều là null, phần tử được tìm thấy
				}
			} else {
				if (elements[i].equals(o)) {
					return true; // Nếu phần tử tại vị trí i bằng với o, phần tử được tìm thấy
				}
			}
		}
		return false; // Không tìm thấy phần tử o trong danh sách
	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
	        if (elements[i] == null) {
	            if (o == null) {
	                return i; // Nếu cả hai đều là null, phần tử được tìm thấy
	            }
	        } else {
	            if (elements[i].equals(o)) {
	                return i; // Nếu phần tử tại vị trí i bằng với o, phần tử được tìm thấy
	            }
	        }
	    }
	    return -1; // Không tìm thấy phần tử o trong danh sách
	    }

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				// Phần tử được tìm thấy tại vị trí i, di chuyển các phần tử phía sau lên trước
				System.arraycopy(elements, i + 1, elements, i, size - i - 1);
				elements[size - 1] = null; // Đặt phần tử cuối cùng về null để tránh tham chiếu không mong muốn
				size--; // Giảm kích thước danh sách
				return true; // Phần tử đã được loại bỏ thành công
			}
		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		E[] tempArray = Arrays.copyOf(elements, size); // Sao chép mảng elements vào một mảng tạm thời
	    Arrays.sort(tempArray, 0, size, c); // Sắp xếp mảng tạm thời
	    System.arraycopy(tempArray, 0, elements, 0, size); // Sao chép mảng tạm thời vào mảng elements
	    }
	public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Thêm phần tử
        myList.add(5);
        myList.add(10);
        myList.add(7);
        myList.add(3);

        // Kiểm tra các phương thức
        System.out.println("Size: " + myList.size());
        System.out.println("Is empty: " + myList.isEmpty());
        System.out.println("Contains 7: " + myList.contains(7));
        System.out.println("Index of 10: " + myList.indexOf(10));
        System.out.println("Last index of 7: " + myList.lastIndexOf(7));
        System.out.println("Element at index 2: " + myList.get(2));

        // Sắp xếp danh sách (sử dụng Comparator)
        myList.sort(Comparator.naturalOrder());

        // In danh sách sau khi sắp xếp
        System.out.print("Sorted List: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        // Xóa phần tử
        int removedElement = myList.remove(2);
        System.out.println("Removed element at index 2: " + removedElement);

        // In danh sách sau khi xóa
        System.out.print("List after removal: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        // Xóa phần tử theo giá trị
        boolean removed = myList.remove(Integer.valueOf(10));
        System.out.println("Removed element 10: " + removed);

        // In danh sách sau khi xóa
        System.out.print("List after removing value 10: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}
