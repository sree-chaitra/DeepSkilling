package StrategyPatternExample;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context1 = new PaymentContext(new CreditCardPayment());
        context1.executePayment(1500);

        PaymentContext context2 = new PaymentContext(new PayPalPayment());
        context2.executePayment(2200);
    }
}
