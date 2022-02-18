import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Ex_08 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        int[] minionsId = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        PreparedStatement updateStmt = connection.prepareStatement(
                "UPDATE minions SET age = age + 1, name = CONCAT(UPPER(SUBSTRING(name, 1, 1)), SUBSTRING(name, 2)) WHERE id = ?;");

        for (int id : minionsId) {
            updateStmt.setInt(1, id);
            updateStmt.executeUpdate();
        }

        PreparedStatement selectStmt = connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet resultSet = selectStmt.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = Integer.parseInt(resultSet.getString("age"));
            System.out.println(name + " " + age);
        }
    }
}