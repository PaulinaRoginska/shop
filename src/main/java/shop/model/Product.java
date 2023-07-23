package shop.model;

public record Product(int productId, double price, String name, Category category) {
    public Product {
        validatePrice(price);
        validateName(name);
        validateCategory(category);
    }

    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be higher than 0.");
        }
    }

    private void validateName(String name) {
        if (name == null || !name.matches("[a-zA-Z]{1,50}")) {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category must not be null.");
        }
    }
}
