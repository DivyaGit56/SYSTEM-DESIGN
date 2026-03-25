
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
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
// Responsibility: Cart logic only
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
// Responsibility: Printing only
class InvoicePrinter {
    public void printInvoice(ShoppingCart cart) {
        System.out.println("------ INVOICE ------");
        for (Product p : cart.getProducts()) {
            System.out.println(p.getName() + " : Rs. " + p.getPrice());
        }
        System.out.println("---------------------");
        System.out.println("Total Amount: Rs. " + cart.calculateTotalPrice());
    }
}

// ---------------- OCP: Storage Abstraction ----------------
abstract class DBStorage {
    public abstract void save(ShoppingCart cart);
}

// ---------------- Save to SQL ----------------
class SaveToSQLDB extends DBStorage {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saved shopping cart to SQL Database");
    }
}

// ---------------- Save to MongoDB ----------------
class SaveToMongoDB extends DBStorage {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saved shopping cart to MongoDB");
    }
}

// ---------------- Save to File ----------------
class SaveToFile extends DBStorage {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saved shopping cart to File System");
    }
}

// ---------------- Main ----------------
public class OCP {
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 800);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);

        // Print invoice
        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(cart);

        // Choose storage type (OCP)
        DBStorage storage;

        storage = new SaveToSQLDB();
        storage.save(cart);

        storage = new SaveToMongoDB();
        storage.save(cart);

        storage = new SaveToFile();
        storage.save(cart);
    }
}
