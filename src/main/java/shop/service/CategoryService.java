package shop.service;

import shop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private int lastAssignedId = 0;

    private final List<Category> categories = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(String name) {
        Category category = new Category(lastAssignedId, name);
        categories.add(category);
        ++lastAssignedId;
    }

    public void removeCategory(final int categoryId) {
        categories.remove(categoryId);
    }

    public Category getById(final int categoryId) {
        for (Category category : getCategories()) {
            if (category.categoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }
}
