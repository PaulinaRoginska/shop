package org.example.shop.modelsShop;

public record Product(int productId, double price, String name, Category category, int quantity) {

    public Product {
        validatePrice(price);
        validateName(name);
        validateCategory(category);
        validateQuantity(quantity);
    }

    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be higher than 0.");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() >= 50 || !name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category must not be null.");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be higher than 0.");
        }
    }
}
