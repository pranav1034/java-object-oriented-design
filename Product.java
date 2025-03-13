import java.util.ArrayList;

// Product class (Can exist independently)
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class (Contains multiple products)
class Order {
    private int orderId;
    private Customer customer;
    private ArrayList<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("  " + product.getName() + " - $" + product.getPrice());
        }
        System.out.println();
    }
}

// Customer class (Can place multiple orders - Association)
class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Customer: " + name + " has placed the following orders:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }

    public static void main(String[] args) {
        // Creating products
        Product product1 = new Product("Laptop", 1000.00);
        Product product2 = new Product("Mobile Phone", 500.00);
        Product product3 = new Product("IPad", 800.00);

        // Creating a customer
        Customer customer = new Customer("Pranav");
        Customer customer2 = new Customer("Nikhil");

        // Creating an order and adding products (Aggregation)
        Order order1 = new Order(101, customer);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102, customer);
        order2.addProduct(product3);

        Order order3 = new Order(103,customer2);
        order3.addProduct(product2);
        order3.addProduct(product3);

        // Customer places orders (Association)
        customer.placeOrder(order1);
        customer.placeOrder(order2);

        customer2.placeOrder(order3);
        // Display all orders for the customer
        customer.displayOrders();
        customer2.displayOrders();
    }
}
