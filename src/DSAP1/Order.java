public class Order {
    private String orderId;
    private String customerId;
    private double amount;

    public Order(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public void printOrderDetails() {
        printOrderId();
        printCustomerId();
        printAmount();
    }

    private void printOrderId() {
        System.out.println("Order ID: " + orderId);
    }

    private void printCustomerId() {
        System.out.println("Customer ID: " + customerId);
    }

    private void printAmount() {
        System.out.println("Amount: $" + amount);
    }

    public void applyDiscountIfValid(double discountPercentage) {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            amount -= (amount * discountPercentage / 100);
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }
}