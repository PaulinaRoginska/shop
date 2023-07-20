package shop.model;

public record Category(int categoryId, String name) {

    private static int lastAssignedId = 0;

    public int categoryId() {
        return categoryId;
    }

    public Category(String name) {
        this(++lastAssignedId, name);
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() >= 50 /*||*/ /*name.matches("[a-zA-Z]+")*/) {
            throw new IllegalArgumentException("Invalid category name.");
        }
    }
}
