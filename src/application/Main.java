package application;

import entities.Commerce;
import entities.InputHandler;
import entities.Product;
import entities.ProductsException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Commerce commerce = null;
        boolean closedCommerce = false;

        while (!closedCommerce) {
            try {
                System.out.println();
                System.out.println("1. List products");
                System.out.println("2. Register product");
                System.out.println("3. Remove product");
                System.out.println("4. Exit");
                System.out.println("Choose an option: ");
                int option = sc.nextInt();
                sc.nextLine();
                    switch (option) {
                        case 1 -> {
                            if (commerce == null) {
                                commerce = new Commerce();
                            }
                            commerce.listProducts();
                        }
                        case 2 -> {
                            if (commerce == null) {
                                commerce = new Commerce();
                            }
                            System.out.println("Enter the product name: ");
                            String productName = sc.nextLine();
                            System.out.println("Enter the product code: ");
                            int productCode = 0;
                            boolean validInput = false;
                            while(!validInput) {
                                String input = sc.nextLine();
                                try{
                                    productCode = InputHandler.inputValidator(input);
                                    validInput = true;
                                } catch (ProductsException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Enter the product code: ");
                                }
                            }
                            System.out.println("Enter the quantity of the product in stock:");
                            int productStock = sc.nextInt();
                            sc.nextLine();
                            Product newProduct = new Product(productName,productCode, productStock);
                            commerce.registerProduct(newProduct);
                        }
                        case 3 -> {
                            if (commerce == null) {
                                commerce = new Commerce();
                            }
                            System.out.println("Enter the product code to be removed:");
                            int code = sc.nextInt();
                            sc.nextLine();
                            commerce.removeProduct(code);
                        }
                        case 4 -> {
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