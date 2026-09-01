package cloudexify.project4;

public class ElectronicsProduct extends Product {

    private int warrantyMonths;

    public ElectronicsProduct(String productId, String name,
                              double price, int quantity,
                              int warrantyMonths) {

        super(productId, name, "Electronics", price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Warranty: " + warrantyMonths + " months";
    }
}