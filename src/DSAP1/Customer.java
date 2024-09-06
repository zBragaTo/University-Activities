public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void printDetails() {
        printCustomerId();
        printName();
        printEmail();
        printPhoneNumber();
    }

    private void printCustomerId() {
        System.out.println("Customer ID: " + customerId);
    }

    private void printName() {
        System.out.println("Name: " + name);
    }

    private void printEmail() {
        System.out.println("Email: " + email);
    }

    private void printPhoneNumber() {
        System.out.println("Phone Number: " + phoneNumber);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}