package entities;

public class InputHandler {
    public static int inputValidator(String input) throws ProductsException {
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
}

