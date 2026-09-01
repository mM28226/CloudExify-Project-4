package cloudexify.project4;

public class Product {

    private String productId;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(String productId, String name, String category,
                   double price, int quantity) {

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-8s | Name: %-25s | Category: %-15s | Price: Rs. %-10.2f | Stock: %d",
                productId, name, category, price, quantity
        );
    }

    public String toFileString() {
        return productId + "," + name + "," + category + ","
                + price + "," + quantity;
    }
}