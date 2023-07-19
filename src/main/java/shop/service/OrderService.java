package shop.service;

import shop.model.Order;
import shop.model.OrderStatus;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    List<Order> orders = new ArrayList<>();

    public List<Order> generateOrdersList() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void getAllOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public Order getOrderById(final int orderId) {
        for (Order order : orders) {
            if (order.orderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public OrderStatus getOrderStatus(Order order) {
        return order.orderStatus();
    }

    public void changeOrderStatus(Order order, OrderStatus newStatus) {
        Order updatedOrder = order.withOrderStatus(newStatus);
        int index = orders.indexOf(order);
        if (index != -1) {
            orders.set(index, updatedOrder);
        }
    }
}


