package shop;

import shop.model.*;
import shop.service.CategoryService;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CategoryService categoryService = new CategoryService();
    private final ProductService productService = new ProductService(categoryService);
    private final OrderService orderService = new OrderService(productService);

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
                case 1 -> showAllCategories();
                case 2 -> showOneCategory(1);
                case 3 -> categoryService.addCategory("AGD");
                case 4 -> categoryService.removeCategory(2);
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showAllCategories() {
        for (Category category : categoryService.getCategories()) {
            System.out.println(category.name());
        }
    }

    public void showOneCategory(final int categoryId) {
        for (Category category1 : categoryService.getCategories()) {
            if (category1.categoryId() == (categoryId)) {
                System.out.println(category1.name());
            }
        }
    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie produkty.");
            System.out.println("[2] Pokaż jeden produkt.");
            System.out.println("[3] Dodaj produkt.");
            System.out.println("[4] Usuń produkt.");
            System.out.println("[5] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllProducts();
                case 2 -> showOneProduct(1);
                case 3 -> addProduct();
                case 4 -> productService.removeProduct(2);
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void addProduct() {
        System.out.println("Podaj cenę produktu:");
        double price = scanner.nextDouble();
        System.out.println("Podaj nazwę produktu:");
        String name = scanner.nextLine();
        System.out.println("Podaj ID kategorii:");
        int categoryID = scanner.nextInt();
        Category category = categoryService.getById(categoryID);
        productService.addProduct(price, name, category);
    }

    public void showAllProducts() {
        for (Product product : productService.getProducts()) {
            System.out.println(product.name());
        }
    }

    public Product showOneProduct(final int productId) {
        for (Product product1 : productService.getProducts()) {
            if (product1.productId() == (productId)) {
                System.out.println(product1.name());
            }
        }
        return null;
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
                case 1 -> getAllOrders();
                case 2 -> getOrderById(1);
                case 3 -> orderService.addOrder("1/07/2023", new Client("Jan",
                        "Kowalski", "Brzozowa 1"), OrderStatus.PAID, new HashMap<>());
                case 4 -> orderService.removeOrder(2);
                case 5 -> getOrderStatus(2);
                case 6 -> {
                    changeOrderStatus();
                    if (choice == 7) {
                        back = true;
                    } else {
                        System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                    }
                }
                default -> System.out.println("Cofnij");
            }
            System.out.println();
        }
    }

    public static String generateOrderNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append((char) (random.nextInt(26) + 'A'));
        }
        return sb.toString();
    }

    public void getAllOrders() {
        for (Order order : orderService.getOrders()) {
            System.out.println(order.orderNumber());
        }
    }

    public Order getOrderById(final int orderId) {
        for (Order order : orderService.getOrders()) {
            if (order.orderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public OrderStatus getOrderStatus(int orderId) {
        Order order = getOrderById(orderId);
        return order != null ? order.orderStatus() : null;
    }

    public void changeOrderStatus() {
        System.out.println("Podaj Id zamówienia:");
        int orderId = scanner.nextInt();
        System.out.println("Podaj nowy status:");
        String orderStatus1 = scanner.nextLine();
    }
}


/*
    public void addProduct() {
        System.out.println("Podaj cenę produktu:");
        double price = scanner.nextDouble();
        System.out.println("Podaj nazwę produktu:");
        String name = scanner.nextLine();
        System.out.println("Podaj ID kategorii:");
        int categoryID = scanner.nextInt();
        Category category = categoryService.getById(categoryID);
        productService.addProduct(price, name, category);*/
