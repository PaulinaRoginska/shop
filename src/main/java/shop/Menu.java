package shop;

import shop.service.CategoryService;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.Scanner;

public class Menu {
        private final Scanner scanner = new Scanner(System.in);
        private final CategoryService categoryService = new CategoryService();
        private final ProductService productService = new ProductService();
        private final OrderService orderService = new OrderService();

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
                    case 2 -> orderService.getAllOrders();
                    /*case 3 -> orderService.getOrderStatus();*/
                    case 4 -> productService.showAllProducts();
                    case 5 -> exit = true;
                    default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }
                System.out.println();
            }
        }
    public void showCategorySubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie kategorie.");
            System.out.println("[2] Pokaż jedną kategorię.");
            System.out.println("[3] Dodaj kategorię.");
            System.out.println("[4] Usuń kategorię.");
            System.out.println("[5] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> categoryService.showAllCategories();
                case 2 -> categoryService.showOneCategory(1);
                /*case 3 -> categoryService.addCategory(1, "");*/
                case 4 -> categoryService.removeCategory(2);
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }


}


