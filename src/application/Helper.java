package application;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Helper {
    public static void exit() {
        System.exit(0);
    }

    public static String BCryptHash(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean BCryptAuth(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }
}
