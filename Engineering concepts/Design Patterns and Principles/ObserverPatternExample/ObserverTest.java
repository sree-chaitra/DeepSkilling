package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stock, double price);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stock;
    private double price;

    public void setStockData(String stock, double price) {
        this.stock = stock;
        this.price = price;
        notifyObservers();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stock, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("Mobile App - Stock: " + stock + " Price: $" + price);
    }
}

class WebApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("Web App - Stock: " + stock + " Price: $" + price);
    }
}

class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setStockData("INFY", 1700.50);
        market.setStockData("TCS", 3500.00);
    }
}
