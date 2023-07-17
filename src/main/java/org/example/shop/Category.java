package org.example.shop;

public record Category(int categoryID, String name) {

    public Category {
        validateCategoryID(categoryID);
    }
    private void validateCategoryID(int categoryID) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() >= 50 || name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid category name.");
        }

    }
}
