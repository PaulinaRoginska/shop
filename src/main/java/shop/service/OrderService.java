package shop.service;

import shop.model.Client;
import shop.model.Order;
import shop.model.OrderStatus;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private int lastOrderId = 0;
    private final ProductService productService;
    private final List<Order> orders = new ArrayList<>();

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(String orderNumber, Client client, OrderStatus orderStatus,
                         Map<Product, Integer> products) {
        Order order = new Order(lastOrderId, orderNumber, client, orderStatus, products);
        orders.add(order);
        lastOrderId++;
    }

    public void removeOrder(final int orderId) {
        orders.removeIf(order -> order.orderId() == orderId);
    }

    public void changeOrderStatus(Order order, OrderStatus newStatus) {
        Order updatedOrder = order.withOrderStatus(newStatus);
        int index = orders.indexOf(order);
        if (index != -1) {
            orders.set(index, updatedOrder);
        }
    }
}
