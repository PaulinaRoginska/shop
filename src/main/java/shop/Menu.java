package shop;

import shop.model.*;
import shop.service.CategoryService;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.*;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CategoryService categoryService = new CategoryService();
    private final ProductService productService = new ProductService(categoryService);
    private final OrderService orderService = new OrderService(productService);


    private List<Category> generateCategories() {
        List<Category> categoryList = new ArrayList<>();

        Category category1 = new Category(1, "Sprzęt AGD");
        Category category2 = new Category(2, "Sprzęt RTV");
        Category category3 = new Category(3, "Zabawki");
        Category category4 = new Category(4, "Meble");
        Category category5 = new Category(5, "Ubrania");
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        categoryList.add(category5);
        return categoryList;
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

    private List<Order> generateOrders() {
        List<Order> orderList = new ArrayList<>();
        Map<Product, Integer> products = new HashMap<>();
        products.put(productService.getProducts().get(0), 1);
        Map<Product, Integer> products1 = new HashMap<>();
        products1.put(productService.getProducts().get(1), 2);
        Map<Product, Integer> products2 = new HashMap<>();
        products2.put(productService.getProducts().get(2), 3);

        Order order1 = new Order(1, "1/07/2023", new Client("Anna", "Kowalska", "Warszawa"),
                OrderStatus.PAID, products);
        Order order2 = new Order(2, "2/07/2023", new Client("Piotr", "Czajka", "Gdańsk"),
                OrderStatus.IN_PREPARATION, products1);
        Order order3 = new Order(3, "3/07/2023", new Client("Ewa", "Cichal", "Gdańsk"),
                OrderStatus.SENT, products2);
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        return orderList;
    }

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
                case 3 -> orderService.addOrder(generateOrderNumber(), new Client("Jan",
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
