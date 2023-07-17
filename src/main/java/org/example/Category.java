package org.example;

public record Category(int categoryID, String orderNumber, double orderValue, String customerName,
                       String customerSurname, String customerAddress) {
}
