package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {

    private String password = "admin123";
    private static final String DB_URL = "jdbc:mysql://localhost/db";

    public void findUser(String username) throws Exception {
        // Fix: Do not use "SELECT *"; specify columns like "id, name, email"
        String query = "SELECT id, name FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.executeQuery();
        }
    }

    public void deleteUser(String username) throws Exception {
        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.execute();
        }
    }
}