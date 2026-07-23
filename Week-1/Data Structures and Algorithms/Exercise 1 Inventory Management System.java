import java.util.HashMap;
import java.util.Map;

// Exercise 1: Inventory Management System
public class Exercise1_InventoryManagementSystem {

    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "Product{id='" + productId + "', name='" + productName + "', qty=" + quantity + ", price=" + price + '}';
        }
    }

    public static class Inventory {
        private Map<String, Product> products = new HashMap<>();

        public void addProduct(Product product) {
            products.put(product.getProductId(), product);
        }

        public void updateProduct(String productId, int newQuantity, double newPrice) {
            Product p = products.get(productId);
            if (p != null) {
                p.setQuantity(newQuantity);
                p.setPrice(newPrice);
            }
        }

        public void deleteProduct(String productId) {
            products.remove(productId);
        }

        public Product getProduct(String productId) {
            return products.get(productId);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("P100", "Laptop", 10, 999.99));
        inventory.addProduct(new Product("P101", "Mouse", 50, 19.99));

        System.out.println(inventory.getProduct("P100"));

        inventory.updateProduct("P100", 8, 949.99);
        System.out.println("After update: " + inventory.getProduct("P100"));

        inventory.deleteProduct("P101");
        System.out.println("Deleted P101. Exists? " + (inventory.getProduct("P101") != null));
    }
}
