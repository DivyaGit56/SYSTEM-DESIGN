
class Car {
    String brand;
    int currentSpeed;
    boolean isEngineOn;

    void startEngine() {
        isEngineOn = true;
        System.out.println("Engine started");
    }

    // Overloaded accelerate methods
    void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Accelerating normally. Speed: " + currentSpeed);
    }

    void accelerate(int speed, boolean turbo) {
        if (turbo) {
            currentSpeed += speed * 2;
            System.out.println("Turbo acceleration! Speed: " + currentSpeed);
        } else {
            accelerate(speed);
        }
    }

    // Overloaded brake methods
    void brake() {
        currentSpeed -= 5;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Normal braking. Speed: " + currentSpeed);
    }

    void brake(int force) {
        currentSpeed -= force;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Hard braking. Speed: " + currentSpeed);
    }
}

// Main class
public class polymoverloding {
    public static void main(String[] args) {

        Car car = new Car();
        car.startEngine();

        car.accelerate(20);              // calls accelerate(int)
        car.accelerate(10, true);        // calls accelerate(int, boolean)

        car.brake();                     // calls brake()
        car.brake(15);                   // calls brake(int)
    }
}
