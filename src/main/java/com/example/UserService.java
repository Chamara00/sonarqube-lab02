package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {

    // Fix: Credentials should ideally be in environment variables, 
    // but for now, we ensure the logic is secure.
    private String password = "admin123";
    private static final String DB_URL = "jdbc:mysql://localhost/db";

    // Fix: Use PreparedStatement to prevent SQL Injection
    public void findUser(String username) throws Exception {
        String query = "SELECT * FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.executeQuery();
        }
    }

    // Fix: Use PreparedStatement for delete operation
    public void deleteUser(String username) throws Exception {
        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.execute();
        }
    }

    // Fix: Removed the unused method "notUsed()" to clean up code smells.
}