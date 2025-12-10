-- Hotel Management System Database Schema
-- Database: hoteldb

-- Create Database
CREATE DATABASE IF NOT EXISTS hoteldb;
USE hoteldb;

-- Users Table
CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    birth_year VARCHAR(4),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    gender VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Hotels Table
CREATE TABLE IF NOT EXISTS hotels (
    hotel_id INT PRIMARY KEY AUTO_INCREMENT,
    hotel_name VARCHAR(200) NOT NULL,
    description TEXT,
    location VARCHAR(200),
    city VARCHAR(100),
    rating DECIMAL(2,1),
    price_per_night DECIMAL(10,2),
    image_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Reservations Table
CREATE TABLE IF NOT EXISTS reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    hotel_id INT NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    total_price DECIMAL(10,2),
    status VARCHAR(20) DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE
);

-- Admins Table (extends users concept)
CREATE TABLE IF NOT EXISTS admins (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    position VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert Sample Hotels
INSERT INTO hotels (hotel_name, description, location, city, rating, price_per_night, image_url) VALUES
('Blue Horizon Suites', 'Eşsiz deniz manzarasıyla huzurun yeni adresi.', 'Sahil Bölgesi', 'Antalya', 9.3, 1500.00, 'otel1.jpg'),
('Crystal Bay Lodge', 'Lüks konfor ve tropikal atmosferin buluştuğu tatil.', 'Marina', 'Bodrum', 9.1, 1200.00, 'otel2.jpg'),
('Starlight Cove Retreat', 'Zümrüt yeşili doğa ve mavinin buluştuğu eşsiz tatil.', 'Yamaç Bölgesi', 'Fethiye', 9.5, 1700.00, 'otel3.jpg'),
('Golden Beach Hotel', 'Altın kumsalların tam yanında.', 'Plaj Bölgesi', 'Bodrum', 8.7, 1200.00, 'otel4.webp'),
('Mountain View Resort', 'Dağ manzarasıyla dinlenme fırsatı.', 'Merkez', 'Uludağ', 9.0, 1000.00, 'otel5.jpg'),
('Sea Breeze Inn', 'Deniz esintisini hissedin.', 'Marina', 'Çeşme', 8.5, 900.00, 'otel1.jpg');

-- Insert Sample Admin (Password: admin123)
-- Note: In production, use proper password hashing
INSERT INTO admins (username, password, phone_number, email, position) VALUES
('admin', 'admin123', '5XXXXXXXXX', 'admin@example.com', 'CEO');

-- Insert Sample User (Password: user123)
INSERT INTO users (username, password, name, surname, birth_year, email, phone, address, gender) VALUES
('user', 'user123', 'Demo', 'User', '1990', 'user@example.com', '5XXXXXXXXX', 'Example Address', 'Male');

-- For SQL Server, use this alternative syntax:
-- CREATE TABLE users (
--     user_id INT PRIMARY KEY IDENTITY(1,1),
--     username NVARCHAR(50) UNIQUE NOT NULL,
--     password NVARCHAR(255) NOT NULL,
--     name NVARCHAR(100) NOT NULL,
--     surname NVARCHAR(100) NOT NULL,
--     birth_year NVARCHAR(4),
--     email NVARCHAR(100) UNIQUE NOT NULL,
--     phone NVARCHAR(20),
--     address NVARCHAR(MAX),
--     gender NVARCHAR(10),
--     created_at DATETIME DEFAULT GETDATE(),
--     updated_at DATETIME DEFAULT GETDATE()
-- );
