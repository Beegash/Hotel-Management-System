

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.izzettinozmen.hotelreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database bağlantı URL'si
    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;instanceName=SQLEXPRESS;databaseName=hoteldb;encrypt=false";
    private static final String USER = "sa"; // SQL Server 'sa' kullanıcısı
    private static final String PASSWORD = "1234"; // Şifreyi kendi belirlediğiniz gibi girin

    // Bağlantı metodu
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Bağlantı başarılı!");
        } catch (SQLException e) {
            System.err.println("Bağlantı sırasında hata oluştu: " + e.getMessage());
            throw e;
        }
        return connection;
    }

    // Main metodu
    public static void main(String[] args) {
        try {
            // Bağlantı test
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Database bağlantısı başarıyla gerçekleştirildi.");
                conn.close(); // Bağlantıyı kapatma
            }
        } catch (SQLException e) {
            System.err.println("Main metodunda hata: " + e.getMessage());
        }
    }
}