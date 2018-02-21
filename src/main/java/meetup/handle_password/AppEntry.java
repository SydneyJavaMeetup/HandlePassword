package meetup.handle_password;

import act.Act;
import act.crypto.AppCrypto;
import act.util.JsonView;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PutAction;

import java.util.Arrays;
import javax.inject.Inject;

@SuppressWarnings("unused")
@JsonView
public class AppEntry {

    @Inject
    private User user;

    @Inject
    private AppCrypto crypto;

    @PutAction("/user/password")
    public char[] setPassword(char[] password) {
        try {
            user.setPassword(crypto.passwordHash(password));
            return user.getPassword();
        } finally {
            Arrays.fill(password, '\0');
        }
    }

    @GetAction("/user/password/verify")
    public boolean verifyPassword(char[] password) {
        return crypto.verifyPassword(password, user.getPassword());
    }

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
