package com.example.demo;

public class SqlComparisonDemo {
    public static void main(String[] args) {

        // Hard to read, prone to typos, and requires manually adding newlines (\n) and
        // spaces
        String sqlOld = "SELECT id, first_name, email\n" +
                "FROM users\n" +
                "WHERE status = 'ACTIVE'\n" +
                "AND country = 'US'\n" +
                "ORDER BY created_at DESC;";

        // WITH TEXT BLOCK (Java 15+)
        // Highly readable, matches raw SQL copy-pasted straight from an editor, and
        // handles newlines natively
        String sqlNew = """
                SELECT id, first_name, email
                FROM users
                WHERE status = 'ACTIVE'
                AND country = 'US'
                ORDER BY created_at DESC;
                """;

        // Both evaluate to identical java.lang.String values
        System.out.println("Are both queries functionally identical? " + sqlOld.equals(sqlNew));
    }
}
