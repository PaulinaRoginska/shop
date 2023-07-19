package shop.service;

import shop.model.Order;
import shop.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    List<Order> orders = new ArrayList<>();

    public List<Order> generateOrdersList() {
        return orders;
    }

    public final void addOrder(Order order) {
        orders.add(order);
    }

    public final void removeOrder(Order order) {
        orders.remove(order);
    }

    public final List<Order> getAllOrders() {
        return orders;
    }

    public final Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.orderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public final OrderStatus getOrderStatus(Order order) {
        return order.orderStatus();
    }


    public final void changeOrderStatus(Order order, OrderStatus newStatus) {
        Order updatedOrder = order.withOrderStatus(newStatus);
        int index = orders.indexOf(order);
        if (index != -1) {
            orders.set(index, updatedOrder);
        }
    }
}


