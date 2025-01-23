package entities;

public class Product {
    private String productName;
    private int productCode;
    private int stock;

    public String getProductName() {
        return productName;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Product (String productName, int productCode) {
        this.productName = productName;
        this.productCode = productCode;
        this.stock = 0;
    }

    public Product(String productName, int productCode, int stock) {
        this.productName = productName;
        this.productCode = productCode;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCode=" + productCode +
                ", stock=" + stock +
                '}';
    }
}
