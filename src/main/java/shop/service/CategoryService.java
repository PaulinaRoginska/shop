package shop.service;

import shop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public static final List<Category> categories = generateCategories();

    public static List<Category> generateCategories() {
        List<Category> categoryList = new ArrayList<>();

        Category category1 = new Category(1, "Sprzęt AGD");
        Category category2 = new Category(2, "Sprzęt RTV");
        Category category3 = new Category(3, "Zabawki");
        Category category4 = new Category(4, "Meble");
        Category category5 = new Category(5, "Ubrania");
        return categoryList;
    }
    final public void addCategory(int categoryId, Category category) {
        categories.add(category);
    }
    final public void removeCategory(int categoryId, Category category) {
        categories.remove(category);
    }
    final public List<Category> showAllCategories() {
        return categories;
    }
    final public Category showOneCategory(int categoryId, Category category) {
        for (Category category1 : categories) {
            if (category1.equals(category)) {
                return category1;
            }
        }
        return null;
    }
}
