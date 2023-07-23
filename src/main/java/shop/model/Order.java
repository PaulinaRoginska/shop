package shop.model;

import java.util.Map;

public record Order(int orderId, String orderNumber, Client client, OrderStatus orderStatus,
                    Map<Product, Integer> products) {
    public Order {
        validateProducts(products);
    }

    private void validateProducts(Map<Product, Integer> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Products map must not be null or empty.");
        }
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getValue() <= 0) {
                throw new IllegalArgumentException("Invalid product quantity. Quantity must be higher than 0.");
            }
        }
    }

    public Order withOrderStatus(OrderStatus newStatus) {
        return new Order(orderId, orderNumber, client, newStatus, products);
    }
}
