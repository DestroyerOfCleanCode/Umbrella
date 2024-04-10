package application;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Helper {
    private static final SecureRandom random = new SecureRandom();

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

    private static ArrayList<Appointment> fetchAppointment(String query) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery(query);

        ArrayList<Appointment> appointments = new ArrayList<>();
        while (rs.next()) {
            Appointment appointment = new Appointment(
                    rs.getInt("ID"),
                    rs.getInt("PatientID"),
                    rs.getInt("DoctorID"),
                    LocalDate.parse(rs.getString("Date"), DateTimeFormatter.ISO_LOCAL_DATE),
                    rs.getString("Allergies"),
                    rs.getString("HealthConcern"),
                    rs.getString("PhysExam"),
                    rs.getString("DocConcern"),
                    rs.getString("Prescription"));

            System.out.println("Fetch: " + appointment);

            appointments.add(appointment);
        }

        return appointments;
    }

    public static ArrayList<Appointment> fetchAppointmentData(int patientID) throws SQLException {
        return fetchAppointment("SELECT * FROM Appointment WHERE PatientID = " + patientID + " ORDER BY Date;");
    }

    public static String fetchTypeFromId(int ID) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery("SELECT Type FROM Account WHERE ID = " + ID + ";");

        if (rs.next()) {
            return rs.getString("Type");
        }

        return null;
    }

    public static Employee fetchEmployeeById(int ID) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery("SELECT * FROM Employee WHERE ID = " + ID + ";");

        if (rs.next()) {
            Employee employee = new Employee(
                    rs.getInt("ID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"));

            System.out.println("Fetch: " + employee);

            return employee;
        }

        return null;
    }

    public static Patient fetchPatientData(int ID) throws SQLException {
        return fetchPatient("SELECT * FROM Patient WHERE ID = " + ID + ";");
    }

    public static Patient fetchPatientData(String firstName, String lastName, String dob) throws SQLException {
        return fetchPatient("SELECT * FROM Patient WHERE firstName = '" + firstName
                + "' AND lastName = '" + lastName + "' AND dob = '" + dob + "';");
    }

    private static Patient fetchPatient(String query) throws SQLException {
        ResultSet rs = Main.stmt.executeQuery(query);

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

            System.out.println("Fetch: " + patient);

            return patient;
        }

        return null;
    }

    public static boolean updatePatientData(Patient patient) {
        String query = "UPDATE Patient SET ";
        Boolean updated = false;

        if (patient.getPhoneNumber() != null && !patient.getPhoneNumber().isBlank()) {
            query += "phoneNumber = '" + patient.getPhoneNumber() + "', ";
            updated = true;
        }

        if (patient.getEmail() != null && !patient.getEmail().isBlank()) {
            query += "email = '" + patient.getEmail() + "', ";
            updated = true;
        }

        if (patient.getAddress() != null && !patient.getAddress().isBlank()) {
            query += "address = '" + patient.getAddress() + "', ";
            updated = true;
        }

        if (patient.getInsuranceNumber() != null && !patient.getInsuranceNumber().isBlank()) {
            query += "insuranceNumber = '" + patient.getInsuranceNumber() + "', ";
            updated = true;
        }

        if (patient.getPharmacyAddress() != null && !patient.getPharmacyAddress().isBlank()) {
            query += "pharmacyAddress = '" + patient.getPharmacyAddress() + "', ";
            updated = true;
        }

        if (patient.getPharmacyPhoneNumber() != null && !patient.getPharmacyPhoneNumber().isBlank()) {
            query += "pharmacyPhoneNumber = '" + patient.getPharmacyPhoneNumber() + "', ";
            updated = true;
        }

        if (patient.getImmunization() != null && !patient.getImmunization().isBlank()) {
            query += "immunization = '" + patient.getImmunization() + "', ";
            updated = true;
        }

        if (patient.getWeight() > 0.0) {
            query += "weight = " + patient.getWeight() + ", ";
            updated = true;
        }

        if (patient.getHeight() > 0.0) {
            query += "height = " + patient.getHeight() + ", ";
            updated = true;
        }

        if (patient.getBodyTemp() > 0.0) {
            query += "bodyTemp = " + patient.getBodyTemp() + ", ";
            updated = true;
        }

        if (patient.getBloodPressureHi() > 0.0) {
            query += "bloodPressureHi = " + patient.getBloodPressureHi() + ", ";
            updated = true;
        }

        if (patient.getBloodPressureLo() > 0.0) {
            query += "bloodPressureLo = " + patient.getBloodPressureLo() + ", ";
            updated = true;
        }

        if (patient.getHealthHistory() != null && !patient.getHealthHistory().isBlank()) {
            query += "healthHistory = '" + patient.getHealthHistory() + "', ";
            updated = true;
        }

        if (updated) {
            query = query.substring(0, query.length() - 2) + " WHERE ID = " + patient.getId() + ";";

            try (PreparedStatement pstmt = Main.connection.prepareStatement(query)) {
                pstmt.executeUpdate();
                System.out.println("Update: " + patient);
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }

    public static boolean createAccount(String username, String password, String type) {
        String sql = "INSERT INTO Account (Username, Password, Type) VALUES (?, ?, ?);";

        try (PreparedStatement pstmt = Main.connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, BCryptHash(password));
            pstmt.setString(3, type);
            pstmt.executeUpdate();

            ResultSet rs = Main.stmt.executeQuery("SELECT * FROM Account WHERE Username = '" + username + "';");

            if (!rs.next()) {
                return false;
            }

            int ID = rs.getInt(1);

            System.out.println("Insert: Account {id=" + ID + ", username=" + rs.getString(2) + ", password="
                    + rs.getString(3) + ", type=" + rs.getString(4));

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean createEmployeeAccount(String username, String password, String firstName, String lastName,
            String type) {
        String sql = "SELECT * FROM Account WHERE Username = '" + username + "';";
        int ID = -1;

        try {
            if (!createAccount(username, password, type)) {
                return false;
            }

            ResultSet rs = Main.stmt.executeQuery(sql);

            if (rs.next()) {
                ID = rs.getInt(1);
            }

            sql = "INSERT INTO Employee (ID, firstName, lastName) VALUES (?, ?, ?);";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement pstmt = Main.connection.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName.isBlank() ? null : lastName);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean createPatientAccount(String username, String password, String firstName, String lastName,
            String dob) {
        String sql = "SELECT * FROM Account WHERE Username = '" + username + "';";
        int ID = -1;

        try {
            if (!createAccount(username, password, "Patient")) {
                return false;
            }

            ResultSet rs = Main.stmt.executeQuery(sql);

            if (rs.next()) {
                ID = rs.getInt(1);
            }

            sql = "INSERT INTO Patient (ID, firstName, lastName, dob, phoneNumber, email, address, insuranceNumber, pharmacyAddress, pharmacyPhoneNumber, weight, height, bodyTemp, bloodPressureHi, bloodPressureLo, healthHistory, immunization) VALUES (?, ?, ?, ?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        try (PreparedStatement pstmt = Main.connection.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, dob);
            pstmt.executeUpdate();

            Patient patient = fetchPatientData(ID);
            System.out.println("Inserted: " + patient);

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private static String blankToNull(String input) {
        return (input == null || input.trim().isEmpty()) ? null : input;
    }

    public static void createAppointment(LocalDate date, int patientID, int doctorID,
            String allergies, String healthConcerns, String physExam,
            String doctorConcerns, String prescriptions) throws SQLException {
        String sql = "INSERT INTO Appointment (Date, PatientID, DoctorID, Allergies, HealthConcern, PhysExam, DocConcern, Prescription) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = Main.connection.prepareStatement(sql)) {
            pstmt.setString(1, date.format(DateTimeFormatter.ISO_LOCAL_DATE));
            pstmt.setInt(2, patientID);
            pstmt.setInt(3, doctorID);
            pstmt.setString(4, blankToNull(allergies));
            pstmt.setString(5, blankToNull(healthConcerns));
            pstmt.setString(6, blankToNull(physExam));
            pstmt.setString(7, blankToNull(doctorConcerns));
            pstmt.setString(8, blankToNull(prescriptions));

            pstmt.executeUpdate();
            System.out.println("Appointment inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting appointment: " + e.getMessage());
        }
    }

    public static String appointmentsAsString(int patientID) throws SQLException {
        ArrayList<Appointment> appointments = fetchAppointmentData(patientID);
        String patientName = Helper.fetchPatientData(patientID).getFirstName();
        String str = "";

        for (Appointment appointment : appointments) {
            str += appointment.getDate() + "\nDoctor: "
                    + Helper.fetchEmployeeById(appointment.getDoctorID()).getFirstName() + "\nPatient: "
                    + patientName + "\nAllergies: " + appointment.getAllergies()
                    + "\nHealth Concerns: " + appointment.getHealthConcern() + "\nPhysical Exam: "
                    + appointment.getPhysExam() + "\nDoctor's Concerns: " + appointment.getDocConcern()
                    + "\nPrescription: " + appointment.getPrescription() + "\n\n";
        }

        return str;
    }

    public static String generateUsername(String firstName, String lastName) {
        String initial = firstName.substring(0, 1).toLowerCase();

        String userLastName = lastName.length() > 4 ? lastName.substring(0, 4).toLowerCase() : lastName.toLowerCase();

        Random random = new Random();
        int randomNumber = 1 + random.nextInt(900);

        return initial + userLastName + randomNumber;
    }

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();

        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 2; i < 15; i++) {
            password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        }

        ArrayList<Character> charList = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            charList.add(c);
        }
        Collections.shuffle(charList);

        StringBuilder finalPassword = new StringBuilder();
        for (int i = 0; i < charList.size(); i++) {
            finalPassword.append(charList.get(i));
            if ((i + 1) % 5 == 0 && i < charList.size() - 1) {
                finalPassword.append("-");
            }
        }

        return finalPassword.toString();
    }

    public static String greetingEmployee(int ID) throws SQLException {
        Employee employee = Helper.fetchEmployeeById(Main.employeeID);
        String type = Helper.fetchTypeFromId(Main.employeeID);

        return "Hello " + type + " " + employee.getFirstName();
    }

    public static String dateConvert(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);

        return formattedDate;
    }

    public static String BCryptHash(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean BCryptAuth(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }
}
