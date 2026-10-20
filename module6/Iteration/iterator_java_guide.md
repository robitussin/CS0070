## What is an `Iterator`?

An **`Iterator`** is an object belonging to the `java.util` package that enables you to step through a collection of elements one by one. It provides a uniform interface to traverse elements across different collection types (`List`, `Set`, `Queue`, etc.) without exposing the underlying data structure (array, linked list, tree, etc.).

> **Note:** `Iterator` is a **one-way traversal** tool (moves only forward). If bidirectional traversal is required for a `List`, Java provides the specialized `ListIterator` interface.

### Key Characteristics:

- **Fail-Fast Behavior:** Standard iterators thrown by Java collections throw a `ConcurrentModificationException` if the collection is structurally modified (added/removed elements outside the iterator) while traversing.
- **Safe Removal:** An `Iterator` provides a safe way to remove elements while looping without throwing exceptions.
- **Universal Interface:** Works across all classes implementing the `Collection` or `Iterable` interfaces.

---

## Main Methods

The `Iterator<E>` interface provides the following primary methods:

| Method                                         | Description                                                                                                               | Return Type |
| :--------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------ | :---------- |
| `hasNext()`                                    | Returns `true` if the iteration has more elements.                                                                        | `boolean`   |
| `next()`                                       | Returns the next element in the iteration and advances the cursor. Throws `NoSuchElementException` if no elements remain. | `E`         |
| `remove()`                                     | Removes the last element returned by `next()` from the underlying collection.                                             | `void`      |
| `forEachRemaining(Consumer<? super E> action)` | Performs the given action for each remaining element until all elements have been processed.                              | `void`      |

---

## 💻 Code Examples

### 1. Basic Traversal with `Iterator`

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicIteratorExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Obtaining the iterator
        Iterator<String> iterator = fruits.iterator();

        // Traversing elements
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Fruit: " + fruit);
        }
    }
}
```

### 2. Safe Element Removal During Iteration

Modifying a collection directly while looping over it with a standard `for-each` loop causes a `ConcurrentModificationException`. Using `Iterator.remove()` avoids this error safely.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SafeRemovalExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Iterator<Integer> iterator = numbers.iterator();

        // Safely remove even numbers
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove(); // Safely removes element
            }
        }

        System.out.println("Odd numbers remaining: " + numbers);
        // Output: [1, 3, 5, 7, 9]
    }
}
```

### 3. Using `forEachRemaining` (Java 8+)

```java
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEachRemainingExample {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Yellow");
        Iterator<String> iterator = colors.iterator();

        // Process the first item manually
        if (iterator.hasNext()) {
            System.out.println("First color: " + iterator.next());
        }

        // Process all remaining items using a Lambda expression
        System.out.println("Remaining colors:");
        iterator.forEachRemaining(color -> System.out.println("- " + color));
    }
}
```

---

## `Iterator` vs. `ListIterator`

| Feature                 | `Iterator`                                            | `ListIterator`                                                      |
| :---------------------- | :---------------------------------------------------- | :------------------------------------------------------------------ |
| **Applicability**       | Works with any `Collection` (`List`, `Set`, `Queue`). | Works **only** with `List` implementations.                         |
| **Traversal Direction** | Forward only                                          | Forward and Backward (`hasPrevious()`, `previous()`)                |
| **Modifications**       | Can only remove elements (`remove()`)                 | Can remove, replace (`set()`), or add (`add()`) elements            |
| **Index Access**        | No index tracking                                     | Tracks next and previous indices (`nextIndex()`, `previousIndex()`) |

---

## Key Rules & Pitfalls

1. **`remove()` Requirement:** You **must** call `next()` at least once before calling `remove()`. Calling `remove()` twice in succession or before calling `next()` throws an `IllegalStateException`.
2. **Concurrent Modifications:** Avoid calling `list.add()` or `list.remove()` directly while using an iterator. Always use `iterator.remove()` to modify the underlying dataset during iteration.
3. **`Iterable` Interface:** Any class implementing the `Iterable<T>` interface must supply an `iterator()` method, making it compatible with Java's `for-each` loop syntax:
   ```java
   for (String item : collection) { ... }
   ```
   _(Behind the scenes, the enhanced for-each loop is translated by the compiler into an `Iterator` loop)._
