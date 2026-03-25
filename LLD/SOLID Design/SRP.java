
import java.util.ArrayList;
import java.util.List;

// ---------------- Product ----------------
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

// ---------------- ShoppingCart ----------------
// Responsibility: Cart management + price calculation ONLY
class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}

// ---------------- InvoicePrinter ----------------
// Responsibility: Printing invoice ONLY
class InvoicePrinter {

    public void printInvoice(ShoppingCart cart) {
        System.out.println("------ INVOICE ------");
        for (Product p : cart.getProducts()) {
            System.out.println(p.getName() + " : ₹" + p.getPrice());
        }
        System.out.println("---------------------");
        System.out.println("Total Amount: ₹" + cart.calculateTotalPrice());
    }
}

// ---------------- CartRepository ----------------
// Responsibility: Database operations ONLY
class CartRepository {

    public void save(ShoppingCart cart) {
        // JDBC code would go here
        System.out.println("Shopping cart saved to database successfully.");
    }
}

// ---------------- Main ----------------
public class SRP {
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 800);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.calculateTotalPrice();

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(cart);

        CartRepository repo = new CartRepository();
        repo.save(cart);
    }
}