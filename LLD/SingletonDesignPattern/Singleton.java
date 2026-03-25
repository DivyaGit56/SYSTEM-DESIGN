package SingletonDesignPattern;
public class Singleton{

    // Step 1: private static variable of same class
    
    private static Singleton instance;

    // Step 2: private constructor
    
    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    // Step 3: public static method to get instance
    
    public static Singleton getInstance() {
        if (instance == null) {                // create only if not created
            instance = new Singleton();
        }
        return instance;
    }

 public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2);    // true, same object
    }
}