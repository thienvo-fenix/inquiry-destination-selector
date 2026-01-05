# Hệ Thống Quản Lý Địa Điểm Liên Hệ
Inquiry Destination Management System - 問合せ先管理システム

## Tổng Quan
Ứng dụng Web để tìm kiếm và quản lý thông tin địa điểm liên hệ.

## Công Nghệ Sử Dụng
- **Backend**: Java 17, Spring Boot 3.2.1
- **Database**: MySQL 8.0
- **Migration**: Flyway
- **Build Tool**: Maven
- **Container**: Docker, Docker Compose
- **Frontend**: HTML, CSS, JavaScript (Vanilla)

## Cấu Trúc Dự Án
```
├── docker/
│   ├── mysql/
│   │   └── init.sql
│   └── app/
│       └── Dockerfile
├── docker-compose.yml
├── src/
│   ├── main/
│   │   ├── java/com/example/inquiry/
│   │   │   ├── domain/
│   │   │   │   ├── model/
│   │   │   │   └── repository/
│   │   │   ├── application/
│   │   │   │   ├── dto/
│   │   │   │   └── usecase/
│   │   │   ├── infrastructure/
│   │   │   │   ├── persistence/
│   │   │   │   └── config/
│   │   │   └── presentation/
│   │   │       └── controller/
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       ├── db/
│   │       │   └── migration/
│   │       │       ├── V1__create_region_table.sql
│   │       │       ├── V2__create_inquiry_destination_table.sql
│   │       │       └── V3__insert_master_data.sql
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Tính Năng
1. **Tìm kiếm địa điểm liên hệ**
   - Tên địa điểm (tìm kiếm từ đầu)
   - Tên Kana (tìm kiếm từ đầu)
   - Số điện thoại (tìm kiếm từ đầu)
   - URL (tìm kiếm một phần)
   - Khu vực (có thể chọn nhiều)

2. **Hiển thị kết quả tìm kiếm**
   - Hiển thị dạng danh sách
   - Chức năng sắp xếp
   - Chọn nhiều mục

3. **Tính năng giao diện**
   - Accordion (đóng/mở điều kiện tìm kiếm)
   - Responsive design
   - Tìm kiếm thời gian thực

## Hướng Dẫn Cài Đặt

### Yêu Cầu
- Docker Desktop đã được cài đặt
- Git đã được cài đặt

### 1. Khởi động với Docker (Khuyến nghị)

```powershell
# Khởi động MySQL container
docker-compose up -d mysql

# Đợi MySQL khởi động (khoảng 30 giây)
Start-Sleep -Seconds 30

# Build ứng dụng
mvn clean package -DskipTests

# Khởi động application container
docker-compose up -d app
```

### 2. Khởi động môi trường local

```powershell
# Chỉ khởi động MySQL bằng Docker
docker-compose up -d mysql

# Chạy ứng dụng local
mvn spring-boot:run
```

### 3. Truy cập ứng dụng

Mở trình duyệt và truy cập:
- **Frontend**: http://localhost:8080
- **API**: http://localhost:8080/api/inquiry-destinations