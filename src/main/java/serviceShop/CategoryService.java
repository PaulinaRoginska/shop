package serviceShop;

import org.example.shop.modelsShop.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<String> categories = new ArrayList<>();

    Category category1 = new Category(1,"Sprzęt AGD");
    Category category2 = new Category(2,"Sprzęt RTV");
    Category category3 = new Category(3,"Zabawki");
    Category category4 = new Category(4,"Meble");
    Category category5 = new Category(5,"Ubrania");

    public void addCategory(int categoryId, String category) {
        categories.add(category);
    }

    public void removeCategory(int categoryId, String category) {
        categories.remove(category);
    }
    public List<String> showAllCategories() {
        return categories;
    }

    public String showOneCategory(int categoryId, String category) {
        for (String Category : categories) {
            if (Category.equals(category)) {
                return Category;
            }
        }
        return null;
    }
}
