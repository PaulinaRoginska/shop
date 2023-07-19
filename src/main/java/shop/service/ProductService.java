package shop.service;

import shop.model.Category;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static final List<Product> products = generateProducts();

    private static List<Product> generateProducts() {
        List<Product> productList = new ArrayList<>();


        Product product1 = new Product(1, 1000, "Pralka",
                new Category(1, "Sprzęt AGD"), 1);
        Product product2 = new Product(2, 3000, "Lodówka",
                new Category(1, "Sprzęt AGD"), 2);
        Product product3 = new Product(3, 5000, "Laptop",
                new Category(2, "Sprzęt RTV"), 1);
        Product product4 = new Product(4, 4500.50, "Smartfon",
                new Category(2, "Sprzęt RTV"), 3);
        Product product5 = new Product(5, 150, "Barbie",
                new Category(3, "Zabawki"), 4);
        Product product6 = new Product(6, 50, "Puzzle",
                new Category(3, "Zabawki"), 3);
        Product product7 = new Product(7, 900.50, "Stół",
                new Category(4, "Meble"), 1);
        Product product8 = new Product(8, 4000, "Sofa",
                new Category(4, "Meble"), 2);
        Product product9 = new Product(9, 250, "Sukienka",
                new Category(5, "Ubrania"), 2);
        Product product10 = new Product(10, 300, "Kurtka",
                new Category(5, "Ubrania"), 1);
        return productList;
    }

    final public void addProduct(int productId, Product product) {
        products.add(product);
    }

    final public void removeProduct(int productId, Product product) {
        products.remove(product);
    }

    final public List<Product> showAllProducts() {
        return products;
    }

    final public Product showOneCategory(int productId, Product product) {
        for (Product product1 : products) {
            if (product1.equals(product)) {
                return product1;
            }
        }
        return null;
    }
}