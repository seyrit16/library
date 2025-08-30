# Библиотечная система

Веб-приложение для управления библиотекой с возможностью заказа книг клиентами.

## Технологии

- **JDK**: Java 1.8
- **Framework**: Spring Boot 2.x
- **Frontend**: Spring Web (Thymeleaf)
- **База данных**: PostgreSQL 14
- **Сборщик**: Maven

## Функциональность

### Веб-интерфейс
- Просмотр списка книг
- Добавление и редактирование книг (название, автор, ISBN)
- Просмотр списка клиентов
- Добавление и редактирование клиентов (ФИО, дата рождения)
- Интерфейс взятия книги на прочтение

### REST API
- `GET /api/loans` - получение JSON со всеми читающими клиентами и взятыми книгами

Формат ответа:
```json
[
  {
    "clientName": "Иван",
    "clientSurname": "Иванов",
    "clientPatronymic": "Иванович",
    "clientBirthDate": "1990-05-15",
    "bookTitle": "Война и мир",
    "bookAuthor": "Лев Толстой",
    "bookIsbn": "978-5-17-123456-7",
    "loanDate": "2024-08-15"
  }
]
```

## Установка и запуск

### Предварительные требования

1. **Java 8** или выше
2. **PostgreSQL 14** 
3. **Maven 3.6+**

### Настройка базы данных

1. Установите и запустите PostgreSQL
2. Создайте базу данных и пользователя:

```sql
CREATE DATABASE library;
CREATE USER library_user WITH PASSWORD 'library_pass';
GRANT ALL PRIVILEGES ON DATABASE library TO library_user;
```

### Конфигурация приложения

Файл `src/main/resources/application.properties`:

```properties
# Настройки приложения
spring.application.name=book_library
server.port=8080

# Настройки базы данных
spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=library_user
spring.datasource.password=library_pass
spring.datasource.driver-class-name=org.postgresql.Driver

# Настройки JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL95Dialect

# Настройки Thymeleaf
spring.thymeleaf.cache=false
```

### Сборка и запуск

1. **Клонирование репозитория:**
```bash
git clone https://github.com/seyrit16/library
cd book-library
```

2. **Сборка проекта:**
```bash
mvn clean package
```

3. **Запуск приложения:**
```bash
java -jar target/book-library-0.0.1-SNAPSHOT.jar
```

### Автоматическое создание схемы

Схема базы данных создается автоматически при первом запуске благодаря настройке:
```properties
spring.jpa.hibernate.ddl-auto=update
```

### Доступ к приложению

После запуска приложение будет доступно по адресу:
- **Веб-интерфейс**: http://localhost:8080
- **REST API**: http://localhost:8080/api/loans

## Структура проекта

```
├───test
└───main
    ├───resources
    │   │   application.properties
    │   │
    │   ├───static
    │   └───templates
    │       ├───books
    │       │       list.html
    │       │       form.html
    │       │
    │       ├───clients
    │       │       form.html
    │       │       list.html
    │       │
    │       ├───loans
    │       │       form.html
    │       │       list.html
    │       │
    │       └───fragments
    │               header.html
    │
    └───java
        └───com
            └───example
                └───book_library
                    │   BookLibraryApplication.java
                    │
                    ├───controller
                    │       BookController.java
                    │       ClientController.java
                    │       LoanController.java
                    │       LoanRestController.java
                    │       HomeController.java
                    │
                    ├───dto
                    │       LoanDto.java
                    │
                    ├───model
                    │       Book.java
                    │       Client.java
                    │       Loan.java
                    │
                    ├───repository
                    │       BookRepository.java
                    │       ClientRepository.java
                    │       LoanRepository.java
                    │
                    └───service
                        │   BookService.java
                        │   ClientService.java
                        │   LoanService.java
                        │
                        └───impl
                                BookServiceImpl.java
                                ClientServiceImpl.java
                                LoanServiceImpl.java
```
