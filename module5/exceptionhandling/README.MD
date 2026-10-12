## Quick Comparison

| Feature | Checked Exceptions | Unchecked Exceptions |
| --- | --- | --- |
| **Parent Class** | `Exception` (excluding `RuntimeException`) | `RuntimeException` |
| **Checked At** | **Compile-time** | **Runtime** |
| **Handling Requirement** | Mandatory (`try-catch` or `throws`) | Optional |
| **Typical Cause** | External issues (e.g., file not found, network timeout) | Programming bugs (e.g., null pointer, invalid argument) |

---

## 📁 Checked Exceptions

Checked exceptions are checked by the compiler at **compile-time**. If a method throws a checked exception, it **must** either handle it using a `try-catch` block or declare it in its signature using the `throws` keyword. Otherwise, the code will fail to compile.

* **When to use:** When the application can reasonably recover from the error (e.g., missing configuration file, database connection failure).
* **Common Examples:** `IOException`, `SQLException`, `ClassNotFoundException`.
---

## 📁 Unchecked Exceptions

Unchecked exceptions are not checked at compile-time; instead, they occur at **runtime**. They inherit from `RuntimeException`. The compiler does not force you to catch or declare these exceptions.

* **When to use:** Usually represent programming logic flaws or improper API usage that should be fixed in the code rather than handled gracefully at runtime.
* **Common Examples:** `NullPointerException`, `ArrayIndexOutOfBoundsException`, `IllegalArgumentException`, `ArithmeticException`.

---

## Best Practices

* **Use Checked Exceptions** for recoverable conditions where the calling code can take corrective action.
* **Use Unchecked Exceptions** for programming errors, invalid arguments, or invariant violations that indicate a bug in the code.
* **Avoid overusing `throws Exception**` on checked exceptions, as it defeats the purpose of compile-time safety.



```
