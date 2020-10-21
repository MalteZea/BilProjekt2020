import java.util.concurrent.TimeUnit;

public class Car {

    int currentSpeedLimit;
    int readSpeedLimit;
    long seconds = (System.currentTimeMillis() / 1000) % 10;
    long formerSecond = (System.currentTimeMillis() / 1000) % 10 - 1;
    private String password;
    private boolean engineOn;
    Pressure speeder;
    CarLights carLights = new CarLights();
    int currentSpeed;
    int formerSpeed;

    Car() {
        this.password = "password1234";
        this.engineOn = false;
        carLights.headLightsOn = false;
        carLights.tailLightsOn = false;
        speeder = Pressure.NON;
        currentSpeed = 0;
        currentSpeedLimit = 50;


    }

    public void turnCarOn() {
        CarKey key = new CarKey("password1234");
        turnEngineOn(key);
        turnHeadLightsOn();
        turnTailLightsOn();
    }

    public void turnEngineOn(CarKey key) {
        if (key.password.equals(password)) {
            System.out.println("Bilen er tændt.");
            engineOn = true;
        } else {
            System.out.println("Bilen kan ikke tænde, pga. forkert nøgle.");
        }
    }

    public void turnHeadLightsOn() {
        if (engineOn) {
            carLights.headLightsOn = true;
            System.out.println("Frontlys er tændt.");
        } else System.out.println("Frontlys kan ikke tænde, da motoren er slukket");
    }

    public void turnTailLightsOn() {
        if (engineOn) {
            carLights.tailLightsOn = true;
            System.out.println("Baglys er tændt.");
        } else System.out.println("Baglys kan ikke tænde, da motoren er slukket");
    }

    public void noPressure() {
        speeder = Pressure.NON;
    }

    public void lightPressure() {
        speeder = Pressure.LIGHT;
    }

    public void heavyPressure() {
        speeder = Pressure.HEAVY;
    }

    public void acceleration() {
        while (speeder != Pressure.NON && currentSpeed < currentSpeedLimit) {
            if (speeder == Pressure.LIGHT) {
                currentSpeed += 5;
            }
            if (speeder == Pressure.HEAVY) {
                currentSpeed += 10;
            }
            try {
                System.out.println(currentSpeed);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
    public int changeSpeedLimit(int readSpeedLimit){
        currentSpeedLimit = readSpeedLimit;
        return currentSpeedLimit;
    }

}

