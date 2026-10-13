## What is a Lambda Expression?

Think of a lambda expression as an **anonymous function**—a method without a declaration name that you can pass around as if it were a variable.

Before Java 8, if you wanted to pass behavior into a method (like sorting rules or event listeners), you had to write bulky **anonymous inner classes**. Lambdas strip away all that repetitive boilerplate code.

### The Anatomy

```java
(parameters) -> expression
// OR
(parameters) -> { statements; }
```

- **Parameters:** The inputs required by the function (enclosed in parentheses). If there is only one parameter, parentheses can be omitted.
- **Arrow Token (`->`):** Separates the parameter list from the function body.
- **Body:** The block of code or single expression to execute.

---

## Why use Lambda Expressions?

1. **Custom Functional Interfaces (`@FunctionalInterface`):**
   Lambdas can only be used with interfaces that contain **exactly one abstract method**. Our `MathOperation` interface is an example of this.
2. **Type Inference:**
   Notice how in `(a, b) -> a * b`, we didn't specify `int` data types for `a` and `b`. Java automatically infers the types based on the interface definition.
3. **Streamlined Collections (`forEach` and `sort`):**
   Lambdas drastically reduce the code needed to manipulate collections, making iterations and sorting concise and readable.
