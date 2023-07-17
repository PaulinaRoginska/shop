package org.example.shop.modelsShop;

import java.util.Map;

public record Order(int orderId, String orderNumber, double orderSum, String clientName,
                    String clientSurname, String clientAddress, OrderStatus orderStatus, Map <Product, Integer> products) {
}
