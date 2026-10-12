## What is a Wrapper Class?

A wrapper class in Java is a class that "wraps" a primitive data type inside an object.

This allows primitive types (like `int`, `char`, etc.) to be treated as full objects, which is essential for object-oriented features, frameworks, and data structures like the Java Collections Framework

### Primitive Types and Their Matching Wrapper Classes

| Primitive Data Type | Wrapper Class |
| :------------------ | :------------ |
| `byte`              | `Byte`        |
| `short`             | `Short`       |
| `int`               | `Integer`     |
| `long`              | `Long`        |
| `float`             | `Float`       |
| `double`            | `Double`      |
| `char`              | `Character`   |
| `boolean`           | `Boolean`     |

### Why Do We Need Wrapper Classes?

1. **Autoboxing and Unboxing**
   - **Autoboxing:** Java automatically converts a primitive value into its corresponding wrapper object (e.g., `Integer wrappedAge = 25;`).

   - **Unboxing:** Java automatically extracts the primitive value back out of the wrapper object (e.g., `int normalAge = wrappedAge;`).

2. **Collections Support**
   - Data structures like `ArrayList`, `HashSet`, or `HashMap` **only** store objects. If you want a list of numbers, you must use a wrapper class like `ArrayList<Integer>` instead of `ArrayList<int>`.

3. **Built-in Utility Methods**
   - Wrapper classes come packed with helpful helper methods. For example, `Integer.parseInt()` lets you easily convert text strings (like user input or data from a file) into actual numbers.

4. **Handling `null` Values**
   - Primitives always default to a value (like `0` for numbers). Wrapper classes can be `null`, making them essential when representing missing, optional, or database-derived information.
