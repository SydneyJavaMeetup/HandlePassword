package meetup.handle_password;

import act.Act;
import act.crypto.AppCrypto;
import act.util.JsonView;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PutAction;

import javax.inject.Inject;

@SuppressWarnings("unused")
@JsonView
public class AppEntry {

    @Inject
    private User user;

    @Inject
    private AppCrypto crypto;

    @PutAction("/user/password")
    public String setPassword(String password) {
        user.setPassword(crypto.passwordHash(password));
        return user.getPassword();
    }

    @GetAction("/user/password/verify")
    public boolean verifyPassword(String password) {
        return crypto.verifyPassword(password, user.getPassword());
    }

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
