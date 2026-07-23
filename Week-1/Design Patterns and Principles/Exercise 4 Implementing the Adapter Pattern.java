// Exercise 4: Implementing the Adapter Pattern
public class AdapterPatternExample {

    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Third-party Gateway A
    public static class GatewayA {
        public void makePayment(double amount) {
            System.out.println("Processing $" + amount + " through Gateway A.");
        }
    }

    // Third-party Gateway B
    public static class GatewayB {
        public void executeTransaction(double amount) {
            System.out.println("Executing $" + amount + " transaction through Gateway B.");
        }
    }

    // Adapters
    public static class GatewayAAdapter implements PaymentProcessor {
        private GatewayA gatewayA = new GatewayA();

        @Override
        public void processPayment(double amount) {
            gatewayA.makePayment(amount);
        }
    }

    public static class GatewayBAdapter implements PaymentProcessor {
        private GatewayB gatewayB = new GatewayB();

        @Override
        public void processPayment(double amount) {
            gatewayB.executeTransaction(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processorA = new GatewayAAdapter();
        processorA.processPayment(150.0);

        PaymentProcessor processorB = new GatewayBAdapter();
        processorB.processPayment(300.0);
    }
}
