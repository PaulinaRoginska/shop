package shop.service;

import shop.model.Client;
import shop.model.Order;
import shop.model.OrderStatus;
import shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final ProductService productService;
    public final List<Order> orders = generateOrders();

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    private List<Order> generateOrders() {
        List<Order> orderList = new ArrayList<>();
        Map<Product, Integer> products = new HashMap<>();
        products.put(productService.products.get(0), 1);
        Map<Product, Integer> products1 = new HashMap<>();
        products1.put(productService.products.get(1), 2);
        Map<Product, Integer> products2 = new HashMap<>();
        products2.put(productService.products.get(2), 3);

        Order order1 = new Order(1, "1/07/2023", 1000, new Client("Anna", "Kowalska", "Warszawa"),
                OrderStatus.PAID, products);
        Order order2 = new Order(2, "2/07/2023", 9001, new Client("Piotr", "Czajka", "Gdańsk"),
                OrderStatus.IN_PREPARATION, products1);
        Order order3 = new Order(3, "3/07/2023", 450, new Client("Ewa", "Cichal", "Gdańsk"),
                OrderStatus.SENT, products2);
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        return orderList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.orderId() == orderId);
    }

}
