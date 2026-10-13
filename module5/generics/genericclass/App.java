public class App {
    public static void main(String[] args) {
        Rating<Integer> integerRating = new Rating<>();
        integerRating.setScore(5);
        System.out.println("Integer Rating: " + integerRating.getScore());

        Rating<Double> doubleRating = new Rating<>();
        doubleRating.setScore(4.5);
        System.out.println("Double Rating: " + doubleRating.getScore());

        Rating<String> stringRating = new Rating<>();
        stringRating.setScore("Excellent");
        System.out.println("String Rating: " + stringRating.getScore());
    }
}