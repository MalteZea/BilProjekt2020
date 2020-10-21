public class CarTest {

    public static void main(String[] args) {
        testSuite();
    }

    private static void testSuite() {
        System.out.println("Testsuiten kører");

        System.out.println("Test 1. Bilen skal være tændt.");
        testStartCarWithCorrectKey();
        System.out.println("\n");
        System.out.println("Test 2. Bilen skal ikke tænde.");
        testStartCarWithWrongKey();
        System.out.println("\n");
        //test outside lights. Headlights, taillights, brakelights, turn signals, emergency signals.
        System.out.println("Test 3. Frontlys skal tændes.");
        testHeadLights();
        System.out.println("\n");
        System.out.println("Test 4. Baglys skal tændes.");
        testTailLights();
        System.out.println("\n");
        //test dashboard. show current speed, rpm, gear and battery level

        //test radio.

        //test climate control.

        /*Når bilen tænder skal der tændes:
        Motor, outside lights, radio, dashboard(hastighed, rpm, gear, battery), climate control.
         */


        //test handbrake. Button function. When engine is turned off and speed is 0, automatic on. Car() automatic on.

        //test brake. Applying pressure to the brake, decreases speed. (Activating brake, for seconds, equals speed reduction)

        //test speeder. Applying pressure to the speeder, increases speed.
        System.out.println("Test 5. Hastigheden skal øges.");
        testSpeederGentlePressure();
        System.out.println("\n");

        System.out.println("Test ... Bilen starter standart funktioner.");
    }

    private static void testSpeederGentlePressure() {
        Car malteCar = new Car();
        CarKey key = new CarKey("password1234");
        malteCar.turnEngineOn(key);
        malteCar.lightPressure();
        malteCar.acceleration();
        System.out.println("Den nuværende hastighed er " + malteCar.currentSpeed);
        if (malteCar.currentSpeed > 0) {
            System.out.println("Test passed");
        } else System.out.println("Test failed");
    }


    private static void testStartCarWithCorrectKey() {
        Car malteCar = new Car();
        CarKey key = new CarKey("password1234");
        malteCar.turnEngineOn(key);
    }

    private static void testStartCarWithWrongKey() {
        Car malteCar = new Car();
        CarKey key = new CarKey("forkert");
        malteCar.turnEngineOn(key);
    }

    private static void testHeadLights() {
        Car malteCar = new Car();
        CarKey key = new CarKey("password1234");
        malteCar.turnEngineOn(key);
        malteCar.turnHeadLightsOn();
        if (malteCar.carLights.headLightsOn) {
            System.out.println("Test passed");
        } else System.out.println("Test failed");
    }

    private static void testTailLights() {
        Car malteCar = new Car();
        CarKey key = new CarKey("password1234");
        malteCar.turnEngineOn(key);
        malteCar.turnTailLightsOn();
        if (malteCar.carLights.tailLightsOn) {
            System.out.println("Test passed");
        } else System.out.println("Test failed");
    }
}
