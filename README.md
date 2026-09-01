# E-Commerce Product System

## Introduction

This is my E-Commerce Product System project, developed using Java as part of my CloudExify internship.

The main purpose of this project is to manage products and orders in a simple way.

## Features

* Add products
* View all products
* Search products
* Update products
* Delete products
* Buy products
* Manage product stock
* Calculate discount and tax
* Generate order receipt
* View orders
* Save data using files

## Technologies Used

* Java
* Apache NetBeans
* OOP
* ArrayList
* File Handling
* Exception Handling

## OOP Concepts

I used the following OOP concepts in this project:

* Encapsulation
* Inheritance
* Polymorphism
* Classes and Objects

## Project Classes

* `Product.java` - Stores product information
* `ElectronicsProduct.java` - Handles electronic products
* `ClothingProduct.java` - Handles clothing products
* `ProductManager.java` - Manages products
* `Order.java` - Stores order information
* `OrderManager.java` - Handles orders and calculations
* `FileManager.java` - Saves and loads data
* `Main.java` - Contains the main menu and program flow

## How It Works

When the program starts, a menu is displayed. The user can add, view, search, update, or delete products.

The user can also buy a product. The system checks the available stock and calculates the subtotal, discount, tax, and final total.

After a purchase, the product stock is automatically updated.

## File Handling

Product and order data is stored in text files inside the `data` folder.

```text
data/
├── products.txt
└── orders.txt
```

## Sample Menu

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

## Screenshots

Screenshots of the working project are included in the `screenshots` folder.

## Conclusion

This project helped me understand how Java OOP concepts can be used to create a simple e-commerce system. I also learned about file handling, product management, stock management, and order processing.

## Author

CloudExify Internship - Project 4
