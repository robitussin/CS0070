# Java OOP Order System Demo 

A beginner-friendly Java console application designed to teach and demonstrate the core concepts of **Object-Oriented Programming (OOP)**: **Abstraction**, **Inheritance**, **Polymorphism**, and **Interfaces**.

---

##  Educational Concepts Demonstrated

This project is structured specifically as a teaching tool for beginner and intermediate Java learners.

| OOP Concept | Project Implementation |
| :--- | :--- |
| **Abstraction** | `MenuItem` is an `abstract class` that defines common attributes (`name`, `price`) and requires child classes to implement `getDetails()`. |
| **Inheritance** | `FoodItem` and `DrinkItem` extend `MenuItem`, inheriting common properties while adding specialized ones (`isSpicy`, `size`). |
| **Polymorphism** | `Order` handles an array of type `MenuItem[]`. At runtime, calling `.getDetails()` dynamically invokes the specific subclass implementation. |
| **Interface** | `Discountable` enforces a contract for calculating discounts, implemented directly by the `Order` class. |

---

##  Features

- **Interactive Console Menu:** Select items from an interactive prompt.
- **Dynamic Calculation:** Automatically calculates total cost and applies a 10% discount upon checkout.
- **Polymorphic Menu Rendering:** Displays custom details depending on whether the item is food or drink.

---

##  Getting Started

### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE / Terminal:** Any Java-compatible IDE (NetBeans, IntelliJ IDEA, Eclipse, VS Code) or command line interface.

### Running the Project

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/java-oop-order-system.git
   cd java-oop-order-system
   ```

2. **Compile the Code**
   ```bash
   javac com/mycompany/ordersystemoop/OrderSystemOOP.java
   ```

3. **Run the Application**
   ```bash
   java com.mycompany.ordersystemoop.OrderSystemOOP
   ```

---

## Code Structure Overview

```text
src/
└── com/mycompany/ordersystemoop/
    ├── Discountable.java    // Interface defining discount behavior
    ├── MenuItem.java        // Abstract parent class
    ├── FoodItem.java        // Child class representing food items
    ├── DrinkItem.java       // Child class representing drink items
    ├── Order.java           // Handles order items and total calculation
    └── OrderSystemOOP.java  // Main execution class (Driver)
```

---

## 📝 License

This project is open-source and available under the [MIT License](LICENSE). Feel free to use it for teaching, learning, or modifying as needed!
