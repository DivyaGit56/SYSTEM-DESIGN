
// Car class (used as component)
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

// ManualCar uses Car via composition
class ManualCar {
    private Car car;          // HAS-A relationship
    private int currentGear;

    ManualCar(Car car) {
        this.car = car;
    }

    void shiftGear(int gear) {
        currentGear = gear;
        System.out.println("Gear shifted to: " + currentGear);
    }

    void start() {
        car.startEngine();
    }

    void accelerate(int speed) {
        car.accelerate(speed);
    }

    void brake(int speed) {
        car.brake(speed);
    }

    void stop() {
        car.stopEngine();
    }
}

// ElectricCar uses Car via composition
class ElectricCar {
    private Car car;          // HAS-A relationship
    private int batteryLevel;

    ElectricCar(Car car) {
        this.car = car;
        this.batteryLevel = 100;
    }

    void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Battery fully charged");
    }

    void start() {
        car.startEngine();
    }

    void accelerate(int speed) {
        if (batteryLevel > 0) {
            car.accelerate(speed);
            batteryLevel -= 5;
            System.out.println("Battery level: " + batteryLevel + "%");
        } else {
            System.out.println("Battery empty");
        }
    }

    void brake(int speed) {
        car.brake(speed);
    }

    void stop() {
        car.stopEngine();
    }
}

// Main class
public class CompositionRel{
    public static void main(String[] args) {

        System.out.println("---- Manual Car ----");
        Car baseCar1 = new Car();
        ManualCar manualCar = new ManualCar(baseCar1);

        manualCar.start();
        manualCar.shiftGear(1);
        manualCar.accelerate(20);
        manualCar.brake(5);
        manualCar.stop();

        System.out.println("\n---- Electric Car ----");
        Car baseCar2 = new Car();
        ElectricCar electricCar = new ElectricCar(baseCar2);

        electricCar.chargeBattery();
        electricCar.start();
        electricCar.accelerate(40);
        electricCar.brake(10);
        electricCar.stop();
    }
}





