enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}

public class App {
    
    public static void checkLight(TrafficLight light) {
        switch (light) {
            case RED:
                System.out.println("Stop! The light is red.");
                break;
            case YELLOW:
                System.out.println("Slow down! The light is turning red.");
                break;
            case GREEN:
                System.out.println("Go! The light is green.");
                break;
            default:
                System.out.println("Invalid light!");
                break;
        }
    }

    public static void main(String[] args) {
        TrafficLight currentLight = TrafficLight.GREEN;
        checkLight(currentLight); // Output: Go! The light is green.
    }
}