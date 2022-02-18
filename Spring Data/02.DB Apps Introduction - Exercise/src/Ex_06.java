import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex_06 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        int villainID = scanner.nextInt();
        int releasedMinions = 0;

        PreparedStatement stmt = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        stmt.setInt(1, villainID);

        ResultSet resultSet = stmt.executeQuery();
        resultSet.next();

        if (!resultSet.next()) {
            System.out.println("No such villain was found");
        } else {
            PreparedStatement deleteStmt = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
            deleteStmt.setInt(1, villainID);
            releasedMinions = deleteStmt.executeUpdate();

            deleteStmt = connection.prepareStatement("DELETE FROM villains WHERE id = ?");
            deleteStmt.setInt(1, villainID);
            deleteStmt.executeUpdate();

            System.out.println(resultSet.getString("name") + " was deleted");
            System.out.println(releasedMinions + " minions released");
        }
    }
}