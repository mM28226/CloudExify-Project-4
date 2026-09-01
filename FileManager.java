package cloudexify.project4;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String DATA_FOLDER = "data";
    private static final String PRODUCT_FILE =
            DATA_FOLDER + File.separator + "products.txt";

    private static final String ORDER_FILE =
            DATA_FOLDER + File.separator + "orders.txt";

    public static void createDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static void saveProducts(ArrayList<Product> products) {

        createDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(PRODUCT_FILE))) {

            for (Product product : products) {

                writer.write(product.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving products: " + e.getMessage()
            );
        }
    }

    public static ArrayList<Product> loadProducts() {

        ArrayList<Product> products = new ArrayList<>();

        createDataFolder();

        File file = new File(PRODUCT_FILE);

        if (!file.exists()) {
            return products;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length != 5) {
                    continue;
                }

                String id = data[0];
                String name = data[1];
                String category = data[2];

                double price =
                        Double.parseDouble(data[3]);

                int quantity =
                        Integer.parseInt(data[4]);

                Product product = new Product(
                        id,
                        name,
                        category,
                        price,
                        quantity
                );

                products.add(product);
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading products: "
                    + e.getMessage()
            );
        }

        return products;
    }

    public static void saveOrders(ArrayList<Order> orders) {

        createDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(ORDER_FILE))) {

            for (Order order : orders) {

                writer.write(order.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving orders: "
                    + e.getMessage()
            );
        }
    }
}