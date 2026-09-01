package cloudexify.project4;

public class Order {

    private int orderId;
    private String productId;
    private String productName;
    private int quantity;
    private double subtotal;
    private double discount;
    private double tax;
    private double total;

    public Order(int orderId,
                 String productId,
                 String productName,
                 int quantity,
                 double subtotal,
                 double discount,
                 double tax,
                 double total) {

        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {

        return String.format(
                "Order ID: %d | Product: %s | Quantity: %d | Total: Rs. %.2f",
                orderId,
                productName,
                quantity,
                total
        );
    }

    public String toFileString() {

        return orderId + ","
                + productId + ","
                + productName + ","
                + quantity + ","
                + subtotal + ","
                + discount + ","
                + tax + ","
                + total;
    }
}
