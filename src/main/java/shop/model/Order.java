package shop.model;

import java.util.Map;
import java.util.Random;

public record Order(int orderId, String orderNumber, double orderSum, String clientName,
                    String clientSurname, String clientAddress, OrderStatus orderStatus,
                    Map<Product, Integer> products) {

    public int orderId() {
        return orderId;
    }

    public Order {
        validateOrderSum(orderSum);
        validateClientName(clientName);
        validateClientSurname(clientSurname);
        validateClientAddress(clientAddress);
        validateProducts(products);
    }

    private void validateOrderSum(double orderSum) {
        if (orderSum <= 0) {
            throw new IllegalArgumentException("Order sum must be higher than 0.");
        }
    }

    private void validateClientName(String clientName) {
        if (clientName == null || clientName.isBlank() || clientName.length() == 0 || clientName.length() >= 50 || !clientName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid client name.");
        }
    }

    private void validateClientSurname(String clientSurname) {
        if (clientSurname == null || clientSurname.isBlank() || clientSurname.length() == 0 || clientSurname.length() >= 50 || !clientSurname.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid client surname.");
        }
    }

    private void validateClientAddress(String clientAddress) {
        if (clientAddress == null || clientAddress.isBlank() || clientAddress.length() == 0 || clientAddress.length() >= 50) {
            throw new IllegalArgumentException("Invalid client address.");
        }
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
        return new Order(orderId, orderNumber, orderSum, clientName, clientSurname, clientAddress, newStatus, products);
    }
}


