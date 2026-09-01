package cloudexify.project4;

public class ClothingProduct extends Product {

    private String size;

    public ClothingProduct(String productId, String name,
                           double price, int quantity,
                           String size) {

        super(productId, name, "Clothing", price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Size: " + size;
    }
}