package shop.service;

import shop.Main;
import shop.model.Category;
import shop.model.Order;
import shop.model.OrderStatus;
import shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

public class OrderService {
    public static final List<Order> orders = generateOrders();
    private static List<Order> generateOrders() {
        List<Order> orderList = new ArrayList<>();


        Order order1 = new Order(1, "1/07/2023", 1000, "Anna",
                "Kowalska", "Kraków", OrderStatus.PAID, " ";
        Order order2 = new Order(2, "2/07/2023", 3000, "Piotr",
                "Czajka", "Warszawa", OrderStatus.IN_PREPARATION, " ",
        Order order3 = new Order(3, "3/07/2023", 150, "Ewa",
                "Cichal", "Warszawa", OrderStatus.SENT, " "
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        return orderList;
    }

    public void addOrder(final int orderId, Order order) {
        orders.add(order);
    }

    public void removeOrder(final int orderId, Order order) {
        orders.remove(order);
    }

    public void getAllOrders() {
        for (Order order : orders) {
            System.out.println(order.orderNumber());
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


