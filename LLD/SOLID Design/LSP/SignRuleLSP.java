package LSP;

class Parent {
    void print(String msg) {
        System.out.println("Parent: " + msg);
    }
}

class Child extends Parent {

    // same method signature
    @Override
    void print(String msg) {
        System.out.println("Child: " + msg);
    }
}

public class SignRuleLSP{
    public static void main(String[] args) {

        Parent obj = new Child();   // LSP

        obj.print("Hello");
    }
}