package ex;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (!(password.length() >= 8 && password.length() <= 32)) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        int digit = 0, specialChar = 0;
        char[] array = password.toCharArray();
        for (char x : array) {
            if (Character.isDigit(x)) {
                digit++;
            }
            if (!Character.isLetterOrDigit(x)) {
                specialChar++;
            }
            if (digit > 0 && specialChar > 0) {
                break;
            }
        }
        if (digit == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (specialChar == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] invalids  = new String[] {"qwerty", "12345", "password", "admin", "user"};
        for (String pass : invalids) {
            if (password.toLowerCase().contains(pass)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
