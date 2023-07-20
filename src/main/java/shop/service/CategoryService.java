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
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        categoryList.add(category5);
        return categoryList;
    }

    public void addCategory(String name) {
        Category category = new Category(name);
        categories.add(category);
    }

    public void removeCategory(final int categoryId) {
        categories.remove(categoryId);
    }

    public void showAllCategories() {
        for (Category category : categories) {
            System.out.println(category.name());
        }
    }

    public void showOneCategory(final int categoryId) {
        for (Category category1 : categories) {
            if (category1.categoryId() == (categoryId)) {
                System.out.println(category1.name());
            }
        }
    }
}

