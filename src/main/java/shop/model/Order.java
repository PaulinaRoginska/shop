package shop.model;

import java.util.Map;
import java.util.Random;

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

    public static String generateOrderNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append((char) (random.nextInt(26) + 'A'));
        }
        return sb.toString();
    }

    public Order withOrderStatus(OrderStatus newStatus) {
        return new Order(orderId, orderNumber, client, newStatus, products);
    }
}
