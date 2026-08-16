import java.sql.*;

public class UniversityDatabase {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/university_db";
        String user = "admin";
        String password = "secure123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to university_db successfully.");

            createCoursesTable(conn);
            insertSampleCourses(conn);
            displayComputerScienceCourses(conn);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Creates the 'courses' table if it doesn't already exist
    public static void createCoursesTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS courses (" +
                "course_id INT PRIMARY KEY, " +
                "course_name VARCHAR(100), " +
                "credits INT, " +
                "department VARCHAR(50))";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'courses' created (or already exists).");
        }
    }

    // three courses using PreparedStatement
    public static void insertSampleCourses(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO courses (course_id, course_name, credits, department) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            // Course 1
            stmt.setInt(1, 101);
            stmt.setString(2, "Introduction to Programming");
            stmt.setInt(3, 3);
            stmt.setString(4, "Computer Science");
            stmt.executeUpdate();

            // Course 2
            stmt.setInt(1, 102);
            stmt.setString(2, "Database Systems");
            stmt.setInt(3, 4);
            stmt.setString(4, "Computer Science");
            stmt.executeUpdate();

            // Course 3
            stmt.setInt(1, 201);
            stmt.setString(2, "Principles of Marketing");
            stmt.setInt(3, 3);
            stmt.setString(4, "Business");
            stmt.executeUpdate();

            System.out.println("Sample courses inserted successfully.");

        } catch (SQLIntegrityConstraintViolationException e) {
            // Happens if course_id already exists (e.g., program run more than once)
            System.out.println("Note: Some sample courses already exist, skipping duplicates.");
        }
    }

    // Retrieves and displays all courses from the Computer Science department
    public static void displayComputerScienceCourses(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM courses WHERE department = ?";

        try (PreparedStatement stmt = conn.prepareStatement(selectSQL)) {
            stmt.setString(1, "Computer Science");

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nComputer Science Courses:");
                System.out.println("-------------------------------------------------");
                System.out.printf("%-10s %-30s %-8s%n", "ID", "Course Name", "Credits");
                System.out.println("-------------------------------------------------");

                while (rs.next()) {
                    int id = rs.getInt("course_id");
                    String name = rs.getString("course_name");
                    int credits = rs.getInt("credits");

                    System.out.printf("%-10d %-30s %-8d%n", id, name, credits);
                }
            }
        }
    }
}