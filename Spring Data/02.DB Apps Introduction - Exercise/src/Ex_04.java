import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex_04 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        String[] minionData = scanner.nextLine().split(" ");
        String villainData = scanner.nextLine();

        if (!isTownValid(connection, minionData[2])) {
            insertTown(connection, minionData[2]);
        }

        if (!isVillainValid(connection, villainData)) {
            insertVillain(connection, villainData);
        }

        insertMinion(connection, minionData[1], Integer.parseInt(minionData[2]), minionData[3], villainData);
    }

    private static boolean isTownValid(Connection connection, String town) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM towns WHERE name = ?");
        preparedStatement.setString(1, town);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    private static boolean isVillainValid(Connection connection, String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM villains WHERE name = ?;");
        preparedStatement.setString(1, villainName);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    private static void insertTown(Connection connection, String townName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO towns(name) VALUES (?);");
        preparedStatement.setString(1, townName);
        preparedStatement.executeUpdate();
        System.out.println("Town " + townName + " was added to the database.");
    }

    private static void insertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO villains(name, evilness_factor) VALUES(?, ?);");
        preparedStatement.setString(1, villainName);
        preparedStatement.setString(2, "evil");
        preparedStatement.executeUpdate();
        System.out.println("Villain " + villainName + " was added to the database");
    }

    private static void insertMinion(Connection connection, String minionName, int minionAge, String minionTown, String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT into minions(name, age, town_id) VALUES(?, ?, (SELECT t.id FROM towns t WHERE t.name = ?));", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setString(3, minionTown);

        preparedStatement.executeUpdate();

        ResultSet resultSetMinionId = preparedStatement.getGeneratedKeys();

        int lastMinionId = 0;

        while (resultSetMinionId.next()) {
            lastMinionId = resultSetMinionId.getInt(1);
            break;
        }

        preparedStatement = connection.prepareStatement("INSERT INTO minions_villains(minion_id, villain_id) VALUES (?, (SELECT v.id FROM villains v WHERE v.name = ?));");
        preparedStatement.setInt(1, lastMinionId);
        preparedStatement.setString(2, villainName);
        preparedStatement.executeUpdate();

        System.out.println("Successfully added " + minionName + " to be minion of " + villainName + ".");
    }
}