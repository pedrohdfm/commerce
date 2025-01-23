package entities;

import java.util.ArrayList;
import java.util.List;

public class Commerce {
    List<Product> registeredProducts = new ArrayList<>();

    public boolean verifyCode(int Code) {
        for (Product product : registeredProducts) {
            if (product.getProductCode() == Code) {
                return false;
            }
        }
        return true;
    }

    public void registerProduct(Product product) {
        try {
            if (verifyCode(product.getProductCode())) {
                registeredProducts.add(product);
                System.out.println("Product registration succesfull! " + product);
            } else {
                throw new ProductsException("ERROR! Duplicated product code, please try again.");
            }
        } catch (ProductsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listProducts() {
        if (registeredProducts.isEmpty()) {
            System.out.println("No products registered yet.");
        }
        System.out.println();
        System.out.println("Products list:");
        for (Product product : registeredProducts) {
            System.out.println(product);
        }
    }

    public void removeProduct(int code) {
        if (registeredProducts.isEmpty()) {
            System.out.println("No products registered yet.");
            return;
        }
        boolean removed = registeredProducts.removeIf(product -> product.getProductCode() == code);

        if (removed) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found, please try again.");
        }
    }

    public void updateProduct(int stock, int code) {
        if (registeredProducts.isEmpty()) {
            System.out.println("No products registered yet.");
            return;
        }
        for (Product product : registeredProducts) {
            if (product.getProductCode() == code) {
                product.setStock(stock);
                System.out.println("Product stock updated successfully!");
                return;
            }
        }
        System.out.println("Product not found, please try again.");
    }
}



