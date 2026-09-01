package cloudexify.project4;

import java.util.ArrayList;

public class OrderManager {

    private ArrayList<Order> orders;
    private int nextOrderId;

    public OrderManager() {

        orders = new ArrayList<>();
        nextOrderId = 1001;
    }

    public Order placeOrder(Product product, int quantity) {

        if (quantity <= 0) {
            System.out.println("\nQuantity must be greater than 0.");
            return null;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("\nNot enough stock available.");
            System.out.println("Available stock: "
                    + product.getQuantity());
            return null;
        }

        double subtotal = product.getPrice() * quantity;

        double discount = 0;

        if (subtotal >= 10000) {
            discount = subtotal * 0.10;
        }

        double afterDiscount = subtotal - discount;

        double tax = afterDiscount * 0.05;

        double total = afterDiscount + tax;

        product.setQuantity(
                product.getQuantity() - quantity
        );

        Order order = new Order(
                nextOrderId++,
                product.getProductId(),
                product.getName(),
                quantity,
                subtotal,
                discount,
                tax,
                total
        );

        orders.add(order);

        printReceipt(order);

        return order;
    }

    private void printReceipt(Order order) {

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("              ORDER RECEIPT");
        System.out.println("==========================================");

        System.out.println("Order ID    : " + order.getOrderId());
        System.out.println("Product     : " + order.getProductName());
        System.out.println("Quantity    : " + order.getQuantity());

        System.out.println("------------------------------------------");

        System.out.printf("Subtotal    : Rs. %.2f%n",
                order.getSubtotal());

        System.out.printf("Discount    : Rs. %.2f%n",
                order.getDiscount());

        System.out.printf("Tax (5%%)    : Rs. %.2f%n",
                order.getTax());

        System.out.println("------------------------------------------");

        System.out.printf("TOTAL       : Rs. %.2f%n",
                order.getTotal());

        System.out.println("------------------------------------------");
        System.out.println("Order placed successfully!");
        System.out.println("==========================================");
    }

    public void viewOrders() {

        if (orders.isEmpty()) {
            System.out.println("\nNo orders available.");
            return;
        }

        System.out.println("\n================ ORDERS ==================");

        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("===========================================");
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}