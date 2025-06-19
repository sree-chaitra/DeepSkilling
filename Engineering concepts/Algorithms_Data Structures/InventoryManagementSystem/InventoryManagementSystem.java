
import java.util.HashMap;
import java.util.Scanner;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

   

	public void updateProduct(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: $" + price;
    }
}

public class InventoryManagementSystem {
    static HashMap<String, Product> inventory = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Product product = new Product(id, name, quantity, price);
        inventory.put(id, product);
        System.out.println("Product added successfully!");
    }

    public static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        String id = scanner.nextLine();

        if (inventory.containsKey(id)) {
            System.out.print("Enter New Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter New Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            inventory.get(id).updateProduct(name, quantity, price);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product ID not found!");
        }
    }

    public static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = scanner.nextLine();

        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product ID not found!");
        }
    }

    public static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Display Inventory\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
