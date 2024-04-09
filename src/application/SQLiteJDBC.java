package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteJDBC {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "DROP TABLE IF EXISTS Account;";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE Account (ID INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT NOT NULL, Password TEXT NOT NULL, Type TEXT NOT NULL);";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Account(Username, Password, Type) VALUES ('testaccount1', 'password', 'patient');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Account(Username, Password, Type) VALUES ('testaccount2', 'password', 'nurse');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Account(Username, Password, Type) VALUES ('testaccount3', 'password', 'doctor');";
            stmt.executeUpdate(sql);

            ResultSet rs = stmt.executeQuery("SELECT * FROM Account;");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String type = rs.getString("Type");

                System.out.println(id + "," + username + "," + password + "," + type);
            }

            rs.close();

            stmt.close();

            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}