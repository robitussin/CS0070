## What is a Generic Class?

A generic class in Java as a template or a blueprint that can work with any data type you choose, while keeping your code safe and organized.

Instead of writing separate classes for handling Strings, Integers, or custom objects, you write one class with a placeholder for the data type.

### How Generics Work

With generics, you use a type parameter (usually written inside angle brackets like <T>) as a placeholder for the actual data type.

```
public class Rating<T> {
    private T score;

    public void setScore(T score) {
        this.score = score;
    }

    public T getScore() {
        return score;
    }
}
```

### How You Use It

When you actually create an object from this generic class, you specify the exact type you want to use inside the angle brackets:

```
    Rating<Integer> integerRating = new Rating<>();
    integerRating.setScore(5);

    Rating<Double> doubleRating = new Rating<>();
    doubleRating.setScore(4.5);

    Rating<String> stringRating = new Rating<>();
    stringRating.setScore("Excellent");
```

### Why do we use Generic classes?

In different applications, ratings are represented in different ways:

- **Numerical Star Ratings:** 5 or 4 (Integer)

- **Precise Decimal Scores:** 4.8 or 9.5 (Double)

- **Textual Feedback:** "Thumbs Up", "Recommended", or "5 Stars" (String)

Without generics, you would either have to create multiple classes (StarRating, DecimalRating, TextRating) or use Object (which leads to type-safety risks and annoying type-casting).

With a Generic Class, you write the code once, and it safely works with any type.
