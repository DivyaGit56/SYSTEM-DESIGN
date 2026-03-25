// Base class
class Car {
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

    void accelerate(int speed) {
        if (isEngineOn) {
            currentSpeed += speed;
            System.out.println("Accelerating, Current speed: " + currentSpeed);
        } else {
            System.out.println("Start the engine first");
        }
    }

    void brake(int speed) {
        currentSpeed -= speed;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
        System.out.println("Braking. Current speed: " + currentSpeed);
    }
}

// Child class 1
class ManualCar extends Car {
    int currentGear;

    void shiftGear(int gear) {
        currentGear = gear;
        System.out.println("Gear shifted to: " + currentGear);
    }
}

// Child class 2
class ElectricCar extends Car {
    int batteryLevel;

    void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Battery fully charged");
    }
}
// Main class
public class Inheritence {
    public static void main(String[] args) {

        System.out.println("---- Manual Car ----");
        ManualCar manualCar = new ManualCar();
        manualCar.brand = "Hyundai";
        manualCar.model = "i20";

        manualCar.startEngine();
        manualCar.shiftGear(1);
        manualCar.accelerate(20);
        manualCar.brake(5);
        manualCar.stopEngine();

        System.out.println("\n---- Electric Car ----");
        ElectricCar electricCar = new ElectricCar();
        electricCar.brand = "Tesla";
        electricCar.model = "Model 3";

        electricCar.chargeBattery();
        electricCar.startEngine();
        electricCar.accelerate(50);
        electricCar.brake(10);
        electricCar.stopEngine();
    }
}
