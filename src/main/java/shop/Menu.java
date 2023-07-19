package shop;

import shop.service.CategoryService;
import shop.service.ProductService;

import java.util.Scanner;

public class Menu {
        private final Scanner scanner = new Scanner(System.in);
        private final CategoryService categoryService = new CategoryService();
        private final ProductService productService = new ProductService();

        public void showMainMenu() {
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Kategoria");
                System.out.println("2. Zamówienie");
                System.out.println("3. Status zamówienia");
                System.out.println("4. Produkty");
                System.out.println("5. Wyjście");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> categoryService.showAllCategories();
                  //  case 2 -> orderService.showAllOrders();
                  //  case 3 -> orderService.showAllOrderStatus();
                    case 4 -> productService.showAllProducts();
                    case 5 -> exit = true;
                    default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }

                System.out.println();
            }
        }
}


