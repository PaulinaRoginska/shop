package org.example.shop;

import org.example.Category;

public record Product(int productId, double price, String name, Category category, int quantity) {


}
