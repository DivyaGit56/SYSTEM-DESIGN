

// Abstract base class
abstract class Car {
    String brand;
    String model;
    boolean isEngineOn;
    int currentSpeed;

    void startEngine() {
        isEngineOn = true;
        System.out.println("Engine started");
    }

    void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println("Engine stopped");
    }

    // Abstract methods
    abstract void accelerate(int speed);
    abstract void brake(int speed);
}

// Child class 1
class ManualCar extends Car {
    int currentGear;

    void shiftGear(int gear) {
        currentGear = gear;
        System.out.println("Gear shifted to: " + currentGear);
    }

    // Overriding abstract methods
    @Override
    void accelerate(int speed) {
        if (isEngineOn) {
            currentSpeed += speed;
            System.out.println("Manual car accelerating. Speed: " + currentSpeed);
        } else {
            System.out.println("Start the engine first");
        }
    }

    @Override
    void brake(int speed) {
        currentSpeed -= speed;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Manual car braking. Speed: " + currentSpeed);
    }
}

// Child class 2
class ElectricCar extends Car {
    int batteryLevel;

    void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Battery fully charged");
    }

    // Overriding abstract methods
    @Override
    void accelerate(int speed) {
        if (isEngineOn && batteryLevel > 0) {
            currentSpeed += speed;
            batteryLevel -= 5;
            System.out.println(
                "Electric car accelerating. Speed: " + currentSpeed +
                ", Battery: " + batteryLevel + "%"
            );
        } else {
            System.out.println("Check engine or battery");
        }
    }

    @Override
    void brake(int speed) {
        currentSpeed -= speed;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Electric car braking. Speed: " + currentSpeed);
    }
}

// Main class
public class polymoveride {
    public static void main(String[] args) {

        System.out.println("---- Manual Car ----");
        Car manual = new ManualCar();   // Polymorphism
        manual.startEngine();
        ((ManualCar) manual).shiftGear(1);
        manual.accelerate(20);
        manual.brake(5);
        manual.stopEngine();

        System.out.println("\n---- Electric Car ----");
        ElectricCar electric = new ElectricCar();
        electric.chargeBattery();
        electric.startEngine();
        electric.accelerate(40);
        electric.brake(10);
        electric.stopEngine();
    }
}



