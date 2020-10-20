public class Car {

    private String password;
    private boolean engineOn;

    CarLights carLights = new CarLights();

    Car() {
        this.password = "password1234";
        this.engineOn = false;
        carLights.headLightsOn = false;
        carLights.tailLightsOn = false;


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
}
