package task2;

/**
 * Lớp SinglyLinkedList<E> định nghĩa một danh sách liên kết đơn chứa các phần tử kiểu E.
 * Danh sách này được triển khai bằng cách sử dụng các đối tượng Node<E> để lưu trữ dữ liệu.
 * Mỗi node trong danh sách chứa một phần tử và một tham chiếu đến node tiếp theo trong danh sách.
 * @param <E> Kiểu dữ liệu của các phần tử trong danh sách.
 */
public class SinglyLinkedList<E> {
    private Node<E> head; // Node đầu tiên trong danh sách
    private Node<E> tail; // Node cuối cùng trong danh sách
    private int size; // Số lượng phần tử trong danh sách

    /**
     * Khởi tạo một danh sách liên kết đơn rỗng.
     */
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Trả về số lượng phần tử trong danh sách.
     * @return Số lượng phần tử trong danh sách.
     */
    public int size() {
        return size;
    }

    /**
     * Kiểm tra xem danh sách có trống hay không.
     * @return True nếu danh sách trống, ngược lại là False.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Trả về phần tử đầu tiên trong danh sách.
     * @return Phần tử đầu tiên trong danh sách hoặc null nếu danh sách trống.
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    /**
     * Trả về phần tử cuối cùng trong danh sách.
     * @return Phần tử cuối cùng trong danh sách hoặc null nếu danh sách trống.
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getData();
    }

    /**
     * Thêm một phần tử vào đầu danh sách.
     * @param e Phần tử cần thêm vào danh sách.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head);
        head = newNode;
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    /**
     * Thêm một phần tử vào cuối danh sách.
     * @param e Phần tử cần thêm vào danh sách.
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    /**
     * Xóa và trả về phần tử đầu tiên trong danh sách.
     * @return Phần tử đầu tiên trong danh sách hoặc null nếu danh sách trống.
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removedData = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return removedData;
    }

    /**
     * Xóa và trả về phần tử cuối cùng trong danh sách.
     * @return Phần tử cuối cùng trong danh sách hoặc null nếu danh sách trống.
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            E removedData = tail.getData();
            head = null;
            tail = null;
            size = 0;
            return removedData;
        }
        Node<E> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        E removedData = tail.getData();
        current.setNext(null);
        tail = current;
        size--;
        return removedData;
    }
}
