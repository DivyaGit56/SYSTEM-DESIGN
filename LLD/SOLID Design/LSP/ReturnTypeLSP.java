package LSP;
// import Child;
// import Client;
// import Parent;

class Animal {
    public void show(String msg) {
        System.out.println("Animal says: " + msg);
    }
}

class Dog extends Animal {
    @Override
    public void show(String msg) {
        System.out.println("Dog says: " + msg);
    }
}

// Parent class
class Parent {
    public Animal getAnimal() {
        System.out.println("Parent : Returning Animal instance");
        return new Animal();
    }
}

// Child class overriding method
class Child extends Parent {
    @Override
    public Dog getAnimal() {   // Covariant return type
        System.out.println("Child : Returning Dog instance");
        return new Dog();
    }
}

// Client class
class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void takeAnimal() {
        Animal a = p.getAnimal();
        a.show("Hello");
    }
}

// Main class
public class ReturnTypeLSP {
    public static void main(String[] args) {

        System.out.println("---- Using Parent Object ----");
        Client client1 = new Client(new Parent());
        client1.takeAnimal();

        System.out.println();

        System.out.println("---- Using Child Object ----");
        Client client2 = new Client(new Child());
        client2.takeAnimal();
    }
}