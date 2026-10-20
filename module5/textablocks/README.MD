# Java Text Blocks

A minimal, self-contained Java example demonstrating the readability improvements introduced by **Java Text Blocks** (standardized in **Java 15** via JEP 378).

## Overview

Writing multi-line strings in traditional Java (such as SQL statements, JSON payloads, or HTML templates) requires tedious string concatenation (`+`) and explicit newline characters (`\n`). This project provides a side-by-side comparison showing how Text Blocks resolve this friction by improving code maintainability and layout readability.

## The Comparison

### Traditional Approach (Without Text Blocks)

- Requires explicit `\n` line terminators.
- Requires `+` operators to concatenate fragments.
- Prone to syntax and spacing bugs during refactoring.

### Modern Approach (With Text Blocks)

- Uses triple double quotes (`"""`) to enclose the block.
- Preserves natural layout formatting natively.
- Eliminates the need to escape standard quotes or concatenate line-by-line.

### Example

**WITHOUT TEXT BLOCK**
Hard to read, prone to typos, and requires manually adding newlines (\n) and spaces

```
String sqlOld = "SELECT id, first_name, email\n" +
"FROM users\n" +
"WHERE status = 'ACTIVE'\n" +
"AND country = 'US'\n" +
"ORDER BY created_at DESC;";
```

**WITH TEXT BLOCK (Java 15+)**

Highly readable, matches raw SQL copy-pasted straight from an editor, and
handles newlines natively

```
String sqlNew = """
SELECT id, first_name, email
FROM users
WHERE status = 'ACTIVE'
AND country = 'US'
ORDER BY created_at DESC;
""";
```
