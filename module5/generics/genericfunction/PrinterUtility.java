public class PrinterUtility {

    // This is a generic method! 
    // <T> tells Java: "This method will accept a type T."
    public static <T> void printItem(T item) {
        System.out.println("Here is your item: " + item);
        System.out.println("It is of type: " + item.getClass().getSimpleName());
    }
}