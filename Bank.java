import java.util.ArrayList;

// Customer class
class Customer {
    private String name;
    private Bank bank;
    private double balance;

    public Customer(String name, Bank bank, double initialDeposit) {
        this.name = name;
        this.bank = bank;
        this.balance = initialDeposit;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println(name + " deposited " + amount + ". New Balance: " + balance);
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(name + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println(name + " has insufficient funds!");
        }
    }

    public void viewAccount() {
        System.out.println("Customer: " + name + ", Bank: " + bank.getName() + ", Balance: " + balance);
    }
}

// Bank class that contains multiple Customer objects (Association)
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {
        System.out.println("Bank: " + name + " has the following customers:");
        for (Customer customer : customers) {
            customer.viewAccount();
        }
    }

    public static void main(String[] args) {
        // Creating Bank
        Bank bank = new Bank("IDFC Bank");

        // Creating Customers with Initial Deposits
        Customer customer1 = new Customer("Pranav", bank, 50000);
        Customer customer2 = new Customer("Abhay", bank, 30000);

        // Associating Customers with the Bank
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        // Displaying Customers and Their Account Details
        bank.displayCustomers();
        System.out.println();

        // Performing Transactions
        customer1.deposit(1000);
        customer2.withdraw(500);

        System.out.println("\nAfter Transactions:");
        bank.displayCustomers();
    }
}
