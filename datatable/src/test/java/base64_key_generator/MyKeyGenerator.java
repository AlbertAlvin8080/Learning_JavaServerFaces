package base64_key_generator;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MyKeyGenerator {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        String key = Base64.getEncoder().encodeToString(generator.generateKey().getEncoded());
        System.out.println(key);
    }
}