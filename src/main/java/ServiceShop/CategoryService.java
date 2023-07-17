package ServiceShop;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<String> Categories = new ArrayList<>();

    public void addCategory(String category) {
        Categories.add(category);
    }

    public void removeCategory(String category) {
        Categories.remove(category);
    }

    public List<String> showAllCategories() {
        return Categories;
    }

    public String showOneCategory(String category) {
        for (String Category : Categories) {
            if (Category.equals(category)) {
                return Category;
            }
        }
        return null;
    }
}
