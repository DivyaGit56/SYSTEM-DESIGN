// Car class (independent entity)
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
        currentSpeed += speed;
        System.out.println("Accelerating. Speed: " + currentSpeed);
    }

    void brake(int speed) {
        currentSpeed -= speed;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Braking. Speed: " + currentSpeed);
    }
}

// ManualCar aggregates Car
class ManualCar {
    private Car car;          // Aggregation (HAS-A)
    private int currentGear;

    ManualCar(Car car) {      // Injected from outside
        this.car = car;
    }

    void shiftGear(int gear) {
        currentGear = gear;
        System.out.println("Gear shifted to: " + currentGear);
    }

    void drive() {
        car.startEngine();
        shiftGear(1);
        car.accelerate(20);
        car.brake(5);
        car.stopEngine();
    }
}

// ElectricCar aggregates Car
class ElectricCar {
    private Car car;          // Aggregation (HAS-A)
    private int batteryLevel;

    ElectricCar(Car car) {    // Injected from outside
        this.car = car;
        this.batteryLevel = 100;
    }

    void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Battery fully charged");
    }

    void drive() {
        car.startEngine();
        car.accelerate(40);
        batteryLevel -= 10;
        System.out.println("Battery level: " + batteryLevel + "%");
        car.brake(10);
        car.stopEngine();
    }
}

// Main class
public class AggregationRel {
    public static void main(String[] args) {

        // Car object exists independently
        Car sharedCar = new Car();
        sharedCar.brand = "Hyundai";
        sharedCar.model = "i20";

        // Aggregation: same car can be used
        ManualCar manualCar = new ManualCar(sharedCar);
        ElectricCar electricCar = new ElectricCar(sharedCar);

        System.out.println("---- Manual Car ----");
        manualCar.drive();

        System.out.println("\n---- Electric Car ----");
        electricCar.chargeBattery();
        electricCar.drive();
    }
}


