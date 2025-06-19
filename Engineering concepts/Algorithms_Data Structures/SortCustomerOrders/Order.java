package SortCustomerOrders;

import java.util.Arrays;

class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

 class Main {

    private static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    private static void printOrders(String message, Order[] orders) {
        System.out.println(message);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("001", "Alice", 250.50),
            new Order("002", "Bob", 175.75),
            new Order("003", "Charlie", 300.00),
            new Order("004", "David", 100.00),
            new Order("005", "Eva", 220.10)
        };

        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);

        bubbleSort(bubbleSortedOrders);
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);

        printOrders("Bubble Sorted Orders by Total Price:", bubbleSortedOrders);
        System.out.println();
        printOrders("Quick Sorted Orders by Total Price:", quickSortedOrders);
    }
}
