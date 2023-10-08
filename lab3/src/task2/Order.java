package task2;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

    public Order(OrderItem[] items) {
        this.items = items;
    }

    // Tính tổng chi phí của đơn hàng
    public double cost() {
        double totalCost = 0.0;
        for (OrderItem item : items) {
            totalCost += item.p.getPrice() * item.quantity;
        }
        return totalCost;
    }

    // Kiểm tra xem sản phẩm có trong đơn hàng không (sử dụng binary search)
    public boolean contains(Product p) {
        Product[] products = new Product[items.length];
        for (int i = 0; i < items.length; i++) {
            products[i] = items[i].p;
        }
        Arrays.sort(products, Comparator.comparing(Product::getId));

        int index = Arrays.binarySearch(products, p, Comparator.comparing(Product::getId));
        return index >= 0;
    }

    // Lọc các sản phẩm theo loại (sử dụng linear search)
    public Product[] filter(String type) {
        int count = 0;
        for (OrderItem item : items) {
            if (item.p.getType().equals(type)) {
                count++;
            }
        }

        Product[] filteredProducts = new Product[count];
        int index = 0;
        for (OrderItem item : items) {
            if (item.p.getType().equals(type)) {
                filteredProducts[index++] = item.p;
            }
        }

        return filteredProducts;
    }

    public static void main(String[] args) {
        Product product1 = new Product("1", "Product 1", 10.0, "Type1");
        Product product2 = new Product("2", "Product 2", 15.0, "Type2");

        OrderItem item1 = new OrderItem(product1, 2);
        OrderItem item2 = new OrderItem(product2, 3);

        OrderItem[] items = { item1, item2 };
        Order order = new Order(items);

        System.out.println("Total cost: $" + order.cost());

        Product searchProduct = new Product("1", "Product 1", 10.0, "Type1");
        System.out.println("Contains Product 1: " + order.contains(searchProduct));

        Product[] filteredProducts = order.filter("Type2");
        System.out.println("Filtered Products:");
        for (Product product : filteredProducts) {
            System.out.println(product.getName());
        }
    }

}
