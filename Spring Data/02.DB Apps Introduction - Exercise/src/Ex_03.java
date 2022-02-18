import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex_03 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1337");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        int villainID = Integer.parseInt(scanner.nextLine());

        printVillainInfo(villainID, connection);
        printMinionsInfo(villainID, connection);
    }

    private static void printMinionsInfo(int villainID, Connection connection) throws SQLException {
        PreparedStatement minionStmt = connection.prepareStatement(
                "SELECT m.name, m.age\n" +
                        "FROM minions AS m\n" +
                        "JOIN minions_villains AS mv\n" +
                        "ON m.id = mv.minion_id\n" +
                        "WHERE mv.villain_id = ?;");

        minionStmt.setInt(1, villainID);

        ResultSet minionSet = minionStmt.executeQuery();

        int counter = 1;
        while (minionSet.next()) {
            String minionName = minionSet.getString("m.name");
            int minionAge = minionSet.getInt("m.age");
            System.out.printf("%d. %s %d%n", counter++, minionName, minionAge);
        }
    }

    private static void printVillainInfo(int villainID, Connection connection) throws SQLException {
        PreparedStatement villainStmt = connection.prepareStatement("" +
                "SELECT v.name\n" +
                "FROM villains AS v\n" +
                "WHERE v.id = ?;");

        villainStmt.setInt(1, villainID);

        ResultSet villainSet = villainStmt.executeQuery();

        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainID);
        } else {
            System.out.println("Villain: " + villainSet.getString("v.name"));
        }
    }
}