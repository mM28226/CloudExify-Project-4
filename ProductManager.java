package cloudexify.project4;

import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {

        if (searchProduct(product.getProductId()) != null) {
            return false;
        }

        products.add(product);
        return true;
    }

    public Product searchProduct(String productId) {

        for (Product product : products) {

            if (product.getProductId()
                    .equalsIgnoreCase(productId)) {

                return product;
            }
        }

        return null;
    }

    public boolean deleteProduct(String productId) {

        Product product = searchProduct(productId);

        if (product != null) {
            products.remove(product);
            return true;
        }

        return false;
    }

    public boolean updateProduct(String productId,
                                 String name,
                                 String category,
                                 double price,
                                 int quantity) {

        Product product = searchProduct(productId);

        if (product == null) {
            return false;
        }

        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setQuantity(quantity);

        return true;
    }

    public void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("\nNo products available.");
            return;
        }

        System.out.println("\n================ PRODUCTS ================");

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("===========================================");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}