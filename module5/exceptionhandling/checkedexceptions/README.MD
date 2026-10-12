```
## 📂 Folder Structure

```
├── IOException/           # Handling input/output stream errors
├── SQLException/          # Handling database access and connectivity errors
└── FileNotFoundException/ # Handling missing file scenarios (subclass of IOException)

```
---

## 1. 📁 IOException

`IOException` is the base class for exceptions thrown while accessing information using streams, files, and directories. It represents general Input/Output failures.

* **Common Causes:** Network drops, closed streams, or general read/write failures.
* **Example Use Case:** Reading data from a file or network socket.
---

## 2. 📁 SQLException

`SQLException` provides information on database access errors or other errors related to database connectivity and SQL statement execution.

* **Common Causes:** Invalid SQL syntax, connection timeouts, incorrect credentials, or database server downtime.
* **Example Use Case:** Executing queries or updates against a relational database via JDBC.

---

## 3. 📁 FileNotFoundException

`FileNotFoundException` is a subclass of `IOException`. It is thrown when an attempt to open the file denoted by a specified pathname has failed (i.e., the file does not exist at the given path).

* **Common Causes:** Typo in file path, missing configuration files, or attempting to read a file that hasn't been created yet.
* **Example Use Case:** Loading a configuration file or reading a user-submitted document.

---


