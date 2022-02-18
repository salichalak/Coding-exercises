import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex_09 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        PreparedStatement stmt = connection.prepareStatement("call usp_get_older(?)");
        int minionId = scanner.nextInt();

        stmt.setInt(1, minionId);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = Integer.parseInt(resultSet.getString("age"));
            System.out.println(name + " " + age);
        }
    }
}