package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Helper {
    public static void exit() {
        System.exit(0);
    }

    public static int authenticate(String username, String password) throws SQLException {
        String query = "SELECT * FROM Account WHERE Username = '" + username + "';";

        ResultSet rs = Main.stmt.executeQuery(query);

        if (rs.next()) {
            String storedPassword = rs.getString("Password");

            if (BCryptAuth(password, storedPassword)) {
                return rs.getInt("ID");
            }
        }

        return -1;
    }

    public static String fetchTypeFromId(int ID) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery("SELECT Type FROM Account WHERE ID = " + ID + ";");

        if (rs.next()) {
            return rs.getString("Type");
        }

        return null;
    }

    public static ArrayList<String> fetchPatientDataFromId(int ID) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery("SELECT * FROM Patient WHERE ID = " + ID + ";");

        if (rs.next()) {
            ArrayList<String> data = new ArrayList<String>();
            data.add(rs.getString("firstName"));
            data.add(rs.getString("lastName"));
            data.add(rs.getString("dob"));
            data.add(rs.getString("phoneNumber"));
            data.add(rs.getString("email"));
            data.add(rs.getString("insuranceNumber"));
            data.add(rs.getString("pharmacy"));
            data.add(rs.getString("weight"));
            data.add(rs.getString("height"));
            data.add(rs.getString("bodyTemp"));
            data.add(rs.getString("bloodPressureHi"));
            data.add(rs.getString("bloodPressureLo"));
            data.add(rs.getString("allergies"));
            data.add(rs.getString("healthIssues"));
            data.add(rs.getString("medications"));

            return data;
        }

        return null;
    }

    public static void createPatientAccount(String username, String password, String firstName, String lastName,
            String dob) {
        String sql = "INSERT INTO Account (Username, Password, Type) VALUES (?, ?, ?);";

        try (PreparedStatement pstmt = Main.connection.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, BCryptHash(password));
            pstmt.setString(3, "Patient");
            pstmt.executeUpdate();

            System.out.println("Patient account inserted successfully.");

            sql = "INSERT INTO Patient (firstName, lastName, dob, phoneNumber, email, insuranceNumber, pharmacy, weight, height, bodyTemp, bloodPressureHi, bloodPressureLo, allergies, healthIssues, medications) VALUES (?, ?, ?, NULL, '', '', '', NULL, NULL, NULL, NULL, NULL, '', '', '');";

            try (PreparedStatement pstmt_new = Main.connection.prepareStatement(sql)) {
                pstmt_new.setString(1, firstName);
                pstmt_new.setString(2, lastName);
                pstmt_new.setString(3, dob);
                pstmt_new.executeUpdate();

                System.out.println("Patient record inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String BCryptHash(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean BCryptAuth(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }
}
