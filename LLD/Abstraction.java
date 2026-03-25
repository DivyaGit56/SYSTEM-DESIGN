abstract class Car{
    abstract void start();
    abstract void accelerate();
    abstract void brake();
    abstract void stop();

}

class ElectricCar extends Car{
    String brand;
    String model;

    ElectricCar(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
    @Override
    void start() {
        System.out.println("Electric car of " + brand + " " + model + " starting using battery.");
    }

    @Override
    void accelerate() {
        System.out.println("Electric car of " + brand + " " + model + " accelerating quickly.");
    }

    @Override
    void brake() {
        System.out.println("Electric car of " + brand + " " + model + " slow down using regenerative braking.");
    }

    @Override
    void stop() {
        System.out.println("Electric car of " + brand + " " + model + " stopping.");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        // Create an instance of the concrete class
        Car car = new ElectricCar("Tesla", "Model S");
        car.start();
        car.accelerate();
        car.brake();
        car.stop();
        
    }
}

