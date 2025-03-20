import java.sql.*;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/Cafe";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Nikita29";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTables(conn);
            System.out.println("Tables created");
            insertSampleData(conn);
            System.out.println("Tables inserted");
            updateData(conn);
            System.out.println("Tables updated");
            deleteData(conn);
            System.out.println("Tables deleted");
            displayData(conn);
            System.out.println("Tables displayed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        String createDrinks = "CREATE TABLE IF NOT EXISTS Drinks (id SERIAL PRIMARY KEY, name_uk VARCHAR(100), name_en VARCHAR(100), price DECIMAL(10,2))";
        String createStaff = "CREATE TABLE IF NOT EXISTS Staff (id SERIAL PRIMARY KEY, full_name VARCHAR(255), phone VARCHAR(20), address VARCHAR(255), position VARCHAR(50))";
        String createClients = "CREATE TABLE IF NOT EXISTS Clients (id SERIAL PRIMARY KEY, full_name VARCHAR(255), birth_date DATE, phone VARCHAR(20), address VARCHAR(255), discount DECIMAL(5,2))";
        String createOrders = "CREATE TABLE IF NOT EXISTS Orders (id SERIAL PRIMARY KEY, client_id INT REFERENCES Clients(id), order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createDrinks);
            stmt.execute(createStaff);
            stmt.execute(createClients);
            stmt.execute(createOrders);
        }
    }

    private static void insertSampleData(Connection conn) throws SQLException {
        String insertDrink1 = "INSERT INTO Drinks (name_uk, name_en, price) VALUES ('Капучіно', 'Cappuccino', 45.00)";
        String insertDrink2 = "INSERT INTO Drinks (name_uk, name_en, price) VALUES ('Еспресо', 'Espresso', 40.00)";
        String insertStaff1 = "INSERT INTO Staff (full_name, phone, address, position) VALUES ('Іван Петров', '+380991234567', 'Київ, вул. Хрещатик, 10', 'Бариста')";
        String insertStaff2 = "INSERT INTO Staff (full_name, phone, address, position) VALUES ('Олена Коваль', '+380992345678', 'Львів, вул. Франка, 15', 'Офіціант')";
        String insertClient = "INSERT INTO Clients (full_name, birth_date, phone, address, discount) VALUES ('Марія Іваненко', '1995-06-15', '+380931234567', 'Львів, вул. Городоцька, 25', 5.00)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(insertDrink1);
            stmt.execute(insertDrink2);
            stmt.execute(insertStaff1);
            stmt.execute(insertStaff2);
            stmt.execute(insertClient);
        }
    }

    private static void updateData(Connection conn) throws SQLException {
        String updatePrice = "UPDATE Drinks SET price = 50.00 WHERE name_en = 'Cappuccino'";
        String updatePhone = "UPDATE Staff SET phone = '+380992345678' WHERE full_name = 'Іван Петров'";
        String updateDiscount = "UPDATE Clients SET discount = 10.00 WHERE full_name = 'Марія Іваненко'";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(updatePrice);
            stmt.execute(updatePhone);
            stmt.execute(updateDiscount);
        }
    }

    private static void deleteData(Connection conn) throws SQLException {
        String deleteDrink = "DELETE FROM Drinks WHERE name_en = 'Cappuccino'";
        String deleteClient = "DELETE FROM Clients WHERE full_name = 'Марія Іваненко'";
        String deleteStaff = "DELETE FROM Staff WHERE full_name = 'Іван Петров'";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(deleteDrink);
            stmt.execute(deleteClient);
            stmt.execute(deleteStaff);
        }
    }

    private static void displayData(Connection conn) throws SQLException {
        String selectDrinks = "SELECT * FROM Drinks";
        String selectStaff = "SELECT * FROM Staff";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectDrinks)) {
            while (rs.next()) System.out.println("Напій: " + rs.getString("name_uk") + " (" + rs.getString("name_en") + ") - " + rs.getBigDecimal("price") + " грн");
        }
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectStaff)) {
            System.out.println("\nПерсонал кафе:");
            while (rs.next()) System.out.println("ID: " + rs.getInt("id") + ", Ім'я: " + rs.getString("full_name") + ", Телефон: " + rs.getString("phone") + ", Адреса: " + rs.getString("address") + ", Посада: " + rs.getString("position"));
        }
    }
}

