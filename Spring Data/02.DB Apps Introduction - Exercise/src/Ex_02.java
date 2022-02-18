import java.sql.*;
import java.util.Properties;

public class Ex_02 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement stmt = connection.prepareStatement(
                "SELECT v.`name`, COUNT(DISTINCT mv.minion_id) AS count\n" +
                        "FROM villains AS v\n" +
                        "JOIN minions_villains AS mv\n" +
                        "ON v.id = mv.villain_id\n" +
                        "GROUP by v.`name`\n" +
                        "HAVING count > 15\n" +
                        "ORDER BY count DESC;");

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionsCount = resultSet.getInt("count");
            System.out.println(villainName + " " + minionsCount);
        }
    }
}