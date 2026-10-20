## ArrayList

An ArrayList is a resizable array implementation of the List interface, located in the java.util package.

Unlike standard Java arrays (which have a fixed size determined at creation), an ArrayList automatically grows and shrinks as elements are added or removed.

**Dynamic Sizing:** Automatically expands its capacity when elements are added beyond its current limit.Indexed Access:

**Allows Duplicates & Nulls:** You can store duplicate values and null entries.

**Objects Only:** It stores object references, not primitive types. To store primitives (like int or double), Java automatically boxes them into their wrapper classes (like Integer or Double).

Method,Description,Time Complexity
add(E e),Appends the specified element to the end of the list.,O(1) amortized
"add(int index, E element)",Inserts the element at the specified position.,O(n)
get(int index),Returns the element at the specified position.,O(1)
"set(int index, E element)",Replaces the element at the specified position with the new element.,O(1)
remove(int index),Removes the element at the specified position.,O(n)
size(),Returns the number of elements in the list.,O(1)
contains(Object o),Returns true if the list contains the specified element.,O(n)
clear(),Removes all elements from the list.,O(1)
