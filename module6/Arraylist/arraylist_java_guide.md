## What is an `ArrayList`?

An **`ArrayList`** is a resizable array implementation of the `List` interface, located in the `java.util` package. Unlike standard Java arrays (which have a fixed size determined at creation), an `ArrayList` automatically grows and shrinks as elements are added or removed.

### Key Characteristics:

- **Dynamic Sizing:** Automatically expands its capacity when elements are added beyond its current limit.
- **Indexed Access:** Elements can be accessed quickly in constant time $O(1)$ using their integer index.
- **Allows Duplicates & Nulls:** You can store duplicate values and `null` entries.
- **Objects Only:** It stores object references, not primitive types. To store primitives (like `int` or `double`), Java automatically boxes them into their wrapper classes (like `Integer` or `Double`).

---

## Common Methods

| Method                      | Description                                                          | Time Complexity  |
| :-------------------------- | :------------------------------------------------------------------- | :--------------- |
| `add(E e)`                  | Appends the specified element to the end of the list.                | $O(1)$ amortized |
| `add(int index, E element)` | Inserts the element at the specified position.                       | $O(n)$           |
| `get(int index)`            | Returns the element at the specified position.                       | $O(1)$           |
| `set(int index, E element)` | Replaces the element at the specified position with the new element. | $O(1)$           |
| `remove(int index)`         | Removes the element at the specified position.                       | $O(n)$           |
| `size()`                    | Returns the number of elements in the list.                          | $O(1)$           |
| `contains(Object o)`        | Returns `true` if the list contains the specified element.           | $O(n)$           |
| `clear()`                   | Removes all elements from the list.                                  | $O(1)$           |

---

## Examples

### 1. Basic Operations

```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Access an element
        System.out.println("First fruit: " + fruits.get(0)); // Output: Apple

        // Modify an element
        fruits.set(1, "Blueberry"); // Replaces "Banana"

        // Remove an element by index
        fruits.remove(2); // Removes "Cherry"

        // Get the size of the list
        System.out.println("List size: " + fruits.size()); // Output: 2
    }
}
```

### 2. Iterating Through an `ArrayList`

```java
import java.util.ArrayList;

public class IterateExample {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        // Method 1: For-Each Loop (Recommended)
        System.out.println("Using For-Each:");
        for (String color : colors) {
            System.out.println(color);
        }

        // Method 2: Standard For Loop
        System.out.println("\nUsing Standard For Loop:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }
}
```

---

### `ArrayList` vs. `LinkedList`

- Use **`ArrayList`** when your primary operations are **accessing elements by index** or adding/removing elements at the **end** of the list.
- Use **`LinkedList`** when you need frequent insertions and deletions at the **beginning or middle** of the list, as it doesn't require shifting elements.
