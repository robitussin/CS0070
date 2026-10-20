## What is a `Set`?

A **`Set`** is a collection in the `java.util` package that **cannot contain duplicate elements**. It models the mathematical set abstraction and is used whenever you need to ensure that every element in a collection is unique.

### Key Characteristics:

- **No Duplicates:** Duplicate entries are automatically rejected.
- **At Most One Null:** Most `Set` implementations allow at most one `null` element (except sorted sets like `TreeSet`, which do not allow `null`).
- **Unordered (by default):** Unlike `List`s, standard sets do not guarantee a specific iteration order or provide index-based access (e.g., no `get(index)` method).

---

## Main Implementations

Java provides three primary classes that implement the `Set` interface:

| Class               | Internal Structure              | Ordering                  | Time Complexity (Add/Contains) | Best Used For                                               |
| :------------------ | :------------------------------ | :------------------------ | :----------------------------- | :---------------------------------------------------------- |
| **`HashSet`**       | Hash Table (`HashMap`)          | Unordered                 | $O(1)$ constant time           | General performance when order does not matter.             |
| **`LinkedHashSet`** | Hash Table + Doubly-Linked List | Insertion Order           | $O(1)$ constant time           | Maintaining predictable iteration order based on insertion. |
| **`TreeSet`**       | Red-Black Tree (`TreeMap`)      | Sorted (Natural / Custom) | $O(\log n)$ logarithmic        | Storing elements in a sorted, navigable order.              |

---

## Common Methods

| Method               | Description                                              | Return Type                   |
| :------------------- | :------------------------------------------------------- | :---------------------------- |
| `add(E e)`           | Adds the specified element if it is not already present. | `boolean` (`true` if added)   |
| `remove(Object o)`   | Removes the specified element from the set if present.   | `boolean` (`true` if removed) |
| `contains(Object o)` | Checks if the set contains the specified element.        | `boolean`                     |
| `size()`             | Returns the number of elements in the set.               | `int`                         |
| `isEmpty()`          | Checks whether the set is empty.                         | `boolean`                     |
| `clear()`            | Removes all elements from the set.                       | `void`                        |

---

## 💻 Code Examples

### 1. Basic `HashSet` Operations

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();

        // Adding elements
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Charlie");

        // Attempting to add a duplicate
        boolean isAdded = uniqueNames.add("Alice");
        System.out.println("Was second 'Alice' added? " + isAdded); // Output: false

        // Checking existence
        System.out.println("Contains Bob? " + uniqueNames.contains("Bob")); // Output: true

        // Size of the set
        System.out.println("Total elements: " + uniqueNames.size()); // Output: 3
    }
}
```

### 2. Comparing `HashSet`, `LinkedHashSet`, and `TreeSet`

```java
import java.util.*;

public class SetComparison {
    public static void main(String[] args) {
        // 1. HashSet: Unordered
        Set<String> hashSet = new HashSet<>(Arrays.asList("Banana", "Apple", "Cherry"));
        System.out.println("HashSet (Unordered): " + hashSet);

        // 2. LinkedHashSet: Insertion Order
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("Banana", "Apple", "Cherry"));
        System.out.println("LinkedHashSet (Insertion Order): " + linkedHashSet);

        // 3. TreeSet: Alphabetical/Sorted Order
        Set<String> treeSet = new TreeSet<>(Arrays.asList("Banana", "Apple", "Cherry"));
        System.out.println("TreeSet (Sorted): " + treeSet);
    }
}
```

---

## 🧠 Core Set Operations (Mathematical)

Java's `Set` interface supports bulk operations that correspond to standard mathematical set theory:

```java
Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
Set<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));

// Union: Combine all elements from both sets
Set<Integer> union = new HashSet<>(setA);
union.addAll(setB); // [1, 2, 3, 4, 5, 6]

// Intersection: Keep only elements present in both sets
Set<Integer> intersection = new HashSet<>(setA);
intersection.retainAll(setB); // [3, 4]

// Difference: Remove elements of setB from setA
Set<Integer> difference = new HashSet<>(setA);
difference.removeAll(setB); // [1, 2]
```

---

## ⚠️ Important Considerations

- **`equals()` and `hashCode()`:** If you store custom objects (e.g., a `User` class) in a `HashSet` or `LinkedHashSet`, you **must** properly override `equals()` and `hashCode()`. Otherwise, duplicate detection will fail.
- **`TreeSet` Requirements:** Objects stored in a `TreeSet` must either implement `Comparable<T>` or be supplied with a custom `Comparator` at creation time to determine sorting order.
