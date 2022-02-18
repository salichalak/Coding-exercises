import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Ex_07 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement stmt = connection.prepareStatement("SELECT name FROM minions");
        ResultSet resultSet = stmt.executeQuery();
        List<String> minions = new ArrayList<>();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            minions.add(name);
        }

        for (int i = 0; i < minions.size() / 2; i++) {
            System.out.println(minions.get(i));
            System.out.println(minions.get(minions.size() - 1 - i));
        }

        if (minions.size() % 2 != 0) {
            System.out.println(minions.get(minions.size() / 2));
        }
    }
}