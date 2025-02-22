package application;

import entities.Commerce;
import entities.InputHandler;
import entities.Product;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Commerce commerce = null;
        boolean closedCommerce = false;

        while (!closedCommerce) {
            if (commerce == null) {
                commerce = new Commerce();
            }
            try {
                System.out.println();
                System.out.println("1. List products");
                System.out.println("2. Register product");
                System.out.println("3. Remove product");
                System.out.println("4. Update product stock");
                System.out.println("5. Sell product");
                System.out.println("6. Exit");
                System.out.println("Choose an option: ");
                int option = sc.nextInt();
                sc.nextLine();
                    switch (option) {
                        case 1 -> commerce.listProducts();
                        case 2 -> {
                            System.out.println("Enter the product name: ");
                            String productName = sc.nextLine();
                            System.out.println("Enter the product code: ");
                            int productCode = InputHandler.captureAndValidateProductCode(sc);
                            System.out.println("Do you want to add stock to the product? [Y/N]");
                            String stockOption = sc.nextLine();
                            while (!stockOption.equalsIgnoreCase("Y") && !stockOption.equalsIgnoreCase("N") ) {
                                System.out.println("Invalid option. Please enter Y or N.");
                                stockOption = sc.nextLine();
                            }
                            if (stockOption.equalsIgnoreCase("N")) {
                                Product newProduct = new Product(productName,productCode);
                                commerce.registerProduct(newProduct);
                                continue;
                            }
                            System.out.println("Enter the quantity of the product in stock:");
                            int productStock = sc.nextInt();
                            sc.nextLine();
                            Product newProduct = new Product(productName,productCode, productStock);
                            commerce.registerProduct(newProduct);
                        }
                        case 3 -> {
                            System.out.println("Enter the product code to be removed:");
                            int code = sc.nextInt();
                            sc.nextLine();
                            commerce.removeProduct(code);
                        }
                        case 4 -> {
                            System.out.println("Enter the product code first, to be updated: ");
                            int productCode = InputHandler.captureAndValidateProductCode(sc);
                            System.out.println("Enter the new stock to be updated: ");
                            int stock = sc.nextInt();
                            sc.nextLine();
                            commerce.updateProduct(stock, productCode);
                        }
                        case 5 -> {
                            System.out.println("Enter the product code that you want to sell: ");
                            int productCode = InputHandler.captureAndValidateProductCode(sc);
                            System.out.println("Enter the quantity to be sold: ");
                            int quantity = sc.nextInt();
                            sc.nextLine();
                            commerce.sellProduct(productCode, quantity);
                        }
                        case 6 -> {
                            System.out.println("Exiting commerce...");
                            closedCommerce = true;
                        }
                        default -> System.out.println("ERROR! Invalid option.");
                    }
                } catch(InputMismatchException e){
                    System.out.println("ERROR! Please enter a valid option.");
                    sc.nextLine();
                }
            }
        sc.close();
        }
    }