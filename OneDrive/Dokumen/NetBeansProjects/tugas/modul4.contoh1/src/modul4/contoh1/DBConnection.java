/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul4.contoh1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DBConnection {
    // konfigurasi koneksi ke database
    private static final String URL = "jdbc:mysql://localhost:3306/pustakaloka";
    private static final String USER = "root"; // Sesuaikan user nya
    private static final String PASSWORD = ""; // Sesuaikan password nya

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
