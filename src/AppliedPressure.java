/* public class AppliedPressure {
    public enum Pressure {
        NON, LIGHT, HEAVY,
    }
    int currentSpeed = 0;

    Pressure pressure;
    public AppliedPressure(Pressure pressure) {
this.pressure = pressure;
    }

    public void acceleration() {
        switch (pressure) {
            case NON -> currentSpeed += 0;
            break;
            case LIGHT -> currentSpeed += 1;
            break;
            case HEAVY -> currentSpeed += 2;
        }
    }
} */