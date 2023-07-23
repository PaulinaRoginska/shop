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
                CategoryService.categories.get(0));
        Product product2 = new Product(2, 3000, "Lodówka",
                CategoryService.categories.get(0));
        Product product3 = new Product(3, 5000, "Laptop",
                CategoryService.categories.get(1));
        Product product4 = new Product(4, 4500.50, "Smartfon",
                CategoryService.categories.get(1));
        Product product5 = new Product(5, 150, "Barbie",
                CategoryService.categories.get(2));
        Product product6 = new Product(6, 50, "Puzzle",
                CategoryService.categories.get(2));
        Product product7 = new Product(7, 900.50, "Stół",
                CategoryService.categories.get(3));
        Product product8 = new Product(8, 4000, "Sofa",
                CategoryService.categories.get(3));
        Product product9 = new Product(9, 250, "Sukienka",
                CategoryService.categories.get(4));
        Product product10 = new Product(10, 300, "Kurtka",
                CategoryService.categories.get(4));
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

    public void addProduct(final int productId, Product product) {
        products.add(product);
    }

    public void removeProduct(final int productId) {
        products.remove(productId);
    }

    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product.name());
        }
    }

    public Product showOneProduct(final int productId) {
        for (Product product1 : products) {
            if (product1.productId()==(productId)) {
                System.out.println(product1.name());
            }
        }
        return null;
    }
}
