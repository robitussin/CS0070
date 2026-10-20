## What is a `Map`?

A **`Map`** is an object in the `java.util` package that maps **keys to values**. It cannot contain duplicate keys; each key can map to at most one value.

> **Note:** Although part of the Java Collections Framework, `Map` does **not** inherit from the `Collection` interface because it operates on key-value pairs rather than individual elements.

### Key Characteristics:

- **Unique Keys:** Duplicate keys are not allowed. Adding an entry with an existing key overwrites the previous value.
- **Key-to-Value Mapping:** Values are retrieved using their corresponding key.
- **Duplicate Values Allowed:** Multiple keys can map to the same value.
- **Objects Only:** Stores object references for both keys and values (uses wrapper classes like `Integer` or `Double` for primitive types).

---

## Main Implementations

Java provides three primary classes that implement the `Map` interface:

| Class               | Internal Structure              | Ordering                  | Time Complexity (`get`/`put`) | Best Used For                                                                                               |
| :------------------ | :------------------------------ | :------------------------ | :---------------------------- | :---------------------------------------------------------------------------------------------------------- |
| **`HashMap`**       | Hash Table                      | Unordered                 | $O(1)$ amortized              | General performance when iteration order does not matter. Allows one `null` key and multiple `null` values. |
| **`LinkedHashMap`** | Hash Table + Doubly-Linked List | Insertion Order           | $O(1)$ constant time          | Maintaining predictable iteration order based on entry insertion.                                           |
| **`TreeMap`**       | Red-Black Tree                  | Sorted (Natural / Custom) | $O(\log n)$ logarithmic       | Storing key-value pairs in a sorted key order. Disallows `null` keys.                                       |

---

## Common Methods

| Method                                     | Description                                                                  | Return Type                     |
| :----------------------------------------- | :--------------------------------------------------------------------------- | :------------------------------ |
| `put(K key, V value)`                      | Associates the specified value with the specified key in the map.            | `V` (previous value, or `null`) |
| `get(Object key)`                          | Returns the value to which the specified key is mapped, or `null`.           | `V`                             |
| `getOrDefault(Object key, V defaultValue)` | Returns the value mapped to the key, or the default value if key is missing. | `V`                             |
| `containsKey(Object key)`                  | Checks if the map contains a mapping for the specified key.                  | `boolean`                       |
| `containsValue(Object value)`              | Checks if the map maps one or more keys to the specified value.              | `boolean`                       |
| `remove(Object key)`                       | Removes the mapping for a key from the map if it is present.                 | `V` (removed value)             |
| `keySet()`                                 | Returns a `Set` view of the keys contained in the map.                       | `Set<K>`                        |
| `values()`                                 | Returns a `Collection` view of the values contained in the map.              | `Collection<V>`                 |
| `entrySet()`                               | Returns a `Set` view of the key-value mappings (`Map.Entry<K, V>`).          | `Set<Map.Entry<K, V>>`          |
| `size()`                                   | Returns the number of key-value mappings.                                    | `int`                           |

---

## Code Examples

### 1. Basic `HashMap` Operations

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();

        // Add key-value pairs
        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);
        inventory.put("Oranges", 20);

        // Updating a value (overwriting existing key)
        inventory.put("Apples", 75);

        // Accessing values
        System.out.println("Apple count: " + inventory.get("Apples")); // Output: 75

        // Using getOrDefault to avoid NullPointerException
        System.out.println("Grapes count: " + inventory.getOrDefault("Grapes", 0)); // Output: 0

        // Checking existence
        if (inventory.containsKey("Bananas")) {
            System.out.println("Bananas are in stock!");
        }

        // Removing an entry
        inventory.remove("Oranges");
    }
}
```

### 2. Iterating Through a `Map`

```java
import java.util.HashMap;
import java.util.Map;

public class MapIterationExample {
    public static void main(String[] args) {
        Map<String, String> capitalMap = new HashMap<>();
        capitalMap.put("USA", "Washington D.C.");
        capitalMap.put("France", "Paris");
        capitalMap.put("Japan", "Tokyo");

        // Method 1: Iterating over key-value pairs using entrySet() (Most Efficient)
        System.out.println("--- EntrySet Iteration ---");
        for (Map.Entry<String, String> entry : capitalMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Method 2: Iterating using forEach (Java 8+)
        System.out.println("\n--- Java 8 forEach ---");
        capitalMap.forEach((country, capital) -> {
            System.out.println(country + ": " + capital);
        });
    }
}
```

### 3. Comparing `HashMap`, `LinkedHashMap`, and `TreeMap`

```java
import java.util.*;

public class MapComparison {
    public static void main(String[] args) {
        // 1. HashMap: No guaranteed order
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Charlie", 30);
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 35);
        System.out.println("HashMap (Unordered): " + hashMap);

        // 2. LinkedHashMap: Insertion order preserved
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Charlie", 30);
        linkedHashMap.put("Alice", 25);
        linkedHashMap.put("Bob", 35);
        System.out.println("LinkedHashMap (Insertion Order): " + linkedHashMap);

        // 3. TreeMap: Sorted by keys
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Charlie", 30);
        treeMap.put("Alice", 25);
        treeMap.put("Bob", 35);
        System.out.println("TreeMap (Sorted by Key): " + treeMap);
    }
}
```

---

## Important Considerations

- **`hashCode()` and `equals()`:** Custom object keys used in `HashMap` or `LinkedHashMap` **must** properly override `hashCode()` and `equals()`. Failing to do so will result in lost entries or unexpected duplicates.
- **Immutability of Keys:** Avoid modifying a key object after it has been inserted into a `Map`. Altering key properties that affect `equals` or `hashCode` renders the value unreachable.
- **Thread Safety:** `HashMap`, `LinkedHashMap`, and `TreeMap` are not synchronized. For thread-safe operations, use `ConcurrentHashMap` from `java.util.concurrent`.
