## What is a Method Reference?

A method reference in Java is an even shorter, cleaner shorthand for a lambda expression.

If your lambda expression does nothing more than call an existing method, you can replace that lambda with a method reference using the double-colon `(::)` operator.

### Example

Imagine you have a list of names and you want to print each one.

**Using a Lambda Expression:**

```
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name));
```

**Using a Method Reference:**

```
names.forEach(System.out::println);
```

Notice how much cleaner the second one is! The parameter `(name)` and the redundant wrapper are gone. `System.out::println` is a method reference pointing to the println method.

### Anatomy of a Method Reference

It uses the `::` operator.

When used with `forEach`, it eliminates repetitive parameter declarations, making your code extremely readable and concise.

### The 4 Main Types of Method References

Depending on what kind of method you are calling, Java supports four styles of method references:

1. Reference to a Static Method (`ClassName::staticMethod`)

Example: `Math::abs` instead of `x -> Math.abs(x)`

2. Reference to an Instance Method of a Particular Object (`instanceVariable::methodName`)

Example: System.out::println instead of `x -> System.out.println(x)`

3. Reference to an Instance Method of an Arbitrary Object of a Particular Type (`ClassName::methodName`)

Example: `String::toUpperCase` instead of `str -> str.toUpperCase()`

4. Reference to a Constructor (`ClassName::new`)

Example: `ArrayList::new` instead of `() -> new ArrayList()`
