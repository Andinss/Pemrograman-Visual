/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul4.contoh1;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class UserDAO {

    public static ObservableList<User> getUsers() {
        // ObservableList untuk menyimpan data user
        ObservableList<User> userList = FXCollections.observableArrayList();
        String query = "SELECT * FROM users";

        try {
            // Membuat koneksi ke database
            Connection koneksi = DBConnection.getConnection();
            // Membuat statement
            Statement stmt = koneksi.createStatement();
            // Query untuk mengambil data user
            ResultSet rs = stmt.executeQuery(query);
            
             // Menambahkan data ke ObservableList
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");

                userList.add(new User(
                    username,
                    password,
                    fullname
                ));
            }

            // Menutup koneksi
            rs.close();
            stmt.close();
            koneksi.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    // Metode untuk menambahkan user (Create)
public static void addUser(User user) {
    String query = "INSERT INTO users (username, password, fullname) VALUES (?, MD5(?), ?)";

    try (
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement stmt = koneksi.prepareStatement(query)
    ) {
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getFullname());

        stmt.executeUpdate();

        stmt.close();
        koneksi.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Metode untuk memperbarui user (Update)
public static void updateUser(User user) {
    String query = "UPDATE users SET password = MD5(?), fullname = ? WHERE username = ?";

    try (
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement stmt = koneksi.prepareStatement(query)) {
        
        stmt.setString(1, user.getPassword());
        stmt.setString(2, user.getFullname());
        stmt.setString(3, user.getUsername());

        stmt.executeUpdate();

        stmt.close();
        koneksi.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

//Metode untuk menghapus user (Delete)
public static void deleteUser(String username){
    String query ="DELETE FROM users WHERE username = ?";
    
    try (
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement smt = koneksi.prepareStatement(query)) {
        
        smt.setString(1, username);
        
        smt.executeUpdate();
        
        smt.close();
        koneksi.close();
       
    } catch (SQLException e){
        e.printStackTrace();
    }
}
}
