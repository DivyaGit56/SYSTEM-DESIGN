package SingletonDesignPattern;

public class ThreadSafeEagerSingleton {
    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();

    private ThreadSafeEagerSingleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static ThreadSafeEagerSingleton getInstance() {   // No synchronization needed, instance is created at class loading time
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeEagerSingleton s1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s2 = ThreadSafeEagerSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}

//pros: Simple implementation and thread safety is guaranteed by the class loader. The instance is created at the time of class loading, so it's ready to use when needed.
//cons: The instance is created even if the client application might not be using it, which can lead to resource wastage if the instance is heavy and not used.