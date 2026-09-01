package cloudexify.project4;

import java.util.Scanner;

public class Main {

    private static Scanner scanner =
            new Scanner(System.in);

    public static void main(String[] args) {

        ProductManager productManager =
                new ProductManager();

        OrderManager orderManager =
                new OrderManager();

        FileManager.createDataFolder();

        productManager.getProducts().addAll(
                FileManager.loadProducts()
        );

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt(
                    "Enter your choice: "
            );

            switch (choice) {

                case 1:
                    addProduct(productManager);
                    break;

                case 2:
                    productManager.viewProducts();
                    break;

                case 3:
                    searchProduct(productManager);
                    break;

                case 4:
                    updateProduct(productManager);
                    break;

                case 5:
                    deleteProduct(productManager);
                    break;

                case 6:
                    buyProduct(
                            productManager,
                            orderManager
                    );

                    FileManager.saveProducts(
                            productManager.getProducts()
                    );

                    FileManager.saveOrders(
                            orderManager.getOrders()
                    );

                    break;

                case 7:
                    orderManager.viewOrders();
                    break;

                case 8:

                    FileManager.saveProducts(
                            productManager.getProducts()
                    );

                    FileManager.saveOrders(
                            orderManager.getOrders()
                    );

                    running = false;

                    System.out.println(
                            "\nThank you for using "
                            + "E-Commerce Product System!"
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice. "
                            + "Please try again."
                    );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("       E-COMMERCE PRODUCT SYSTEM");
        System.out.println("==========================================");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Search Product");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Buy Product");
        System.out.println("7. View Orders");
        System.out.println("8. Exit");
        System.out.println("==========================================");
    }

    private static void addProduct(
            ProductManager productManager) {

        System.out.println("\n========== ADD PRODUCT ==========");

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Product ID cannot be empty.");
            return;
        }

        if (productManager.searchProduct(id) != null) {

            System.out.println(
                    "Product ID already exists."
            );

            return;
        }

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty.");
            return;
        }

        System.out.print("Enter Category: ");
        String category = scanner.nextLine().trim();

        double price = readPositiveDouble(
                "Enter Price: "
        );

        int quantity = readPositiveInt(
                "Enter Quantity: "
        );

        Product product = new Product(
                id,
                name,
                category,
                price,
                quantity
        );

        if (productManager.addProduct(product)) {

            FileManager.saveProducts(
                    productManager.getProducts()
            );

            System.out.println(
                    "\nProduct added successfully!"
            );

        } else {

            System.out.println(
                    "\nFailed to add product."
            );
        }
    }

    private static void searchProduct(
            ProductManager productManager) {

        System.out.println("\n========== SEARCH PRODUCT ==========");

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();

        Product product =
                productManager.searchProduct(id);

        if (product != null) {

            System.out.println("\nProduct Found:");
            System.out.println(product);

        } else {

            System.out.println(
                    "\nProduct not found."
            );
        }
    }

    private static void updateProduct(
            ProductManager productManager) {

        System.out.println("\n========== UPDATE PRODUCT ==========");

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();

        Product product =
                productManager.searchProduct(id);

        if (product == null) {

            System.out.println(
                    "\nProduct not found."
            );

            return;
        }

        System.out.println("\nCurrent Product:");
        System.out.println(product);

        System.out.print(
                "\nEnter New Product Name: "
        );

        String name = scanner.nextLine().trim();

        System.out.print(
                "Enter New Category: "
        );

        String category = scanner.nextLine().trim();

        double price = readPositiveDouble(
                "Enter New Price: "
        );

        int quantity = readPositiveInt(
                "Enter New Quantity: "
        );

        boolean updated =
                productManager.updateProduct(
                        id,
                        name,
                        category,
                        price,
                        quantity
                );

        if (updated) {

            FileManager.saveProducts(
                    productManager.getProducts()
            );

            System.out.println(
                    "\nProduct updated successfully!"
            );

        } else {

            System.out.println(
                    "\nUnable to update product."
            );
        }
    }

    private static void deleteProduct(
            ProductManager productManager) {

        System.out.println("\n========== DELETE PRODUCT ==========");

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();

        Product product =
                productManager.searchProduct(id);

        if (product == null) {

            System.out.println(
                    "\nProduct not found."
            );

            return;
        }

        System.out.println("\nProduct:");
        System.out.println(product);

        System.out.print(
                "Are you sure you want to delete it? (yes/no): "
        );

        String confirm =
                scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {

            if (productManager.deleteProduct(id)) {

                FileManager.saveProducts(
                        productManager.getProducts()
                );

                System.out.println(
                        "\nProduct deleted successfully!"
                );
            }

        } else {

            System.out.println(
                    "\nDelete operation cancelled."
            );
        }
    }

    private static void buyProduct(
            ProductManager productManager,
            OrderManager orderManager) {

        System.out.println("\n========== BUY PRODUCT ==========");

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();

        Product product =
                productManager.searchProduct(id);

        if (product == null) {

            System.out.println(
                    "\nProduct not found."
            );

            return;
        }

        System.out.println("\nProduct Details:");
        System.out.println(product);

        int quantity = readPositiveInt(
                "Enter Quantity: "
        );

        orderManager.placeOrder(
                product,
                quantity
        );
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value =
                        Integer.parseInt(
                                scanner.nextLine().trim()
                        );

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static int readPositiveInt(String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than 0."
            );
        }
    }

    private static double readPositiveDouble(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                double value =
                        Double.parseDouble(
                                scanner.nextLine().trim()
                        );

                if (value > 0) {
                    return value;
                }

                System.out.println(
                        "Price must be greater than 0."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid price."
                );
            }
        }
    }
}