

## Folder Structure

```text
├── arithmetic_exception/           # Handling illegal arithmetic operations
├── arrayindexoutofbounds_exception/ # Handling invalid array index access
├── illegalargument_exception/      # Handling inappropriate method arguments
├── multiplecatchblocks/            # Demonstrating multiple catch blocks handling
├── nullpointer_exception/          # Handling null object reference accesses
└── numberformat_exception/         # Handling failed string-to-number conversions

```

---

## 📁 arithmetic_exception
`ArithmeticException` is thrown when an exceptional arithmetic condition has occurred.

* **Common Causes:** Dividing an integer by zero (/ 0) or performing an invalid modulo operation.

* **Example Use Case:** Calculating ratios or percentages where a dynamic denominator evaluates to zero.

## 📁 arrayindexoutofbounds_exception
`ArrayIndexOutOfBoundsException` is thrown to indicate that an array has been accessed with an illegal index.

* **Common Causes:** Using a negative index or an index greater than or equal to the array's size (length).

* **Example Use Case:** Iterating past the bounds of an array due to an incorrect loop condition (<= instead of <).

## 📁 illegalargument_exception
`IllegalArgumentException` is thrown to indicate that a method has been passed an inappropriate, illegal, or out-of-range argument.

* **Common Causes:** Passing negative values where positive ones are expected, or supplying conflicting configuration parameters.

* **Example Use Case:** Setting a user's age or percentage value to an impossible negative number.

## 📁 multiplecatchblocks
This directory demonstrates how to handle multiple types of exceptions using a single `try` block followed by specialized `catch` blocks.

* **Common Causes:** Executing complex code blocks where different statements can trigger distinct runtime errors.

* **Example Use Case:** Processing user input strings, parsing them to numbers, and performing arithmetic computations.

## 📁 nullpointer_exception
`NullPointerException` is thrown when an application attempts to use a `null` reference where an object is required.

* **Common Causes:** Invoking instance methods, accessing fields, or checking the length of an object reference that has not been initialized (`null`).

* **Example Use Case:** Processing uninitialized string variables or missing object properties returned from a database query.

## 📁 numberformat_exception
`NumberFormatException` is thrown when an application attempts to convert a string into one of the numeric types, but the string does not have the appropriate format.

* **Common Causes:** Parsing strings containing letters, symbols, or incorrect formatting (e.g., `Integer.parseInt("abc")`).

* **Example Use Case:** Converting user input from text fields or configuration files into numeric values (like IDs or ages).
