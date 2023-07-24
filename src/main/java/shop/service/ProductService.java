package shop.service;

import shop.model.Category;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private int productId = 0;
    private final CategoryService categoryService;
    private final List<Product> products = new ArrayList<>();

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(double price, String name, Category category) {
        Product product = new Product(productId, price, name, category);
        products.add(product);
        productId++;
    }

    public void removeProduct(final int productId) {
        products.remove(productId);
    }
}
