package ServiceShop;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<String> mvpCategories = new ArrayList<>();

    public void addMvpCategory(String category) {
        mvpCategories.add(category);
    }

    public void removeMvpCategory(String category) {
        mvpCategories.remove(category);
    }

    public List<String> showAllMvpCategories() {
        return mvpCategories;
    }

    public String showOneMvpCategory(String category) {
        for (String mvpCategory : mvpCategories) {
            if (mvpCategory.equals(category)) {
                return mvpCategory;
            }
        }
        return null;
    }
}
