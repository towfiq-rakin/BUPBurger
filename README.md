# BUPBurger - Restaurant Management System

A Java Swing-based restaurant management system that provides both customer and administrative interfaces for managing a burger restaurant.

## Features

### Customer Features
- User Registration and Login
- Browse Food Items by Categories:
  - Burgers
  - Pizza
  - Pasta
  - Salads
  - Drinks
  - Coffee
  - Desserts
  - Sides
- Shopping Cart Functionality
- Food Details View

### Administrative Features
- User Management
  - Add New Users
  - Modify Existing Users
  - View All Users
- Food Management
  - Add New Food Items
  - Manage Food Inventory

## Technical Stack

- **Language**: Java
- **UI Framework**: Java Swing with FlatLaf theme (One Dark)
- **Database**: MySQL
- **Dependencies**:
  - Spring JDBC for database operations
  - FlatLaf for modern UI theming

## Database Structure

The application uses two main database tables:

### Users Table
- ID (Auto-increment)
- Username (Unique)
- Email (Unique)
- Password
- Phone
- Gender
- Registration Date

### Foods Table
- ID (Auto-increment)
- Category
- Title (Unique)
- Description
- Price

## Project Structure

```
src/
├── main/
    ├── java/org/rakin/bupburger/
    │   ├── dao/          # Data Access Objects
    │   ├── domain/       # Entity Classes
    │   ├── util/         # Utility Classes
    │   └── view/         # UI Components
    └── resources/
        ├── database/     # SQL Scripts
        └── img/          # Application Images
```

## Setup Instructions

1. Install MySQL Server
2. Create database using the SQL script in `src/main/resources/database/app.sql`
3. Configure database connection in `application-context.xml`
4. Build the project using Maven:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   java -jar target/BUPBurger.jar
   ```

## Default Admin Account
- Username: admin
- Password: admin

## Contributing

Feel free to fork this project and submit pull requests for any improvements.
