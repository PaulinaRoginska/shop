package org.example.shop.modelsShop;

public record Category(int categoryID, String name) {

    public Category {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() >= 50 || name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid category name.");
        }
    }

}
