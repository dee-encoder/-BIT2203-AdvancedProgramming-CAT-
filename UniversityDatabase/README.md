# UniversityDatabase.java

## Description
A JDBC program demonstrating database connectivity, table creation, data insertion, and filtered data retrieval using Java's `java.sql` package.

## Database Config
- Database: `university_db`
- Username: `admin`
- Password: `secure123`

## What the program does
1. Connects to the `university_db` database via JDBC
2. Creates a `courses` table (if it doesn't already exist) with:
   - `course_id` — INT, Primary Key
   - `course_name` — VARCHAR(100)
   - `credits` — INT
   - `department` — VARCHAR(50)
3. Inserts three courses using `PreparedStatement`
4. Retrieves and displays all courses belonging to the **Computer Science** department

## Why PreparedStatement
`PreparedStatement` is used instead of `Statement` throughout to prevent SQL injection (user/query values are never concatenated directly into SQL) and to allow the database to reuse the compiled query plan on repeated execution.

## Requirements
- A running MySQL server.
- A database named `university_db`
- A MySQL user `admin` with password `secure123` and privileges on `university_db`
