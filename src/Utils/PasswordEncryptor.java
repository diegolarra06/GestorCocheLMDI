package Utils;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordEncryptor {
	private final StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();

    public String encryptPassword(String password) {
        return encryptor.encryptPassword(password);
    }

    public boolean checkPassword(String inputPassword, String encryptedPassword) {
        return encryptor.checkPassword(inputPassword, encryptedPassword);
    }
}
