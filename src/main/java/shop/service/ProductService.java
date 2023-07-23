package shop.service;

import shop.model.Category;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private int productId = 0;
    private final CategoryService categoryService;
    public final List<Product> products = generateProducts();

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private List<Product> generateProducts() {
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product(1, 1000, "Pralka",
                categoryService.getCategories().get(0));
        Product product2 = new Product(2, 3000, "Lodówka",
                categoryService.getCategories().get(0));
        Product product3 = new Product(3, 5000, "Laptop",
                categoryService.getCategories().get(1));
        Product product4 = new Product(4, 4500.50, "Smartfon",
                categoryService.getCategories().get(1));
        Product product5 = new Product(5, 150, "Barbie",
                categoryService.getCategories().get(2));
        Product product6 = new Product(6, 50, "Puzzle",
                categoryService.getCategories().get(2));
        Product product7 = new Product(7, 900.50, "Stół",
                categoryService.getCategories().get(3));
        Product product8 = new Product(8, 4000, "Sofa",
                categoryService.getCategories().get(3));
        Product product9 = new Product(9, 250, "Sukienka",
                categoryService.getCategories().get(4));
        Product product10 = new Product(10, 300, "Kurtka",
                categoryService.getCategories().get(4));
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        return productList;
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
