package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Helper {
    public static void exit() {
        System.exit(0);
    }

    public static void makeDraggable(Parent root, Stage stage) {
        // This allows window to be dragged
        root.setOnMousePressed(event -> {
            Main.xOffset = stage.getX() - event.getScreenX();
            Main.yOffset = stage.getY() - event.getScreenY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + Main.xOffset);
            stage.setY(event.getScreenY() + Main.yOffset);
        });
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

    public static Patient fetchPatientDataFromId(int ID) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery("SELECT * FROM Patient WHERE ID = " + ID + ";");

        if (rs.next()) {
            Patient patient = new Patient(
                    rs.getInt("ID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("dob"),
                    rs.getString("phoneNumber"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("insuranceNumber"),
                    rs.getString("pharmacyAddress"),
                    rs.getString("pharmacyPhoneNumber"),
                    rs.getDouble("weight"),
                    rs.getDouble("height"),
                    rs.getDouble("bodyTemp"),
                    rs.getDouble("bloodPressureHi"),
                    rs.getDouble("bloodPressureLo"),
                    rs.getString("healthHistory"),
                    rs.getString("immunization"));

            System.out.println(patient);

            return patient;
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

            sql = "SELECT ID FROM Account WHERE Username = '" + username + "';";
            ResultSet rs = Main.stmt.executeQuery(sql);
            int ID = rs.getInt("ID");

            sql = "INSERT INTO Patient (ID, firstName, lastName, dob, phoneNumber, email, address, insuranceNumber, pharmacyAddress, pharmacyPhoneNumber, weight, height, bodyTemp, bloodPressureHi, bloodPressureLo, healthHistory, immunization) VALUES (?, ?, ?, ?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";

            try (PreparedStatement pstmt_new = Main.connection.prepareStatement(sql)) {
                pstmt_new.setInt(1, ID);
                pstmt_new.setString(2, firstName);
                pstmt_new.setString(3, lastName);
                pstmt_new.setString(4, dob);
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
