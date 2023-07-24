package shop.model;

public record Category(int categoryId, String name) {
    public Category {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null /*|| !name.matches("[a-zA-Z]{1,50}")*/) {
            throw new IllegalArgumentException("Invalid category name.");
        }
    }
}
