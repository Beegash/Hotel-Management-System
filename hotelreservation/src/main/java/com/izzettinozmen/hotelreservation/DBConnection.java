

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.izzettinozmen.hotelreservation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        loadDatabaseProperties();
    }

    // Database özelliklerini yükleme metodu
    private static void loadDatabaseProperties() {
        Properties props = new Properties();
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.err.println("db.properties dosyası bulunamadı! Varsayılan değerler kullanılıyor.");
                // Varsayılan değerler (sadece development için)
                URL = "jdbc:sqlserver://127.0.0.1:1433;instanceName=SQLEXPRESS;databaseName=hoteldb;encrypt=false";
                USER = "sa";
                PASSWORD = "1234";
                return;
            }
            
            props.load(input);
            String dbType = props.getProperty("db.type", "sqlserver");
            
            if ("mysql".equalsIgnoreCase(dbType)) {
                URL = props.getProperty("db.mysql.url");
                USER = props.getProperty("db.mysql.username");
                PASSWORD = props.getProperty("db.mysql.password");
            } else {
                URL = props.getProperty("db.sqlserver.url");
                USER = props.getProperty("db.sqlserver.username");
                PASSWORD = props.getProperty("db.sqlserver.password");
            }
            
        } catch (IOException e) {
            System.err.println("db.properties dosyası yüklenirken hata oluştu: " + e.getMessage());
            // Varsayılan değerler
            URL = "jdbc:sqlserver://127.0.0.1:1433;instanceName=SQLEXPRESS;databaseName=hoteldb;encrypt=false";
            USER = "sa";
            PASSWORD = "1234";
        }
    }

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
