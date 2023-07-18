package serviceShop;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<String> categories = new ArrayList<>();

    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }

    public List<String> showAllCategories() {
        return categories;
    }

    public String showOneCategory(String category) {
        for (String Category : categories) {
            if (Category.equals(category)) {
                return Category;
            }
        }
        return null;
    }
}
