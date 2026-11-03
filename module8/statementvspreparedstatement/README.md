# Java JDBC: `Statement` vs `PreparedStatement`

## Overview

When working with Java Database Connectivity (JDBC), executing SQL queries requires an implementation of the `java.sql.Statement` interface. The two most commonly used interfaces for executing SQL statements are:

1. **`Statement`**: Used for executing static SQL queries without parameters.
2. **`PreparedStatement`**: Extends `Statement` and is used to execute precompiled SQL queries with or without dynamic parameters.

---

## Quick Comparison

| Feature                        | `Statement`                        | `PreparedStatement`                          |
| :----------------------------- | :--------------------------------- | :------------------------------------------- |
| **SQL Type**                   | Static SQL queries                 | Dynamic / Parameterized SQL queries          |
| **Compilation**                | Compiled every time it is executed | Compiled once, executed multiple times       |
| **Performance**                | Slower for repetitive queries      | Faster for repeated execution (Pre-compiled) |
| **SQL Injection Risk**         | High (Vulnerable)                  | Safe (Prevents SQL Injection)                |
| **Binary Objects (BLOB/CLOB)** | Hard / Inefficient to handle       | Simple & efficient (`setBinaryStream`, etc.) |
| **Parameter Placeholder**      | Uses String concatenation (`+`)    | Uses `?` placeholders                        |

---

## 1. Security: SQL Injection Prevention

### The Problem with `Statement`

Using `Statement` with string concatenation leaves your application exposed to SQL Injection (SQLi) attacks.

```java
// VULNERABLE TO SQL INJECTION
String username = "admin' OR '1'='1";
String password = "password";

String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(sql);
```

> **Security Risk:** The resulting query bypasses authentication entirely because the SQL logic is altered at runtime.

---

### The Solution: `PreparedStatement`

`PreparedStatement` uses parameterized queries with `?` placeholders. The database treats input values strictly as **data**, not as executable SQL code.

```java
// SAFE FROM SQL INJECTION
String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);

preparedStatement.setString(1, username);
preparedStatement.setString(2, password);

ResultSet resultSet = preparedStatement.executeQuery();
```

---

## 2. Performance & Compilation

### How `Statement` Works

Every time a `Statement` is executed, the Database Engine performs four steps:

1. Parse SQL query
2. Compile SQL query
3. Optimize execution plan
4. Execute query

If you run a query inside a loop $1,000$ times using `Statement`, the database will compile and plan the query **1,000 times**.

---

### How `PreparedStatement` Works

`PreparedStatement` pre-compiles the SQL query structure upon creation:

1. **At Creation (`prepareStatement`):** Parse, compile, and optimize execution plan.
2. **At Execution (`executeQuery` / `executeUpdate`):** Pass parameters directly to the compiled plan.

If you run a parameterized query $1,000$ times, compilation happens **once**, drastically reducing database load and latency.

```java
// Efficient batch insertion with PreparedStatement
String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
PreparedStatement pstmt = connection.prepareStatement(sql);

for (Employee emp : employeeList) {
    pstmt.setString(1, emp.getName());
    pstmt.setDouble(2, emp.getSalary());
    pstmt.addBatch();
}

pstmt.executeBatch(); // Highly efficient
```

---

## Best Practices

1. **Default Choice:** Always default to using **`PreparedStatement`**—even for queries without parameters.
2. **Resource Management:** Always close your `Statement`, `PreparedStatement`, and `ResultSet` objects using `try-with-resources` blocks to avoid connection leaks:
   ```java
   try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
       // execute queries
   } catch (SQLException e) {
       e.printStackTrace();
   }
   ```
3. **When to use `Statement`?**
   - Rare cases involving DDL statements (e.g., `CREATE TABLE`, `DROP TABLE`) where SQL syntax is static and fixed within trusted application code.
