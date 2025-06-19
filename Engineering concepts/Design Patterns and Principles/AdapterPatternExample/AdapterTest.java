package AdapterPatternExample;

interface PaymentProcessor {
    void processPayment(double amount);
}

class OldGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Old Gateway.");
    }
}

class OldGatewayAdapter implements PaymentProcessor {
    private OldGateway gateway;

    public OldGatewayAdapter(OldGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

class AdapterTest {
    public static void main(String[] args) {
        OldGateway oldGateway = new OldGateway();
        PaymentProcessor adapter = new OldGatewayAdapter(oldGateway);
        adapter.processPayment(1000.0);
    }
}
