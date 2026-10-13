## What is a Generic Method?

Just like a generic class lets an entire class work with any data type, a generic method lets a single function work with any data type—even if the class it lives inside is completely normal and not generic at all!

### How a generic method works in Java

To make a method generic, you put the type parameter (like <T>) right before the method's return type.

Here is a simple utility class with a generic method that prints out any item you give it:

```
public class PrinterUtility {

    public static <T> void printItem(T item) {
        System.out.println("Here is your item: " + item);
        System.out.println("It is of type: " + item.getClass().getSimpleName());
    }
}
```

### How to use a generic method

Notice that you don't even have to tell Java what type you are passing in. Java is smart enough to figure it out automatically based on what you hand to the method:

```
public class Main {
    public static void main(String[] args) {

        // Passing a String
        PrinterUtility.printItem("Hello World!");

        // Passing an Integer
        PrinterUtility.printItem(42);

        // Passing a Double (Price Tag value)
        PrinterUtility.printItem(19.99);
    }
}
```

### Output

```
Here is your item: Hello World!
It is of type: String

Here is your item: 42
It is of type: Integer

Here is your item: 19.99
It is of type: Double
```

### Why Use Generic Methods?

- **_Code Reuse:_** Instead of writing three different methods (`printString()`, `printInteger()`, `printDouble()`), you write one method that handles them all.

- **_Flexibility:_** You can use them inside normal, everyday classes whenever you need a specific function to be adaptable to multiple types.
