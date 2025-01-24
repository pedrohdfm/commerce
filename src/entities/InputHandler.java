package entities;

import java.util.Scanner;

public class InputHandler {

        public static int captureAndValidateProductCode(Scanner sc) {
        int productCode = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = sc.nextLine();
            try {
                productCode = Integer.parseInt(input);
                if (productCode < 0) {
                    throw new ProductsException("ERROR! Only positive numbers are allowed.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Please type a valid integer.");
            } catch (ProductsException e) {
                System.out.println(e.getMessage());
            }
            if (!validInput) {
                System.out.println("Enter the product code: ");
            }
        }
        return productCode;
    }

    /*public static int inputValidator(String input) throws ProductsException {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new ProductsException("ERROR! Only positive numbers are allowed.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new ProductsException("ERROR! Please type a valid integer.");
        }
    }

    public int captureValidCode (Scanner sc) {
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
        return productCode;
    }*/
}

