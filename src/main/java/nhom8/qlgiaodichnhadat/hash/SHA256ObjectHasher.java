package nhom8.qlgiaodichnhadat.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;

public class SHA256ObjectHasher implements ObjectHasher {
    // STATIC FIELDS:
    private static SHA256ObjectHasher hasher = new SHA256ObjectHasher();

    // STATIC METHODS:
    public static SHA256ObjectHasher getInstance() {
        return hasher;
    }

    // FIELDS:
    private Notifier errorNotifier;

    private MessageDigest messageDigest;

    // CONSTRUCTORS:
    private SHA256ObjectHasher() {
        // Get error notifier
        errorNotifier = ErrorNotifier.getInstance();

        try {
            // Get message digest
            messageDigest = MessageDigest.getInstance("SHA-256");
        }
        catch (Exception e) {
            errorNotifier.notify(
                e.getStackTrace()
            );
        }
    }

    // METHODS:
    public String hashObject(Object obj) {
        // Result declaration
        String result = null;

        // Get obj's info as string
        String info = obj.toString();

        // Get info's byte
        byte[] infoBytes = info.getBytes(
            StandardCharsets.UTF_8
        );

        // Hash infoBytes
        byte[] hashed = messageDigest.digest(infoBytes);

        // Result initialization
        result = "";

        // Completing
        for (byte b : hashed) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hex += '0';
            }
            result += hex;
        }
        
        // Return
        return result;
    }
}
