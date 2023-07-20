package shop;

import shop.model.Order;
import shop.model.OrderStatus;
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
            System.out.println("1. Kategorie");
            System.out.println("2. Produkty");
            System.out.println("3. Zamówienia");
            System.out.println("4. Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showCategorySubMenu();
                case 2 -> showProductSubMenu();
                case 3 -> showOrderSubMenu();
                case 4 -> exit = true;
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

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie produkty.");
            System.out.println("[2] Pokaż jedną kategorię.");
            System.out.println("[3] Dodaj kategorię.");
            System.out.println("[4] Usuń kategorię.");
            System.out.println("[5] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productService.showAllProducts();
                case 2 -> productService.showOneProduct(1);
                /*case 3 -> productService.addProduct(1, "");*/
                case 4 -> productService.removeProduct(2);
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showOrderSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie zamówienia.");
            System.out.println("[2] Pokaż jedno zamówienie.");
            System.out.println("[3] Dodaj zamówienie.");
            System.out.println("[4] Usuń zamówienie.");
            System.out.println("[5] Status zamówienia.");
            System.out.println("[6] Zmień status zamówienia.");
            System.out.println("[7] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> orderService.getAllOrders();
                case 2 -> orderService.getOrderById(1);
                /*case 3 -> orderService.addOrder(1, "");*/
                case 4 -> orderService.removeOrder(2);
                case 5 -> orderService.getOrderStatus(2);
                /*case 6 -> orderService.changeOrderStatus(, OrderStatus.PAID);*/
                case 7 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }
}


