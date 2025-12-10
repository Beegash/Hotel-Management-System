# Hotel Management System

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-22-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Project-blue.svg)](https://maven.apache.org/)

Modern ve kullanıcı dostu bir otel yönetim ve rezervasyon sistemi. Java Swing ile geliştirilmiş masaüstü uygulaması.

## 📋 İçindekiler

- [Özellikler](#özellikler)
- [Teknolojiler](#teknolojiler)
- [Sistem Gereksinimleri](#sistem-gereksinimleri)
- [Kurulum](#kurulum)
- [Veritabanı Yapılandırması](#veritabanı-yapılandırması)
- [Kullanım](#kullanım)
- [Veritabanı Şeması](#veritabanı-şeması)
- [Proje Yapısı](#proje-yapısı)
- [Güvenlik Notları](#güvenlik-notları)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)
- [İletişim](#iletişim)

## ✨ Özellikler

### 👥 Kullanıcı Özellikleri
- **Kullanıcı Kaydı ve Girişi**: Güvenli kullanıcı hesabı oluşturma ve giriş yapma
- **Otel Arama ve Listeleme**: Detaylı otel bilgileri ve filtreleme seçenekleri
- **Rezervasyon Yönetimi**: Otel rezervasyonu oluşturma ve yönetme
- **Profil Yönetimi**: Kullanıcı bilgilerini güncelleme
- **Rezervasyon Geçmişi**: Geçmiş ve aktif rezervasyonları görüntüleme

### 🔐 Admin Özellikleri
- **Otel Yönetimi**: Yeni otel ekleme, düzenleme ve silme
- **Kullanıcı Yönetimi**: Kullanıcı hesaplarını görüntüleme ve yönetme
- **Rezervasyon Kontrolü**: Tüm rezervasyonları görüntüleme ve yönetme
- **Sistem Ayarları**: Sistem konfigürasyonlarını yönetme

### 🎨 Arayüz Özellikleri
- Modern ve kullanıcı dostu GUI (Java Swing)
- Responsive tasarım
- Smooth geçişler ve animasyonlar
- Görsel splash ekranları
- Otel görselleri ve derecelendirmeleri

## 🛠 Teknolojiler

- **Programlama Dili**: Java 22
- **GUI Framework**: Java Swing
- **Layout Manager**: NetBeans AbsoluteLayout
- **Build Tool**: Maven
- **Veritabanı**: 
  - SQL Server (Varsayılan)
  - MySQL (Alternatif)
- **JDBC Sürücüleri**: 
  - Microsoft SQL Server JDBC Driver
  - MySQL Connector/J

## 💻 Sistem Gereksinimleri

- **Java JDK**: 22 veya üzeri
- **Maven**: 3.6 veya üzeri
- **Veritabanı**: SQL Server 2019+ veya MySQL 8.0+
- **İşletim Sistemi**: Windows, macOS, Linux
- **RAM**: Minimum 4GB (8GB önerilir)
- **Disk Alanı**: 500MB

## 📥 Kurulum

### 1. Projeyi Klonlayın

```bash
git clone https://github.com/YOUR_USERNAME/Hotel-Management-System.git
cd Hotel-Management-System
```

### 2. Maven Bağımlılıklarını Yükleyin

```bash
cd hotelreservation
mvn clean install
```

### 3. Veritabanını Oluşturun

SQL Server veya MySQL kullanarak veritabanını oluşturun:

```bash
# MySQL için
mysql -u root -p < database/schema.sql

# SQL Server için SQL Server Management Studio kullanarak schema.sql dosyasını çalıştırın
```

### 4. Veritabanı Konfigürasyonunu Yapın

`hotelreservation/src/main/resources/` dizininde `db.properties` dosyası oluşturun:

```bash
cp hotelreservation/src/main/resources/db.properties.example hotelreservation/src/main/resources/db.properties
```

`db.properties` dosyasını düzenleyerek kendi veritabanı bilgilerinizi girin:

```properties
# Database Type (sqlserver or mysql)
db.type=sqlserver

# SQL Server Configuration
db.sqlserver.url=jdbc:sqlserver://127.0.0.1:1433;instanceName=SQLEXPRESS;databaseName=hoteldb;encrypt=false
db.sqlserver.username=sa
db.sqlserver.password=YOUR_PASSWORD

# MySQL Configuration (Alternative)
db.mysql.url=jdbc:mysql://localhost:3306/hoteldb
db.mysql.username=root
db.mysql.password=YOUR_PASSWORD
```

### 5. Uygulamayı Çalıştırın

```bash
# Maven ile çalıştırma
mvn clean javafx:run

# Veya JAR dosyası oluşturup çalıştırma
mvn clean package
java -jar target/hotelreservation-1.0-SNAPSHOT.jar
```

## 🗄️ Veritabanı Yapılandırması

### Desteklenen Veritabanları

#### SQL Server (Varsayılan)
```properties
db.type=sqlserver
db.sqlserver.url=jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=hoteldb;encrypt=false
db.sqlserver.username=sa
db.sqlserver.password=YOUR_PASSWORD
```

#### MySQL
```properties
db.type=mysql
db.mysql.url=jdbc:mysql://localhost:3306/hoteldb?useSSL=false&serverTimezone=UTC
db.mysql.username=root
db.mysql.password=YOUR_PASSWORD
```

### Veritabanı Bağlantısını Test Etme

```bash
cd hotelreservation
mvn exec:java -Dexec.mainClass="com.izzettinozmen.hotelreservation.DBConnection"
```

Başarılı bağlantı mesajı görmelisiniz: `"Bağlantı başarılı!"`

## 🎯 Kullanım

### Demo Kullanıcı Hesapları

#### Admin Hesabı
- **Kullanıcı Adı**: `admin`
- **Şifre**: `admin123`
- **Özellikler**: Tam sistem erişimi, otel yönetimi, kullanıcı yönetimi

#### Normal Kullanıcı
- **Kullanıcı Adı**: `user`
- **Şifre**: `user123`
- **Özellikler**: Otel arama, rezervasyon yapma, profil yönetimi

> ⚠️ **ÖNEMLİ**: Production ortamında bu demo hesapları kaldırın veya şifrelerini değiştirin!

### Uygulama Akışı

1. **Giriş Ekranı**: Kullanıcı adı ve şifre ile giriş yapın veya yeni hesap oluşturun
2. **Ana Sayfa**: Öne çıkan otelleri görüntüleyin
3. **Otel Listesi**: Tüm otelleri detaylı şekilde inceleyin
4. **Rezervasyon**: İstediğiniz oteli seçip rezervasyon yapın
5. **Profil**: Kişisel bilgilerinizi güncelleyin
6. **Rezervasyon Geçmişi**: Geçmiş ve aktif rezervasyonlarınızı görüntüleyin

## 📊 Veritabanı Şeması

### Ana Tablolar

#### `users` - Kullanıcı Bilgileri
```sql
- user_id (PRIMARY KEY)
- username (UNIQUE)
- password
- name
- surname
- birth_year
- email (UNIQUE)
- phone
- address
- gender
- created_at
- updated_at
```

#### `hotels` - Otel Bilgileri
```sql
- hotel_id (PRIMARY KEY)
- hotel_name
- description
- location
- city
- rating (DECIMAL 2,1)
- price_per_night (DECIMAL 10,2)
- image_url
- created_at
- updated_at
```

#### `reservations` - Rezervasyon Bilgileri
```sql
- reservation_id (PRIMARY KEY)
- user_id (FOREIGN KEY -> users)
- hotel_id (FOREIGN KEY -> hotels)
- check_in_date
- check_out_date
- total_price
- status
- created_at
- updated_at
```

#### `admins` - Admin Bilgileri
```sql
- admin_id (PRIMARY KEY)
- username (UNIQUE)
- password
- phone_number
- email (UNIQUE)
- position
- created_at
```

### Entity İlişkileri
- Bir kullanıcı birden fazla rezervasyon yapabilir (1:N)
- Bir otel birden fazla rezervasyona sahip olabilir (1:N)
- Rezervasyonlar kullanıcı ve otel ile ilişkilidir (N:1:N)

## 📁 Proje Yapısı

```
Hotel-Management-System/
├── database/
│   └── schema.sql              # Veritabanı şema dosyası
├── hotelreservation/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/izzettinozmen/hotelreservation/
│   │   │   │       ├── Admin.java              # Admin sınıfı
│   │   │   │       ├── User.java               # Kullanıcı sınıfı
│   │   │   │       ├── DBConnection.java       # Veritabanı bağlantı yöneticisi
│   │   │   │       ├── FrameLogin.java         # Giriş ekranı
│   │   │   │       ├── FrameSignUpPage.java    # Kayıt ekranı
│   │   │   │       ├── FrameHome.java          # Ana sayfa
│   │   │   │       ├── FrameHotelList.java     # Otel listesi
│   │   │   │       ├── FrameUser.java          # Kullanıcı ayarları
│   │   │   │       ├── FrameAdminMenu.java     # Admin menüsü
│   │   │   │       ├── FrameChangeProfile.java # Profil düzenleme
│   │   │   │       ├── TermsOfUsage.java       # Kullanım şartları
│   │   │   │       └── Hotels/                 # Otel görselleri
│   │   │   └── resources/
│   │   │       ├── db.properties               # Veritabanı konfigürasyonu (git'e eklenmez)
│   │   │       └── db.properties.example       # Örnek konfigürasyon
│   │   └── test/
│   └── pom.xml                 # Maven konfigürasyonu
├── .gitignore
├── LICENSE
└── README.md
```

## 📄 Lisans

Bu proje MIT Lisansı altında lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakın.


**İzzettin Furkan Özmen**

- GitHub: [@Beegash](https://github.com/beegash)
- Email: contact@example.com
