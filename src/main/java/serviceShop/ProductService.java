package serviceShop;

import org.example.shop.modelsShop.Category;
import org.example.shop.modelsShop.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<String> products = new ArrayList<>();

   /* Product product1 = new Product(1, 1000, "Pralka",  )*/
   /* Product product2 = new Product(2, 3000, "Lodówka",  )*/
   /* Product product3 = new Product(3, 5000, "Laptop",  )*/
   /* Product product4 = new Product(4, 4500.50, "Smartfon",  )*/
   /* Product product5 = new Product(5, 150, "Barbie",  )*/
   /* Product product6 = new Product(6, 50, "Puzzle",  )*/
   /* Product product7 = new Product(7, 900.50, "Stół",  )*/
   /* Product product8 = new Product(8, 4000, "Sofa",  )*/
   /* Product product9 = new Product(9, 250, "Sukienka",  )*/
   /* Product product10 = new Product(10, 300, "Kurtka",  )*/

    public void addProduct(int productId, String product) {
        products.add(product);
    }

    public void removeProduct(int productId, String product) {
        products.remove(product);
    }

    public List<String> showAllProducts() {
        return products;
    }

    public String showOneCategory(int productId, String product) {
        for (String Product : products) {
            if (Product.equals(product)) {
                return Product;
            }
        }
        return null;
    }
}
