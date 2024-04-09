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
           String sql = "CREATE TABLE Account (\r\n"
           		+ "    ID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
           		+ "    Username TEXT NOT NULL,\r\n"
           		+ "    Password TEXT NOT NULL,\r\n"
           		+ "    Type TEXT NOT NULL,\r\n"
           		+ "    UserID INTEGER NOT NULL\r\n"
           		+ ");"; 
           stmt.executeUpdate(sql);
           
           sql = "INSERT INTO Account(Username, Password, Type, UserID) VALUES ('testaccount1', 'password', 'patient', 1);";
           stmt.executeUpdate(sql);
           
           sql = "INSERT INTO Account(Username, Password, Type, UserID) VALUES ('testaccount2', 'password', 'nurse', 2);";
           stmt.executeUpdate(sql);
           
           sql = "INSERT INTO Account(Username, Password, Type, UserID) VALUES ('testaccount3', 'password', 'doctor', 3);";
           stmt.executeUpdate(sql);
           
           ResultSet rs = stmt.executeQuery( "SELECT * FROM Account;" );
           
           while ( rs.next() ) {
               int id = rs.getInt("ID");
               String  username = rs.getString("Username");
               String  password = rs.getString("Password");
               String  type = rs.getString("Type");
               int userID = rs.getInt("UserID");
               
               System.out.println(id + "," + username + "," + password + "," + type + "," + userID);
            }
           
            rs.close();
           
           stmt.close();
           
           c.close();
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
    }
}