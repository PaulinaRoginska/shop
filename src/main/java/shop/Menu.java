package shop;

import shop.model.Category;
import shop.model.Order;
import shop.model.OrderStatus;
import shop.model.Product;
import shop.service.CategoryService;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.Random;
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

    public void showAllCategories() {
        for (Category category : categories) {
            System.out.println(category.name());
        }
    }

    public void showOneCategory(final int categoryId) {
        for (Category category1 : categories) {
            if (category1.categoryId() == (categoryId)) {
                System.out.println(category1.name());
            }
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
                case 3 -> categoryService.addCategory("AGD");
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
            System.out.println("[2] Pokaż jeden produkt.");
            System.out.println("[3] Dodaj produkt.");
            System.out.println("[4] Usuń produkt.");
            System.out.println("[5] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String[] words = scanner.nextLine().split(",");

            switch (choice) {
                case 1 -> productService.showAllProducts();
                case 2 -> productService.showOneProduct(1);
                case 3 -> productService.addProduct();
                case 4 -> productService.removeProduct(2);
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }
    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product.name());
        }
    }

    public Product showOneProduct(final int productId) {
        for (Product product1 : products) {
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

            case 1 -> orderService.getAllOrders();
            case 2 -> orderService.getOrderById(1);
            case 3 -> orderService.addOrder(1, "");
            case 4 -> orderService.removeOrder(2);
            case 5 -> orderService.getOrderStatus(2);
            case 6 -> orderService.changeOrderStatus(, OrderStatus.PAID);
            if (choice == 7) {
                back = true;
            } else {
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
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
        for (Order order : orders) {
            System.out.println(order.orderNumber());
        }
    }

    public Order getOrderById(final int orderId) {
        for (Order order : orders) {
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

    public void changeOrderStatus(Order order, OrderStatus newStatus) {
        Order updatedOrder = order.withOrderStatus(newStatus);
        int index = orders.indexOf(order);
        if (index != -1) {
            orders.set(index, updatedOrder);
        }
    }
}
