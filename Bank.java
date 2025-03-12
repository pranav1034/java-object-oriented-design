import java.util.ArrayList;

// Bank and Customer (Association)
class Bank {
    protected String name;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(customer,  initialDeposit);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
    }

    public void displayAccounts() {
        System.out.println("Bank: " + name);
        for (Account account : accounts) {
            System.out.println("Account Holder: " + account.getCustomer().getName() + ", Balance: $" + account.getBalance());
        }
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewAccounts() {
        System.out.println("Customer: " + name + " has the following accounts:");
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().name + ", Balance: $" + account.getBalance());
        }
    }
class Accoun
    private Customer customer;
    private Bank bank;
    private double balance;

    public Account(Customer customer, double initialDeposit) {
        this.customer = customer;
        this.balance = initialDeposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Association Example
        Bank bank = new Bank("National Bank");
        Customer customer = new Customer("Alice");
        bank.openAccount(customer, 5000);
        bank.displayAccounts();
        customer.viewAccounts();
    }
}
