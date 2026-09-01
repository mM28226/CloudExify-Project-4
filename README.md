# E-Commerce Product System

## Project Overview

The E-Commerce Product System is a Java-based console application developed as part of the CloudExify Internship Program.

The system is designed to manage products, inventory, and customer orders in a simple and organized way. It demonstrates the practical use of Object-Oriented Programming, ArrayList, File Handling, Exception Handling, and basic e-commerce operations.

## Features

* Add new products
* View all products
* Search products by Product ID
* Update product information
* Delete products
* Purchase products
* Automatic stock management
* Discount calculation
* Tax calculation
* Order receipt generation
* View customer orders
* Save product data to files
* Load product data when the application starts
* Input validation and error handling

## Technologies Used

* Java
* Apache NetBeans
* Object-Oriented Programming
* ArrayList
* File Handling
* Exception Handling

## OOP Concepts Used

### 1. Encapsulation

Private variables and public getter/setter methods are used in the Product and Order classes to protect and manage data.

### 2. Inheritance

The `ElectronicsProduct` and `ClothingProduct` classes inherit properties and methods from the `Product` class.

### 3. Polymorphism

The `toString()` method is overridden in the child product classes to provide specific product information.

### 4. Abstraction

The system separates product management, order management, and file management into different classes.

## Main Classes

| Class                   | Description                              |
| ----------------------- | ---------------------------------------- |
| Product.java            | Stores basic product information         |
| ElectronicsProduct.java | Represents electronic products           |
| ClothingProduct.java    | Represents clothing products             |
| ProductManager.java     | Manages products                         |
| Order.java              | Stores order information                 |
| OrderManager.java       | Handles purchases and order calculations |
| FileManager.java        | Saves and loads data from files          |
| Main.java               | Runs the main application and menu       |

## Product Management

The system allows the user to add products with the following information:

* Product ID
* Product Name
* Category
* Price
* Quantity

The user can also search, update, delete, and view products.

## Order Management

When a customer purchases a product, the system checks the available stock before placing the order.

The system automatically calculates:

* Subtotal
* Discount
* Tax
* Final Total

A 10% discount is applied when the subtotal is Rs. 10,000 or more.

A 5% tax is calculated after applying the discount.

## Stock Management

After a successful purchase, the purchased quantity is automatically deducted from the available stock.

For example:

```text
Available Stock: 10
Purchased Quantity: 2
Remaining Stock: 8
```

The system also prevents customers from purchasing more products than are available.

## File Handling

The application uses text files to store product and order information.

The data folder contains:

```text
data/
├── products.txt
└── orders.txt
```

Product information is saved so that it can be loaded again when the application is started.

## Exception Handling

The system uses exception handling to manage invalid user input and file-related errors.

For example, if the user enters an invalid number instead of a valid price or quantity, the system displays an appropriate error message instead of terminating the program.

## How to Run

1. Open Apache NetBeans.
2. Open the `CloudExify-Project-4` project.
3. Make sure all Java files are inside the `cloudexify.project4` package.
4. Run `Main.java`.
5. Select an option from the main menu.
6. Follow the instructions displayed in the console.

## Main Menu

The application provides the following options:

```text
1. Add Product
2. View All Products
3. Search Product
4. Update Product
5. Delete Product
6. Buy Product
7. View Orders
8. Exit
```

## Sample Order Receipt

```text
==========================================
              ORDER RECEIPT
==========================================
Order ID    : 1001
Product     : Wireless Headphones
Quantity    : 2
------------------------------------------
Subtotal    : Rs. 9000.00
Discount    : Rs. 0.00
Tax (5%)    : Rs. 450.00
------------------------------------------
TOTAL       : Rs. 9450.00
------------------------------------------
Order placed successfully!
==========================================
```

## Screenshots

Screenshots of the working application are included in the `screenshots` folder.

The screenshots demonstrate:

* Main menu
* Adding a product
* Viewing products
* Searching for a product
* Updating a product
* Deleting a product
* Purchasing a product
* Order receipt
* Stock management

## Project Structure

```text
CloudExify-Project-4
│
├── src
│   └── cloudexify
│       └── project4
│           ├── Product.java
│           ├── ElectronicsProduct.java
│           ├── ClothingProduct.java
│           ├── ProductManager.java
│           ├── Order.java
│           ├── OrderManager.java
│           ├── FileManager.java
│           └── Main.java
│
├── data
│   ├── products.txt
│   └── orders.txt
│
├── screenshots
│   ├── main-menu.png
│   ├── add-product.png
│   ├── products.png
│   ├── search-product.png
│   ├── update-product.png
│   ├── order-receipt.png
│   └── stock-management.png
│
└── README.md
```

## Future Improvements

The system can be further improved by adding:

* Graphical User Interface (GUI)
* Customer accounts and login
* Shopping cart
* Product categories and filters
* Payment system
* Database connectivity
* Admin dashboard

## Conclusion

The E-Commerce Product System demonstrates how Java and Object-Oriented Programming concepts can be used to develop a practical product management and ordering application.

The project provides basic e-commerce functionality while also demonstrating file handling, inventory management, order processing, calculations, and input validation.

## Author

**CloudExify Internship Program - Project 4**
