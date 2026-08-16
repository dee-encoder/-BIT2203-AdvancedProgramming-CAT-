import java.sql.*;

public class StudentLogin {

    public static boolean authenticateStudent(String regNumber, String password) {
        String url = "jdbc:mysql://localhost:3306/university_db";
        String dbUser = "root";
        String dbPassword = "124";

        // SQL query with placeholders instead of concatenated values
        String query = "SELECT * FROM students WHERE reg_number = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Bind parameters safely — treated as data, not SQL code
            stmt.setString(1, regNumber);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login successful. Welcome, " + rs.getString("full_name"));
                    return true;
                } else {
                    System.out.println("Invalid registration number or password.");
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        authenticateStudent("BIT2203/001", "mypassword123");
        authenticateStudent("' OR '1'='1", "' OR '1'='1");
    }
}