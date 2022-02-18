import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex_05 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        PreparedStatement stmt = connection.prepareStatement(
                "UPDATE towns SET name = UPPER(name) WHERE country = ? AND name NOT LIKE BINARY UPPER(name)");

        stmt.setString(1, country);
        int rows = stmt.executeUpdate();

        if (rows > 0) {
            PreparedStatement selectStmt = connection.prepareStatement(
                    "SELECT name FROM towns WHERE country = ?;");

            selectStmt.setString(1, country);
            ResultSet countriesSet = selectStmt.executeQuery();
            StringBuilder result = new StringBuilder("[");

            while (countriesSet.next()) {
                result.append(countriesSet.getString("name")).append(", ");
            }

            result = new StringBuilder(result.substring(0, result.length() - 2));
            result.append("]");

            System.out.println(rows + " town names were affected.");
            System.out.println(result);
        } else {
            System.out.println("No town names were affected");
        }
    }
}