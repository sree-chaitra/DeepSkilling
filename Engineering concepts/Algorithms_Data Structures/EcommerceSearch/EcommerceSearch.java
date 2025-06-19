import java.util.Arrays;
import java.util.Scanner;

public class EcommerceSearch {

    // Product class defined as public static inner class
    public static class Product {
        String productId;
        String productName;
        String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    static Product[] products = {
        new Product("101", "Laptop", "Electronics"),
        new Product("102", "Shoes", "Footwear"),
        new Product("103", "Watch", "Accessories"),
        new Product("104", "Phone", "Electronics"),
        new Product("105", "Shirt", "Clothing")
    };

    public static int linearSearch(String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static Product binarySearch(String name) {
        Product[] sortedProducts = products.clone(); // avoid modifying original array
        Arrays.sort(sortedProducts, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        int left = 0, right = sortedProducts.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedProducts[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0)
                return sortedProducts[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter product name to search: ");
            String name = scanner.nextLine();

            System.out.println("\nUsing Linear Search:");
            int indexLinear = linearSearch(name);
            if (indexLinear != -1)
                System.out.println("Found: " + products[indexLinear]);
            else
                System.out.println("Product not found.");

            System.out.println("\nUsing Binary Search:");
            Product result = binarySearch(name);
            if (result != null)
                System.out.println("Found: " + result);
            else
                System.out.println("Product not found.");
        }
    }
}
